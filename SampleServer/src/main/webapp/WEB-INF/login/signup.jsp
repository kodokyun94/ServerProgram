<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>JSP2 - signup.jsp</title>
</head>
<body>
<form action="/signup" method="post">
<input type="text" name="mid" placeholder="아이디를 입력해주세요">
<input type="text" name="mname" placeholder="이름을 입력해주세요">
<input type="password" name="mpw" placeholder="비밀번호를 입력해주세요">
<input type="password" name="mpw2" placeholder="비밀번호를 확인해주세요">
    <br>
    <button type="reset">리셋</button>
    <button type="submit">회원가입</button>
</form>

</body>
</html>
