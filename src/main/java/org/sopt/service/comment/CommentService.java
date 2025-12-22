package org.sopt.service.comment;

import org.sopt.service.comment.dto.CommentCreateRequest;

public interface CommentService {
    void create(Long articleId, CommentCreateRequest request);
}
