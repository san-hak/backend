package com.mda.imirror.repository;

import com.mda.imirror.domain.entity.Balance;
import com.mda.imirror.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BalanceRepository extends JpaRepository<Balance, Integer>{
    Optional<Balance> findByMember(Member member);

    List<Balance> findTop10ByMemberOrderByBalancePkDesc(Member member);


}
