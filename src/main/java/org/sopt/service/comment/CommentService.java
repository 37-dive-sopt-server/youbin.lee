package org.sopt.service.comment;

import org.sopt.service.comment.dto.request.CommentCreateRequest;
import org.sopt.service.comment.dto.response.CommentGetResponse;

import java.util.List;

public interface CommentService {
    void create(Long articleId, CommentCreateRequest request);
    List<CommentGetResponse> getCommentList(Long articleId);
}
