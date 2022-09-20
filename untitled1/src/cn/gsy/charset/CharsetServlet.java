package cn.gsy.charset;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
* @description: TODO
* @author 瑛
* @date 2022/9/20 14:35
* @version 1.0
*/

@WebServlet("/charset/process")
public class CharsetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        System.out.println(name + ":" + address);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println(name + ":" + address);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        response.setContentType("text/html;charset=utf-8");
        System.out.println(name + ":" + address);
        response.getWriter().println(name + ":" + address);
    }
}