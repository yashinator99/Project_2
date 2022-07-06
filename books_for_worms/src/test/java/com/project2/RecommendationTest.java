package com.project2;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.project2.repository.BookDao;
import com.project2.repository.entities.BookEntity;

import java.util.List;


public class RecommendationTest {

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
    
    
};
