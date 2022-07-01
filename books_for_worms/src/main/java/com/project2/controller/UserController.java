package com.project2.controller;

import io.javalin.http.Handler;

public class UserController {

    // private static UserService userService = new UserService(new UserDao());
    // private static UserEntity newUserEntity =


    // public static Handler registerHandler =
    // path("register.html", () -> {
    //     post("register/input", ctx -> {
    //         String username = ctx.formParam("username");
    //         String password = ctx.formParam("password");
    //         String email = ctx.formParam("email");

    //         if (newUser.insert(username, password, email) != null){
    //             UserEntity newUser = newUserDao.insert(username, password, email);
    //             ctx.json(newUser);
    //             ctx.redirect("homepage.html");
    //         }else{
    //             ctx.json("Please enter valid inputs");
    //             ctx.redirect("register.html");
    //         }

    //         });
    //     });


    public static Handler registerHandler = ctx -> {
        ctx.redirect("/login.html");
    };

    public static Handler loginHandler = ctx -> {
        ctx.redirect("/login.html");
    };
}

