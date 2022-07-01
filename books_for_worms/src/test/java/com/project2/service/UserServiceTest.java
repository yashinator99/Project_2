package com.project2.service;

import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.project2.models.User;
import com.project2.models.UserModel;

import com.project2.repository.UserDao;
import com.project2.repository.entities.UserEntity;



public class UserServiceTest{
    private UserService userService;

    @Mock
    private UserDao mockUserDao;
    
    private UserEntity dummyUser1;
    private UserEntity dummyUser2;

    private UserModel dummyUserModel1;
    private UserModel dummyUserModel2;

    private UserDao UserDao;

    //private User dummyItemConvert1;
    //private User dummyItemConvert2;


    @BeforeClass
    public void setup(){
        MockitoAnnotations.openMocks(this);
        this.userService = new UserService(UserDao);
        dummyUser1 = new UserEntity("john",password:"pass1234",email:"john@gmail.com");
        dummyUser1 = new UserEntity("deo",password:"pass",email:"deo@gmail.com");
        when(mockUserDao.select(dummyUser1.getuser_id())).thenReturn(dummyUser1);
        when(mockUserDao.select(dummyUser1.getuser_id())).thenReturn(dummyUser2;
        
    }
    @Test
    void testGetAllUser()  {
        Assert.assertEquals(UserService.getAllUser() );
    }
   
    @Test
    void testGetItem()  {
        Assert.assertEquals(UserService.getUser(dummyUser1.getuser_Id()), dummyUserModel1);
    }
          
       

    @Test
  public void testAddUser(){
    assertNotNull(dummyUser1);
 
  }     
        



}