package com.ixaut.action;

import com.ixaut.dao.GoddessDao;
import com.ixaut.model.Goddess;

import java.util.Date;
import java.util.List;

public class GoddessAction
{
    public static void main(String[] args) throws Exception {
        GoddessDao g = new GoddessDao();

        /*测试查询
        List<Goddess> gs = g.query();
        for (Goddess goddess:gs) {
            System.out.println(goddess.getUser_name()+","+goddess.getAge());
        }
        */

        /*测试增加数据
        Goddess g1 = new Goddess();
        g1.setUser_name("小夏");
        g1.setAge(22);
        g1.setSex(1);
        g1.setBirthday(new Date());
        g1.setEmail("xiaoxia@imooc.com");
        g1.setMobile("13333333333");
        g1.setCreate_user("ADMIN");
        g1.setUpdate_user("ADMIN");
        g1.setIsdel(1);
        g.addGoddess(g1);
        */
    }
}
