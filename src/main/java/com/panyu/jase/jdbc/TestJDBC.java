package com.panyu.jase.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBC {
    public static void main(String[] args) {

        Statement s = null;
        Connection c = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            c = DriverManager
                    .getConnection(
                            "com.panyu.jase.jdbc:mysql://127.0.0.1:3306/testdemo?characterEncoding=UTF-8",
                            "root", "panyu123");

            // 注意：使用的是 java.sql.Statement
            // 不要不小心使用到： com.mysql.com.panyu.jase.jdbc.Statement;
            s = c.createStatement();

            System.out.println("获取 Statement对象： " + s);

            // 准备sql语句
            // 注意： 字符串要用单引号'
            String sql = "insert into hero values(null," + "'提莫'" + "," + 313.0f + "," + 50 + ")";
            System.out.println(sql);
            s.execute(sql);

            System.out.println("执行插入语句成功");

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            // 数据库的连接时有限资源，相关操作结束后，养成关闭数据库的好习惯
            // 先关闭Statement
            if (s != null)
                try {
                    s.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            // 后关闭Connection
            if (c != null)
                try {
                    c.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

        }

    }
}