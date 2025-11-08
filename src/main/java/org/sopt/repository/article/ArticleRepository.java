package org.sopt.repository.article;

import org.springframework.data.jpa.repository.JpaRepository;
import org.sopt.domain.article.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    boolean existsByTitle(String title);
}
