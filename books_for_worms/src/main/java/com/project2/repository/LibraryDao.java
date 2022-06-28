package com.project2.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.project2.repository.entities.BookEntity;
import com.project2.repository.entities.LibraryEntity;
import com.project2.repository.interfaces.LibraryDaoInterface;
import com.project2.util.ConnectionFactory;

public class LibraryDao implements LibraryDaoInterface {

    @Override
    public void insert(LibraryEntity libraryEntity) {
        // TODO Auto-generated method stub

    }

    @Override
    public LibraryEntity select(int book_id) {
        // TODO Auto-generated method stub
        Connection connection = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM library WHERE book_id=? ;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, book_id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                return new LibraryEntity(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getString(3));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<LibraryEntity> selectAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void update(LibraryEntity libraryEntity) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(LibraryEntity libraryEntity) {
        // TODO Auto-generated method stub

    }

}
