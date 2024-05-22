<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP-Model2(MVC) - menulist</title>
</head>
<body>
<h1><%= "menuupdate.jsp" %></h1>
<br>
<h1><%= "임시 menu 수정폼 화면" %></h1>
<form method="post" action="/menu/update">
    <div>
        <input type="text" name="menuTitle" placeholder="제목을 입력해주세요" value="${sample.menuTitle}" >
    </div>
    <div>
        <input type="date" name="menuRegDate" value="${sample.menuRegDate}" >
    </div>
    <div>
        <input type="hidden" name="menuNo" value="${sample.menuNo}">
        <button type="submit">수정하기</button>
    </div>
</form>

<form method="post" action="/menu/delete">
    <input type="hidden" name="menuNo" value="${sample.menuNo}">
    <button type="submit">삭제하기</button>
</form>

<form method="post" action="/menu/list">
    <button type="submit">전체 메뉴</button>
</form>
</body>
</html>
