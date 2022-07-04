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
        System.out.print("testing in libraryhandler in librarycontroller");
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
        }
    };
}
