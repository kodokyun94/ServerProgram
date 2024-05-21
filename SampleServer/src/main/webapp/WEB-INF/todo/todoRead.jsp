<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP-Model2(MVC) - todolist</title>
</head>
<body>
<h1><%= "todoRead.jsp" %></h1>
<br>
<h1><%= "임시 Read화면" %></h1>
<form method="post" action="/todo/update">
  <div>
    <input type="text" name="title" placeholder="제목을 입력해주세요" value="${sample.title}">
  </div>
  <div>
    <input type="date" name="dueDate" value="${sample.dueDate}">
  </div>
  <div>
    <button type="submit">수정</button>
  </div>
</form>
</body>
</html>