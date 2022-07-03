package com.project2.controller;

import com.project2.repository.UserDao;
import com.project2.repository.entities.UserEntity;
import com.project2.service.UserService;

import io.javalin.http.Handler;


public class UserController {


    // private static UserEntity newUserEntity = new UserEntity(0, null, null, null);


    // public static Handler registerHandler = ctx -> {
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
    //     }


    public static Handler registerHandler = ctx -> {
        if( ctx.method() == "GET"){
            ctx.redirect("/register.html");
        }else if(ctx.method() == "POST"){
            ctx.redirect("/register.html/register");
            String username = ctx.formParam("username");
            String password = ctx.formParam("password");
            String email = ctx.formParam("email");
            System.out.println(username+ password+ email);
            if (username != null && password != null && email != null){
                UserDao newUserDao = new UserDao();
                newUserDao.insert(new UserEntity(username, password, email));
                ctx.redirect("homepage.html");
            }else{
                ctx.json("Please enter valid inputs");
                ctx.redirect("register.html");
            }
        }
    };

    public static Handler loginHandler = ctx -> {

        ctx.redirect("login.html");
    };

    public static Handler loginsubmitHandler = ctx -> {
        System.out.println("test in loginsubmithandler");
        System.out.println(ctx.formParam("username") + " " + ctx.formParam("password"));
        UserService srv = new UserService();
        System.out.println("testing if hit 1");
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
        System.out.println("testing if hit 2");

    };

    public static Handler signoutHandler = ctx -> {
        System.out.println("test in signoutHandler");
        ctx.removeCookie("user_id");
        ctx.status(200);
    };
}


