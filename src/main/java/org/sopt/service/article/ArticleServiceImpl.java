package org.sopt.service.article;

import lombok.RequiredArgsConstructor;
import org.sopt.domain.article.Article;
import org.sopt.domain.member.Member;
import org.sopt.global.execption.CustomException;
import org.sopt.global.message.ErrorMessage;
import org.sopt.repository.article.ArticleRepository;
import org.sopt.repository.member.MemberRepository;
import org.sopt.service.article.dto.request.ArticleCreateRequest;
import org.sopt.service.article.dto.response.ArticleGetResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public void create(ArticleCreateRequest request) {
        Member member = memberRepository.findById(request.memberId())
                .orElseThrow(() -> new CustomException(ErrorMessage.MEMBER_NOT_FOUND));

        Article article = Article.create(
                member,
                request.title(),
                request.content(),
                request.tag()
        );

        articleRepository.save(article);
    }

    @Override
    @Transactional(readOnly = true)
    public ArticleGetResponse getArticle(Long id) {
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorMessage.ARTICLE_NOT_FOUND));

        return ArticleGetResponse.from(article);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ArticleGetResponse> getArticleList() {
        return articleRepository.findAll().stream()
                .map(ArticleGetResponse::from)
                .toList();
    }
}
