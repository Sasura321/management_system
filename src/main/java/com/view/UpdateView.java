package com.view;

/**
 * 8类名：UpdateView
 * 类用途：项目信息修改的界面
 */

import com.model.Tool;

import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract   class UpdateView extends JDialog{
    private JLabel tableLabel =new JLabel("项目信息列表"); //列表标题
    private JScrollPane tablePane =new JScrollPane();  //滚动视口
    protected JTable table=new JTable();
    private JLabel Label1 =new JLabel("项目编号");//编号标题
    private JLabel Label2 =new JLabel("项目名称");
    private JLabel Label3 =new JLabel("创建时间");
    private JLabel Label4 =new JLabel("实施时间");//编号标题
    private JLabel Label5 =new JLabel("完工时间");
    private JLabel Label6 =new JLabel("地点");

    //添加功能组件
    protected JTextField addText1=new JTextField(6);//添加邮编文本框
    protected JTextField addText2=new JTextField(6);
    protected JTextField addText3=new JTextField(6);
    protected JTextField addText4=new JTextField(6);
    protected JTextField addText5=new JTextField(6);
    protected JTextField addText6=new JTextField(6);
    private JButton addBtn =new JButton("修改项目");//按钮
    private JButton addBtn1 =new JButton("返回主页");//按钮
    //构造方法
    public UpdateView()  {
        this(null,true);
    }
    public UpdateView(Frame owner,boolean modal){
        super(owner,modal);
        this.init();
        this.addComponent();
        this.addListener();
        this.HoustListener();}
    private void init(){
        this.setTitle("修改界面");
        this.setSize(700, 400);
        Tool.center(this);
        this.setResizable(false);//窗口固定
    }
    //添加组件
    private void addComponent(){
        this.setLayout(null);//取消布局
        //表格标题
        tableLabel.setBounds(290, 20, 100, 30);
        this.add(tableLabel);
        //表格
        table.getTableHeader().setReorderingAllowed(false);//列不能移动
        table.getTableHeader().setResizingAllowed(false);//不可拉动表格
        table.setEnabled(false);
        tablePane.setBounds(50,50,600,200);//50,50,500,25
        tablePane.setViewportView(table);//视口装入表格
        this.add(tablePane);
        //字段标题
        Label1.setBounds(50,250,70,25);
        Label2.setBounds(150,250,70,25);
        Label3.setBounds(250,250,70,25);
        Label4.setBounds(350,250,70,25);
        Label5.setBounds(450,250,70,25);
        Label6.setBounds(550,250,70,25);
        this.add(Label1);
        this.add(Label2);
        this.add(Label3);
        this.add(Label4);
        this.add(Label5);
        this.add(Label6);
        //增加组件
        addText1.setBounds(50,280,80,25);
        addText2.setBounds(150,280,80,25);
        addText3.setBounds(250,280,80,25);
        addText4.setBounds(350,280,80,25);
        addText5.setBounds(450,280,80,25);
        addText6.setBounds(550,280,80,25);
        this.add(addText1);
        this.add(addText2);
        this.add(addText3);
        this.add(addText4);
        this.add(addText5);
        this.add(addText6);
        addBtn.setBounds(50,320,90,25);
        this.add(addBtn);
        addBtn1.setBounds(250,320,90,25);
        this.add(addBtn1);
    }

    private void addListener(){
        addBtn.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                JOptionPane.showMessageDialog(null, "确定修改");
                updateItem();
            }
        });
    }
    private void HoustListener(){
        addBtn1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(null, "返回主界面！");
                new View1();
                setVisible(false);
            }
        });
    }
    public abstract void queryItem();
    public abstract void updateItem();
}

