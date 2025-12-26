package org.sopt.service.article.dto.response;

import org.sopt.domain.article.Article;

public record ArticleListGetResponse(
        Long id,
        String title,
        String content,
        String tag,
        Long memberId
) {
    public static ArticleListGetResponse from(Article article) {
        return new ArticleListGetResponse(
                article.getId(),
                article.getTitle(),
                article.getContent(),
                article.getTag().toString(),
                article.getMember().getId()
        );
    }

}
