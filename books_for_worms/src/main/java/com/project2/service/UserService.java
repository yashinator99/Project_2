package com.project2.service;
import javax.jws.soap.SOAPBinding.Use;

import com.project2.repository.UserDao;
//import com.project2.repository.entities.UserEntity;
//import com.project2.models.User;
//import com.project2.models.UserModel;
import com.project2.repository.entities.UserEntity;

public class UserService {

    public UserService() {
    }

    public Object insert(String username, String password, String email) {
        return null;
    }

    public int get_user_id(String username, String password) {
        UserDao uid = new UserDao();
        UserEntity uidentity = uid.select(username, password);

        if(uidentity != null) {
            System.out.println("UserService" + uidentity);
            return uidentity.getUser_id();
        } else {
            return -1;
        }
    }
}
