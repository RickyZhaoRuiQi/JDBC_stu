package com.ixaut.dao;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.ixaut.db.DBUtil;
import com.ixaut.model.Goddess;

public class GoddessDao
{
    public void addGoddess(Goddess g) throws SQLException {
        Connection conn = DBUtil.getConnection();
        String sql = ""+
                "insert into imooc_goddess"+
                "(user_name,sex,age,birthday,email,mobile,"+
                "create_user,create_date,update_user,update_date,isdel)"+
                "values("+
                "?,?,?,?,?,?,?,current_date(),?,current_date(),?)";
        PreparedStatement ptmp = conn.prepareStatement(sql);

        ptmp.setString(1,g.getUser_name());
        ptmp.setInt(2,g.getSex());
        ptmp.setInt(3,g.getAge());
        ptmp.setDate(4,new Date(g.getBirthday().getTime()));
        ptmp.setString(5,g.getEmail());
        ptmp.setString(6,g.getMobile());
        ptmp.setString(7,g.getCreate_user());
        ptmp.setString(8,g.getUpdate_user());
        ptmp.setInt(9,g.getIsdel());
        ptmp.execute();
    }

    public void updateGoddess()
    {

    }

    public void delGoddess()
    {

    }

    public List<Goddess> query() throws Exception
    {
        Connection conn = DBUtil.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select user_name,age from imooc_goddess");

        List<Goddess> gs = new ArrayList<Goddess>();
        Goddess g = null;

        while(rs.next())
        {
            g = new Goddess();
            g.setUser_name(rs.getString("user_name"));
            g.setAge(rs.getInt("age"));
            gs.add(g);
        }
        return gs;
    }

    public Goddess get()
    {
        return null;
    }
}
