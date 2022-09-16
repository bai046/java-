package cn.gsy;
/**
* @description: TODO
* @author 瑛
* @date 2022/9/15 9:16
* @version 1.0
*/

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/ua")
public class UserAgentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userAgent = request.getHeader("User-Agent");
        if (userAgent.length() > 0) {
            System.out.println(userAgent);
        }
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println(userAgent);
        String output = "";
        if (userAgent.indexOf("Windows NT") != -1) {
            output = "<h1>这是PC端首页</h1>";
        } else if (userAgent.indexOf("iPhone") != -1 || userAgent.indexOf("Android") != -1) {
            output = "<h1>这是移动端首页</h1>";
        }
        response.getWriter().println(output);
    }
}