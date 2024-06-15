package com.mda.imirror.repository;

import com.mda.imirror.domain.entity.Checkup;
import com.mda.imirror.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckupRepository extends JpaRepository<Checkup, Integer> {
    List<Checkup> findTop10ByMemberOrderByCheckupPkDesc(Member member);


}
