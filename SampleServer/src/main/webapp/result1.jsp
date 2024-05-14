<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP2 - result1</title>
</head>
<body>
<h1>input.jsp에서 보낸 정보 출력 파일</h1>
<h1>넘어온 데이터 num1 : ${param.num1}</h1>
<h1>넘어온 데이터 num2 : ${param.num2}</h1>
<h1>넘어온 데이터 num1 + num2 : ${param.num1 + param.num2} </h1>
<h1>넘어온 데이터 정수로 변환 : ${Integer.parseInt(param.num1) + Integer.parseInt(param.num2)} </h1>
</body>
</html>