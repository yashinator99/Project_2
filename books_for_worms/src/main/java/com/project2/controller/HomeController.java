package com.project2.controller;

import io.javalin.http.Handler;

public class HomeController {

    public static Handler homepage = ctx -> {
        ctx.redirect("base.html");
    } ;
    public static Handler homeHandler = ctx -> {
        ctx.redirect("homepage.html");
    };
}
