package com.project2.controller;

import com.project2.repository.UserDao;
import com.project2.service.UserService;

import io.javalin.http.Handler;

public class UserController {

    private static UserService userService = new UserService(new UserDao());

    public static Handler registerHandler = ctx -> {
        ctx.redirect("register.html");
    };



    public static Handler loginHandler = ctx -> {
        ctx.redirect("/login.html");
    };
}

