package com.project2.repository.interfaces;

import java.util.List;

import com.project2.repository.entities.LibraryEntity;

public interface LibraryDaoInterface {
    // CRUD

    void insert(LibraryEntity libraryEntity);

    LibraryEntity select(int user_id);

    List<LibraryEntity> selectAll();

    void update(LibraryEntity libraryEntity);

    void delete(LibraryEntity libraryEntity);

}
