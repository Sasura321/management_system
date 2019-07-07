package com.dao;

/*
 * 12类名：Tool
 * 类用途：数据访问类
 */
import com.model.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class AdminDao {
    //获取所有数据
    public ArrayList<Item> queryAllData() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Item> list = new ArrayList<Item>();
        try{
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM project;";
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                Item projectItem = new Item();
                projectItem.setNo(rs.getString("No"));
                projectItem.setName(rs.getString("Name"));
                projectItem.setStarTime(rs.getString("StarTime"));
                projectItem.setOutTime(rs.getString("OutTime"));
                projectItem.setFinashTime(rs.getString("FinashTime"));
                projectItem.setPlace(rs.getString("Place"));
                list.add(projectItem);
            }
            return list;
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs,stmt,conn);
        }
        return null;
    }

    //添加数据
    public void addItem(Item projectItem){
        Connection conn=null;
        PreparedStatement pstm = null;
        ResultSet rs=null;
        try{
            conn = JDBCUtils.getConnection();
            String sql = "INSERT INTO project (no , name, starTime, outTime, finashTime, place ) VALUES (?,?,?,?,?,?);";
            pstm =conn.prepareStatement(sql);

            pstm.setString(1, projectItem.getNo());
            pstm.setString(2, projectItem.getName());
            pstm.setString(3, projectItem.getStarTime());
            pstm.setString(4, projectItem.getOutTime());
            pstm.setString(5, projectItem.getFinashTime());
            pstm.setString(6, projectItem.getPlace());

            int num = pstm.executeUpdate();
            System.out.println(num);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs,pstm,conn);
        }
    }

    //更新信息
    public void updataItem(String no, Item projectItem){
        Connection conn=null;
        PreparedStatement pstm = null;
        ResultSet rs=null;
        try{
            conn = JDBCUtils.getConnection();
            String sql = "UPDATE  project SET No=?,Name=?,StarTime=?,OutTime=?,FinashTime=?,Place=? where no = " +no;
            pstm =conn.prepareStatement(sql);

            pstm.setString(1, projectItem.getNo());
            pstm.setString(2, projectItem.getName());
            pstm.setString(3, projectItem.getStarTime());
            pstm.setString(4, projectItem.getOutTime());
            pstm.setString(5, projectItem.getFinashTime());
            pstm.setString(6, projectItem.getPlace());

            int num = pstm.executeUpdate();
            System.out.println(num);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs,pstm,conn);
        }
    }

    //删除信息
    public void delItem(String delNum){
        Connection conn=null;
        PreparedStatement pstm = null;
        ResultSet rs=null;
        try{
            conn = JDBCUtils.getConnection();
            System.out.println("success conneciton");
            String sql = "DELETE FROM project WHERE No= ?";

            pstm =conn.prepareStatement(sql);
            pstm.setString(1, delNum);

            int num = pstm.executeUpdate();
            System.out.println(num);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            JDBCUtils.release(rs,pstm,conn);
        }
    }
}
