package com.ixaut.dao;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.ixaut.db.DBUtil;
import com.ixaut.model.Goddess;

public class GoddessDao
{
    public void addGoddess(Goddess g) throws SQLException
    {
        Connection conn = DBUtil.getConnection();
        String sql = ""+
                " insert into imooc_goddess "+
                " (user_name,sex,age,birthday,email,mobile, "+
                " create_user,create_date,update_user,update_date,isdel) "+
                " values( "+
                " ?,?,?,?,?,?,?,current_date(),?,current_date(),?) ";
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

    public void updateGoddess(Goddess g) throws SQLException
    {
        Connection conn = DBUtil.getConnection();
        String sql = ""+
                " update imooc_goddess "+
                " set user_name=?,sex=?,age=?,birthday=?,email=?,mobile=?, "+
                " update_user=?,update_date=current_date(),isdel=? "+
                " where id=? ";
        PreparedStatement ptmp = conn.prepareStatement(sql);

        ptmp.setString(1,g.getUser_name());
        ptmp.setInt(2,g.getSex());
        ptmp.setInt(3,g.getAge());
        ptmp.setDate(4,new Date(g.getBirthday().getTime()));
        ptmp.setString(5,g.getEmail());
        ptmp.setString(6,g.getMobile());
        ptmp.setString(7,g.getUpdate_user());
        ptmp.setInt(8,g.getIsdel());
        ptmp.setInt(9,g.getId());
        ptmp.execute();
    }

    public void delGoddess(Integer id) throws SQLException
    {
        Connection conn = DBUtil.getConnection();
        String sql = ""+
                " delete from imooc_goddess "+
                " where id=? ;";
        PreparedStatement ptmp = conn.prepareStatement(sql);

        ptmp.setInt(1,id);
        ptmp.execute();
    }

    public List<Goddess> query(String name) throws Exception
    {
        List<Goddess> result = new ArrayList<Goddess>();

        Connection conn = DBUtil.getConnection();
        StringBuilder sb = new StringBuilder();
        sb.append(" select * from imooc_goddess ");
        sb.append(" where user_name = ? ");

        PreparedStatement ptmp = conn.prepareStatement(sb.toString());
        ptmp.setString(1,name);
        ResultSet rs = ptmp.executeQuery();
        Goddess g = null;

        while(rs.next())
        {
            g = new Goddess();
            g.setId(rs.getInt("id"));
            g.setUser_name(rs.getString("user_name"));
            g.setAge(rs.getInt("age"));
            g.setSex(rs.getInt("sex"));
            g.setBirthday(rs.getDate("birthday"));
            g.setEmail(rs.getString("email"));
            g.setMobile(rs.getString("mobile"));
            g.setCreate_date(rs.getDate("create_date"));
            g.setCreate_user(rs.getString("create_user"));
            g.setUpdate_user(rs.getString("update_user"));
            g.setIsdel(rs.getInt("isdel"));

            result.add(g);
        }

        return result;
    }

    public Goddess get(Integer id) throws SQLException
    {
        Goddess g = null;
        Connection conn = DBUtil.getConnection();
        String sql = ""+
                " select * from imooc_goddess "+
                " where id=? ";
        PreparedStatement ptmp = conn.prepareStatement(sql);

        ptmp.setInt(1,id);
        ResultSet rs = ptmp.executeQuery();
        if(rs.next())
        {
            g = new Goddess();
            g.setId(rs.getInt("id"));
            g.setUser_name(rs.getString("user_name"));
            g.setAge(rs.getInt("age"));
            g.setSex(rs.getInt("sex"));
            g.setBirthday(rs.getDate("birthday"));
            g.setEmail(rs.getString("email"));
            g.setMobile(rs.getString("mobile"));
            g.setCreate_date(rs.getDate("create_date"));
            g.setCreate_user(rs.getString("create_user"));
            g.setUpdate_user(rs.getString("update_user"));
            g.setIsdel(rs.getInt("isdel"));
        }
        return g;
    }
}
