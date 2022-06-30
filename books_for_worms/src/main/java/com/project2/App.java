package com.project2;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.project2.repository.BookDao;
import com.project2.repository.LibraryDao;
import com.project2.repository.UserDao;
import com.project2.repository.entities.BookEntity;
import com.project2.repository.entities.LibraryEntity;
import com.project2.repository.entities.UserEntity;
import com.project2.util.ConnectionFactory;

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

        app.routes(() -> {
            app.get("/", ctx -> {
                ctx.redirect("/homepage.html");
            });

            BookDao newBookDao = new BookDao();

            app.post("/homepage.html", ctx -> {
                String searchCategory = ctx.formParam("select");
                String searchTerm = ctx.formParam("search");
                int bookID = 0;
                if (newBookDao.search(searchCategory, searchTerm) != null){
                    bookID = newBookDao.search(searchCategory, searchTerm).getBook_id();
                }
                ctx.redirect("/book/" + bookID);
            });

            app.get("/book/{name}", ctx -> {
                try{
                    int bookID = Integer.parseInt((ctx.pathParam("name")));
                    BookEntity foundBook = newBookDao.search(bookID);
                    ctx.json(foundBook);

                } catch (Exception e){
                    ctx.result("No book found with that criteria");
                };
            });
        });

    }
}
