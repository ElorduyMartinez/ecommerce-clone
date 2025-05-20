package com.itesm.ecommerce.infrastructure.rest;

import com.itesm.ecommerce.application.usecase.CreateCategoryUseCase;
import com.itesm.ecommerce.domain.model.Category;
import com.itesm.ecommerce.infrastructure.dto.category.CreateCategoryDTO;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/categories")
public class CategoryController {
    @Inject
    CreateCategoryUseCase createCategoryUseCase;

    @POST
    public Response createCategory(CreateCategoryDTO dto) {
        Category category = createCategoryUseCase.execute(dto);
        return Response.ok(category).build();
    }
}
