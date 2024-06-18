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
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class CheckupService {

    private final MemberRepository memberRepository;
    private final CheckupRepository checkupRepository;

    public void registerCheckupResult(CheckupResultRequest request) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(request.getMemberBirthDate(), formatter);

        Member member = memberRepository.findByMemberNameAndMemberBirthDateAndRoleNot(request.getMemberName(),date, "ROLE_ADMIN")
                .orElseGet(() -> Member.builder()
                        .memberPk(UUID.randomUUID().toString())
                        .memberName(request.getMemberName())
                        .memberBirthDate(LocalDate.parse(request.getMemberBirthDate()))
                        .role(MemberRole.USER.getKey())
                        .personalInfoConsent(true)  //임시
                        .isMale(true) //임시
                        .build());

        member.changeMemberInfo(
                null,
                null,
                null,
                null,
                LocalDate.now()
        );
        Checkup checkup = CheckupRequestMapper.MAPPER.toEntity(request);
        checkup.registerMember(member);

        memberRepository.save(member);
        checkupRepository.save(checkup);
    }

    public Slice<CheckupResultResponse> getCheckupResult(String name, String birth, int page, int size, String startDate, String endDate) {
        LocalDateTime startAt = LocalDate.parse(startDate).atStartOfDay();
        LocalDateTime endAt = LocalDate.parse(endDate).atTime(23, 59, 59);

        Member member = memberRepository.findByMemberNameAndMemberBirthDateAndRoleNot(name, LocalDate.parse(birth, DateTimeFormatter.ISO_DATE), "ROLE_ADMIN")
                .orElseThrow(MemberNotFoundException::new);

        return checkupRepository.findByMemberAndCreatedAtBetweenOrderByCreatedAtDesc(member, startAt, endAt, PageRequest.of(page-1, size))
                .map(CheckupMapper.MAPPER::toDto);
    }

    public List<LocalDate> getCheckupDates(Member member) {
        return checkupRepository.findByMemberOrderByCreatedAtDesc(member).stream().map(checkupInfo -> checkupInfo.getCreatedAt().toLocalDate()).toList();
    }

    public Slice<CheckupResultResponse> getCheckupResult(Member member, int page, int size, String startDate, String endDate) {

        LocalDateTime startAt = LocalDate.parse(startDate).atStartOfDay();
        LocalDateTime endAt = LocalDate.parse(endDate).atTime(23, 59, 59);

        return checkupRepository.findByMemberAndCreatedAtBetweenOrderByCreatedAtDesc(member, startAt, endAt, PageRequest.of(page-1, size))
                .map(CheckupMapper.MAPPER::toDto);
    }
}
