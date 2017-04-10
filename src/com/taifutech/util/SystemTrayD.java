package com.taifutech.util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.net.URL;

/**
 * Created by baiyang
 * Email: 1419408386@qq.com
 * Creation time : 2017/4/6
 * If you don't konw it,Please ask Google
 */
public class SystemTrayD extends JFrame {
    private static final long serialVersionUID = 1L;

    private TrayIcon trayIcon = null;

    /**
     * Constructs a new frame that is initially invisible.
     * <p>
     * This constructor sets the component's locale property to the value
     * returned by <code>JComponent.getDefaultLocale</code>.
     *
     * @throws HeadlessException if GraphicsEnvironment.isHeadless()
     *                           returns true.
     * @see GraphicsEnvironment#isHeadless
     * @see Component#setSize
     * @see Component#setVisible
     * @see JComponent#getDefaultLocale
     */
    public SystemTrayD() {
        jbInit();
    }

    public void jbInit() {
        if (SystemTray.isSupported()) { //检查当前系统是否支持系统托盘
            SystemTray tray = SystemTray.getSystemTray();//获取表示桌面托盘区的 SystemTray 实例。
//            String imgPath = System.getProperty("user.dir") + "\\src\\picture\\icon.jpg";
//            Image image = Toolkit.getDefaultToolkit().getImage(imgPath);
            PopupMenu popupMenu = new PopupMenu();
            MenuItem exitItem = new MenuItem("退出");
            MenuItem openItem = new MenuItem("打开");
            openItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    showIT(true);
                    System.out.println("右键点击菜单选项打开\n");
                }
            });
            exitItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        System.exit(0);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            });
            popupMenu.add(openItem);
            popupMenu.add(exitItem);
//            trayIcon = new TrayIcon(image, "系统托盘图标", popupMenu);
            trayIcon.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 2) {
                        showIT(true);
                        System.out.println("双击系统托盘图标打开\n");
                    }
                }
            });
            try {
                tray.add(trayIcon); // 将 TrayIcon 添加到 SystemTray。
            } catch (AWTException e) {
                System.err.println(e);
            }
        } else {
            System.out.println("你的系统不支持系统托盘");
        }
//        ImageIcon icon = new ImageIcon();
//        try {
//            URL url = new URL("http://img1.qq.com/ent/pics/11436/11436218.jpg");
//            icon = new ImageIcon(url);
//        } catch (Exception e) {
//
//        }
//        JButton btn = new JButton(icon);
//        this.setLayout(new BorderLayout());
//        this.add(btn, BorderLayout.CENTER);
//        this.add(new JButton("North"), BorderLayout.NORTH);
//        this.add(new JButton("South"), BorderLayout.SOUTH);
//        this.add(new JButton("West"), BorderLayout.WEST);
//        this.add(new JButton("East"), BorderLayout.EAST);
    }

    public void showIT(boolean visable) {
        if (this.isVisible() != visable)
            this.setVisible(visable);
    }
}
