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
    <title>Title1</title>
</head>
<%
    String url = request.getRequestURI().toString();
    response.getWriter().println(url);
%>
<body>

</body>
</html>
