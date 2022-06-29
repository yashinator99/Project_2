package com.project2;

import org.openqa.selenium.devtools.v85.emulation.model.UserAgentBrandVersion;

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

            app.get("/recommmendation.html", ctx -> ctx.result("Hello world"));
        });

        System.out.println(ConnectionFactory.getConnection());
        BookDao bookDao = new BookDao();
        LibraryDao libraryDao = new LibraryDao();

        BookEntity bookEntity = bookDao.select(25);
        System.out.println(bookEntity);

        System.out.println(libraryDao.select(bookEntity.getBook_id()));

        UserEntity userEntity = new UserEntity("olivier_cook", "pass12345", "olivier@gmail.com");
        UserDao userDao = new UserDao();
        userDao.insert(userEntity);

    }
}
