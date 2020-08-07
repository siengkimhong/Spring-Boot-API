package com.kimhong.apispring.rest.response;


import com.kimhong.apispring.repository.dto.CategoryDto;

import java.io.Serializable;
import java.util.Date;

public class ArticleResponse implements Serializable {

    private String articleId;
    private String title;
    private String description;
    private String thumbnail;
    private String author;
    private Date publishedDate;
    private CategoryDto category;

    public ArticleResponse() {
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public CategoryDto getCategory() {
        return category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "ArticleResponse{" +
                "articleId='" + articleId + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", author='" + author + '\'' +
                ", publishedDate=" + publishedDate +
                ", category=" + category +
                '}';
    }
}
