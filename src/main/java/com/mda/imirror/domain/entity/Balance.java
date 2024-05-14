package com.mda.imirror.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "balance")
public class Balance {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer balancePk;

    // 머리 각도
    @Column
    private Double headFrontalAngle;
    @Column
    private Double headSagittalAngle;
    @Column
    private String headFrontalComment;
    @Column
    private String headSagittalComment;


    //어깨 각도
    @Column
    private Double shoulderLeftAngle;
    @Column
    private Double shoulderRightAngle;
    @Column
    private String shoulderComment;

    //라운드 숄더
    @Column
    private Double roundShoulderAngle;
    @Column
    private String roundShoulderComment;


    //골반 각도
    @Column
    private Double pelvisLeftAngle;
    @Column
    private Double pelvisRightAngle;
    @Column
    private String pelvisComment;


    //무릎 각도
    @Column
    private Double KneeLeftAngle;
    @Column
    private Double KneeRightAngle;


    //발목 각도
    @Column
    private Double AnkleLeftAngle;
    @Column
    private Double AnkleRightAngle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_pk", nullable = false)
    private Member member;
}