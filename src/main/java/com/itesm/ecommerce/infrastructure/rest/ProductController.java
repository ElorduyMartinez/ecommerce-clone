package com.itesm.ecommerce.infrastructure.rest;

import com.google.firebase.auth.FirebaseToken;
import com.itesm.ecommerce.application.usecase.AssignCategoryProductUseCase;
import com.itesm.ecommerce.application.usecase.CreateProductUseCase;
import com.itesm.ecommerce.application.usecase.ListProductsUseCase;
import com.itesm.ecommerce.infrastructure.dto.CreateProductDTO;
import com.itesm.ecommerce.infrastructure.dto.category.AssignCategoryToProductDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
@Path("/products")
@Consumes("application/json")
@Produces("application/json")
public class ProductController {

    @Inject
    CreateProductUseCase createProductUseCase;
    @Inject
    ListProductsUseCase listProductsUseCase;
    @Inject
    AssignCategoryProductUseCase assignCategoryProductUseCase;

    @POST
    public Response createProduct(CreateProductDTO productRequest) {
        try{
            return Response.ok(createProductUseCase.execute(productRequest.toProduct())).build();
        }catch (Exception e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }

    }

    @GET
    @Path("/test-auth")
    public Response testAuth() {
        return Response.ok("Authentication successful").build();
    }

    @GET
    @Path("/list")
    public Response listProducts(@Context ContainerRequestContext requestContext) {
        return Response.ok(listProductsUseCase.execute()).build(); // Replace with actual product list
    }

    @PUT
    @Path("/assign-category")
    public Response updateProduct(AssignCategoryToProductDTO dto) {
        try{
            assignCategoryProductUseCase.execute(dto);
            return Response.ok().build();
        }catch (Exception e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
