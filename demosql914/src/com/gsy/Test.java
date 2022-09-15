package com.gsy;
/**
* @description: TODO
* @author 瑛
* @date 2022/9/14 14:36
* @version 1.0
*/

import java.sql.Connection;
import java.sql.DriverManager;

public class Test {
    public static void main(String[] args) throws Exception {
        // 数据库地址 + 要使用的数据库名
        String url = "jdbc:mysql://localhost:3306/" + "sql1";
        // 你要登陆的数据库用户，一般为 root
        String user = "root";
        // 你要登录用户的密码
        String password = "gsy20010406hk";

        // 三个参数分别是：URL，用户名，密码
        Connection con = DriverManager.getConnection(url, user, password);

        // 输出连接
        System.out.println(con);
        // 关闭连接
        con.close();
    }
}
