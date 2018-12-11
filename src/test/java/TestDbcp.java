import com.ixaut.dao.AccountDao;
import com.ixaut.model.Account;

import java.util.Date;

public class TestDbcp {

    public static void main(String[] args) throws Exception {
        //通过普通方式操纵数据库
        Date a = new Date();
        trans();
        Date b = new Date();
        System.out.println(b.getTime() - a.getTime());

        //通过DBCP连接数据库
        Date c = new Date();
        transByDbcp();
        Date d = new Date();
        System.out.println(d.getTime() - c.getTime());
    }

    public static void trans() throws Exception{

        AccountDao accountDao = new AccountDao();
        Account from = null;
        from = accountDao.get(1);
        System.out.println(from);
    }

    public static void transByDbcp() throws Exception{

        AccountDao accountDao = new AccountDao();
        Account from = null;
        from = accountDao.getByDbcp(1);
        System.out.println(from);
    }
}
