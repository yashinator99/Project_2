package com.project2.controller;


import io.javalin.http.Handler;
import com.project2.repository.BookDao;
import com.project2.repository.LibraryDao;
import com.project2.repository.UserDao;
import com.project2.repository.entities.BookEntity;
import com.project2.service.LibraryService;
import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;



public class LibraryController {
    public static Handler libraryHandler = ctx -> {
        String jsonbody = ctx.body();
        LibraryService libsvc = new LibraryService();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Map<String, String> map = objectMapper.readValue(jsonbody, Map.class);
            int user_id = Integer.parseInt(map.get("user_id"));
            String selector_id = "" + map.get("selector_id");
            List<BookEntity> userBookList = libsvc.get_my_library(user_id,selector_id);
            if (userBookList != null && !userBookList.isEmpty()){
                ctx.json(userBookList);
            } else{
                ctx.status(404);
            }
        } catch (Exception e) {
            e.printStackTrace();
            ctx.status(404);
        }
    };

    public static Handler libraryDeleteHandler = ctx -> {
        System.out.print("testing in libraryhandler in librarycontroller");
        String jsonbody = ctx.body();
        LibraryService libsvc = new LibraryService();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Map<String, String> map = objectMapper.readValue(jsonbody, Map.class);
            int user_id = Integer.parseInt(map.get("user_id"));
            int book_id = Integer.parseInt(map.get("book_id"));
            libsvc.delete_book_from_library(user_id,  book_id);
            ctx.status(200);
        } catch (Exception e) {
            e.printStackTrace();
            ctx.status(400);
        }
    };

    public static Handler libraryUpdateHandler = ctx -> {
        System.out.print("testing in libraryhandler in librarycontroller");
        String jsonbody = ctx.body();
        LibraryService libsvc = new LibraryService();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Map<String, String> map = objectMapper.readValue(jsonbody, Map.class);
            int user_id = Integer.parseInt(map.get("user_id"));
            int book_id = Integer.parseInt(map.get("book_id"));
            String selector = "" + map.get("selector_id");
            libsvc.update_book_from_library(user_id, book_id, selector);
            ctx.status(200);
        } catch (Exception e) {
            e.printStackTrace();
            ctx.status(400);
        }
    };


}
