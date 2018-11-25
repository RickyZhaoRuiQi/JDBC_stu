package com.ixaut.action;

import com.ixaut.dao.GoddessDao;
import com.ixaut.model.Goddess;

import java.sql.SQLException;
import java.util.*;

public class GoddessAction
{
    public void add(Goddess g) throws SQLException {
        GoddessDao dao = new GoddessDao();
        dao.addGoddess(g);
    }

    public Goddess get(Integer id) throws SQLException {
        GoddessDao dao = new GoddessDao();
        return dao.get(id);
    }

    public void edit(Goddess g) throws SQLException {
        GoddessDao dao = new GoddessDao();
        dao.updateGoddess(g);
    }

    public void del(Integer id) throws SQLException {
        GoddessDao dao = new GoddessDao();
        dao.delGoddess(id);
    }

    public List<Goddess> query() throws Exception {
        GoddessDao dao = new GoddessDao();
        return dao.query();
    }

    public List<Goddess> query(List<Map<String,Object>> params) throws Exception {
        GoddessDao dao = new GoddessDao();
        return dao.query(params);
    }

    public static void main(String[] args) throws Exception {
        GoddessDao g = new GoddessDao();

        //CRUD测试

        /*测试查询
        List<Goddess> gs = g.query();
        for (Goddess goddess:gs) {
            System.out.println(goddess.getUser_name()+","+goddess.getAge());
        }
        */

        /*测试增加数据
        Goddess g1 = new Goddess();
        g1.setUser_name("小王");
        g1.setAge(26);
        g1.setSex(1);
        g1.setBirthday(new Date());
        g1.setEmail("xiaowang@imooc.com");
        g1.setMobile("19999999999");
        g1.setCreate_user("ADMIN");
        g1.setUpdate_user("ADMIN");
        g1.setIsdel(1);
        g.addGoddess(g1);
        */


        /*更新测试
        Goddess g1 = new Goddess();
        g1.setUser_name("小夏");
        g1.setAge(20);
        g1.setSex(1);
        g1.setBirthday(new Date());
        g1.setEmail("xiaoxia@imooc.com");
        g1.setMobile("13333333312");
        g1.setUpdate_user("ADMIN");
        g1.setIsdel(1);
        g1.setId(3);
        g.updateGoddess(g1);
        */


        /*删除测试
        g.delGoddess(3);
        */

        /*测试查询
        Goddess gs = g.get(4);
        System.out.println(gs);
        */

        /*
        List<Goddess> result = g.query("小王");
        for(Goddess rs : result)
        {
            System.out.println(rs);
        }
        */

        /*更加通用的查询
        List<Map<String,Object>> params = new ArrayList<Map<String,Object>>();
        Map<String,Object> param = new HashMap<>();
        param.put("name","user_name");
        param.put("rela","like");
        param.put("value","'%王%'");
        params.add(param);
        List<Goddess> result = g.query(params);
        for (int i = 0; i < result.size(); i++)
        {
            System.out.println(result.get(i));
        }
        */
    }
}
