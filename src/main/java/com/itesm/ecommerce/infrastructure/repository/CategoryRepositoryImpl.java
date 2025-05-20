package com.itesm.ecommerce.infrastructure.repository;

import com.itesm.ecommerce.domain.model.Category;
import com.itesm.ecommerce.domain.repository.CategoryRepository;
import com.itesm.ecommerce.infrastructure.entity.CategoryEntity;
import com.itesm.ecommerce.infrastructure.mapper.CategoryMapper;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class CategoryRepositoryImpl implements CategoryRepository, PanacheRepositoryBase<CategoryEntity,Integer> {

    @Override
    public Category insertCategory(Category category) {
        CategoryEntity categoryEntity= CategoryMapper.toEntity(category);
        categoryEntity.persist();
        return CategoryMapper.toDomain(categoryEntity);
    }
}
