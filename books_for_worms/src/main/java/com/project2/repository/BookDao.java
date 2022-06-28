package com.project2.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.project2.repository.entities.BookEntity;
import com.project2.repository.interfaces.BookDaoInterface;
import com.project2.util.ConnectionFactory;

public class BookDao implements BookDaoInterface {

    @Override
    public void insert(BookEntity bookEntity) {
        // TODO Auto-generated method stub

    }

    @Override
    public BookEntity select(int book_id) {
        // TODO Auto-generated method stub
        Connection connection = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM books WHERE book_id=? ;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, book_id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                return new BookEntity(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getDate(5),
                        resultSet.getBoolean(6));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<BookEntity> selectAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void update(BookEntity bookEntity) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(BookEntity bookEntity) {
        // TODO Auto-generated method stub

    }

}
