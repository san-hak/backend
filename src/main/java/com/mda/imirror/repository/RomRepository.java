package com.mda.imirror.repository;

import com.mda.imirror.domain.entity.Member;
import com.mda.imirror.domain.entity.Rom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RomRepository extends JpaRepository<Rom, Integer> {
    List<Rom> findTop10ByMemberOrderByRomPkDesc(Member member);

}
