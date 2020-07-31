package com.kimhong.apispring.rest.controller;

import com.kimhong.apispring.constant.ApiConstant;
import com.kimhong.apispring.reposiitory.dto.CategoryDto;
import com.kimhong.apispring.rest.message.FailureMessage;
import com.kimhong.apispring.rest.message.SuccessMessage;
import com.kimhong.apispring.rest.request.CategoryRequest;
import com.kimhong.apispring.rest.response.ApiResponse;
import com.kimhong.apispring.rest.response.CategoryResponse;
import com.kimhong.apispring.service.implement.CategoryServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(ApiConstant.API_VERSION)
public class CategoryController {

    private final CategoryServiceImpl service;

    @Autowired
    public CategoryController(CategoryServiceImpl service) {
        this.service = service;
    }

    @GetMapping(ApiConstant.CATEGORIES_URL)
    ResponseEntity<ApiResponse<List<CategoryResponse>>> getCategoriesAction() {
        ApiResponse<List<CategoryResponse>> apiResponse = new ApiResponse<>();
        ModelMapper modelMapper = new ModelMapper();
        List<CategoryDto> categoryDtoList = service.findAll();
        List<CategoryResponse> categoryResponseList = new ArrayList<>();
        for (CategoryDto categoryDto : categoryDtoList) {
            categoryResponseList.add(modelMapper.map(categoryDto, CategoryResponse.class));
        }
        apiResponse.setMessage(SuccessMessage.FOUND_ALL.value());
        apiResponse.setCode(HttpStatus.OK.value());
        apiResponse.setData(categoryResponseList);
        apiResponse.setTime(new Timestamp(System.currentTimeMillis()));
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping(ApiConstant.CATEGORIES_URL + "/{id}")
    ResponseEntity<ApiResponse<CategoryResponse>> getCategoryAction(@PathVariable int id){
        ApiResponse<CategoryResponse> response = new ApiResponse<>();
        ModelMapper modelMapper = new ModelMapper();
        CategoryDto categoryDto = service.findOne(id);
        if (categoryDto != null){
            CategoryResponse categoryResponse = modelMapper.map(categoryDto, CategoryResponse.class);
            response.setMessage(SuccessMessage.FOUND_ONE.value());
            response.setCode(HttpStatus.OK.value());
            response.setData(categoryResponse);
        }
        else {
            response.setMessage(FailureMessage.NOT_FOUND_BY_ID.value());
            response.setSuccess(false);
            response.setCode(HttpStatus.NO_CONTENT.value());
            response.setData(null);
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping(ApiConstant.CATEGORIES_URL)
    ResponseEntity<ApiResponse<CategoryResponse>> addCategoryAction(@RequestBody CategoryRequest categoryRequest){

        ApiResponse<CategoryResponse> response = new ApiResponse<>();
        ModelMapper mapper = new ModelMapper();

        CategoryDto categoryDto = mapper.map(categoryRequest, CategoryDto.class);
        CategoryDto saveCategory = service.save(categoryDto);
        CategoryResponse categoryResponse = mapper.map(saveCategory, CategoryResponse.class);

        response.setMessage(SuccessMessage.IS_SAVE.value());
        response.setSuccess(true);
        response.setCode(HttpStatus.CREATED.value());
        response.setData(categoryResponse);
        return ResponseEntity.ok(response);

    }

    @PutMapping(ApiConstant.CATEGORIES_URL + "/{id}")
    ResponseEntity<ApiResponse<CategoryResponse>> editCategoryAction(@PathVariable int id,
                                                                     @RequestBody CategoryRequest categoryRequest){

        ApiResponse<CategoryResponse> response = new ApiResponse<>();
        ModelMapper mapper = new ModelMapper();
        CategoryDto updateCategory = mapper.map(categoryRequest, CategoryDto.class);

        if (service.findOne(id) !=null){
            updateCategory.setId(id);
            CategoryDto categoryDto = service.update(updateCategory);
            CategoryResponse categoryResponse = mapper.map(categoryDto, CategoryResponse.class);
            response.setMessage(SuccessMessage.IS_UPDATE.value());
            response.setSuccess(true);
            response.setCode(HttpStatus.CREATED.value());
            response.setData(categoryResponse);
        }else {
            response.setMessage(FailureMessage.NOT_FOUND_BY_ID.value());
            response.setSuccess(false);
            response.setCode(HttpStatus.NO_CONTENT.value());
            response.setData(null);
        }
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(ApiConstant.CATEGORIES_URL + "/{id}")
    ResponseEntity<ApiResponse<CategoryResponse>> deleteCategory(@PathVariable int id){

        ApiResponse<CategoryResponse> response = new ApiResponse<>();
        if (service.findOne(id) !=null){
            service.delete(id);
            response.setMessage(SuccessMessage.IS_DELETE.value());
            response.setSuccess(true);
            response.setCode(HttpStatus.CREATED.value());
        }else {
            response.setMessage(FailureMessage.NOT_FOUND_BY_ID.value());
            response.setSuccess(false);
            response.setCode(HttpStatus.NO_CONTENT.value());
        }
        response.setData(null);
        return ResponseEntity.ok(response);
    }
}
