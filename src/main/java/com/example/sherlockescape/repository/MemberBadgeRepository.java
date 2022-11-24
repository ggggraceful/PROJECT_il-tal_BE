package com.example.sherlockescape.repository;


import com.example.sherlockescape.domain.MemberBadge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberBadgeRepository extends JpaRepository<MemberBadge, Long> {
    MemberBadge findByBadgeId(Long badgeId);
    List<MemberBadge> findAllByMemberId(Long memberId);

}