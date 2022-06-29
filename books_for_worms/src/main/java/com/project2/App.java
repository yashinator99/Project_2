package com.project2;


import java.time.LocalDate;
import java.sql.Date;

import com.project2.repository.BookDao;
import com.project2.repository.LibraryDao;
import com.project2.repository.entities.BookEntity;
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

            app.get("/recommmendation.html", ctx -> ctx.result("Hello world"));
        });

        System.out.println(ConnectionFactory.getConnection());
        BookDao bookDao = new BookDao();
        
        Date harryDate = new Date(0);
        BookEntity harryBook = new BookEntity(99, "Harry Potter", "J.K. Rowling", "Fantasy", harryDate, true, "description");
        System.out.println(harryBook);
        bookDao.insert(harryBook);
        BookEntity checkBook = bookDao.select(99);
        System.out.println(checkBook);


    }
}
