package com.kimhong.apispring.service.implement;

import com.kimhong.apispring.reposiitory.ArticleRepository;
import com.kimhong.apispring.reposiitory.dto.ArticleDto;
import com.kimhong.apispring.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository;

    @Autowired
    public void setArticleRepository(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public ArticleDto save(ArticleDto newArticle) {

        try{
            newArticle.setArticleId(UUID.randomUUID().toString());
            articleRepository.save(newArticle);
            return newArticle;
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getCause().getMessage());
        }
    }

    @Override
    public List<ArticleDto> findAl() {
        return articleRepository.findAll();
    }

    @Override
    public List<ArticleDto> recentPost(int limit) {
        return articleRepository.recentPost(limit);
    }
}
