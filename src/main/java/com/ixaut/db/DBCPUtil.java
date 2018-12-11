package com.ixaut.db;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DBCPUtil {

    /*  数据源，static  */
    private static DataSource DS;

    private static final String configFile = "resources/dbcp.properties";

    /*  从数据源获得一个连接  */
    public Connection getConn(){
        Connection con = null;
        if(DS != null){
            try{
                con = DS.getConnection();
            }catch(Exception e){
                e.printStackTrace();
            }

            try{
                con.setAutoCommit(false);
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return con;
    }

    /*  默认构造函数  */
    public DBCPUtil(){
        initDbcp();
    }

    private static void initDbcp(){
        Properties pops = new Properties();
        try{
            File file = new File(configFile);
            FileInputStream in = new FileInputStream(file);
            pops.load(in);
            DS = BasicDataSourceFactory.createDataSource(pops);
        }catch(Exception e){
            e.printStackTrace();
        }
    }


//    /*  构造函数，初始化了DS */
//    public DBCPUtil(String connectURI){
//        initDS(connectURI);
//    }

    /*  构造函数，初始化了DS，指定所有参数  */
    public DBCPUtil(String connectURI,String usrname,String pswd,
                    String driverClass,int initialSize, int maxTotal,
                    int maxActive, int maxIdle,int maxWait, int minIdle){
        initDS(connectURI,usrname,pswd,driverClass,initialSize,maxTotal,
                maxActive,maxIdle,maxWait,minIdle);
    }

    public static void initDS(String connectURI,String usrname,
                              String pswd,String driverClass,
                              int initialSize,int maxTotal,
                              int maxActive, int maxIdle,int maxWait,
                              int minIdle){
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(driverClass);
        ds.setUsername(usrname);
        ds.setPassword(pswd);
        ds.setUrl(connectURI);
        ds.setInitialSize(initialSize);
        ds.setMaxTotal(maxTotal);
        ds.setMaxIdle(maxIdle);
        ds.setMaxWaitMillis(maxWait);
        ds.setMinIdle(minIdle);
        DS = ds;
    }
}
