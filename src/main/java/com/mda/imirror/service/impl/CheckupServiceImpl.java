package com.mda.imirror.service.impl;

import com.mda.imirror.domain.entity.Balance;
import com.mda.imirror.domain.entity.Member;
import com.mda.imirror.domain.entity.Rom;
import com.mda.imirror.dto.mapper.impl.BalanceMapper;
import com.mda.imirror.dto.mapper.impl.RomMapper;
import com.mda.imirror.dto.request.CheckupResultRequest;
import com.mda.imirror.dto.request.MemberNameAndBirthRequest;
import com.mda.imirror.dto.response.CheckupResultResponse;
import com.mda.imirror.exception.NotFoundUserException;
import com.mda.imirror.repository.BalanceRepository;
import com.mda.imirror.repository.MemberRepository;
import com.mda.imirror.repository.RomRepository;
import com.mda.imirror.service.AuthService;
import com.mda.imirror.service.CheckupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CheckupServiceImpl implements CheckupService {

    private final MemberRepository memberRepository;
    private final RomRepository romRepository;
    private final BalanceRepository balanceRepository;
    private final AuthService authService;

    @Override
    public void registerCheckupResult(CheckupResultRequest request) {

        Member member= memberRepository.findByMemberNameAndMemberBirthDate(request.getMemberName(), request.getMemberBirthDate())
                .orElseGet(() -> Member.builder()
                        .memberPk(UUID.randomUUID().toString())
                        .memberName(request.getMemberName())
                        .memberBirthDate(request.getMemberBirthDate())
                        .role("ROLE_USER")
                        .personalInfoConsent(true)  //임시
                        .isMale(true)
                        .build());

        request.getRom().setMember(member);
        request.getBalance().setMember(member);

        Rom rom = RomMapper.MAPPER.toEntity(request.getRom());
        Balance balance = BalanceMapper.MAPPER.toEntity(request.getBalance());

        memberRepository.save(member);
        romRepository.save(rom);
        balanceRepository.save(balance);
    }

    @Override
    public List<CheckupResultResponse> getCheckupResult(MemberNameAndBirthRequest request) {
        Member member = memberRepository.findByMemberNameAndMemberBirthDate(request.getName(), request.birthToLocalDate(request.getBirth()))
                .orElseThrow(NotFoundUserException::new);

        return getCheckupResultResponses(member);
    }

    @Override
    public List<CheckupResultResponse> getCheckupResult(Member member) {
        return getCheckupResultResponses(member);
    }

    private List<CheckupResultResponse> getCheckupResultResponses(Member member) {
        List<Rom> roms = romRepository.findTop10ByMemberOrderByRomPkDesc(member);
        List<Balance> balances = balanceRepository.findTop10ByMemberOrderByBalancePkDesc(member);

        List<CheckupResultResponse> response = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            response.add(new CheckupResultResponse(
                    RomMapper.MAPPER.toDto(roms.get(i)),
                    BalanceMapper.MAPPER.toDto(balances.get(i))
            ));
        }
        return response;
    }
}
