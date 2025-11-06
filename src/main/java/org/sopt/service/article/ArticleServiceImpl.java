package org.sopt.service.article;

import org.sopt.common.ErrorMessage;
import org.sopt.common.execption.CustomException;
import org.sopt.domain.article.Article;
import org.sopt.domain.article.Tag;
import org.sopt.domain.member.Member;
import org.sopt.repository.article.ArticleRepository;
import org.sopt.repository.member.MemberRepository;
import org.sopt.service.article.dto.request.ArticleCreateRequest;
import org.sopt.service.article.dto.response.ArticleGetResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository;
    private MemberRepository memberRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository, MemberRepository memberRepository) {
        this.articleRepository = articleRepository;
        this.memberRepository = memberRepository;
    }

    @Override
    public void create(ArticleCreateRequest request) {
        Member member = memberRepository.findById(request.memberId())
                .orElseThrow(() -> new CustomException(ErrorMessage.MEMBER_NOT_FOUND));

        Article article = Article.create(
                member,
                request.title(),
                request.content(),
                Tag.valueOf(request.tag())
        );

        articleRepository.save(article);
    }

    @Override
    public ArticleGetResponse getArticle(Long id) {
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorMessage.ARTICLE_NOT_FOUND));

        return ArticleGetResponse.from(article);
    }

    @Override
    public List<ArticleGetResponse> getArticleList() {
        return articleRepository.findAll().stream()
                .map(ArticleGetResponse::from)
                .toList();
    }

}
