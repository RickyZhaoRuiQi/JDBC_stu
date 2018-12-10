package com.ixaut.action;

import com.ixaut.dao.AccountDao;
import com.ixaut.model.Account;
import com.ixaut.service.TransService;

public class TransAction {

    public static void main(String[] args) {
        try{
            //String res = trans();
            String res = transaction();
            System.out.println(res);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static String trans() throws Exception{

        AccountDao accountDao = new AccountDao();
        TransService transService = new TransService();

        Account from = null;
        Account to = null;

        from = accountDao.get(1);
        to = accountDao.get(2);

        return transService.trans(from,to,10d);
    }

    public static String transaction() throws Exception{

        AccountDao accountDao = new AccountDao();
        TransService transService = new TransService();

        Account from = null;
        Account to = null;

        from = accountDao.get(1);
        to = accountDao.get(2);

        return transService.transaction(from,to,20d);
    }
}
