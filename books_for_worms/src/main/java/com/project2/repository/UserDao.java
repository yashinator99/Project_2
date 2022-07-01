package com.project2.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project2.repository.entities.UserEntity;
import com.project2.repository.interfaces.UserDaoInterface;
import com.project2.util.ConnectionFactory;

public class UserDao implements UserDaoInterface {

    @Override
    public void insert(UserEntity userEntity) {
        Connection connection = ConnectionFactory.getConnection();
        String sql = "INSERT INTO users VALUES (default, ?, ?, ?) ;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            // preparedStatement.setInt(1, userEntity.getUser_id());
            preparedStatement.setString(1, userEntity.getUsername());
            preparedStatement.setString(2, userEntity.getPassword());
            preparedStatement.setString(3, userEntity.getEmail());

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                return;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return;
    }

    @Override
    public UserEntity select(int user_id) {
        Connection connection = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM users WHERE user_id=? ;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, user_id);

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
    public UserEntity select(String username, String password) {
        Connection connection = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM users WHERE user_name=? AND password=? ;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
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

    public List<UserEntity> selectAll() {
        Connection connection = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM users;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<UserEntity> userList = new ArrayList<>();

            while (resultSet.next()){
                UserEntity nextUser = new UserEntity(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4));

                userList.add(nextUser);
            }

            return userList;
        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public void update(UserEntity userEntity){
        Connection connection = ConnectionFactory.getConnection();
        String sql = "UPDATE users SET user_name=?, password=?, email=? WHERE user_id=? ;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userEntity.getUsername());
            preparedStatement.setString(2, userEntity.getPassword());
            preparedStatement.setString(3, userEntity.getEmail());
            preparedStatement.setInt(4, userEntity.getUser_id());

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                return;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return;
    }

    public void delete(int user_id){
        Connection connection = ConnectionFactory.getConnection();
        String sql = "DELETE FROM users WHERE user_id=?;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, user_id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                return;
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return;
    }
}
