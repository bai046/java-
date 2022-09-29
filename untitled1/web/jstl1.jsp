<%--
  Created by IntelliJ IDEA.
  User: 瑛
  Date: 2022/9/22
  Time: 10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>${requestScope.score}</h2>
<c:if test="${score>=60}">
    <h2 style="color: green">恭喜您,已经通过测试</h2>
</c:if>
<c:if test="${score<60}">
    <h2 style="color: red">对不起,再见...</h2>
</c:if>

<!-- choose when otherwise -->
${grade}
<c:choose>
    <c:when test="${grade=='A'}">
        <h2>你非常非常非常非常非常的优秀</h2>
    </c:when>

    <c:when test="${grade=='B'}">
        <h2>你还不错哟....</h2>
    </c:when>

    <c:when test="${grade=='C'}">
        <h2>嗯,你还行吧...</h2>
    </c:when>

    <c:when test="${grade=='D'}">
        <h2>嗯,继续努力啦,你很棒</h2>
    </c:when>
    <c:otherwise>
        <h2>怎么说呢,我觉得你努力一下会非常有潜质</h2>
    </c:otherwise>
</c:choose>

</body>
</html>
