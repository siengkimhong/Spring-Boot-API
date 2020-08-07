package com.kimhong.apispring.repository.dto;

import java.io.Serializable;
import java.util.Date;

public class ArticleDto implements Serializable {

    private int id;
    private String articleId;
    private String title;
    private String description;
    private String thumbnail;
    private String author;
    private Date publishedDate;
    private CategoryDto category;
    private boolean status;

    public ArticleDto(int id, String articleId, String title, String description, String thumbnail, String author, Date publishedDate, CategoryDto category, boolean status) {
        this.id = id;
        this.articleId = articleId;
        this.title = title;
        this.description = description;
        this.thumbnail = thumbnail;
        this.author = author;
        this.publishedDate = publishedDate;
        this.category = category;
        this.status = status;
    }

    public ArticleDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ArticleDto{" +
                "id=" + id +
                ", articleId='" + articleId + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", author='" + author + '\'' +
                ", publishedDate=" + publishedDate +
                ", category=" + category +
                ", status=" + status +
                '}';
    }
}
