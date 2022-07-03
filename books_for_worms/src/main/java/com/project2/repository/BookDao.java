package com.project2.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project2.repository.entities.BookEntity;
import com.project2.repository.interfaces.BookDaoInterface;
import com.project2.util.ConnectionFactory;

public class BookDao implements BookDaoInterface {

    @Override
    public void insert(BookEntity bookEntity) {
        Connection connection = ConnectionFactory.getConnection();
        String sql = "INSERT INTO books VALUES (default , ?, ?, ?, ?, ?, ?) ;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, bookEntity.getTitle());
            preparedStatement.setString(2, bookEntity.getAuthor());
            preparedStatement.setString(3, bookEntity.getGenre());
            preparedStatement.setDate(4, bookEntity.getYear());
            preparedStatement.setBoolean(5, bookEntity.isFiction());
            preparedStatement.setString(6, bookEntity.getDescription());

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
                        resultSet.getInt("book_id"),
                        resultSet.getString("title"),
                        resultSet.getString("author"),
                        resultSet.getString("genre"),
                        resultSet.getDate("year"),
                        resultSet.getBoolean("fiction"),
                        resultSet.getString("description"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<BookEntity> selectAll() {
        Connection connection = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM books;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<BookEntity> bookList = new ArrayList<>();

            while (resultSet.next()){
                BookEntity nextBook = new BookEntity(
                    resultSet.getInt("book_id"),
                    resultSet.getString("title"),
                    resultSet.getString("author"),
                    resultSet.getString("genre"),
                    resultSet.getDate("year"),
                    resultSet.getBoolean("fiction"),
                    resultSet.getString("description"));

                bookList.add(nextBook);
            }

            return bookList;
        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(BookEntity bookEntity) {
        Connection connection = ConnectionFactory.getConnection();
        String sql = "UPDATE books SET title=?, author=?, genre=?, year=?, fiction=?, description=? WHERE book_id=? ;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, bookEntity.getTitle());
            preparedStatement.setString(2, bookEntity.getAuthor());
            preparedStatement.setString(3, bookEntity.getGenre());
            preparedStatement.setDate(4, bookEntity.getYear());
            preparedStatement.setBoolean(5, bookEntity.isFiction());
            preparedStatement.setString(6, bookEntity.getDescription());
            preparedStatement.setInt(7, bookEntity.getBook_id());

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                return;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return;

    }

    @Override
    public void delete(BookEntity bookEntity) {
        Connection connection = ConnectionFactory.getConnection();
        String sql = "DELETE FROM books WHERE book_id=?;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, bookEntity.getBook_id());

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                return;
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return;

    }

    public BookEntity random(){
        Connection connection = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM books ORDER by random() LIMIT 1;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                BookEntity nextBook = new BookEntity(
                    resultSet.getInt("book_id"),
                    resultSet.getString("title"),
                    resultSet.getString("author"),
                    resultSet.getString("genre"),
                    resultSet.getDate("year"),
                    resultSet.getBoolean("fiction"),
                    resultSet.getString("description"));
                return nextBook;
            }
        } catch(SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    public BookEntity search(String column, String searchTerm){
        Connection connection = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM books WHERE UPPER(" + column  + ") LIKE UPPER(?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + searchTerm + "%");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                BookEntity nextBook = new BookEntity(
                    resultSet.getInt("book_id"),
                    resultSet.getString("title"),
                    resultSet.getString("author"),
                    resultSet.getString("genre"),
                    resultSet.getDate("year"),
                    resultSet.getBoolean("fiction"),
                    resultSet.getString("description"));
                return nextBook;
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public List<BookEntity> searchAllBooks(String column, String searchTerm){
        Connection connection = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM books WHERE UPPER(" + column  + ") LIKE UPPER(?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + searchTerm + "%");

            ResultSet resultSet = preparedStatement.executeQuery();
            List<BookEntity> lstOfBooks = new ArrayList<BookEntity>();
            while (resultSet.next()){
                BookEntity nextBook = new BookEntity(
                    resultSet.getInt("book_id"),
                    resultSet.getString("title"),
                    resultSet.getString("author"),
                    resultSet.getString("genre"),
                    resultSet.getDate("year"),
                    resultSet.getBoolean("fiction"),
                    resultSet.getString("description"));
                lstOfBooks.add(nextBook);
            }
            return lstOfBooks;
        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public BookEntity search(int searchTerm){
        Connection connection = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM books WHERE book_id =?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, searchTerm);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                BookEntity nextBook = new BookEntity(
                    resultSet.getInt("book_id"),
                    resultSet.getString("title"),
                    resultSet.getString("author"),
                    resultSet.getString("genre"),
                    resultSet.getDate("year"),
                    resultSet.getBoolean("fiction"),
                    resultSet.getString("description"));
                return nextBook;
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

}
