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
        Connection connection = ConnectionFactory.getConnection();
        String sql = "INSERT INTO books (?, ?, ?, ?, ?, ?, ?) ;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, bookEntity.getBook_id());
            preparedStatement.setString(2, bookEntity.getTitle());
            preparedStatement.setString(3, bookEntity.getAuthor());
            preparedStatement.setString(4, bookEntity.getGenre());
            preparedStatement.setDate(5, bookEntity.getYear());
            preparedStatement.setBoolean(6, bookEntity.isFiction());
            preparedStatement.setString(7, bookEntity.getDescription());

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                return;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return;

    }

    @Override
    public BookEntity select(int book_id) {
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
                        resultSet.getBoolean(6),
                        resultSet.getString(7));
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
