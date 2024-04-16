package com.mda.imirror.repository;

import com.mda.imirror.domain.entity.Rom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RomRepository extends JpaRepository<Rom, Integer> {
}
