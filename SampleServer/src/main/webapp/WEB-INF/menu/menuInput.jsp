<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP-Model2(MVC) - menuInput</title>
</head>
<body>
<h1><%= "menuInput" %></h1>
<br>
<h1><%= "임시 menuInput화면" %></h1>
<form method="post" action="/menu/list">
    <button type="submit">메뉴 등록</button>
</form>
</body>
</html>
