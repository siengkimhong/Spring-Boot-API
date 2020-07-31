package com.kimhong.apispring.reposiitory;

import com.kimhong.apispring.reposiitory.dto.CategoryDto;
import com.kimhong.apispring.reposiitory.provider.CategoryProvider;

import com.kimhong.apispring.rest.response.CategoryResponse;
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
