<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP-Model2(MVC) - todolist</title>
</head>
<body>
<h1><%= "menuInput.jsp" %></h1>
<br>
<h1><%= "임시 input화면" %></h1>
<form method="post" action="/menu/list">
    <div>
        <input type="text" name="title" placeholder="제목을 입력해주세요">
    </div>
    <div>
        <input type="date" name="dueDate" >
    </div>
    <div>
        <button type="reset">리셋</button>
        <button type="submit">작성</button>
    </div>
</form>
</body>
</html>
