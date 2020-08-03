package com.kimhong.apispring.rest.controller;

import com.kimhong.apispring.constant.ApiConstant;
import com.kimhong.apispring.reposiitory.dto.ArticleDto;
import com.kimhong.apispring.rest.message.SuccessMessage;
import com.kimhong.apispring.rest.request.ArticleRequest;
import com.kimhong.apispring.rest.response.ApiResponse;
import com.kimhong.apispring.rest.response.ArticleResponse;
import com.kimhong.apispring.service.implement.ArticleServiceImpl;
import org.modelmapper.ModelMapper;
import org.springdoc.api.AbstractOpenApiResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiConstant.API_VERSION)
public class ArticleRestController {

    private final ArticleServiceImpl service;
    private ModelMapper mapper;

    @Autowired
    public ArticleRestController(ArticleServiceImpl service) {
        this.service = service;
    }

    @Autowired
    public void setMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @GetMapping(ApiConstant.ARTICLES_URL)
    public String getArticles(){
        return "articles";
    }

    @PostMapping(ApiConstant.ARTICLES_URL)
    public ResponseEntity<ApiResponse<ArticleResponse>> saveArticle(
            @RequestBody ArticleRequest articleRequest
            ){

        ApiResponse<ArticleResponse> response = new ApiResponse<>();
        ArticleDto articleDto = mapper.map(articleRequest, ArticleDto.class);
        ArticleDto saveArticle = service.save(articleDto);
        ArticleResponse articleResponse = mapper.map(saveArticle, ArticleResponse.class);
        response.setResponse(SuccessMessage.IS_SAVE.value(),
                true,
                HttpStatus.CREATED.value(),
                articleResponse);
        return ResponseEntity.ok(response);
    }
}
