package com.kimhong.apispring.repository.provider;

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

    //get all category which have more article with limit
    //
    public String mostPopularCategorySql(){
        return new SQL(){{
            SELECT("c.id, c.name");
            FROM("articles a INNER JOIN categories c on c.id = a.category_id");
            WHERE("a.status=true");
            GROUP_BY("c.name, c.id");
            ORDER_BY("count(category_id) desc");
            LIMIT("#{limit}");
        }}.toString();
    }

    public String mostPopularArticleByCategorySql(){
        return new SQL(){{
            SELECT("*");
            FROM("articles");
            WHERE("category_id=#{id}");
            ORDER_BY("id DESC");
            LIMIT(1);
        }}.toString();
    }
}
