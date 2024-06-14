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

//    @Query("select m " +
//            "from Member m " +
//            "where m.memberName = :memberName " +
//            "and m.memberBirthDate = :memberBirthDate " +
//            "and m.role != 'ROLE_ADMIN'")
//    Optional<Member> findByMemberNameAndMemberBirthDate(String memberName, LocalDate memberBirthDate);

    Optional<Member> findByMemberNameAndMemberBirthDateAndRoleNot(String memberName, LocalDate memberBirthDate, String role);

    Optional<Member> findByMemberNameAndMemberBirthDate(String memberName, LocalDate memberBirthDate);


//    @Query("select m " +
//            "from Member m " +
//            "where m.memberName = :name " +
//            "and m.role != 'ROLE_ADMIN'")
//    Slice<Member> findAllByMemberNameOrderByMemberName(String name, Pageable pageable);

//    Slice<Member> findByMemberNameAndRoleNotOrderByMemberBirthDateAsc(String memberName, String role, Pageable pageable);

    Slice<Member> findByMemberNameContainsAndRoleNotOrderByMemberBirthDateAsc(String memberName, String role, Pageable pageable);


    Optional<Member> findByMemberName(String name);

//    @Query("select m " +
//            "from Member m " +
//            "where m.role != 'ROLE_ADMIN' " +
//            "order by m.memberName")
//    Slice<Member> findAllByOrderByMemberName(Pageable pageable);

    Slice<Member> findByRoleNotOrderByMemberNameAscMemberBirthDateAsc(String role, Pageable pageable);


}
