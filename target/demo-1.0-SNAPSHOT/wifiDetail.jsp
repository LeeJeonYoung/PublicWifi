<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>JSP - 와이파이 정보</title>
</head>
<>
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

<br/>
<br/>
<form action="/bookmarkServlet" method="post">
<select name="bookmarkGroup" id="bookmarkGroup" onchange="selectBookmarkGroup(this.value)">
    <c:forEach items="${bookmarkGroupList}" var="bookmarkGroup">
        <option> <c:out value="${bookmarkGroup.name}"/></option>>
    </c:forEach>
</select>
<input type="hidden" value="${wifiDetail.x_SWIFI_MAIN_NM}" name="wifiNm">
<button type="submit">북마크 추가</button>
</form>
<br/>

<table class="table" style="width: 50%">

    <thead>
    <tr class ="success">
        <td>관리번호</td>
        <td><c:out value="${wifiDetail.x_SWIFI_MGR_NO}"/></td>
    </tr>
    <tr>
        <td >자치구</td>
        <td><c:out value="${wifiDetail.x_SWIFI_WRDOFC}"/></td>
    </tr>
    <tr>
        <td >와이파이명</td>
        <td>${wifiDetail.x_SWIFI_MAIN_NM}</td>
    </tr>
    <tr>
        <td >도로명주소</td>
        <td><c:out value="${wifiDetail.x_SWIFI_ADRES1}"/></td>
    </tr>
    <tr>
        <td >상세주소</td>
        <td><c:out value="${wifiDetail.x_SWIFI_ADRES2}"/></td>
    </tr>
    <tr>
        <td >설치위치(층)</td>
        <td><c:out value="${wifiDetail.x_SWIFI_INSTL_FLOOR}"/></td>
    </tr>
    <tr>
        <td >설치유형</td>
        <td><c:out value="${wifiDetail.x_SWIFI_INSTL_TY}"/></td>
    </tr>
    <tr>
        <td >설치기관</td>
        <td><c:out value="${wifiDetail.x_SWIFI_INSTL_MBY}"/></td>
    </tr>
    <tr>

        <td >서비스구분 </td>
        <td><c:out value="${wifiDetail.x_SWIFI_SVC_SE}"/></td>
    </tr>
    <tr>

        <td >망종류</td>
        <td><c:out value="${wifiDetail.x_SWIFI_CMCWR}"/></td>
    </tr>
    <tr>
        <td >설치년도</td>
        <td><c:out value="${wifiDetail.x_SWIFI_CNSTC_YEAR}"/></td>
    </tr>
    <tr>
        <td>실내외구분</td>
        <td><c:out value="${wifiDetail.x_SWIFI_INOUT_DOOR}"/></td>
    </tr>
    <tr>
        <td >WIFI접속환경</td>
        <td><c:out value="${wifiDetail.x_SWIFI_REMARS3}"/></td>
    </tr>
    <tr>
        <td>X좌표</td>
        <td><c:out value="${wifiDetail.lat}"/></td>
    </tr>
    <tr>
        <td >Y좌표</td>
        <td><c:out value="${wifiDetail.lnt}"/></td>
    </tr>
    <tr>
        <td>작업일자</td>
        <td><c:out value="${wifiDetail.WORK_DTTM}"/></td>
    </tr>

    </tbody>
</table>
<script>

    function selectBookmarkGroup(value) {
        ${"#selectBookmarkGroup"}.val(value);
    }

</script>
</body>
</html>