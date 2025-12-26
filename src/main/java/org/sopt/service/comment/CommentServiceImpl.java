package org.sopt.service.comment;

import lombok.RequiredArgsConstructor;
import org.sopt.domain.article.Article;
import org.sopt.domain.commnet.Comment;
import org.sopt.domain.member.Member;
import org.sopt.global.execption.CustomException;
import org.sopt.global.message.ErrorMessage;
import org.sopt.repository.article.ArticleRepository;
import org.sopt.repository.comment.CommentRepository;
import org.sopt.repository.member.MemberRepository;
import org.sopt.service.comment.dto.request.CommentCreateRequest;
import org.sopt.service.comment.dto.request.CommentUpdateRequest;
import org.sopt.service.comment.dto.response.CommentGetResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentServiceImpl implements CommentService {

    private final ArticleRepository articleRepository;
    private final MemberRepository memberRepository;
    private final CommentRepository commentRepository;

    @Override
    public void create(Long articleId, CommentCreateRequest request) {
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new CustomException(ErrorMessage.ARTICLE_NOT_FOUND));

        Member writer = memberRepository.findById(request.memberId())
                .orElseThrow(() -> new CustomException(ErrorMessage.MEMBER_NOT_FOUND));

        Comment comment = Comment.create(
                request.content(),
                article,
                writer
        );

        commentRepository.save(comment);
    }

    @Transactional(readOnly = true)
    @Override
    public List<CommentGetResponse> getCommentList(Long articleId) {
        articleRepository.findById(articleId)
                .orElseThrow(() -> new CustomException(ErrorMessage.ARTICLE_NOT_FOUND));

        return commentRepository.findAllByArticleId(articleId)
                .stream()
                .map(CommentGetResponse::toResponse)
                .toList();
    }

    @Override
    public void update(Long articleId, Long commentId, Long memberId, CommentUpdateRequest request) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new CustomException(ErrorMessage.COMMENT_NOT_EXIST));

        if (!comment.getArticle().getId().equals(articleId)) {
            throw new CustomException(ErrorMessage.COMMENT_NOT_IN_ARTICLE);
        }

        if (!comment.getMember().getId().equals(memberId)) {
            throw new CustomException(ErrorMessage.COMMENT_UPDATE_FORBIDDEN);
        }

        comment.updateContent(request.content());
    }
}
