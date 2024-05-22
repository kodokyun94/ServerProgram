<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>JSP-Model2(MVC)-menuList</title>
</head>
<body>
<ul>
    <button><a href="/menu/input">Menu 작성</a></button>
    <c:forEach items="${list}" var = "dto">
        <li>
    <span>
      <a href="/menu/read?menuNo=${dto.menuNo}">${dto.menuNo}</a>
    </span>
            <span>
                    ${dto.menuTitle}
            </span>
            <span>
                    ${dto.menuRegDate}
            </span>
        </li>
    </c:forEach>
</ul>
</body>
</html>
