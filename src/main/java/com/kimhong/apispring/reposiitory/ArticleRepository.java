package com.kimhong.apispring.reposiitory;

import com.kimhong.apispring.reposiitory.dto.ArticleDto;
import com.kimhong.apispring.reposiitory.provider.ArticleProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository {

    @InsertProvider(type = ArticleProvider.class, method = "saveArticleSql")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void save(ArticleDto articleDto);
}
