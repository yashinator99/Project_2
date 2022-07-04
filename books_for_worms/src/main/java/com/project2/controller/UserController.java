package com.project2.controller;

import com.project2.repository.UserDao;
import com.project2.repository.entities.UserEntity;
import com.project2.service.UserService;

import io.javalin.http.Handler;


public class UserController {

    public static Handler registerHandler = ctx -> {
            ctx.redirect("register.html");
    };

    public static Handler registerSubmitHandler = ctx -> {
        String username = ctx.formParam("username");
        String password = ctx.formParam("password");
        String email = ctx.formParam("email");
        UserService usersvc = new UserService();
        System.out.println(username + password + email);
        if (username != "" && password != "" && email != ""){
            usersvc.creating_user(username, password, email);
            ctx.status(200);
        }else{
            ctx.status(400);
        }
    };

    public static Handler loginHandler = ctx -> {
        ctx.redirect("login.html");
    };

    public static Handler loginsubmitHandler = ctx -> {
        UserService srv = new UserService();
        int userId = srv.get_user_id(ctx.formParam("username"), ctx.formParam("password"));
        if(userId != -1) {
            System.out.println("Userid " + userId);
            ctx.cookieStore("user_id", userId);
            //ctx.redirect("/");
            ctx.result(""+userId);
        } else {
            //ctx.redirect("/login");
            System.out.println("Useridfailed " + userId);
            ctx.status(401);
        }
    };

    public static Handler signoutHandler = ctx -> {
        System.out.println("test in signoutHandler");
        ctx.removeCookie("user_id");
        ctx.status(200);
    };


}


