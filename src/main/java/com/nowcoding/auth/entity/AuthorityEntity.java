package com.nowcoding.auth.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="Member_Auth")
public class AuthorityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    private String name;

    @JoinColumn(name = "member")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private MemberEntity member;

    public void setMember(MemberEntity member) {
        this.member = member;
    }

}
