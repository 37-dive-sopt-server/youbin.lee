package org.sopt.repository.comment;

import org.sopt.domain.commnet.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.EntityGraph;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByArticleId(Long articleId);
    @EntityGraph(attributePaths = {"member", "article"})
    Optional<Comment> findById(Long id);
}

