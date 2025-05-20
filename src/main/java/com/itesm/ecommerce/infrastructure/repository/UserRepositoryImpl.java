package com.itesm.ecommerce.infrastructure.repository;

import com.itesm.ecommerce.domain.model.User;
import com.itesm.ecommerce.domain.repository.UserRepository;
import com.itesm.ecommerce.infrastructure.entity.UserEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserRepositoryImpl implements UserRepository, PanacheRepositoryBase<UserEntity,Integer> {
    @Override
    public User getUserById(int userId) {
        UserEntity user = findById(userId);
        if (user == null) {
            return null;
        }
        User userModel = new User();
        userModel.setId(user.getId());
        userModel.setFirebaseId(user.getFirebaseId());
        return userModel;
    }

    @Override
    public User getUserByFirebaseId(String firebaseId) {
        UserEntity user = find("firebaseId", firebaseId).firstResult();
        if (user == null) {
            return null;
        }
        User userModel = new User();
        userModel.setId(user.getId());
        userModel.setFirebaseId(user.getFirebaseId());
        return userModel;

    }

    public UserEntity getUserEntityByFirebaseId(String firebaseId) {
        return find("firebaseId", firebaseId).firstResult();
    }
}
