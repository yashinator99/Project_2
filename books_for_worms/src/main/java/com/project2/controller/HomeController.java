package com.project2.controller;

import io.javalin.http.Handler;
import com.project2.repository.BookDao;
import com.project2.repository.entities.BookEntity;
import java.util.*;

public class HomeController {

    public static Handler homepage = ctx -> {
        ctx.redirect("base.html");
    } ;
    public static Handler homeHandler = ctx -> {
        ctx.redirect("homepage.html");
    };

    public static Handler homepageSeachHandler = ctx -> {
        BookDao newBookDao = new BookDao();
        String searchCategory = ctx.formParam("select");
        String searchTerm = ctx.formParam("search");
        List<BookEntity> lstOfBooks = newBookDao.searchAllBooks(searchCategory, searchTerm);
        if (lstOfBooks != null && !lstOfBooks.isEmpty()){
            ctx.json(lstOfBooks);
        } else{
            ctx.status(404);
        }
    };
}
