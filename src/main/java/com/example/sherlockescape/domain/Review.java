package com.example.sherlockescape.domain;

import com.example.sherlockescape.dto.request.ReviewRequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.FetchType.LAZY;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "review_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "theme_id")
    private Theme theme;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    // ??????
    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private LocalDate playDate;

    @Column(nullable = false)
    private double score;

    ///// enum 고려
    @Column(nullable = false)
    private String challenge;

    @Column(nullable = false)
    private int difficulty;

    @Column(nullable = false)
    private int hint;

    @Column(nullable = false)
    private String comment;

    public void update(Member member, ReviewRequestDto requestDto) {
        this.nickname = member.getNickname();
        this.playDate = requestDto.getPlayDate();
        this.score = requestDto.getScore();
        this.challenge = requestDto.getChallenge();
        this.difficulty = requestDto.getDifficulty();
        this.hint = requestDto.getHint();
        this.comment = requestDto.getComment();
    }

}
