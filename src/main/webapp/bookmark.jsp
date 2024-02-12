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

<table class="table" style="undefinedtable-layout: fixed; background-color: aquamarine; width: 1833px">
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
        <td>북마크 이름</td>
        <td>와이파이명</td>
        <td>등록일자</td>
        <td>비고</td>
    </tr>
    </thead>

    <tbody>
    <form action="/bookmarkServlet" method="get" class="location-form5">

        <c:forEach items="${bookmarkList}" var="bookmark">
            <tr class="warning">
                <td id="id" name="id"><c:out value="${bookmark.id}"/></td>
                <td><c:out value="${bookmark.name}"/></td>
                <td><c:out value="${bookmark.wifiNm}"/></td>
                <td><c:out value="${bookmark.ins_tms}"/></td>
                <td>
                    <button id="deleteBookmark" onclick="submitFormWithId(this)" data-bookmark-id="${bookmark.id}">삭제
                    </button>
                </td>
            </tr>
        </c:forEach>
        <input type="hidden" name="id" id="bookmarkId" value=""/>
    </form>


    </tbody>
</table>
    <script>
        function submitFormWithId(buttonElement) {
            var bookmarkId = buttonElement.getAttribute('data-bookmark-id'); // Get the history ID from the button's data attribute
            document.getElementById('bookmarkId').value = bookmarkId; // Set the hidden input value
            document.querySelector('.location-form5').submit(); // Submit the form
        }

    </script>
</body>
</html>