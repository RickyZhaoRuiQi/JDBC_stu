package com.ixaut.dao;

import com.ixaut.db.DBUtil;
import com.ixaut.model.Goddess;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProduceDao {

    public static Integer select_count() throws SQLException {
        Integer count = 0;
        //1.获得连接
        Connection conn = DBUtil.getConnection();
        //2.获得CallableStatement
        CallableStatement cs = conn.prepareCall("call sp_select_count(?)");
        cs.registerOutParameter(1, Types.INTEGER);
        //3.执行存储过程
        cs.execute();
        //4.处理返回结果：结果集，出参
        count = cs.getInt(1);
        return count;
    }

    public static List<Goddess> select_filter(String sp_name) throws SQLException {

        List<Goddess> result = new ArrayList<Goddess>();

        //1.获得连接
        Connection conn = DBUtil.getConnection();
        //2.获得CallableStatement
        CallableStatement cs = conn.prepareCall("call sp_name(?)");
        cs.setString(1,sp_name);
        //3.执行存储过程
        cs.execute();
        //4.处理返回结果：结果集，出参
        ResultSet rs = cs.getResultSet();

        Goddess g = null;
        while(rs.next()){
            g = new Goddess();
            g.setId(rs.getInt("id"));
            g.setUser_name(rs.getString("user_name"));
            g.setAge(rs.getInt("age"));
            g.setMobile(rs.getString("mobile"));
            result.add(g);
        }
        return result;
    }

    public static void select_nofileter() throws SQLException {
        //1.获得连接
        Connection conn = DBUtil.getConnection();
        //2.获得CallableStatement
        CallableStatement cs = conn.prepareCall("call sp_select_nofilter()");
        //3.执行存储过程
        cs.execute();
        //4.处理返回结果：结果集，出参
        ResultSet rs = cs.getResultSet();

        while(rs.next())
        {
            System.out.println(rs.getString("user_name")+
                    rs.getString("email")+rs.getString("mobile"));
        }
    }
}
