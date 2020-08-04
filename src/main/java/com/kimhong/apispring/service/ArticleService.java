package com.kimhong.apispring.service;

import com.kimhong.apispring.reposiitory.dto.ArticleDto;

import java.util.List;

public interface ArticleService {

    ArticleDto save(ArticleDto newArticle);

    List<ArticleDto> findAl();

    List<ArticleDto> recentPost(int limit);
}
