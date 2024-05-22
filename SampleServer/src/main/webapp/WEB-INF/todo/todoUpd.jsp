<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP-Model2(MVC) - todolist</title>
</head>
<body>
<h1><%= "todoupdate.jsp" %></h1>
<br>
<h1><%= "임시 todo 수정폼 화면" %></h1>
<form method="post" action="/todo/update">
  <div>
    <input type="text" name="title" placeholder="제목을 입력해주세요" value="${sample.title}" >
  </div>
  <div>
    <input type="date" name="dueDate" value="${sample.dueDate}" >
  </div>
  <div>
    <input type="checkbox" name="finished" ${sample.finished ? "checked":""} >
  </div>
  <div>
    <input type="hidden" name="tno" value="${sample.tno}">
    <button type="submit">수정하기</button>
  </div>
</form>

<form method="post" action="/todo/delete">
  <input type="hidden" name="tno" value="${sample.tno}">
  <button type="submit">삭제하기</button>
</form>

<form method="post" action="/todo/list">
  <button type="submit">전체 메뉴</button>
</form>
</body>
</html>