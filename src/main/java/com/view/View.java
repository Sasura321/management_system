package com.view;

/**
 * 1类名：View
 * 类用途：登陆界面
 */

import com.model.Tool;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//主窗口
public  class View extends JFrame implements ActionListener {
    private JButton btn = new JButton("登录");

    //窗体上的控件
    JLabel lb1;
    JLabel lb2;
    JLabel lb3;
    JTextField tf1;
    JTextField tf2;
    JButton jb;
    //构造函数
    public View(){
        this.init();
        this.setVisible(true);
        //this.addListener();
    }

    public void init() {
        this.setTitle("项 目 信 息 管 理 系 统");//标题
        this.setSize(610, 410);
        Tool.center(this);
        this.setResizable(false);//窗口固定
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );//退出程序

        lb3 = new JLabel("工  程 项  目  信  息   管  理  系  统 ");
        lb3.setBounds(200, 60, 200, 50);
        this.add(lb3);

        View1.BackgroundPanel bgp; //自定义的背景类
        //重新绘制背景图片
        //参数是一个Image对象
        bgp=new View1.BackgroundPanel((new ImageIcon("src//main//images//5.jpg")).getImage());
        bgp.setBounds(0,0,1000,600);
        this.add(bgp);

        lb1 = new JLabel("用户名:");
        lb1.setBounds(210, 120, 50, 25);
        this.add(lb1);

        tf1 = new JTextField();
        tf1.setBounds(260, 120, 120, 25);
        this.add(tf1);

        lb2 = new JLabel("密    码:");
        lb2.setBounds(210, 160, 50, 25);
        this.add(lb2);

        tf2 = new JTextField();
        tf2.setBounds(260, 160, 120, 25);
        this.add(tf2);

        jb = new JButton("退出");
        jb.setBounds(310, 200, 60, 30);
        this.add(jb);
        // 实现退出功能
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("退出按钮关闭窗口");
                System.exit(0);
            }
        });
        JPanel btnPanel=new JPanel();
        //清除布局
        btnPanel.setLayout(null);
        this.add(btnPanel);
        //定义边界位置
        btn.setBounds(220, 200, 60,30);
        //将按钮添加到JPanel
        btn.addActionListener(this);
        btnPanel.add(btn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if((tf1.getText().equals("root"))&&(tf2.getText().equals("root")))
        {
            View1 view=new View1();
        }
        else {
            JOptionPane.showMessageDialog(this, "请输入正确的用户名和密码！！");
        }
    }
}

