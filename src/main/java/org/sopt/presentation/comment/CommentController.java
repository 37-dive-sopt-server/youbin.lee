package org.sopt.presentation.comment;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.sopt.global.dto.BaseApiResponse;
import org.sopt.global.message.SuccessMessage;
import org.sopt.service.comment.CommentService;
import org.sopt.service.comment.dto.request.CommentCreateRequest;
import org.sopt.service.comment.dto.request.CommentUpdateRequest;
import org.sopt.service.comment.dto.response.CommentGetResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<BaseApiResponse<List<CommentGetResponse>>> getCommentList(
            @PathVariable Long articleId
    ) {
        List<CommentGetResponse> response = commentService.getCommentList(articleId);

        return ResponseEntity.ok(BaseApiResponse.of(SuccessMessage.SUCCESS_GET_COMMENT_LIST, response));
    }

    @PatchMapping("/{commentId}")
    public ResponseEntity<BaseApiResponse> updateComment(
            @PathVariable Long articleId,
            @PathVariable Long commentId,
            @RequestParam Long memberId,
            @Valid @RequestBody CommentUpdateRequest request
    ) {
        commentService.update(articleId, commentId, memberId, request);

        return ResponseEntity.ok(BaseApiResponse.of(SuccessMessage.SUCCESS_UPDATE_COMMENT));
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<BaseApiResponse> deleteComment(
            @PathVariable Long articleId,
            @PathVariable Long commentId,
            @RequestParam Long memberId
    ) {
        commentService.delete(articleId, commentId, memberId);

        return ResponseEntity.ok(BaseApiResponse.of(SuccessMessage.SUCCESS_DELETED_COMMENT));
    }
}
