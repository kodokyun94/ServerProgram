<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP-Model2(MVC)-memberInput</title>
</head>
<body>
<h1><%= "임시 memberInput 화면." %>
</h1>
<form method="post" action="/member/input ">
    <input type="text" name="member1" placeholder="멤버1 입력해주세요">
    <input type="text" name="member2" placeholder="멤버2 입력해주세요">
    <button type="submit">임시 멤버 등록</button>
</form>
</body>
</html>