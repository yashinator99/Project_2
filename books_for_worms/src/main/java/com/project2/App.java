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

import static io.javalin.apibuilder.ApiBuilder.*;
=======
>>>>>>> c96628c8172e1d11593322ccb5a9f4ca9aaa5e77
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
                    config.addStaticFiles("/templates", Location.CLASSPATH);
                });
        app.start(9090);

<<<<<<< HEAD
        app.routes( () -> {
            path("register", () -> {
                app.get("/", UserController.registerHandler);
            });
            
=======
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

            /*
            app.get("/book/{name}", ctx -> {
                try{
                    String book = ctx.pathParam("name");
                    int bookID = Integer.parseInt(book);
                    BookEntity foundBook = newBookDao.search(bookID);
                    ctx.json(foundBook);

                } catch (Exception e){
                    e.printStackTrace();
                    ctx.result("No book found with that criteria");
                };
            });
             */
>>>>>>> c96628c8172e1d11593322ccb5a9f4ca9aaa5e77
        });

        // app.routes(() -> {
        //     path("register", () -> {
        //         app.get("/", UserController.registerHandler);
        //     });
        // });

        // app.routes(() -> {
        //     app.get("/", ctx -> {
        //         ctx.redirect("/homepage.html");
        //     });

        //     BookDao newBookDao = new BookDao();

        //     app.post("/homepage.html", ctx -> {
        //         String searchCategory = ctx.formParam("select");
        //         String searchTerm = ctx.formParam("search");
        //         int bookID = 0;
        //         if (newBookDao.search(searchCategory, searchTerm) != null){
        //             bookID = newBookDao.search(searchCategory, searchTerm).getBook_id();
        //         }
        //         ctx.redirect("/book/" + bookID);
        //     });

        //     app.get("/recommendation.html", ctx -> {
        //         int bookID = newBookDao.random().getBook_id();
        //         ctx.redirect("/book/" + bookID);
        //     });

        //     app.get("/book/{name}", ctx -> {
        //         try{
        //             int bookID = Integer.parseInt((ctx.pathParam("name")));
        //             BookEntity foundBook = newBookDao.search(bookID);
        //             ctx.json(foundBook);

        //         } catch (Exception e){
        //             ctx.result("No book found with that criteria");
        //         };
        //     });
        // });

    }
}
