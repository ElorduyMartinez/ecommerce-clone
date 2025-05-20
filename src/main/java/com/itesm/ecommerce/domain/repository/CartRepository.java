package com.itesm.ecommerce.domain.repository;

import com.itesm.ecommerce.domain.model.Cart;

public interface CartRepository {
    public void createCart(String userId);
    public void changeStatus(int cartId, String status);
    public void emptyCart(int cartId);
    public Cart findByUserId(int id);
}
