package com.panyu.jase.jdbc2;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class ConnectDB {
    public static void main(String[] args) {
//        getConnection1();
//        getConnection2();
//        getConnection3();
//        getConnection4();
//        getConnection5();


    }

    public static void getConnection5() {
        try {
            // 文件配置法
            // 1、创建BasicDataSourceFactory对象
            BasicDataSourceFactory factory = new BasicDataSourceFactory();
            // 2、读取配置流
            Properties prop = new Properties();
            FileInputStream fs = new FileInputStream("src/dbcp.properties");
            prop.load(fs);
            // 3.1、获取配置好的BasicDataSource对象
            DataSource ds = factory.createDataSource(prop);
            // 3.2、获取连接对象
            Connection conn = ds.getConnection();
            // 4、执行sql
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getConnection4() {
        // 手动配置法
        // 1、创建对象
        BasicDataSource ds = new BasicDataSource();
        // 2、配置DataSource对象
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("");
        ds.setUsername("");
        ds.setPassword("");
        // 3、获取连接对象
        try {
            Connection conn = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getConnection3() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "";
            String user = "";
            String password = "";
            Connection conn = DriverManager.getConnection(url, user, password);
            String sql = "call p1(?,?,?)";
            CallableStatement cs = conn.prepareCall(sql);
            cs.setInt(1, 50);
            cs.setInt(2, 60);
            // 对于输出变量，需要进行注册，以便获得变量
            cs.registerOutParameter(3, Types.INTEGER);
            // 然后可以使用cs的getXX来获得结果
            cs.executeQuery();
            System.out.println(cs.getInt(3));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getConnection2() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "";
            String user = "";
            String password = "";
            Connection conn = DriverManager.getConnection(url, user, password);
            String sql = "select * from student where gender=?";
            PreparedStatement sm = conn.prepareStatement(sql);
            sm.setString(1, "male");
            ResultSet rs = sm.executeQuery();// 执行语句
            while (rs.next()) {
                System.out.println("id:" + rs.getInt(1) + "name:" + rs.getString(2) + "gender:" + rs.getString(3));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void getConnection1() {
        Connection conn = null;
        Statement sm = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "";
            String user = "";
            String password = "";
            conn = DriverManager.getConnection(url, user, password);
            sm = conn.createStatement();
            String sql = "select * from student";
            rs = sm.executeQuery(sql);
            while (rs.next()) {
                System.out.println("id:" + rs.getInt(1) + "name:" + rs.getString(2) + "gender:" + rs.getString(3));
            }
            String sql2 = "delete from student where name='alice'";
            int count = sm.executeUpdate(sql2);
            System.out.println("受影响的行数：" + count);
//            Properties p = new Properties();
//            p.setProperty("user", user);
//            p.setProperty("password", password);
//            DriverManager.getConnection(url, p);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs == null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (sm == null) {
                try {
                    sm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn == null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
