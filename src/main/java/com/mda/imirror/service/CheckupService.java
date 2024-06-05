package com.mda.imirror.service;
import com.mda.imirror.domain.entity.Member;
import com.mda.imirror.domain.entity.Checkup;
import com.mda.imirror.domain.enums.MemberRole;
import com.mda.imirror.dto.mapper.impl.CheckupMapper;
import com.mda.imirror.dto.mapper.impl.CheckupRequestMapper;

import com.mda.imirror.dto.request.CheckupResultRequest;
import com.mda.imirror.dto.response.CheckupResultResponse;
import com.mda.imirror.exception.MemberNotFoundException;
import com.mda.imirror.repository.MemberRepository;
import com.mda.imirror.repository.CheckupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class CheckupService {

    private final MemberRepository memberRepository;
    private final CheckupRepository checkupRepository;
    private final AuthService authService;

    public void registerCheckupResult(CheckupResultRequest request) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate date = LocalDate.parse(request.getMemberBirthDate(), formatter);



        Member member= memberRepository.findByMemberNameAndMemberBirthDate(request.getMemberName(),date)
                .orElseGet(() -> Member.builder()
                        .memberPk(UUID.randomUUID().toString())
                        .memberName(request.getMemberName())
                        .memberBirthDate( LocalDate.parse(request.getMemberBirthDate()))
                        .role(MemberRole.USER.toString())
                        .personalInfoConsent(true)  //임시
                        .isMale(null) //임시
                        .recentCheckupDate(LocalDate.now())
                        .build());


        Checkup checkup = CheckupRequestMapper.MAPPER.toEntity(request);

        member.changeMemberInfo(
                null,
                null,
                null,
                null,
                LocalDate.now()

        );

        memberRepository.save(member);
        checkupRepository.save(checkup);
    }

    public List<CheckupResultResponse> getCheckupResult(String name, String birth) {
        Member member = memberRepository.findByMemberNameAndMemberBirthDate(name, LocalDate.parse(birth, DateTimeFormatter.ISO_DATE))
                .orElseThrow(MemberNotFoundException::new);
        return getCheckupResultResponses(member);
    }


    public List<CheckupResultResponse> getCheckupResult(Member member) {
        return getCheckupResultResponses(member);
    }

    private List<CheckupResultResponse> getCheckupResultResponses(Member member) {
        List<Checkup> checkups = checkupRepository.findTop10ByMemberOrderByRomPkDesc(member);
        List<CheckupResultResponse> response = new ArrayList<>();
        int responseSize = Math.min(checkups.size(), 10);

        for (int i = 0; i < responseSize; i++) {
            response.add(CheckupMapper.MAPPER.toDto(checkups.get(i)));
        }
        return response;
    }
}
