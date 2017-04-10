package com.taifutech.Dao;

import com.taifutech.entity.MessageInformation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by baiyang
 * Email: 1419408386@qq.com
 * Creation time : 2017/4/6
 * If you don't konw it,Please ask Google
 */
public class MessageDao {
    /**
     * @information 所有蕴含的数据全部显示 根据where条件而定  ShowFrame 中保留乐 插入数据功能
     * @method public ## ##(Connection conn,Object obj) throws Exception  修改如上样式即可
     * @param connection
     * @return
     * @throws Exception
     */
    public List selectMessageInformation(Connection connection) throws Exception{
        MessageInformation infor = null;
        List<MessageInformation> alist = new ArrayList<MessageInformation>();
        String sql = "select * from messageinfor where teamname = 'by'";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            infor = new MessageInformation();
            infor.setMessage(((resultSet.getString("message")).toString()));
            alist.add(infor);

        }
        return alist;
    }

    /**
     * @information 显示最近更新的一条记录 单一记录显示
     * @param connection
     * @return
     * @throws Exception
     */
    public MessageInformation selectMessageToOne(Connection connection) throws Exception {
        MessageInformation infor = null;
        String sql = "select * from messageinfor where teamname = 'by'";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            infor = new MessageInformation();
            infor.setMessage(resultSet.getString("message"));
        }
        return infor;
    }
}
