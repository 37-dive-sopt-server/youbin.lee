package org.sopt.service.comment.dto.response;

import org.sopt.domain.commnet.Comment;

public record CommentGetResponse(
        Long id,
        String content
) {
    public static CommentGetResponse toResponse(Comment comment) {
        return new CommentGetResponse(
                comment.getId(),
                comment.getContent()
        );
    }
}
