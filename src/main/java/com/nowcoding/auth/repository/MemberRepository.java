package com.nowcoding.auth.repository;

import com.nowcoding.auth.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity,Long> {
    Optional<MemberEntity> findByUsername(String username);
    Optional<MemberEntity> findByUsernameAndPasswordAndIsDeleted(String username,String password, String isDeleted);
}
