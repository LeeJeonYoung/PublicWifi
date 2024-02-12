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

<form action="/location" class="location-form">

    <label>LAT:</label>
    <label>
        <input id="latitude-input" name="latitude-input" step="any" type="number" placeholder="X좌표"/>
    </label>

    <label>, LNT:</label>
    <label>

        <input id="longitude-input" name="longitude-input" step="any" type="number" placeholder="Y좌표"/>
    </label>
    <button id="myLocationButton" type="button" class="btn btn-danger" onclick="takeLocation()">내 위치 가져오기</button>
    <button id="nearWifiButton" type="submit" class="btn btn-info">근처 WIFI 정보 보기</button>

</form>


<table class="table" style="undefinedtable-layout: fixed; width: 1833px">
    <colgroup>
        <col style="width: 86px">
        <col style="width: 77px">
        <col style="width: 74px">
        <col style="width: 147px">
        <col style="width: 197px">
        <col style="width: 127px">
        <col style="width: 83px">
        <col style="width: 134px">
        <col style="width: 99px">
        <col style="width: 144px">
        <col style="width: 104px">
        <col style="width: 59px">
        <col style="width: 73px">
        <col style="width: 116px">
        <col style="width: 97px">
        <col style="width: 103px">
        <col style="width: 113px">
    </colgroup>
    <thead>
    <tr class ="success">
        <td >거리(Km)</td>
        <td>관리번호</td>
        <td >자치구</td>
        <td >와이파이명</td>
        <td >도로명주소</td>
        <td >상세주소</td>
        <td >설치위치(층)</td>
        <td >설치유형</td>
        <td >설치기관</td>
        <td >서비스구분 </td>
        <td >망종류</td>
        <td >설치년도</td>
        <td>실내외구분</td>
        <td >WIFI접속환경</td>
        <td>X좌표</td>
        <td >Y좌표</td>
        <td>작업일자</td>



    </tr>
    </thead>



    <tbody>
    <form action="/locationDetail" method="get" class="location-form2">
    <c:forEach items="${searchList}" var="wifi">
        <tr class="warning">
            <td><c:out value="${wifi.distance}"/></td>
            <td><c:out value="${wifi.x_SWIFI_MGR_NO}"/></td>
            <td><c:out value="${wifi.x_SWIFI_WRDOFC}"/></td>
            <td>
                <button id="wifiDetail" onclick="submitFormWithMGR_NO(this)"
                        data-wifi-mgr-no="${wifi.x_SWIFI_MGR_NO}">
                        ${wifi.x_SWIFI_MAIN_NM}
                </button>
            </td>
            <td><c:out value="${wifi.x_SWIFI_ADRES1}"/></td>
            <td><c:out value="${wifi.x_SWIFI_ADRES2}"/></td>
            <td><c:out value="${wifi.x_SWIFI_INSTL_FLOOR}"/></td>
            <td><c:out value="${wifi.x_SWIFI_INSTL_TY}"/></td>
            <td><c:out value="${wifi.x_SWIFI_INSTL_MBY}"/></td>
            <td><c:out value="${wifi.x_SWIFI_SVC_SE}"/></td>
            <td><c:out value="${wifi.x_SWIFI_CMCWR}"/></td>
            <td><c:out value="${wifi.x_SWIFI_CNSTC_YEAR}"/></td>
            <td><c:out value="${wifi.x_SWIFI_INOUT_DOOR}"/></td>
            <td><c:out value="${wifi.x_SWIFI_REMARS3}"/></td>
            <td><c:out value="${wifi.lat}"/></td>
            <td><c:out value="${wifi.lnt}"/></td>
            <td><c:out value="${wifi.WORK_DTTM}"/></td>

        </tr>
    </c:forEach>

    <input type="hidden" name="x_SWIFI_MGR_NO" id="mGR_NO" value=""/>

    </form>
    </tbody>
</table>
<script>
    function  takeLocation(){
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(function (pos) {
                var latitude = pos.coords.latitude;
                var longitude = pos.coords.longitude;

                document.getElementById('latitude-input').value = latitude;
                document.getElementById('longitude-input').value = longitude;
            });
        } else {
            alert("이 브라우저에서는 Geolocation이 지원되지 않습니다.")
        }
    }

    function submitFormWithMGR_NO(buttonElement) {
        var mGR_NO = buttonElement.getAttribute('data-wifi-mgr-no');
        document.getElementById('mGR_NO').value = mGR_NO;
        document.querySelector('.location-form2').submit();
    }

</script>
</body>
</html>