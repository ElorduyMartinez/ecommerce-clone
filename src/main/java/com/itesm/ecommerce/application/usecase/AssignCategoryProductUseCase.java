package com.itesm.ecommerce.application.usecase;

import com.itesm.ecommerce.application.service.ProductService;
import com.itesm.ecommerce.infrastructure.dto.category.AssignCategoryToProductDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class AssignCategoryProductUseCase {
    @Inject
    ProductService productService;

    public void execute(AssignCategoryToProductDTO dto){
        productService.assignCategory(dto.getCategoryId(), dto.getProductId());
    }
}
