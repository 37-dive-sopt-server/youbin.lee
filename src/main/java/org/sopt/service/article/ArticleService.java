package org.sopt.service.article;

import org.sopt.service.article.dto.request.ArticleCreateRequest;
import org.sopt.service.article.dto.response.ArticleGetResponse;

import java.util.List;

public interface ArticleService {
    void create(ArticleCreateRequest request);

    ArticleGetResponse getArticle(Long id);

    List<ArticleGetResponse> getArticleList();
}
