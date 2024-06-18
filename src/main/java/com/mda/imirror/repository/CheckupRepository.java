package com.mda.imirror.repository;

import com.mda.imirror.domain.entity.Checkup;
import com.mda.imirror.domain.entity.Member;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CheckupRepository extends JpaRepository<Checkup, Integer> {
    List<Checkup> findTop10ByMemberOrderByCheckupPkAsc(Member member);

    Slice<Checkup> findByMemberAndCreatedAtBetweenOrderByCreatedAtDesc(Member member, LocalDateTime createdAtStart, LocalDateTime createdAtEnd, Pageable pageable);

    Slice<Checkup> findByMemberOrderByCreatedAtDesc(Member member, Pageable pageable);

    List<CheckupInfo> findByMemberOrderByCreatedAtDesc(Member member);


}
