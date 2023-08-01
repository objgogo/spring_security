package com.nowcoding.auth.service;

import com.nowcoding.auth.entity.AuthorityEntity;
import com.nowcoding.auth.entity.MemberEntity;
import com.nowcoding.auth.repository.MemberRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService implements UserDetailsService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public MemberService(MemberRepository memberRepository, PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        MemberEntity member = memberRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("Invalid authentication!")
        );

        return new CustomUserDetails(member);
    }

    public void insertMember(){
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

    public void login(String username, String password){

        Optional<MemberEntity> checkMember = memberRepository.findByUsername(username);
    }


}
