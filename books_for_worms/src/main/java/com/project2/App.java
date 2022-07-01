package com.project2;

import com.project2.controller.HomeController;
import com.project2.controller.UserController;
import com.project2.repository.BookDao;
import com.project2.repository.entities.BookEntity;
import static io.javalin.apibuilder.ApiBuilder.*;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;


public class App {
    public static void main(String[] args) {

        Javalin app = Javalin.create(
            config -> {
                config.addStaticFiles("/templates", Location.CLASSPATH);
                config.addStaticFiles("/js", Location.CLASSPATH);
            }
        );

        app.start(9090);



        app.get("/", ctx -> {
            ctx.redirect("homepage.html");
        });

        app.routes(() -> {
            BookDao newBookDao = new BookDao();
            path("homepage.html", () -> {
                post("", ctx -> {
                    String searchCategory = ctx.formParam("select");
                    String searchTerm = ctx.formParam("search");

                    if (newBookDao.search(searchCategory, searchTerm) != null){
                        BookEntity foundBook = newBookDao.search(searchCategory, searchTerm);
                        ctx.json(foundBook);
                    } else{
                        ctx.json("No book found with that criteria");
                    }
                });
            });

            path("base", () -> {
                    get("", ctx -> {
                    get(HomeController.homepage);
                });

            });
            path("register", () -> {
                    get(UserController.registerHandler);
                    post(UserController.registerHandler);
                });

            });

            path("login", () -> {
                get(UserController.loginHandler);
                /*post("", ctx -> {
                    get(UserController.loginHandler);
                });*/
            });

            path("login/submit", () -> {
                get(UserController.loginHandler);
            });

        }
    };








