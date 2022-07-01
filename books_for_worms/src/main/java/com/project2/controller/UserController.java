package com.project2.controller;

import io.javalin.http.Handler;
import com.project2.service.UserService;

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

    public static Handler loginsubmitHandler = ctx -> {
        System.out.println("test in loginsubmithandler");
        System.out.println(ctx.formParam("username") + " " + ctx.formParam("password"));
        UserService srv = new UserService();
        int userId = srv.get_user_id(ctx.formParam("username"), ctx.formParam("password"));
        if(userId != -1) {
            ctx.redirect("/");
        } else {
            ctx.redirect("/login");
        }

    };
}

