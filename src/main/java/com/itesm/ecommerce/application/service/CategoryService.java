package com.itesm.ecommerce.application.service;

import com.itesm.ecommerce.domain.model.Category;
import com.itesm.ecommerce.domain.repository.CategoryRepository;
import com.itesm.ecommerce.infrastructure.dto.category.CreateCategoryDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class CategoryService {
    @Inject
    CategoryRepository categoryRepository;

    @Transactional
    public Category createCategory(CreateCategoryDTO dto) {
        Category category= dto.toDomain();
        category=categoryRepository.insertCategory(category);
        return category;
    }

}
