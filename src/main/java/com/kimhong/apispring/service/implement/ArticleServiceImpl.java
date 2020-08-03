package com.kimhong.apispring.service.implement;

import com.kimhong.apispring.reposiitory.ArticleRepository;
import com.kimhong.apispring.reposiitory.dto.ArticleDto;
import com.kimhong.apispring.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository;

    @Autowired
    public void setArticleRepository(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public ArticleDto save(ArticleDto newArticle) {
        articleRepository.save(newArticle);
        return newArticle;
    }
}
