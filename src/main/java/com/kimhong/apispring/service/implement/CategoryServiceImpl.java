package com.kimhong.apispring.service.implement;

import com.kimhong.apispring.repository.CategoryRepository;
import com.kimhong.apispring.repository.dto.CategoryDto;
import com.kimhong.apispring.rest.message.FailureMessage;
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

        if (categoryDto.getName().isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    FailureMessage.CATEGORY_NAME_CANNOT_BE_EMPTY.value());
        }
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

        CategoryDto category = categoryRepository.findOne(updateCategory.getId());
        if (category == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    FailureMessage.NOT_FOUND_BY_ID.value());

        if (updateCategory.getName().isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    FailureMessage.CATEGORY_NAME_CANNOT_BE_EMPTY.value());

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
