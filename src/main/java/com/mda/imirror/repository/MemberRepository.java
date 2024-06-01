package com.mda.imirror.repository;

import com.mda.imirror.domain.entity.Member;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {
    Optional<Member> findByMemberNameAndMemberBirthDate(String memberName, LocalDate memberBirthDate);
    Optional<Member> findByMemberName(String memberName);

    boolean existsByMemberNameAndMemberBirthDate(String memberName, LocalDate memberBirthDate);
    Slice<Member> findAllByOrderByMemberName(Pageable pageable);
}
