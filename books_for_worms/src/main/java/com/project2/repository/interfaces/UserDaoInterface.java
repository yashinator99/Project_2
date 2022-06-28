package com.project2.repository.interfaces;

import com.project2.repository.entities.UserEntity;

public interface UserDaoInterface {
    void insert(UserEntity userEntity);

    UserEntity select(int user_id);

    UserEntity select(String username, String password);
}
