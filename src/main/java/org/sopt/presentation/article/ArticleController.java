package org.sopt.presentation.article;

import lombok.RequiredArgsConstructor;
import org.sopt.common.BaseApiResponse;
import org.sopt.common.SuccessMessage;
import org.sopt.service.article.ArticleService;
import org.sopt.service.article.dto.request.ArticleCreateRequest;
import org.sopt.service.article.dto.response.ArticleGetResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

        return ResponseEntity.ok(BaseApiResponse.of(SuccessMessage.SUCCESS_CREATE_MEMBER));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseApiResponse<ArticleGetResponse>> getArticle(
            @PathVariable Long id
    ) {
        ArticleGetResponse response = articleService.getArticle(id);

        return ResponseEntity.ok(BaseApiResponse.of(SuccessMessage.SUCCESS_GET_ARTICLE, response));
    }

    @GetMapping
    public ResponseEntity<BaseApiResponse<List<ArticleGetResponse>>> getArticleList() {
        List<ArticleGetResponse> response = articleService.getArticleList();

        return ResponseEntity.ok(BaseApiResponse.of(SuccessMessage.SUCCESS_GET_ARTICLE_LIST, response));
    }

}
