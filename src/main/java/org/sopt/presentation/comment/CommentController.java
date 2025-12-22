package org.sopt.presentation.comment;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.sopt.global.dto.BaseApiResponse;
import org.sopt.global.message.SuccessMessage;
import org.sopt.service.comment.CommentService;
import org.sopt.service.comment.dto.CommentCreateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/articles/{articleId}/comments")
public class CommentController {
    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<BaseApiResponse> createComment(
            @PathVariable Long articleId,
            @Valid @RequestBody CommentCreateRequest request
    ) {
        commentService.create(articleId, request);

        return ResponseEntity.ok(BaseApiResponse.of(SuccessMessage.SUCCESS_CREATE_COMMENT));
    }
}
