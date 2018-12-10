package com.ixaut.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.ixaut.db.DBUtil;
import com.ixaut.model.Account;

public class AccountDao {

    public Account get(Integer index) throws SQLException{
        Connection conn = DBUtil.getConnection();
        PreparedStatement st = conn.prepareStatement("select * from account_info where id = ?");
        st.setInt(1,index);
        ResultSet rs = st.executeQuery();
        rs.next();
        Account account = new Account();
        account.setId(rs.getInt("id"));
        account.setAccount(rs.getString("account"));
        account.setAmount(rs.getDouble("amount"));
        account.setCreateAt(rs.getDate("create_at"));
        return account;
    }

    public void insert(Account account) throws SQLException{
        Connection conn = DBUtil.getConnection();
        PreparedStatement st = conn.prepareStatement("insert into account_info(account,amount) values (?,?)");
        st.setString(1, account.getAccount());
        st.setDouble(2, account.getAmount());
        st.execute();
    }

    public void update(Account account) throws SQLException{
        Connection conn = DBUtil.getConnection();
        PreparedStatement st = conn.prepareStatement("update account_info set account =?,amount=? where id =?");
        st.setString(1, account.getAccount());
        st.setDouble(2, account.getAmount());
        st.setInt(3, account.getId());
        st.execute();
    }

    public void delete(Account account) throws SQLException{
        Connection conn = DBUtil.getConnection();
        PreparedStatement st = conn.prepareStatement("delete from account_info where id =?");
        st.setInt(1, account.getId());
        st.execute();
    }

    public List<Account> query(Account account) throws SQLException{
        List<Account> list =new ArrayList<Account>();
        Connection conn = DBUtil.getConnection();
        StringBuilder sb =new StringBuilder();
        sb.append("select * from account_info");
        sb.append("where account like ?");
        PreparedStatement st =conn.prepareStatement(sb.toString());
        st.setString(1, "%"+account.getAccount()+"%");
        ResultSet rs = st.executeQuery();
        Account a =null;
        while(rs.next()){
            a = new Account();
            a.setAccount(rs.getString("account"));
            a.setAmount(rs.getDouble("amount"));
            a.setCreateAt(rs.getDate("create_at"));
            a.setId(rs.getInt("id"));
            list.add(a);
        }
        return list;
    }

    public Account query(int id) throws SQLException{
        List<Account> list = new ArrayList<Account>();
        Connection conn = DBUtil.getConnection();
        StringBuilder sb = new StringBuilder();
        sb.append("select * from account_info");
        sb.append(" where id like ?");
        PreparedStatement st =conn.prepareStatement(sb.toString());
        st.setInt(1, id);
        ResultSet rs =st.executeQuery();
        Account a = null;
        while(rs.next()){
            a=new Account();
            a.setAccount(rs.getString("account"));
            a.setAmount(rs.getDouble("amount"));
            a.setCreateAt(rs.getDate("create_at"));
            a.setId(rs.getInt("id"));
        //  list.add(a);
        }
        return a;
    }
}
