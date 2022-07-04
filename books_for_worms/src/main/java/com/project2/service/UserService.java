package com.project2.service;

import com.project2.repository.UserDao;
//import com.project2.repository.entities.UserEntity;
//import com.project2.models.User;
//import com.project2.models.UserModel;
import com.project2.repository.entities.UserEntity;

public class UserService {

    public void creating_user(String username, String password, String email) {
        UserDao newUserDao = new UserDao();
        UserEntity createUser = new UserEntity(username, password, email);
        newUserDao.insert(createUser);
    }

    public int get_user_id(String username, String password) {
        UserDao uid = new UserDao();
        UserEntity uidentity = uid.select(username, password);

        if(uidentity != null) {
            System.out.println("UserService" + uidentity);
            return uidentity.getUser_id();
        } else {
            System.out.println("UserService failed" + uidentity);
            return -1;
        }
    }
}
