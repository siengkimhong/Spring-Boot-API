package com.kimhong.apispring.service.implement;

import com.kimhong.apispring.reposiitory.CategoryRepository;
import com.kimhong.apispring.reposiitory.dto.CategoryDto;
import com.kimhong.apispring.rest.request.CategoryRequest;
import com.kimhong.apispring.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public CategoryDto findOne(int id) {        
        return categoryRepository.findOne(id);
    }

    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        try{
            categoryRepository.save(categoryDto);
            return categoryDto;
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    e.getCause().getMessage());
        }
    }

    @Override
    public CategoryDto update(CategoryDto updateCategory) {
        try{
            categoryRepository.update(updateCategory);
            return updateCategory;
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    e.getCause().getMessage());
        }
    }

    @Override
    public void delete(int id) {
        try{
            categoryRepository.delete(id);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    e.getCause().getMessage());
        }
    }
}
