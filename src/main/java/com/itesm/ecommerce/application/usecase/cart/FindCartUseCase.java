package com.itesm.ecommerce.application.usecase.cart;

import com.itesm.ecommerce.domain.model.Cart;
import com.itesm.ecommerce.domain.model.User;
import com.itesm.ecommerce.domain.repository.CartRepository;
import com.itesm.ecommerce.domain.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class FindCartUseCase {

    @Inject
    UserRepository userRepository;
    @Inject
    CartRepository cartRepository;

    public Cart execute(String firebaseId){
        User user= userRepository.getUserByFirebaseId(firebaseId);
        Cart cart= cartRepository.findByUserId(user.getId());
        return cart;
    }
}
