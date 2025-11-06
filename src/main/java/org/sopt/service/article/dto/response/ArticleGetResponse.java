package org.sopt.service.article.dto.response;

import org.sopt.domain.article.Article;

import java.time.LocalDate;

public record ArticleGetResponse(
        Long id,
        String title,
        String content,
        String tag,
        LocalDate createAt
) {
    public static ArticleGetResponse from(Article article) {
        return new ArticleGetResponse(
                article.getId(),
                article.getTitle(),
                article.getContent(),
                article.getTag().toString(),
                article.getCreateAt()
        );
    }
}
