package com.project2.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project2.repository.entities.UserEntity;
import com.project2.repository.entities.LibraryEntity;
import com.project2.repository.interfaces.LibraryDaoInterface;
import com.project2.util.ConnectionFactory;

public class LibraryDao implements LibraryDaoInterface {

    @Override
    public void insert(LibraryEntity libraryEntity) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<LibraryEntity> select(UserEntity userEntity) {
        Connection connection = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM library WHERE user_id=? ;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userEntity.getUser_id());

            ResultSet resultSet = preparedStatement.executeQuery();

            List<LibraryEntity> libraryList = new ArrayList<>();

            while (resultSet.next()) {
                LibraryEntity nextBook =  new LibraryEntity(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getString(3));
                
                libraryList.add(nextBook);
            }

            return libraryList;

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
