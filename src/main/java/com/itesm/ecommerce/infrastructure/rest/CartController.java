package com.itesm.ecommerce.infrastructure.rest;

import com.itesm.ecommerce.application.usecase.cart.AddProductToCartUseCase;
import com.itesm.ecommerce.application.usecase.cart.FindCartUseCase;
import com.itesm.ecommerce.infrastructure.dto.cart.AddProductDto;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Path("/cart")
public class CartController {

    @Inject
    private AddProductToCartUseCase addProductToCartUseCase;
    @Inject
    private FindCartUseCase findCartUseCase;

    @POST
    @Path("/add")
    public Response addProductToCart(AddProductDto addProductDto) {
        addProductToCartUseCase.execute(addProductDto, "H5AkbDHeaEhAgvfGLqyn6r9d0Ua2");
        Map<String,String> response= new HashMap<>();
        response.put("message", "Product added to cart");
        response.put("productId", String.valueOf(addProductDto.getIdProduct()));
        response.put("quantity", String.valueOf(addProductDto.getQuantity()));
        return Response.ok().entity(response).build();
    }

    @GET
    public Response getCart() {
        return Response.ok().entity(findCartUseCase.execute("H5AkbDHeaEhAgvfGLqyn6r9d0Ua2")).build();
    }
}
