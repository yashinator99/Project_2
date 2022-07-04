package com.project2.service;

import com.project2.repository.LibraryDao;
//import com.project2.repository.entities.UserEntity;
//import com.project2.models.User;
//import com.project2.models.UserModel;
import com.project2.repository.entities.LibraryEntity;
import com.project2.repository.entities.BookEntity;
import java.util.*;

public class LibraryService {
    public LibraryService() {
    }

    public void insert(int user_id, int book_id) {
        LibraryEntity libinsert = new LibraryEntity(user_id, book_id);
        LibraryDao libraryDaoInsert = new LibraryDao();
        libraryDaoInsert.insert(libinsert);
    }

    public boolean check_book_exist(int user_id, int book_id) {
        LibraryDao libid = new LibraryDao();
        LibraryEntity libentity = libid.selectUserAndBook(user_id, book_id);

        if(libentity != null) {
            System.out.println("LibService " + libentity);
            return true;
        } else {
            System.out.println("LibService failed " + libentity);
            return false;
        }
    }
    public List<BookEntity> get_my_library(int user_id, String selector_id){
        LibraryDao libGetBooks = new LibraryDao();
        if(selector_id.equals("all")) {
            List<BookEntity> libentity = libGetBooks.selectAllByUserId(user_id);
            return libentity;
        }

        return null;
    }
}
