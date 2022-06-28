package com.project2.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.project2.repository.entities.UserEntity;
import com.project2.repository.interfaces.UserDaoInterface;
import com.project2.util.ConnectionFactory;

public class UserDao implements UserDaoInterface{

    @Override
    public void insert(UserEntity userEntity) {
        return;
    }

    @Override
    public UserEntity select(int user_id) {
        Connection connection = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM users WHERE user_id=? ;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,user_id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                return new UserEntity(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public UserEntity select(String username, String password){
        Connection connection = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM users WHERE user_name=? AND password=? ;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                return new UserEntity(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
