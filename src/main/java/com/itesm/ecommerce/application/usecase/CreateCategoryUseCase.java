package com.itesm.ecommerce.application.usecase;

import com.itesm.ecommerce.domain.model.Category;
import com.itesm.ecommerce.infrastructure.dto.category.CreateCategoryDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import com.itesm.ecommerce.application.service.CategoryService;
@ApplicationScoped
public class CreateCategoryUseCase {

    @Inject
    CategoryService categoryService;

    public Category execute(CreateCategoryDTO dto) {
        return categoryService.createCategory(dto);
    }

}
