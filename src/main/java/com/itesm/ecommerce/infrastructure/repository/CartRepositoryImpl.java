package com.itesm.ecommerce.infrastructure.repository;

import com.itesm.ecommerce.domain.model.Cart;
import com.itesm.ecommerce.domain.model.CartHasProduct;
import com.itesm.ecommerce.domain.model.Product;
import com.itesm.ecommerce.domain.repository.CartRepository;
import com.itesm.ecommerce.infrastructure.entity.CartEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.ArrayList;

@ApplicationScoped
public class CartRepositoryImpl implements CartRepository, PanacheRepositoryBase<CartEntity, Integer> {

    @Inject
    UserRepositoryImpl userRepository;

    @Override
    public void createCart(String userId) {
        CartEntity cart = new CartEntity();
        cart.setUser(userRepository.getUserEntityByFirebaseId(userId));
        cart.setStatus("active");
        persist(cart);
    }

    @Override
    public void changeStatus(int cartId, String status) {
        CartEntity cart = findById(cartId);
        if (cart != null) {
            cart.setStatus(status);
            persist(cart);
        }
    }

    @Override
    public void emptyCart(int cartId) {
    }

    @Override
    public Cart findByUserId(int id) {
        CartEntity cart = find("user.id", id).firstResult();
        if (cart == null) {
            return null;
        }
        Cart cartModel = new Cart();
        cartModel.setId(cart.getId());
        cartModel.setStatus(cart.getStatus());
        cartModel.setProductsInCart(new ArrayList<>());
        for(int i = 0; i < cart.getCartHasProductsEntity().size(); i++) {
            CartHasProduct cartHasProduct = new CartHasProduct();
            cartHasProduct.setCart(cartModel);
            Product product = new Product();
            product.setName(cart.getCartHasProductsEntity().get(i).getProduct().getName());
            cartHasProduct.setProduct(product);
            cartHasProduct.setQuantity(cart.getCartHasProductsEntity().get(i).getQuantity());
            cartModel.getProductsInCart().add(cartHasProduct);
        }
        return cartModel;
    }

    public CartEntity getCartById(int cartId) {
        return findById(cartId);
    }

}
