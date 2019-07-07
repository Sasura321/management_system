package com.view;

/**
 * 7类名：SelectView
 * 类用途：项目信息查询的界面和控制
 */

import com.control.listArray;
import com.model.Item;
import com.model.Tool;
import com.service.AdminService;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SelectView extends JDialog{
    private AdminService adminService=new AdminService();
    private JLabel tableLabel =new JLabel("项目信息列表"); //列表标题
    private JScrollPane tablePane =new JScrollPane();  //滚动视口
    protected JTable table=new JTable();

    //添加功能组件

    private JButton addBtn1 =new JButton("返回主页");//按钮
    //构造方法
    public SelectView()  {
        this(null,true);
    }

    public SelectView(Frame owner,boolean modal){
        super(owner,modal);
        this.init();
        this.addComponent();
        this.HoustListener();
    }

    private void init(){
        this.setTitle("查询界面");
        this.setSize(700, 400);
        Tool.center(this);
        //Tool.setTitleImage(this, "22.png");
        this.setResizable(false);//窗口固定
        queryItem();
    }

    //添加组件
    private void addComponent(){
        this.setLayout(null);//取消布局
        //表格标题
        tableLabel.setBounds(290, 20, 100, 25);
        this.add(tableLabel);
        //表格
        table.getTableHeader().setReorderingAllowed(false);//列不能移动
        table.getTableHeader().setResizingAllowed(false);//不可拉动表格
        table.setEnabled(false);
        tablePane.setBounds(50,50,500,200);
        tablePane.setViewportView(table);//视口装入表格
        this.add(tablePane);
        //增加组件
        addBtn1.setBounds(265,280,90,30);
        this.add(addBtn1);
    }
    //监听
    private void HoustListener(){
        addBtn1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                //System.exit(0);//退出程序
                JOptionPane.showMessageDialog(null, "返回主界面！");
                new View1();
                setVisible(false);
            }
        });
    }

    public void queryItem() {
        // TODO Auto-generated method stub'No','Name','StarTime','OutTime','FinashTime','Place'
        //定义表格头
        String[] thead={"项目编号","项目名称","创建时间","实施时间","完工时间","地点"};
        //adminService 查询服务
        ArrayList<Item> dataList=adminService.queryItem();
        //调用list2Array,将查询到的集合转为数组
        String[][] tbody=listArray.list2Array(dataList);
        //将查询到的结果为table赋值
        TableModel dataModel=new DefaultTableModel(tbody,thead);
        table.setModel(dataModel);
    }

}

