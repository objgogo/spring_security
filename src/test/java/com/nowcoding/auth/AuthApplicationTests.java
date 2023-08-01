package com.nowcoding.auth;

import com.nowcoding.auth.entity.AuthorityEntity;
import com.nowcoding.auth.entity.MemberEntity;
import com.nowcoding.auth.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class AuthApplicationTests {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${jwt.secret.key}")
    private String secretKey;

    @Test
    void contextLoads() {
    }

    @Test
    void insertMemberTest(){

        List<AuthorityEntity> authList = new ArrayList<>();
        AuthorityEntity a = AuthorityEntity.builder().name("USER").build();

        authList.add(a);
        MemberEntity member = MemberEntity.builder()
                .username("test")
                .password(passwordEncoder.encode("asdf1234"))
                .educationId(171)
                .email("test@test.com")
                .roles(authList)
                .build();

        memberRepository.save(member);
    }

    @Test
    void isSecretKey(){
        System.out.println(secretKey);
    }

}
