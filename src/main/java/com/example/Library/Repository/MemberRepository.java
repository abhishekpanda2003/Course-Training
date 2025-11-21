package com.example.Library.Repository;

import com.example.Library.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    boolean existsByEmail(String email);
}
