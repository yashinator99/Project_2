package com.project2.repository.interfaces;

import java.util.List;

import com.project2.repository.entities.BookEntity;

public interface BookDaoInterface {

    // CRUD
    void insert(BookEntity bookEntity);

    BookEntity select(int book_id);

    List<BookEntity> selectAll();

    void update(BookEntity bookEntity);

    void delete(BookEntity bookEntity);
}
