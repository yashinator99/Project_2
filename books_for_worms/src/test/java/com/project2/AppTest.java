package com.project2;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.project2.repository.BookDao;
import com.project2.repository.UserDao;
import com.project2.repository.entities.BookEntity;
import com.project2.repository.entities.UserEntity;

public class AppTest {

    @Test
    public void UserDaoLoginPositiveTest(){
        UserDao userDao = new UserDao();
        UserEntity userEntity = new UserEntity("yash", "bosh", "bosh@gmail");
        Assert.assertNotNull(userDao.select(userEntity.getUsername(), userEntity.getPassword()));
    }

    @Test
    public void testUserDaoLoginNegativeUsername(){
        UserDao userDao = new UserDao();
        UserEntity userEntity = new UserEntity("yassh", "bosh", "bosh@gmail");
        Assert.assertNull(userDao.select(userEntity.getUsername(), userEntity.getPassword()));
    }

    @Test
    public void testUserDaoLoginNegativePassword(){
        UserDao userDao = new UserDao();
        UserEntity userEntity = new UserEntity("yash", "boss", "bosh@gmail");
        Assert.assertNull(userDao.select(userEntity.getUsername(), userEntity.getPassword()));
    }


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


    @Test
    public void testBookDaoSearchPositive(){
        BookDao bookDao = new BookDao();
        List<BookEntity> booksToFind = new ArrayList<BookEntity>();
        BookEntity book1 =
        new BookEntity(
        4,
        "Nightwork",
        "Nora Roberts",
        "Romance",
        Date.valueOf("2022-05-24"),
        true,
        "Harry Booth, a master thief, breaks things off with Miranda when a dangerous contact might harm her.");
        booksToFind.add(book1);
        BookEntity book2 =
        new BookEntity(
        8,
        "Nightcrawling",
        "Leila Mottley",
        "Drama",
        Date.valueOf("2022-06-07"),
        true,
        "A young, struggling Black woman is identified as a key witness in a scandal within the Oakland Police Department.");
        booksToFind.add(book2);
        BookEntity book3 =
        new BookEntity(
        25,
        "The Midnight Library",
        "Matt Haig ",
        "Mystery",
        Date.valueOf("2020-08-13"),
        true,
        "A dazzling novel about all the choices that go into a life well lived, from the internationally bestselling author of Reasons to Stay Alive and How To Stop Time.\r\n ");
        booksToFind.add(book3);
        List<BookEntity> booksFound = bookDao.searchAllBooks("Title", "night");
        Assert.assertEquals(booksFound, booksToFind);
    };

    @Test
    public void testBookDaoSearchNegative(){
        BookDao bookDao = new BookDao();
        List<BookEntity> booksFound = bookDao.searchAllBooks("Title", "nothing");
        List<BookEntity> booksToFind = new ArrayList<BookEntity>();
        System.out.println(booksFound);
        System.out.println(booksToFind);
        Assert.assertEquals(booksFound, booksToFind);


    }

    @Test
    public void testRandomBooks(){
        BookDao bookDao = new BookDao();
        List<BookEntity> randomBooks = bookDao.random();


        Assert.assertNotNull(randomBooks);
        Assert.assertEquals(randomBooks.size(), 3);
        for (BookEntity book : randomBooks){
            Assert.assertNotNull(book);
        };
    };
}

