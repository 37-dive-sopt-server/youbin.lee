package org.sopt.service.article.dto.response;

import org.sopt.domain.article.Article;

import java.util.List;

public record ArticleListGetResponse(
        List<ArticleSummary> articles
) {

    public record ArticleSummary(
            Long id,
            String title,
            String content,
            String tag,
            Long memberId
    ) {
        public static ArticleSummary from(Article article) {
            return new ArticleSummary(
                    article.getId(),
                    article.getTitle(),
                    article.getContent(),
                    article.getTag().toString(),
                    article.getMember().getId()
            );
        }
    }

    public static ArticleListGetResponse from(List<Article> articles) {
        return new ArticleListGetResponse(
                articles.stream()
                        .map(ArticleSummary::from)
                        .toList()
        );
    }
}
