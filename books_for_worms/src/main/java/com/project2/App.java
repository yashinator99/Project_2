package com.project2;

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
                config.addStaticFiles("books_for_worms/src/main/resources/templates", Location.EXTERNAL);
            }
        );

        app.start(9090);

        // app.get("/", HomeController.homepage);

<<<<<<< HEAD
        /*app.get("/", ctx -> {
            ctx.redirect("/homepage.html");
        }); */
=======
        app.get("/", ctx -> {
            ctx.redirect("homepage.html");
        });
>>>>>>> d167e779b352af6244e7b5a6ee8d797bcb50bf26

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
<<<<<<< HEAD
            path("/", () -> {
                get(UserController.homeHandler);
            });
=======
        });

>>>>>>> d167e779b352af6244e7b5a6ee8d797bcb50bf26

            path("register.html", () -> {
                post("", ctx -> {
                    get(UserController.registerHandler);
                });
<<<<<<< HEAD

            });

            path("/login", () -> {
                get(UserController.loginHandler);
                /*post("", ctx -> {
                    get(UserController.loginHandler);
                });*/

            });
            path("/login/submit", () -> {
                get(UserController.loginHandler);
                /*post("", ctx -> {
                    get(UserController.loginHandler);
                });*/

            });
        });




=======
        });
>>>>>>> d167e779b352af6244e7b5a6ee8d797bcb50bf26
    }

}


