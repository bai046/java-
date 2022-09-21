package cn.gsy.el;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
* @description: TODO
* @author 瑛
* @date 2022/9/21 15:58
* @version 1.0
*/

@WebServlet("/info")
public class StudnetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student stu = new Student();
        stu.setName("皮卡丘");
        stu.setMobile(null);
        String grade = "A";
        HttpSession session = request.getSession();
        session.setAttribute("stu",stu);
        session.setAttribute("grade", grade);
        List list = new ArrayList();
        list.add("A");
        list.add("B");
        list.add("C");
        session.setAttribute("list", list);
//        request.setAttribute("grade", "B");

        request.getRequestDispatcher("/el_info.jsp").forward(request, response);
    }
}