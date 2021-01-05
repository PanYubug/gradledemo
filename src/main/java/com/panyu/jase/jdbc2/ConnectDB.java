package com.panyu.jase.jdbc2;

import java.sql.*;

public class ConnectDB {
    public static void main(String[] args) {
//        getConnection1();
//        getConnection2();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url="";
            String user="";
            String password="";
            Connection conn = DriverManager.getConnection(url, user, password);
            String sql = "select * from student where gender=?";
            PreparedStatement sm = conn.prepareStatement(sql);
            sm.setString(1,"male");
            ResultSet rs = sm.executeQuery();// 执行语句
            while (rs.next()) {
                System.out.println("id:"+rs.getInt(1)+"name:"+rs.getString(2)+"gender:"+rs.getString(3));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getConnection2() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url="";
            String user="";
            String password="";
            Connection conn = DriverManager.getConnection(url, user, password);
            String sql = "select * from student where gender=?";
            PreparedStatement sm = conn.prepareStatement(sql);
            sm.setString(1,"male");
            ResultSet rs = sm.executeQuery();// 执行语句
            while (rs.next()) {
                System.out.println("id:"+rs.getInt(1)+"name:"+rs.getString(2)+"gender:"+rs.getString(3));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void getConnection1() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url="";
            String user="";
            String password="";
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement sm = conn.createStatement();
            String sql = "select * from student";
            ResultSet rs = sm.executeQuery(sql);
            while (rs.next()){
                System.out.println("id:"+rs.getInt(1)+"name:"+rs.getString(2)+"gender:"+rs.getString(3));
            }
            String sql2 = "delete from student where name='alice'";
            int count = sm.executeUpdate(sql2);
            System.out.println("受影响的行数："+count);
//            Properties p = new Properties();
//            p.setProperty("user", user);
//            p.setProperty("password", password);
//            DriverManager.getConnection(url, p);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
