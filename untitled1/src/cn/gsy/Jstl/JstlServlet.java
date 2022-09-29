package cn.gsy.Jstl;
/**
* @description: TODO
* @author 瑛
* @date 2022/9/22 10:07
* @version 1.0
*/

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/jstl")
public class JstlServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("score", 71);
        request.setAttribute("grade", "A");

        request.getRequestDispatcher("/jstl1.jsp").forward(request, response);
    }
}
