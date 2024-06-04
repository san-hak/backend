package com.mda.imirror.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "member")
public class Member implements Serializable {

    @Serial
    private static final long serialVersionUID = -8816508202720576265L;

    @Id
    @Column(nullable = false, updatable = false, length = 36)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String memberPk;

    @Column(nullable = false, length = 100)
    private String memberName;

    @Column(nullable = false)
    private Boolean isMale;

    @Column(nullable = false)
    private LocalDate memberBirthDate;

    @Column(nullable = false)
    private Boolean personalInfoConsent;

    @Column(nullable = false, length = 10)
    private String role;

    @Column(nullable = false)
    private LocalDate recentCheckupDate;

    public void changeMemberInfo(String memberName, LocalDate memberBirthDate, Boolean isMale, Boolean personalInfoConsent, LocalDate recentCheckupDate) {

        this.memberName = memberName == null ? this.memberName : memberName;
        this.memberBirthDate = memberBirthDate == null ? this.memberBirthDate : memberBirthDate;
        this.isMale = isMale == null ? this.isMale : isMale;
        this.personalInfoConsent = personalInfoConsent == null ? this.personalInfoConsent : personalInfoConsent;
        this.recentCheckupDate = recentCheckupDate == null ? this.recentCheckupDate : recentCheckupDate;
    }

    @Override
    public int hashCode() {
        return memberPk.hashCode();
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberPk='" + memberPk + '\'' +
                ", memberName='" + memberName + '\'' +
                ", isMale=" + isMale + '\'' +
                ", memberBirthDate=" + memberBirthDate + '\'' +
                ", personalInfoConsent=" + personalInfoConsent + '\'' +
                ", role='" + role + '\'' +
                ", recentCheckupDate=" + recentCheckupDate + '\n' +
                '}';
    }

}


