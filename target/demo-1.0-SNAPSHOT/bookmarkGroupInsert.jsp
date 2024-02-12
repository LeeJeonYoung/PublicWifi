<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>JSP - 와이파이 정보</title>
</head>
<body>
<h1><%= "와이파이 정보 구하기" %>
</h1>
<br/>
<a href="/">홈</a>
|
<a href="historyServlet">위치 히스토리 목록</a>
|
<a href="openAPIservlet">Open API 와이파이 정보 가져오기</a>
|
<a href="bookmarkServlet">북마크 보기</a>
|
<a href="bookmarkGroupServlet">북마크 그룹관리</a>


<form action="/bookmarkGroupInsertServlet" method="post">
    <input type="hidden" id="id" name="id" value="<%=request.getParameter("id") %>"/>
    북마크 그룹 이름:<input type="text" name="name"><br/>
    순서:<input type="text" name="order"><br/>
    <input type="submit" value="저장"><br/>

</form>


    <script>
        function submitFormWithId(buttonElement) {
            var bookmarkGroupId = buttonElement.getAttribute('data-bookmarkGroup-id'); // Get the history ID from the button's data attribute
            var bookmarkGroupFlag = buttonElement.getAttribute('flag'); // Get the history ID from the button's data attribute
            document.getElementById('bookmarkGroupId').value = bookmarkGroupId; // Set the hidden input value
            document.getElementById('bookmarkGroupFlag').value = bookmarkGroupFlags; // Set the hidden input value
            document.querySelector('.location-form3').submit(); // Submit the form
        }

    </script>
</body>
</html>