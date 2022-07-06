package com.project2;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.project2.repository.UserDao;
import com.project2.repository.entities.UserEntity;

public class LoginUserTest {
    @Test
    public void testUserDaoInsertPositive(){
        UserDao userDao = new UserDao();
        UserEntity userEntity = new UserEntity("yash", "bosh", "bosh@gmail");
        Assert.assertNotNull(userDao.select(userEntity.getUsername(), userEntity.getPassword()));
    }

    @Test
    public void testUserDaoInsertNegativeUsername(){
        UserDao userDao = new UserDao();
        UserEntity userEntity = new UserEntity("yassh", "bosh", "bosh@gmail");
        Assert.assertNull(userDao.select(userEntity.getUsername(), userEntity.getPassword()));
    }
    @Test
    public void testUserDaoInsertNegativePassword(){
        UserDao userDao = new UserDao();
        UserEntity userEntity = new UserEntity("yash", "boss", "bosh@gmail");
        Assert.assertNull(userDao.select(userEntity.getUsername(), userEntity.getPassword()));
    }
}
