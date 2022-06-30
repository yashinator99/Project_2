package com.project2;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.project2.controller.UserController;
import com.project2.repository.BookDao;
import com.project2.repository.LibraryDao;
import com.project2.repository.UserDao;
import com.project2.repository.entities.BookEntity;
import com.project2.repository.entities.LibraryEntity;
import com.project2.repository.entities.UserEntity;
import com.project2.util.ConnectionFactory;
import static io.javalin.apibuilder.ApiBuilder.*;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import static io.javalin.apibuilder.ApiBuilder.*;


public class App {
    public static void main(String[] args) {

        Javalin app = Javalin.create(
                config -> {
                    config.addStaticFiles("/templates", Location.CLASSPATH);
                });
        app.start(9090);

        app.routes( () -> {
            path("register", () -> {
                get("/", UserController.registerHandler);
            });
            
            path("/", () -> {
                get("", ctx -> {
                    ctx.redirect("homepage.html");
                });
            });

            BookDao newBookDao = new BookDao();
            path("/homepage.html", () -> {
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


        });

        
/*
        app.get("/", ctx -> {
            ctx.redirect("/homepage.html");
        });

        app.routes(() -> {
            BookDao newBookDao = new BookDao();
            path("/homepage.html", () -> {
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

            path("/register.html", () -> {
                post("", ctx -> {
                    get(UserController.registerHandler);
                });
        });            
<<<<<<< HEAD

    });
=======
 */
    }
>>>>>>> 55239bab31ea4c9c220c30059e915d6b88e6cbb8
}
