package com.control;

import com.model.Item;

import java.util.ArrayList;

public class listArray {
    public static String[][] list2Array(ArrayList<Item> list) {
        //根据Item的model与集合数据定义JTable的数据二维数组
        String[][] tbody=new String[list.size()][6];
        for(int i=0;i<list.size();i++){
            Item item=list.get(i);
            tbody[i][0]=item.getNo();
            tbody[i][1]=item.getName();
            tbody[i][2]=item.getStarTime();
            tbody[i][3]=item.getOutTime();
            tbody[i][4]=item.getFinashTime();
            tbody[i][5]=item.getPlace();
        }
        return tbody;
    }
}
