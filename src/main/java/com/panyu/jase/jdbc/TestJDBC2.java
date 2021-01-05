package com.panyu.jase.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBC2 {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (
                Connection c = DriverManager.getConnection("com.panyu.jase.jdbc:mysql://127.0.0.1:3306/testdemo?characterEncoding=UTF-8",
                        "root", "panyu123");
                Statement s = c.createStatement();
        )
        {
            String sql = "insert into hero values(null," + "'提莫'" + "," + 313.0f + "," + 50 + ")";
            String delete_sql = "delete from hero where id = 5";
            String update_sql = "update hero set name = 'name 5' where id = 3";
            s.execute(sql);
            s.execute(delete_sql);
            s.execute(update_sql);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}