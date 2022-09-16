<%--
  Created by IntelliJ IDEA.
  User: 瑛
  Date: 2022/9/9
  Time: 21:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Insert title here</title>
</head>
<body>
<table>
  <form action="/web/request" method="post">
    <input name="username">
    <input name="password" type="password">
    <input type="submit">
  </form>
  <tr>
    <th>year</th>
    <th>salary</th>
  </tr>
  <%
    for (int i = 0; i <= 50; i ++) {
      System.out.println("<tr>");
      System.out.println("<td>"+ i +"</td>");
      int sal = 0;
      if ( i <= 5) {
        sal = 1500 + i * 150;
      } else if ( i > 5 && i <= 10) {
        sal = 1500 + 150 * 5 + 300 * (i - 5);
      } else if ( i > 10) {
        sal = 1500 + 150 * 5 + 300 + 375 * (i - 10);
      }
      System.out.println("<td>"+sal+"</td>");
      System.out.println("</tr>");
    }
  %>
</table>
</body>
</html>
