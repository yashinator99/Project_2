package com.project2;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.project2.repository.BookDao;
import com.project2.repository.LibraryDao;
import com.project2.repository.UserDao;
import com.project2.repository.entities.BookEntity;
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

            //app.get("/recommmendation.html", ctx -> ctx.result("Hello world"));
        });

        System.out.println(ConnectionFactory.getConnection());
        BookDao bookDao = new BookDao();

        Date HPyear = new Date(0);

        //BookEntity newBook = new BookEntity(99 ,"HP", "JKR", "fantasy", HPyear, true, "YA story");
        BookEntity updateBook = new BookEntity(33, "new book", "John Doe", "biography", HPyear, false, "new description");



    }
}
