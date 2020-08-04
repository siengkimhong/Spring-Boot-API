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

    public String selectAll(){
        return new SQL(){{
            SELECT("*");
            FROM("articles");
            WHERE("status=true");
            ORDER_BY("id desc");
        }}.toString();
    }

    public String selectCategoryByArticleIdSql(){
        return new SQL(){{
            SELECT("c.id, c.name");
            FROM("categories c");
            INNER_JOIN("articles a ON a.category_id=c.id");
            WHERE("c.status=true");
            WHERE("a.id=#{id}");
        }}.toString();
    }

    public String recentPostSQL(){
        return new SQL(){{
            SELECT("*");
            FROM("articles");
            WHERE("status=true");
            ORDER_BY("id desc");
            LIMIT("#{limit}");
        }}.toString();
    }
}
