package com.qdz.sql;

import com.alibaba.druid.pool.DruidDataSource;

import javax.sql.DataSource;
import java.sql.*;

public class Sql {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        String sql = "select * from ";

        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = dataSource.getConnection();
            //conn = DriverManager.getConnection("url","root","root");

            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.execute();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
