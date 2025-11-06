package org.sopt.domain.article;

import jakarta.persistence.*;
import org.sopt.domain.member.Member;

import java.time.LocalDate;

@Entity(name = "article")
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

    public static Article create(Member member, String title, String content, Tag tag) {
      Article article = new Article();

      article.member = member;
      article.title = title;
      article.content = content;
      article.tag = tag;

      return article;
    }

    public Long getId() {
        return id;
    }

    public Member getMember() {
        return member;
    }

    public Tag getTag() {
        return tag;
    }

    public LocalDate getCreateAt() {
        return createAt;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
