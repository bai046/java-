<%--
  Created by IntelliJ IDEA.
  User: 瑛
  Date: 2022/9/21
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>姓名：${sessionScope.stu.name}</h1>
<h1>手机：${sessionScope.stu.mobile}</h1>
<%--    <h1>讲师：${sessionScope.student.mobile}</h1>--%>
<h1>评级：${sessionScope.grade}</h1>

<c:forEach items="${list}" var="l">
    ${l}
</c:forEach>
</body>
</html>
