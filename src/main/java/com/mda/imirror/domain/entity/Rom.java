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
    private Integer romPk;

    @Column
    private Double neckSagittalUp;

    @Column
    private Double neckSagittalDown;

    @Column
    private Double neckFrontalLeft;

    @Column
    private Double neckFrontalRight;

    @Column
    private Double shoulderHorizontalLeftUp;

    @Column
    private Double shoulderHorizontalLeftDown;

    @Column
    private Double shoulderHorizontalRightUp;

    @Column
    private Double shoulderHorizontalRightDown;

    @Column
    private Double shoulderSagittalLeftUp;

    @Column
    private Double shoulderSagittalLeftDown;

    @Column
    private Double shoulderSagittalRightUp;

    @Column
    private Double shoulderSagittalRightDown;

    @Column
    private Double shoulderFrontalLeftUp;

    @Column
    private Double shoulderFrontalLeftDown;

    @Column
    private Double shoulderFrontalRightUp;

    @Column
    private Double shoulderFrontalRightDown;

    @Column
    private Double waistSagittalUp;

    @Column
    private Double waistSagittalDown;

    @Column
    private Double waistFrontalLeft;

    @Column
    private Double waistFrontalRight;

    @Column
    private Double kneeSagittalLeft;

    @Column
    private Double kneeSagittalRight;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_pk", nullable = false)
    private Member member;
}
