package com.kimhong.apispring.reposiitory.provider;

import org.apache.ibatis.jdbc.SQL;

public class ArticleProvider {

    public String saveArticleSql(){
        return new SQL(){{
            INSERT_INTO("articles");
            VALUES("article_id", "#{articleId");
            VALUES("title","#{title}");
            VALUES("descriptions","#{description}");
            VALUES("thumbnail", "#{thumbnail}");
            VALUES("author", "#{author}");
            VALUES("category_id", "#{category.id}");
        }}.toString();
    }
}
