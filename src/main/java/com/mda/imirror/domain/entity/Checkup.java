package com.mda.imirror.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "checkup")
public class Checkup {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer checkupPk;

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

    @Column
    private Double headTwisted;

    @Column
    private Double shoulderTwisted;

    @Column
    private Double pelvisTwisted;

    @Column
    private Double neckTwisted;

    @Column
    private Double shoulderRolled;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_pk", nullable = false)
    private Member member;

    public void registerMember(Member member) {
        this.member = member;
    }

}