package com.control;

/**
 * 4类名：AddViewController
 * 类用途：项目信息添加的控制
 */
import com.model.Item;
import com.service.AdminService;
import com.view.AddView;
import java.awt.Frame;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.*;

public class AddViewController extends AddView {

    private AdminService adminService=new AdminService();

    public AddViewController(){
        super();
    }

    public AddViewController(Frame owner, boolean modal){
        super(owner,modal);
        //创建对象时展示数据
        queryItem();

    }


    @Override
    //查询方法
    public void queryItem() {
        //定义表格头
        String[] thead={"项目编号","项目名称","创建时间","实施时间","完工时间","地点"};
        //adminService 查询服务
        ArrayList<Item> dataList= adminService.queryItem();
        //调用list2Array,将查询到的集合转为数组
        String[][] tbody=listArray.list2Array(dataList);
        //将查询到的结果为table赋值
        TableModel dataModel=new DefaultTableModel(tbody,thead);
        table.setModel(dataModel);
    }

    @Override
    //增加方法
    public void addItem() {
        String addNumber=addText1.getText();
        String addName=addText2.getText();
        String addTime1=addText3.getText();
        String addTime2=addText4.getText();
        String addTime3=addText5.getText();
        String addPlace=addText6.getText();
        boolean addSuccess=adminService.addItem(addNumber, addName, addTime1,addTime2,addTime3,addPlace);
        //如果添加成功刷新表格
        if(addSuccess){
            queryItem();
        } else {
            JOptionPane.showMessageDialog(this, "项目编号不能重复，请检查数据");
        }
    }
}

