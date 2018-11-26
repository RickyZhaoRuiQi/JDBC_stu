package com.ixaut.view;

import com.ixaut.action.GoddessAction;
import com.ixaut.model.Goddess;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class View {
    private static final String CONTEXT = "欢迎来到女生禁区：\n" +
            "下面是女生禁区的功能列表：\n" +
            "[MAIN/M]：主菜单\n" +
            "[QUERY/Q]：查看全部女神的信息\n" +
            "[GET/G]：查看某位女神的详细信息\n" +
            "[ADD/A]：添加女神信息\n"+
            "[UPDATE/U]：更新女神信息\n"+
            "[DELETE/D]：删除女神信息\n"+
            "[SEARCH/S]：查询女生信息（更具姓名）\n"+
            "[EXIT/E]：退出女神禁区\n"+
            "[BREAK/B]：退出当前功能，返回主菜单";
    
    private static final String OPERATION_MAIN = "MAIN";
    private static final String OPERATION_QUERY = "QUERY";
    private static final String OPERATION_GET = "GET";
    private static final String OPERATION_ADD = "ADD";
    private static final String OPERATION_UPDATE = "UPDATE";
    private static final String OPERATION_DELETE = "DELETE";
    private static final String OPERATION_SEARCH = "SEARCH";
    private static final String OPERATION_EXIT = "EXIT";
    private static final String OPERATION_BREAK = "BREAK";

    public static void main(String[] args)
    {
        System.out.println(CONTEXT);
        //保持程序的一直运行

        Scanner scan = new Scanner(System.in);
        Goddess g = new Goddess();
        GoddessAction action = new GoddessAction();
        String pre = null;
        Integer step = 1;
        g.setSex(1);
        g.setCreate_user("ADMIN");
        g.setUpdate_user("ADMIN");
        g.setIsdel(1);
        while(scan.hasNext())
        {
            String in = scan.next();
            if(OPERATION_EXIT.equals(in.toUpperCase())
                    || OPERATION_EXIT.substring(0,1).equals(in.toUpperCase()))
            {
                System.out.println("您已成功退出女神禁区。");
                break;
            }
            else if(OPERATION_ADD.equals(in.toUpperCase())
                    || OPERATION_ADD.substring(0,1).equals(in.toUpperCase())
                    || OPERATION_ADD.equals(pre))
            {
                pre = OPERATION_ADD;
                if(1 == step)
                {
                    System.out.println("请输入女神的[姓名]");
                }
                else if(2 == step)
                {
                    g.setUser_name(in);
                    System.out.println("请输入女神的[年龄]");
                }
                else if(3 == step)
                {
                    g.setAge(Integer.valueOf(in));
                    System.out.println("请输入女神的[生日],格式：yyyy-MM-dd");
                }
                else if(4 == step)
                {
                    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
                    Date birthday = null;
                    try
                    {
                        birthday = sf.parse(in);
                        g.setBirthday(birthday);
                        System.out.println("请输入女神的[邮箱]");
                    }catch(ParseException e)
                    {
                        e.printStackTrace();
                        System.out.println("您输入的格式有错，请重新输入");
                        step = 3;
                    }
                }
                else if(5 == step)
                {
                    g.setEmail(in);
                    System.out.println("请输入女神的[手机号]");
                }
                else if(6 == step)
                {
                    g.setMobile(in);
                    try
                    {
                        action.add(g);
                        System.out.println("新增女生成功");
                    }catch(Exception e)
                    {
                        e.printStackTrace();
                        System.out.println("新增女神失败");
                    }
                }
                if(OPERATION_ADD.equals(pre))
                    ++step;
            }//待填充查询、删除、更新功能
            else
            {
                System.out.println("您输入的值为："+in);
            }
        }
    }
}
