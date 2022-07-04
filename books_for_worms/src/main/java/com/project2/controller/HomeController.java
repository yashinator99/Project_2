package com.project2.controller;

import io.javalin.http.Handler;
import com.project2.repository.BookDao;
import com.project2.repository.LibraryDao;
import com.project2.repository.UserDao;
import com.project2.repository.entities.BookEntity;
import com.project2.service.LibraryService;
import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;

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

    public static Handler homepageAddHandler = ctx -> {
        String jsonbody = ctx.body();
        LibraryService libsvc = new LibraryService();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Map<String, String> map = objectMapper.readValue(jsonbody, Map.class);
            int user_id = Integer.parseInt(map.get("user_id"));
            int book_id = Integer.parseInt(map.get("book_id"));
            if(libsvc.check_book_exist(user_id, book_id)) {
                System.out.print("Book exist");
            } else {
                libsvc.insert(user_id, book_id);
                System.out.print("Book doesn't exist");
            }
            //System.out.println("Map is " + map);
        } catch (Exception e) {
            e.printStackTrace();
        }
    };
}
