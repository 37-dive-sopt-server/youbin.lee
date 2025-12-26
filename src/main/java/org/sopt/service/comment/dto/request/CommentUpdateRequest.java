package org.sopt.service.comment.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CommentUpdateRequest(
        @NotNull Long memberId,
        @NotBlank @Size(max = 300) String content
) {

}
