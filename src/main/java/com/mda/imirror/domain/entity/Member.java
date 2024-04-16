package com.mda.imirror.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
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

    @Column(unique = true, nullable = false)
    private String memberId;

    @Column(nullable = false)
    private String memberPassword;

    @Column(nullable = false)
    private String memberName;

    @Column(nullable = false)
    private Boolean memberGender;

    @Column(nullable = false)
    private LocalDateTime memberBirthDate;

    private Double memberHeight;

    private Double memberWeight;

    @Column(nullable = false)
    private Boolean personalInfoConsent;

    @Column(nullable = false, length = 10)
    private String role;

    @OneToMany(mappedBy = "memberPk")
    private List<Rom> memberPkRoms;

    @OneToMany(mappedBy = "memberPk")
    private List<Balance> memberPkBalances;

    public void changePassword(String password) {
        this.memberPassword = password;
    }

}


