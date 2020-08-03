package com.kimhong.apispring.rest.controller;

import com.kimhong.apispring.constant.ApiConstant;
import com.kimhong.apispring.reposiitory.dto.ArticleDto;
import com.kimhong.apispring.rest.request.ArticleRequest;
import com.kimhong.apispring.rest.response.ApiResponse;
import com.kimhong.apispring.rest.response.ArticleResponse;
import org.modelmapper.ModelMapper;
import org.springdoc.api.AbstractOpenApiResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiConstant.API_VERSION)
public class ArticleRestController {

    private ModelMapper mapper;
    private ApiResponse<List<ArticleResponse>> listResponse;
    private ApiResponse<ArticleResponse> response;

    @Autowired
    public void setMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Autowired
    public void setListResponse(ApiResponse<List<ArticleResponse>> listResponse) {
        this.listResponse = listResponse;
    }

    @Autowired
    public void setResponse(ApiResponse<ArticleResponse> response) {
        this.response = response;
    }

    @GetMapping(ApiConstant.ARTICLES_URL)
    public String getArticles(){
        return "articles";
    }

    @PostMapping(ApiConstant.ARTICLES_URL)
    public ResponseEntity<ApiResponse<ArticleResponse>> saveArticle(
            @RequestBody ArticleRequest articleRequest
            ){
        ArticleDto articleDto = mapper.map(articleRequest, ArticleDto.class);

        return null;
    }
}
