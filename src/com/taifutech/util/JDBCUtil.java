package com.taifutech.util;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by baiyang
 * Email: 1419408386@qq.com
 * Creation time : 2017/4/5
 * If you don't konw it,Please ask Google
 */
//封住链接数据库的util
public class JDBCUtil {
    private static final String sqlproperties = "sql.properties";
    private Connection connection;
    /**
     * getConnection 获取链接数据库
     */
    public Connection getConnection() throws Exception{
        Properties properties = new Properties();
        InputStream in = ClassLoader.getSystemResourceAsStream(sqlproperties);
        Base64 base64 = new Base64();
        //加载配置文件
        properties.load(in);
        Class.forName(properties.getProperty("DRIVER_CLASS"));
        connection = DriverManager.getConnection(
                properties.getProperty("CONNECTION_URL"),
                base64.Base64Decoder(properties.getProperty("CONNECTION_USERNAME")),
                base64.Base64Decoder(properties.getProperty("CONNECTION_PASSWORD"))

        );
        return connection;
    }
    public void closeCon(Connection conne) throws Exception {
        if(conne!=null){
           conne.close();
        }
    }

    /**
     * junit 测试链接properties 成功
     */
    @Test
    public void test() {
        Properties properties = new Properties();
        InputStream in = ClassLoader.getSystemResourceAsStream(sqlproperties);
        try {

            properties.load(in);
            String a = properties.getProperty("CONNECTION_URL");
            System.out.println(a);
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("-----");
        }
        System.out.println("+++++");
    }
}
