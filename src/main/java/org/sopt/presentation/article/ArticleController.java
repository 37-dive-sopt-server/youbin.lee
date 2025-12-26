package org.sopt.presentation.article;

import lombok.RequiredArgsConstructor;
import org.sopt.global.dto.BaseApiResponse;
import org.sopt.global.message.SuccessMessage;
import org.sopt.service.article.ArticleService;
import org.sopt.service.article.dto.request.ArticleCreateRequest;
import org.sopt.service.article.dto.response.ArticleGetResponse;
import org.sopt.service.article.dto.response.ArticleListGetResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/article")
public class ArticleController {
    private final ArticleService articleService;

    @PostMapping
    public ResponseEntity<BaseApiResponse> createArticle(
            @RequestBody ArticleCreateRequest request
    ) {
        articleService.create(request);

        return ResponseEntity.ok(BaseApiResponse.of(SuccessMessage.SUCCESS_CREATE_ARTICLE));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseApiResponse<ArticleGetResponse>> getArticle(
            @PathVariable Long id
    ) {
        ArticleGetResponse response = articleService.getArticle(id);

        return ResponseEntity.ok(BaseApiResponse.of(SuccessMessage.SUCCESS_GET_ARTICLE, response));
    }

    @GetMapping
    public ResponseEntity<BaseApiResponse<ArticleListGetResponse>> getArticleList() {
        ArticleListGetResponse response = articleService.getArticleList();

        return ResponseEntity.ok(BaseApiResponse.of(SuccessMessage.SUCCESS_GET_ARTICLE_LIST, response));
    }
}
