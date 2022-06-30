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
<<<<<<< HEAD
=======

>>>>>>> ec18f575654b24ae29dc3ddf68f5d1367fa290d7
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

<<<<<<< HEAD
        app.routes( () -> {
            path("register", () -> {
                app.get("/", UserController.registerHandler);
            });
            
        app.routes(() -> {
            app.get("/", ctx -> {
                ctx.redirect("/homepage.html");
            });

            BookDao newBookDao = new BookDao();

            app.post("/homepage.html", ctx -> {
                String searchCategory = ctx.formParam("select");
                String searchTerm = ctx.formParam("search");
                
                if (newBookDao.search(searchCategory, searchTerm) != null){
                    BookEntity foundBook = newBookDao.search(searchCategory, searchTerm);
                    ctx.json(foundBook);
                } else{
                    ctx.json("No book found with that criteria");
                }
            });

            app.get("/recommendation.html", ctx -> {
                BookEntity randomBook = newBookDao.random();
                ctx.json(randomBook);
            });


        });
=======

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
        });            

>>>>>>> ec18f575654b24ae29dc3ddf68f5d1367fa290d7
    }
}
