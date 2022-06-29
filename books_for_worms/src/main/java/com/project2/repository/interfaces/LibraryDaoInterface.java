package com.project2.repository.interfaces;

import java.util.List;

import com.project2.repository.entities.LibraryEntity;
import com.project2.repository.entities.UserEntity;

public interface LibraryDaoInterface {
    // CRUD

    void insert(LibraryEntity libraryEntity);

    List<LibraryEntity> select(UserEntity userEntity);

    List<LibraryEntity> selectAll();

    void update(LibraryEntity libraryEntity);

    void delete(LibraryEntity libraryEntity);

}
