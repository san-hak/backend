package com.mda.imirror.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "member")
public class Member {

    @Id
    @Column(nullable = false, updatable = false, length = 36)
    private String memberPk;

    @Column(nullable = false)
    private String memberName;

    @Column(nullable = false)
    private Boolean memberGender;

    @Column(nullable = false)
    private Integer memberAge;

    @Column
    private Double memberHeight;

    @Column
    private Double memberWeight;

    @Column(nullable = false)
    private Boolean personalInfoConsentation;

    @Column(nullable = false, length = 10)
    private String role;

    @OneToMany(mappedBy = "memberPk")
    private List<Rom> memberPkRoms;

    @OneToMany(mappedBy = "memberPk")
    private List<Balance> memberPkBalances;
}


