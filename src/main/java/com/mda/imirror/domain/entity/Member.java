package com.mda.imirror.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
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
    @GeneratedValue(strategy = GenerationType.UUID)
    private String memberPk;

    @Column(nullable = false)
    private String memberName;

    @Column(nullable = false)
    private Boolean memberGender;

    @Column(nullable = false)
    private LocalDate memberBirthDate;

    @Column(nullable = false)
    private Boolean personalInfoConsent;

    @Column(nullable = false, length = 10)
    private String role;

//    @OneToMany
//    private List<Rom> memberPkRoms;
//
//    @OneToMany
//    private List<Balance> memberPkBalances;


    public void changeMemberInfo(String memberName, LocalDate memberBirthDate, Boolean memberGender) {

        this.memberName = memberName == null ? this.memberName : memberName;
        this.memberBirthDate = memberBirthDate == null ? this.memberBirthDate : memberBirthDate;
        this.memberGender = memberGender == null ? this.memberGender : memberGender;
    }

}


