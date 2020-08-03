package com.kimhong.apispring.service;

import com.kimhong.apispring.reposiitory.dto.ArticleDto;

public interface ArticleService {

    ArticleDto save(ArticleDto newArticle);
}
