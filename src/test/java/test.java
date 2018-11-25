import com.ixaut.action.GoddessAction;
import com.ixaut.model.Goddess;

import java.util.*;

public class test
{
    public static void main(String[] args) throws Exception {
        GoddessAction action = new GoddessAction();

        //CURD

        /*
        Goddess g = new Goddess();
        g.setUser_name("小青");
        g.setSex(1);
        g.setAge(25);
        g.setBirthday(new Date());
        g.setEmail("xiaoqing@ixaut.com");
        g.setMobile("15555555555");
        g.setIsdel(0);
        action.add(g);
        */

        /*
        Goddess g = new Goddess();
        g.setUser_name("小青");
        g.setSex(1);
        g.setAge(25);
        g.setBirthday(new Date());
        g.setEmail("xiaoqing@ixaut.com");
        g.setMobile("15555555555");
        g.setIsdel(0);
        g.setId(5);
        action.edit(g);
        */

        /*
        action.del(5);
        */

        List<Map<String,Object>> params = new ArrayList<Map<String, Object>>();
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("name","user_name");
        map.put("rela","=");
        map.put("value","'小美'");
        params.add(map);

        List<Goddess> result = action.query(params);


        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i).getId()+":"
            +result.get(i).getUser_name());
        }

    }
}
