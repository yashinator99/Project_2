package com.project2;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        
        Javalin app = Javalin.create(
            config -> {
                config.addStaticFiles("/public", Location.CLASSPATH);
            }
        );        
        app.start(9090);

        app.routes(() -> {
            app.get("/", ctx -> {
                ctx.redirect("/homepage.html");
            });
        });
    }
}
