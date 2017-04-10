package com.taifutech.Test;

import com.taifutech.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by baiyang
 * Email: 1419408386@qq.com
 * Creation time : 2017/4/5
 * If you don't konw it,Please ask Google
 */

/**
 * 测试链接是否通过
 */
public class SqlTest {
    public static void main(String[] args) throws Exception {
        JDBCUtil jb = new JDBCUtil();
        //获取数据库连接
        System.out.println("---------");
        Connection conn = jb.getConnection();
        System.out.println("---------");
        System.out.println(conn);
        //select sql语句
        PreparedStatement ps = conn.prepareStatement("select * from user");
        //执行sql语句
        ResultSet rs = ps.executeQuery();
        //循环输入查询到的内容
        while(rs.next()){
            //id username password 为查询数据库的字段
            System.out.println( "id:"+rs.getInt("id")+" \n"+
                                "Username:"+rs.getString("username")+" \n"+
                                "Password:"+rs.getString("password")
            );
        }
        jb.closeCon(conn);
    }
}
