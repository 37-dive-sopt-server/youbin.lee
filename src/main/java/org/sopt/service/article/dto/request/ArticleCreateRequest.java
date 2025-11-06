package org.sopt.service.article.dto.request;

import java.time.LocalDate;

public record ArticleCreateRequest(
        Long memberId,
        String title,
        String content,
        String tag,
        LocalDate creatAt
) {
}
