package com.mda.imirror.repository;

import com.mda.imirror.domain.entity.Member;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {
    Optional<Member> findByMemberNameAndMemberBirthDate(String memberName, LocalDate memberBirthDate);
    Optional<Member> findByMemberName(String name);

    @Query("select m " +
            "from Member m " +
            "where m.role != 'ROLE_ADMIN' " +
            "order by m.memberName")
    Slice<Member> findAllByOrderByMemberName(Pageable pageable);
}
