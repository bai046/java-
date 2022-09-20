<%--
  Created by IntelliJ IDEA.
  User: 瑛
  Date: 2022/9/20
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%
    String url = request.getRequestURI().toString();
    response.getWriter().println(url);
%>
<%
    out.println("<br/>ABC");
    session.setAttribute("user", "皮卡丘");
    out.println((String) session.getAttribute("user"));
%>

<%
    String cp = application.getInitParameter("copyright");
    out.println("<hr/>");
    out.println(cp);
%>


<%
    // pageContext 中转站,可以通过它获取其它的对象
    pageContext.getSession();
    pageContext.getRequest();
%>
</body>
</html>