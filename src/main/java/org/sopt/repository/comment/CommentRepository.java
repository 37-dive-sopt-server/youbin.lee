package org.sopt.repository.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.sopt.domain.commnet.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
