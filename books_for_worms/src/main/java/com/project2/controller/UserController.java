package com.project2.controller;

import com.project2.repository.UserDao;
import com.project2.service.UserService;

import io.javalin.http.Handler;

public class UserController {

    private static UserService userService = new UserService(new UserDao());

    public static Handler registerHandler = ctx -> {

    };

<<<<<<< HEAD
    public static Handler homeHandler = ctx -> {
        ctx.redirect("/homepage.html");
    };

    public static Handler loginHandler = ctx -> {
        ctx.redirect("/login.html");
    };
=======
>>>>>>> d167e779b352af6244e7b5a6ee8d797bcb50bf26
}

