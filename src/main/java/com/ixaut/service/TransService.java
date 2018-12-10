package com.ixaut.service;

import com.ixaut.dao.AccountDao;
import com.ixaut.dao.TransinfoDao;
import com.ixaut.db.DBUtil;
import com.ixaut.model.Account;
import com.ixaut.model.Transinfo;

import java.sql.Connection;

public class TransService {

    public String trans(Account from,Account to,Double amount) throws Exception{

        AccountDao accountDao = new AccountDao();
        TransinfoDao transInfoDao = new TransinfoDao();

        from.setAmount(from.getAmount() - amount);
        accountDao.update(from);

//        String a = null;
//        a.split("#");

        to.setAmount(to.getAmount() + amount);
        accountDao.update(to);

        Transinfo info = new Transinfo();
        info.setSourceAccount(from.getAccount());
        info.setSourceId(from.getId());
        info.setDestinationAccount(to.getAccount());
        info.setDestinationId(to.getId());
        info.setAmount(amount);
        transInfoDao.insert(info);

        return "success";
    }

    public String transaction(Account from,Account to,Double amount) throws Exception{
        Connection conn = DBUtil.getConnection();
        conn.setAutoCommit(false);
        try{
            AccountDao accountDao = new AccountDao();
            TransinfoDao transinfoDao = new TransinfoDao();

            from.setAmount(from.getAmount() - amount);
            accountDao.update(from);

            //String a = null;
            //a.split("#");

            to.setAmount(to.getAmount() + amount);
            accountDao.update(to);

            Transinfo info = new Transinfo();
            info.setSourceAccount(from.getAccount());
            info.setSourceId(from.getId());
            info.setDestinationAccount(to.getAccount());
            info.setDestinationId(to.getId());
            info.setAmount(amount);
            transinfoDao.insert(info);

            conn.commit();

            return "success";
        }catch(Exception e){
            conn.rollback();
            e.printStackTrace();
            return "fail";
        }
    }
}
