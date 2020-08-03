package com.kimhong.apispring.rest.request;

public class CategoryRequest {
    private String name;

    public CategoryRequest(String name) {
        this.name = name.trim();
    }

    public CategoryRequest() {
    }

    public String getName() {
        return name.trim();
    }

    public void setName(String name) {
        this.name = name.trim();
    }

    @Override
    public String toString() {
        return "Category Response{" +
                "name='" + name + '\'' +
                '}';
    }
}
