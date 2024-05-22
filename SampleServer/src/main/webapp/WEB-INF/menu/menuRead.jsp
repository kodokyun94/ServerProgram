<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP-Model2(MVC) - menulist</title>
</head>
<body>
<h1><%= "menuRead.jsp" %></h1>
<br>
<h1><%= "임시 Read화면" %></h1>

<div>
    <input type="text" name="menuTitle" placeholder="제목을 입력해주세요" value="${sample.menuTitle}" readonly>
</div>
<div>
    <input type="date" name="menuRegDate" value="${sample.menuRegDate}" readonly>
</div>

<%--방법2 링크로 해당 수정폼 이동하기.--%>
<div>
    <h3>방법2, 수정폼 이동</h3>
    <a href="/menu/update?menuNo=${sample.menuNo}">수정폼이동</a>
</div>


<form method="get" action="/menu/list">
    <button type="submit">전체 메뉴</button>
</form>
<%--<script>--%>
<%--    document.querySelector("#updateBtn").addEventListener("click",function(e){--%>
<%--        self.location = "/menu/update?menuNo=${sample.menuNo}"--%>
<%--    },false);--%>

<%--</script>--%>
</body>
</html>
