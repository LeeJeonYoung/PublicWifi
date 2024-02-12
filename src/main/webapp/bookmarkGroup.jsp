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
        <col style="width: 10%">
        <col style="width: 10%">
        <col style="width: 10%">
        <col style="width: 10%">
        <col style="width: 10%">
    </colgroup>
    <thead>
    <tr class="success">
        <td>id</td>
        <td>북마크 그룹 이름</td>
        <td>순서</td>
        <td>등록일자</td>
        <td>수정일자</td>
        <td>비고</td>
    </tr>
    </thead>

    <tbody>
    <br>
    <button id="insertBookmarkGroup" onclick="movePage(this)" flag="insert">추가
    </button>

    <form action="/bookmarkGroupServlet" method="post" class="location-form3">

<tr>

</tr>
        <c:forEach items="${bookmarkGroupList}" var="bookmarkGroup">
            <tr class="warning">
                <td id="id" name="id"><c:out value="${bookmarkGroup.id}"/></td>
                <td><c:out value="${bookmarkGroup.name}"/></td>
                <td><c:out value="${bookmarkGroup.order2}"/></td>
                <td><c:out value="${bookmarkGroup.ins_tms}"/></td>
                <td><c:out value="${bookmarkGroup.upd_tms}"/></td>
                <td>
                    <button id="updateBookmarkGroup" type="button" onclick="movePage(this)" data-bookmarkGroup-id="${bookmarkGroup.id}" flag="update">수정
                    </button>
                    <button id="deleteBookmarkGroup" onclick="submitFormWithId(this)" data-bookmarkGroup-id="${bookmarkGroup.id}" flag="delete">삭제
                    </button>
                </td>
            </tr>
        </c:forEach>
        <input type="hidden" name="id" id="bookmarkGroupId" value=""/>
        <input type="hidden" name="flag" id="bookmarkGroupFlag" value=""/>
    </form>


    </tbody>
</table>
</body>
</html>


<script>
    function submitFormWithId(buttonElement) {
        var bookmarkGroupId = buttonElement.getAttribute('data-bookmarkGroup-id'); // Get the history ID from the button's data attribute
        var bookmarkGroupFlag = buttonElement.getAttribute('flag'); // Get the history ID from the button's data attribute
        document.getElementById('bookmarkGroupId').value = bookmarkGroupId; // Set the hidden input value
        document.getElementById('bookmarkGroupFlag').value = bookmarkGroupFlag; // Set the hidden input value
        document.querySelector('.location-form3').submit(); // Submit the form
    }
    function movePage(buttonElement){
        var bookmarkGroupId = buttonElement.getAttribute('data-bookmarkGroup-id');
        console.log("bookmarkGroupId: "+bookmarkGroupId);
        location.href='/bookmarkGroupInsertServlet?id='+bookmarkGroupId;
    }


</script>
