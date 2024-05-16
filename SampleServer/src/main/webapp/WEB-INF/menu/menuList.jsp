<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>JSP-Model2(MVC)-menuList</title>
</head>
<body>
<h1><%= "MenuList.jsp" %>
</h1>
<br/>
<h1><%= "임시 menuList 화면. 임시 메인" %>
</h1>
<h2>더미 리스트 </h2>
<h1>JSTL 이용해서 반복문 출력해보기1.</h1>
<ul>
    <c:forEach var="dto" items="${list}">
        <li>
                ${dto}
        </li>
    </c:forEach>
</ul>

</body>
</html>
