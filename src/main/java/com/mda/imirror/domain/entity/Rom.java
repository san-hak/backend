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
@Table(name = "rom")
public class Rom {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer balancePk;

    @Column
    private Double sagittalNeckUpperAngle;

    @Column
    private Double sagittalNeckLowerAngle;

    @Column
    private Double frontalNeckLeftAngle;

    @Column
    private Double frontalNeckRightAngle;

    @Column
    private Double horizontalLeftArmUpperAngle;

    @Column
    private Double horizontalLeftArmLowerAngle;

    @Column
    private Double horizontalRightArmUpperAngle;

    @Column
    private Double horizontalRightArmLowerAngle;

    @Column
    private Double sagittalLeftArmFrontAngle;

    @Column
    private Double sagittalLeftArmRearAngle;

    @Column
    private Double sagittalRightArmFrontAngle;

    @Column
    private Double sagittalRightArmRearAngle;

    @Column
    private Double frontalLeftArmOuterAngle;

    @Column
    private Double frontalLeftArmInnerAngle;

    @Column
    private Double frontalRightArmOuterAngle;

    @Column
    private Double frontalRightArmInnerAngle;

    @Column
    private Double sagittalWaistRearAngle;

    @Column
    private Double sagittalWaistFrontAngle;

    @Column
    private Double frontalWaistLeftAngle;

    @Column
    private Double frontalWaistRightAngle;

    @Column
    private Double leftKneeRearAngle;

    @Column
    private Double rightKneeRearAngle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_pk", nullable = false)
    private Member memberPk;
}
