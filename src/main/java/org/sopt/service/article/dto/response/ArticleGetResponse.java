package org.sopt.service.article.dto.response;

import org.sopt.domain.article.Article;
import org.sopt.service.comment.dto.response.CommentGetResponse;

import java.util.List;

public record ArticleGetResponse(
        Long id,
        String title,
        String content,
        String tag,
        Long memberId,
        List<CommentGetResponse> comments
) {
    public static ArticleGetResponse from(
            Article article,
            List<CommentGetResponse> comments
    ) {
        return new ArticleGetResponse(
                article.getId(),
                article.getTitle(),
                article.getContent(),
                article.getTag().toString(),
                article.getMember().getId(),
                comments
        );
    }
}
