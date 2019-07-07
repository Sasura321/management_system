package com.service;

import com.dao.AdminDao;
import com.model.Item;

import java.util.ArrayList;

/**
 * 13类名：AdminService
 * 类用途：增删查改服务
 */

public class AdminService {
    AdminDao adminDao=new AdminDao();

    //查询服务
    public ArrayList<Item> queryItem(){
        //调用DAO层的获取方法
        ArrayList<Item> data =adminDao.queryAllData();
        return data;
    }

    //添加服务
    public boolean addItem(String number,String name,String time1,String time2,String time3,String place){
        //调用DAO层的获取方法
        ArrayList<Item> data =adminDao.queryAllData();
        //输入邮编与所有数据比较
        for (int i=0;i<data.size();i++){
            Item item =data.get(i);
            //重复添加失败
            if(number.equals(item.getNo() )){
                return false;
            }
        }
        //如果没有重复
        Item thisItem=new Item(number,name,time1,time2,time3,place);
        adminDao.addItem(thisItem);
        return true;
    }

    //删除服务
    public boolean delItem(String delNumber){
        //调用DAO层的获取方法获取全部数据
        ArrayList<Item> data =adminDao.queryAllData();
        for (int i=0;i<data.size();i++){
            Item item =data.get(i);
            if(item.getNo().trim().equals(delNumber))
            {
                adminDao.delItem(delNumber);
                return true;
            }
        }
        System.out.println("delete "+delNumber);
        return false;//项目编号不同则不删除
    }

    //修改服务
    public boolean updateItem(String number,String name,String time1,String time2,String time3,String place){
        //调用DAO层的获取方法获取全部数据
        ArrayList<Item> data =adminDao.queryAllData();
        Item itemthis = new Item( number, name, time1, time2, time3, place);
        for (int i=0;i<data.size();i++){
            Item item =data.get(i);
            //邮编相同可以更新
            if(item.getNo().trim().equals(number))
            {
                adminDao.updataItem(item.getNo(),itemthis);
                return true;
            }
        }   return false;//项目编号编不同不修改数据
    }
}

