package com.kimhong.apispring.util;

import com.kimhong.apispring.rest.response.ApiResponse;
import com.kimhong.apispring.rest.response.ArticleResponse;
import com.kimhong.apispring.rest.response.CategoryResponse;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApiComponent {

    @Bean
    public ModelMapper mapper(){
        return new ModelMapper();
    }

    @Bean
    public ApiResponse<CategoryResponse> apiCategoryResponse(){
        return new ApiResponse<>();
    }

    @Bean
    public ApiResponse<List<CategoryResponse>> apiCategoryResponseList(){
        return new ApiResponse<>();
    }

    @Bean
    public ApiResponse<ArticleResponse> apiArticleResponse(){
        return new ApiResponse<ArticleResponse>();
    }

    @Bean
    public ApiResponse<List<ArticleResponse>> apiArticleResponseList(){
        return new ApiResponse<>();
    }
}
