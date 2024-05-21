<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>JSP-Model2(MVC)-menuList</title>
</head>
<body>
<ul>
    <c:forEach items="${list}" var = "dto">
        <li>${dto}</li>
    </c:forEach>
</ul>
</body>
</html>
