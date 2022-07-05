package com.project2;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.project2.repository.UserDao;
import com.project2.repository.entities.UserEntity;

public class RegisterUserTest {
    @Test
    public void testUserDaoInsertPositive(){
        UserDao userDao = new UserDao();
        UserEntity userEntity = new UserEntity("testuser", "testpassword", "test@testemail");
        userDao.insert(userEntity);
        Assert.assertNotNull(userDao.select(userEntity.getUsername(), userEntity.getPassword()));
    }

    @Test
    public void testUserDaoInsertNegative(){
        UserDao userDao = new UserDao();
        UserEntity userEntity = new UserEntity("", "", "");
        userDao.insert(userEntity);
        Assert.assertNull(userDao.select(userEntity.getUser_id()));
    }
}
