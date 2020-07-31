package com.kimhong.apispring.rest.request;

public class CategoryRequest {
    private String name;

    public CategoryRequest(String name) {
        this.name = name;
    }

    public CategoryRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CategoryReponse{" +
                "name='" + name + '\'' +
                '}';
    }
}
