package com.taifutech.Dao;

import com.taifutech.entity.UserEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by baiyang
 * Email: 1419408386@qq.com
 * Creation time : 2017/4/5
 * If you don't konw it,Please ask Google
 */
public class UserDao {
    public UserEntity userLogin(Connection connection, UserEntity userEntity) throws Exception{
        UserEntity user = null;
        String sqlSelect = "select * from user where userName = ? and password=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlSelect);
        preparedStatement.setString(1,userEntity.getUserName());
        preparedStatement.setString(2,userEntity.getPassword());
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            user = new UserEntity();
            user.setUserName(resultSet.getString("userName"));
            user.setPassword(resultSet.getString("password"));
            resultSet.close();
            preparedStatement.close();
        }
        return user;
    }
}
