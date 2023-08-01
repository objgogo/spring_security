package com.nowcoding.auth.entity;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Member")
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer educationId;
    private String type;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String gender;
    private LocalDate birthDate;
    private String isUnder14;
    private String image;
    private String email;
    private String cellphone;
    private String isCellphoneCerted;
    private String cellphoneCertedAt;
    private String trialDatetime;
    private String termsAgreedAt;
    private String privacyTermsAgreedAt;
    private String status;
    private String isParentConfirmed;
    private String parentConfirmedAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String isWithdrawn;
    private String withdrawnAt;
    private String isDeleted;
    private String deletedAt;
    private String department;
    private String occupation;
    private String yearsOfService;
    private String company;
    private String rank;
    private String jobPosition;
    private String termCode;
    private String certName;
    private String extMemo;

    @OneToMany(mappedBy = "member", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Builder.Default
    private List<AuthorityEntity> roles = new ArrayList<>();
}
