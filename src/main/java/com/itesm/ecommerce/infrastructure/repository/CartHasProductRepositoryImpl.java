package com.itesm.ecommerce.infrastructure.repository;

import com.itesm.ecommerce.domain.repository.CartHasProductRepository;
import com.itesm.ecommerce.infrastructure.entity.CartHasProductsEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CartHasProductRepositoryImpl implements CartHasProductRepository, PanacheRepository<CartHasProductsEntity> {
    @Inject
    CartRepositoryImpl cartRepository;

    @Inject
    ProductRepositoryImpl productRepository;
    @Override
    public void addProductToCart(int cartId, int productId, int quantity) {
        System.out.println("Adding product with ID " + productId + " to cart with ID " + cartId + " with quantity " + quantity);
        CartHasProductsEntity cartHasProduct = new CartHasProductsEntity();
        cartHasProduct.setCart(cartRepository.getCartById(cartId));
        cartHasProduct.setProduct(productRepository.findById(productId));
        cartHasProduct.setQuantity(quantity);
        persist(cartHasProduct);
        System.out.println("Product added to cart successfully.");

    }
}
