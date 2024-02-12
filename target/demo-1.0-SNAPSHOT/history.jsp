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

<table class="table" style="undefinedtable-layout: fixed; width: 1833px">
    <colgroup>
        <col style="width: 86px">
        <col style="width: 77px">
        <col style="width: 74px">
        <col style="width: 147px">
        <col style="width: 197px">
    </colgroup>
    <thead>
    <tr class="success">
        <td>id</td>
        <td>위도</td>
        <td>경도</td>
        <td>조회일자</td>
        <td>비고</td>
    </tr>
    </thead>

    <tbody>
    <form action="/historyServlet" method="get" class="location-form">

        <c:forEach items="${searchList}" var="history">
            <tr class="warning">
                <td id="id" name="id"><c:out value="${history.id}"/></td>
                <td><c:out value="${history.lat}"/></td>
                <td><c:out value="${history.lnt}"/></td>
                <td><c:out value="${history.datetime}"/></td>
                <td>
                    <button id="deleteHistory" onclick="submitFormWithId(this)" data-history-id="${history.id}">삭제
                    </button>
                </td>
            </tr>
        </c:forEach>
        <input type="hidden" name="id" id="historyId" value=""/>
    </form>


    </tbody>
</table>
    <script>
        function submitFormWithId(buttonElement) {
            var historyId = buttonElement.getAttribute('data-history-id'); // Get the history ID from the button's data attribute
            document.getElementById('historyId').value = historyId; // Set the hidden input value
            document.querySelector('.location-form').submit(); // Submit the form
        }

    </script>
</body>
</html>