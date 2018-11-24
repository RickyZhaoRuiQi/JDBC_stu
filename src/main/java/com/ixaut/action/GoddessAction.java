package com.ixaut.action;

import com.ixaut.dao.GoddessDao;
import com.ixaut.model.Goddess;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoddessAction
{
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
    }
}
