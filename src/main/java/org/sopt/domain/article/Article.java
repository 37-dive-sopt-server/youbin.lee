package org.sopt.domain.article;

import jakarta.persistence.*;
import lombok.*;
import org.sopt.domain.member.Member;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Entity(name = "article")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EntityListeners(AuditingEntityListener.class)
@Builder
@Getter
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    private Member member;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Tag tag;

    @CreatedDate
    @Column(nullable = false)
    private LocalDate createAt;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

}
