package com.kimhong.apispring.rest.response;

import java.io.Serializable;

public class CategoryResponse implements Serializable {

    private String name;

    public CategoryResponse(String name) {
        this.name = name;
    }

    public CategoryResponse() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category Response{" +
                "name='" + name + '\'' +
                '}';
    }



}
