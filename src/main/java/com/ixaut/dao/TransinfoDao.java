package com.ixaut.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.ixaut.db.DBUtil;
import com.ixaut.model.Transinfo;

public class TransinfoDao {
    public void insert(Transinfo transInfo) throws SQLException{
        Connection conn = DBUtil.getConnection();
        PreparedStatement st = conn.prepareStatement("insert into trans_info(source_id,source_account,destination_id,destination_account,amount) values(?,?,?,?,?)");
        st.setInt(1, transInfo.getSourceId());
        st.setString(2, transInfo.getSourceAccount());
        st.setInt(3, transInfo.getDestinationId());
        st.setString(4, transInfo.getDestinationAccount());
        st.setDouble(5, transInfo.getAmount());
        st.execute();
    }

    public void update(Transinfo transInfo) throws SQLException{
        Connection conn = DBUtil.getConnection();
        PreparedStatement st = conn.prepareStatement("update trans_info set source_id =?,source_account =?,destination_id =?,destination_account=?,amount=? where id =?");
        st.setInt(1, transInfo.getSourceId());
        st.setString(2, transInfo.getSourceAccount());
        st.setInt(3, transInfo.getDestinationId());
        st.setString(4, transInfo.getDestinationAccount());
        st.setDouble(5, transInfo.getAmount());
        st.setInt(6, transInfo.getId());
        st.execute();
    }

    public void delete(Transinfo transInfo) throws SQLException{
        Connection conn = DBUtil.getConnection();
        PreparedStatement st = conn.prepareStatement("delete from trans_info where id=?");
        st.setInt(1, transInfo.getId());
        st.execute();
    }

    public List<Transinfo> query(Transinfo transInfo) throws SQLException{
        List<Transinfo> list = new ArrayList<Transinfo>();
        Connection conn = DBUtil.getConnection();
        PreparedStatement st = conn.prepareStatement("select * from trans_info where id =?");
        st.setInt(1, transInfo.getId());
        ResultSet rs = st.getResultSet();
        Transinfo t = null;
        while(rs.next()){
            t.setId(rs.getInt("id"));
            t.setSourceId(rs.getInt("sourceId"));
            t.setSourceAccount(rs.getString("sourceAccount"));
            t.setDestinationId(rs.getInt("destinationId"));
            t.setDestinationAccount(rs.getString("destinationAccount"));
            t.setAmount(rs.getDouble("amount"));
            list.add(t);
        }
        return list;
    }
}
