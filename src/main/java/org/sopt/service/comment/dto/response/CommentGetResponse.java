package org.sopt.service.comment.dto.response;

import org.sopt.domain.commnet.Comment;
import org.sopt.domain.member.Member;

public record CommentGetResponse(
        Long id,
        String content,
        MemberResponse member
) {
    public record MemberResponse(
            Long id,
            String name
    ) {}

    public static CommentGetResponse toResponse(Comment comment) {
        Member member = comment.getMember();

        return new CommentGetResponse(
                comment.getId(),
                comment.getContent(),
                new MemberResponse(
                        member.getId(),
                        member.getName()
                )
        );
    }
}
