package com.itesm.ecommerce.application.service;

import com.itesm.ecommerce.domain.model.Cart;
import com.itesm.ecommerce.domain.model.Product;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CartService {

    public Cart findByUserId(int userId){
        return null;
    }

    public void addProductToCart(Product product, Cart cart, int quantity) {

    }

    public void removeProductFromCart(Product product, Cart cart) {

    }

    public void clearCart(Cart cart) {
    }
}
