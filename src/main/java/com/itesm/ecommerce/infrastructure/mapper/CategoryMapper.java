package com.itesm.ecommerce.infrastructure.mapper;

import com.itesm.ecommerce.infrastructure.entity.CategoryEntity;
import com.itesm.ecommerce.domain.model.Category;
public class CategoryMapper {

    public static Category toDomain(CategoryEntity categoryEntity) {
        Category c= new Category();
        c.setName(categoryEntity.getName());
        c.setId(categoryEntity.getId());
        return c;
    }

    public static CategoryEntity toEntity(Category category) {
        CategoryEntity c= new CategoryEntity();
        c.setName(category.getName());
        c.setId(category.getId());
        return c;
    }
}
