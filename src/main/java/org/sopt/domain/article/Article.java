package org.sopt.domain.article;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sopt.domain.member.Member;

import java.time.LocalDate;

@Entity(name = "article")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    @Column(nullable = false)
    private LocalDate createAt;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    public Article(
            Member member,
            String title,
            String content,
            Tag tag
    ) {
        this.member = member;
        this.title = title;
        this.content = content;
        this.tag = tag;
    }

}
