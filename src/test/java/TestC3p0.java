import com.ixaut.dao.AccountDao;
import com.ixaut.db.C3P0Util;
import com.ixaut.model.Account;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class TestC3p0 {
    public static void main(String[] args) throws Exception {
        //Connection conn = C3P0Util.getConnection();
        //System.out.println(conn.getCatalog());

        //通过普通方式操纵数据库
        Date a = new Date();
        trans();
        Date b = new Date();
        System.out.println(b.getTime() - a.getTime());

        //通过DBCP连接数据库
        Date c = new Date();
        transByC3p0();
        Date d = new Date();
        System.out.println(d.getTime() - c.getTime());
    }

    public static void trans() throws Exception{

        AccountDao accountDao = new AccountDao();
        Account from = null;
        from = accountDao.get(1);
        System.out.println(from);
    }

    public static void transByC3p0() throws Exception{

        AccountDao accountDao = new AccountDao();
        Account from = null;
        from = accountDao.getByC3p0(1);
        System.out.println(from);
    }
}
