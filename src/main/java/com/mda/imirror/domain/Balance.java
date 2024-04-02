package com.mda.imirror.domain;

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
    @SequenceGenerator(
            name = "primary_sequence",
            sequenceName = "primary_sequence",
            allocationSize = 1,
            initialValue = 10000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "primary_sequence"
    )
    private Integer balancePk;

    @Column(length = 10)
    private String headTwisted;

    @Column(length = 10)
    private String shoulderTwisted;

    @Column(length = 10)
    private String pelvisTwisted;

    @Column(length = 10)
    private String neckTwisted;

    @Column(length = 10)
    private String shoulderRolled;

    @Column
    private Double leftShoulderAngle;

    @Column
    private Double rightShoulderAngle;

    @Column
    private Double leftHipAngle;

    @Column
    private Double rightHipAngle;

    @Column
    private Double leftKneeAngle;

    @Column
    private Double rightKneeAngle;

    @Column
    private Double leftAnkleAngle;

    @Column
    private Double rightAnkleAngle;

    @Column
    private Double neckAngle;

    @Column
    private Double waistAngle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_pk_id", nullable = false)
    private Member memberPk;
}