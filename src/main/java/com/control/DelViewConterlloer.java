package com.control;

/**
 * 6类名：DelViewConterlloer
 * 类用途：项目信息删除的控制
 */

import com.model.Item;
import com.service.AdminService;
import com.view.DelView;

import java.awt.Frame;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.*;

@SuppressWarnings("serial")
public class DelViewConterlloer extends DelView {
    private AdminService adminService=new AdminService();
    public DelViewConterlloer() {
        queryItem();
    }
    public DelViewConterlloer(Frame owner, boolean modal) {
        super(owner,modal);
        //创建对象时展示数据
        queryItem();
    }

    @Override
    public void queryItem()  {
        //定义表格头
        String[] thead={"项目编号","项目名称","创建时间","实施时间","完工时间","地点"};
        //adminService 查询服务
        ArrayList<Item> dataList= adminService.queryItem();
        //调用list2Array,将查询到的集合转为数组
        String[][] tbody=listArray.list2Array(dataList);
        //将查询到的结果为table赋值
        TableModel dataModel = new DefaultTableModel(tbody,thead);
        table.setModel(dataModel);
    }

    @Override
    public void delItem() {
        String addNumber = addText1.getText();

        boolean delSuccess = adminService.delItem(addNumber);
        //如果删除成功刷新表格
        if(delSuccess) {
            queryItem();
        } else {
            JOptionPane.showMessageDialog(this, "没有这个项目编号，请检查数据");
        }
    }
}
