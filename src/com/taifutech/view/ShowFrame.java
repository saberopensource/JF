package com.taifutech.view;

import com.taifutech.Dao.MessageDao;
import com.taifutech.entity.MessageInformation;
import com.taifutech.util.JDBCUtil;
import com.taifutech.util.StringBoolean;
import com.taifutech.util.SystemTrayD;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by baiyang
 * Email: 1419408386@qq.com
 * Creation time : 2017/4/5
 * If you don't konw it,Please ask Google
 */
public class ShowFrame {

    JDBCUtil jdbcUtil = new JDBCUtil();
    Connection conn = null;
    MessageDao dao = new MessageDao();

    private JPanel main;
    private JTextField textField1;
    private JButton Button1;
    private JButton button3;
    private JTextField textField3;
    private static JFrame frame1;

    public ShowFrame() {
        Button1.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String text1 = textField1.getText();
                List list = new ArrayList();
                if (StringBoolean.isIndexOf(text1)){
                    JOptionPane.showMessageDialog(null,"请填写数据");
                }else {
                    try {
                        conn = jdbcUtil.getConnection();
//                        List<MessageInformation> message = dao.selectMessageInformation(conn);
//                        for (int i = 0 ;i<message.size();i++){
//                            System.out.println(message.get(i).getMessage());
//                            list.add(message.get(i).getMessage());
//                        }
                        MessageInformation message = dao.selectMessageToOne(conn);
                        list.add(message.getMessage());
                        textField3.setText(list.toString());
                    }catch (Exception e1){
                        JOptionPane.showMessageDialog(null,"没有这条数据");
                        e1.printStackTrace();
                    }finally {
                        try {
                            jdbcUtil.closeCon(conn);
                        }catch(Exception e2){
                            e2.printStackTrace();
                            JOptionPane.showMessageDialog(null,"程序错误！联系制作者");
                        }
                    }
                }
            }
        });
        button3.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText("");
                textField3.setText("");
            }
        });
    }

    public static void main() {
        frame1 = new JFrame("ShowFrame");
        frame1.setContentPane(new ShowFrame().main);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.pack();
        frame1.setVisible(true);
        new SystemTrayD().jbInit();
    }


}
