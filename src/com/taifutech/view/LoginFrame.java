package com.taifutech.view;

import com.taifutech.Dao.UserDao;
import com.taifutech.entity.UserEntity;
import com.taifutech.util.JDBCUtil;
import com.taifutech.util.StringBoolean;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

/**
 * Created by baiyang
 * Email: 1419408386@qq.com
 * Creation time : 2017/4/5
 * If you don't konw it,Please ask Google
 */
public class LoginFrame {

    JDBCUtil jdbcUtil = new JDBCUtil();
    UserDao userDao = new UserDao();
    Connection conn = null;

    ShowFrame showFrame = new ShowFrame();
    private JPanel panel1;
    private JTextField userName;
    private JPasswordField password;
    private JButton button1;
    private JButton button2;
    private static JFrame frame;//设置静态内部类 实现

    public LoginFrame() {
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userName.setText("");
                password.setText("");
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = userName.getText();
                String pass = new String(password.getPassword());
                if (StringBoolean.isIndexOf(user)){
                    JOptionPane.showMessageDialog(null,"用户名为空！");
                }
                if (StringBoolean.isIndexOf(pass)){
                    JOptionPane.showMessageDialog(null,"密码为空！");
                }
                UserEntity userEn = new UserEntity(user,pass);
                try {
                    conn = jdbcUtil.getConnection();
                    UserEntity userEntity = userDao.userLogin(conn,userEn);
                    if (userEntity!=null){
                        /**
                         * 打开新的窗口
                         * 并关闭旧的窗口
                         */
                        LoginFrame.frame.setVisible(false);
                        ShowFrame.main();
                    }else {
                        JOptionPane.showMessageDialog(null,"登陆失败");
                    }
                }catch (Exception e1){
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null,e1);

                }finally {//关闭数据库连接
                    try {
                        jdbcUtil.closeCon(conn);
                    }catch (Exception e2){
                        e2.printStackTrace();
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        frame = new JFrame("loginFrame");
        frame.setResizable(false);
        java.awt.Image icon = Toolkit.getDefaultToolkit().getImage("");
        frame.setIconImage(icon);
        frame.setLocationRelativeTo(null);
        frame.setContentPane(new LoginFrame().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
