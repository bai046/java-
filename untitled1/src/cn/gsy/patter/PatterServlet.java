package cn.gsy.patter;
/**
* @description: TODO
* @author 瑛
* @date 2022/9/20 14:57
* @version 1.0
*/

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class PatterServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 查询员工的基本信息
        // 获取当前访问的URL
        String url = request.getRequestURI().toString();
        System.out.println(url);
        // 获取最后一次出现/的位置
        String id = url.substring(url.lastIndexOf("/") + 1);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        // 获取地址的id
        out.println(id);
        if (id.equals("1")) {
            out.println("张三");
        } else if (id.equals("2")) {
            out.println("李四");
        }else {
            out.println("其它员工");
        }
    }
}