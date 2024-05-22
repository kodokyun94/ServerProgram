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

  <div>
    <input type="text" name="title" placeholder="제목을 입력해주세요" value="${sample.title}" readonly>
  </div>
  <div>
    <input type="date" name="dueDate" value="${sample.dueDate}" readonly>
  </div>
<div>
  <input type="checkbox" name="finished" ${sample.finished ? "checked":""} onclick="return  false">
</div>
<div>
  <h3>방법1, 수정폼 이동</h3>
  <button type="submit">수정폼이동</button>
</div>
<%--방법2 링크로 해당 수정폼 이동하기.--%>
<div>
  <h3>방법2, 수정폼 이동</h3>
  <a href="/todo/update?tno=${sample.tno}">수정폼이동</a>
</div>
<%--방법3--%>
<%--자바스크립트의 코드 이용해서. 처리하기. --%>
<div>
  <h3>방법3, 수정폼 이동</h3>
  <input type="button" value="수정폼이동" id="updateBtn">
</div>

<form method="get" action="/todo/list">
  <button type="submit">전체 메뉴</button>
</form>
<script>
  document.querySelector("#updateBtn").addEventListener("click",function(e){
    self.location = "/todo/update?tno=${sample.tno}"
  },false);

</script>
</body>
</html>