package com.itesm.ecommerce.domain.repository;

import com.itesm.ecommerce.domain.model.User;

public interface UserRepository {

    public User getUserById(int userId);
    public User getUserByFirebaseId(String firebaseId);

}
