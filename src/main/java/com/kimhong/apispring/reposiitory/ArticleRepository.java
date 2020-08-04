package com.kimhong.apispring.reposiitory;

import com.kimhong.apispring.reposiitory.dto.ArticleDto;
import com.kimhong.apispring.reposiitory.dto.CategoryDto;
import com.kimhong.apispring.reposiitory.provider.ArticleProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository {

    @InsertProvider(type = ArticleProvider.class, method = "saveArticleSql")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void save(ArticleDto articleDto);

    @Select("SELECT * FROM articles WHERE status=true ORDER BY id DESC")
    @Results(id = "articleMap",
            value = {
                    @Result(property = "id", column = "id"),
                    @Result(property = "articleId", column = "article_id"),
                    @Result(property = "title", column = "title"),
                    @Result(property = "description", column = "description"),
                    @Result(property = "thumbnail", column = "thumbnail"),
                    @Result(property = "author", column = "author"),
                    @Result(property = "publishedDate", column = "published_date"),
                    @Result(property = "category", column = "id",
                            many = @Many(select = "selectCategoryByArticleId"))

    })
    List<ArticleDto> findAll();

    @SelectProvider(type = ArticleProvider.class, method = "selectCategoryByArticleIdSql")
    CategoryDto selectCategoryByArticleId(int id);

    @SelectProvider(type = ArticleProvider.class, method = "recentPostSQL")
    @ResultMap("articleMap")
    List<ArticleDto> recentPost(int limit);
}
