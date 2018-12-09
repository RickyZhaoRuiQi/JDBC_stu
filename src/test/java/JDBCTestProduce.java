import com.ixaut.dao.ProduceDao;
import com.ixaut.model.Goddess;

import java.sql.SQLException;
import java.util.List;

public class JDBCTestProduce {
    public static void main(String[] args) throws SQLException {

        //dao.select_nofileter();

        /*
        String sp_name = "";
        List<Goddess> res = null;
        res = select_filter(sp_name);
        showResult(res);
        */

        System.out.println(select_count());

    }

    public static Integer select_count() throws SQLException {
        ProduceDao dao = new ProduceDao();
        return dao.select_count();
    }

    public static List<Goddess> select_filter(String sp_name) throws SQLException {
        ProduceDao dao = new ProduceDao();
        return dao.select_filter(sp_name);
    }

    public static void showResult(List<Goddess> result){
        for(Goddess g:result){
            System.out.println(g.getId()+":"+g.getUser_name()
                    +":"+g.getMobile());
        }
    }
}
