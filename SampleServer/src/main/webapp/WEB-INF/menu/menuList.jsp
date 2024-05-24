<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>JSP-Model2(MVC)-menuList</title>
</head>
<body>
<ul>
    <h1>${memberDTO.mname}님 환영합니다.</h1>
    <div>
        <form method="post" action="/logout-menu">
            <button type="submit">로그아웃</button>
        </form>
    </div>
    <div>
        <form method="post" action="/noauto-menu">
            <button type="submit">자동로그인해제</button>
        </form>
    </div>
    <button><a href="/menu/input">Todo 작성</a></button>
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
