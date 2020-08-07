package com.kimhong.apispring.repository;

import com.kimhong.apispring.repository.dto.CategoryDto;
import com.kimhong.apispring.repository.provider.CategoryProvider;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository {
    @Select("SELECT * FROM categories WHERE status=true")
    List<CategoryDto> findAll();

    @SelectProvider(type = CategoryProvider.class, method="findOneSql")
    CategoryDto findOne(int id);

    @InsertProvider(type = CategoryProvider.class, method = "saveSql")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void save(CategoryDto categoryDto);

    @UpdateProvider(type = CategoryProvider.class, method = "updateSql")
    void update(CategoryDto categoryDto);

    @DeleteProvider(type = CategoryProvider.class, method = "deleteSql")
    void delete(int id);
}
