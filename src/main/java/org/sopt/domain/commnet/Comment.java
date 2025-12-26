package org.sopt.domain.commnet;

import jakarta.persistence.*;
import lombok.*;
import org.sopt.domain.article.Article;
import org.sopt.domain.member.Member;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity(name = "comment")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EntityListeners(AuditingEntityListener.class)
@Builder
@Getter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 300)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "article_id")
    private Article article;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    private Comment(String content, Article article, Member member) {
        this.content = content;
        this.article = article;
        this.member = member;
    }

    public static Comment create(String content, Article article, Member member) {
        return Comment.builder()
                .content(content)
                .article(article)
                .member(member)
                .build();
    }

    public void updateContent(String newContent) {
        this.content = newContent;
    }
}
