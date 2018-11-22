package com.ixaut.db;

import java.sql.*;

public class DBUtil
{
    private static final String URL="jdbc:mysql://127.0.0.1:3306/JDBC_stu";
    private static final String USER="";
    private static final String PASSWORD="";

    public static void main(String[] args) throws Exception
    {
        //1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //2.获得数据库的连接
        DriverManager.getConnection(URL,USER,PASSWORD);
        //3.
    }
}
