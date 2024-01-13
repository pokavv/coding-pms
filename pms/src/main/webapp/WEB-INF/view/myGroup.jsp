<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>내 그룹</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>

    <br class="my-4">
    <div class="container">
        <table class="my-group-table">
        <c:choose>
            <c:when test="${groups.isEmpty()}">
                <tr>
                <td colspan="3">가입된 그룹이 없습니다.</td>
                <td><button type="button" onclick="location.href='/group-list'">새 그룹 찾아보기</button></td>
                </tr>
            </c:when>
            <c:otherwise>
                <h2>가입된 그룹</h2>
                <thead>
                <tr>
                    <th>그룹명</th>
                    <th>그룹목표</th>
                    <th>모집여부</th>
                    <th>진행상황</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="item" items="${groups}">
                <c:if test="${item.isAdmitted == true}">
                    <tr>
                        <td><a href="/my-group/${item.groupId}">${item.groupName}</a></td>
                        <td>${item.groupAim}</td>
                        <td>${item.isRecruit}</td>
                        <td>${item.isCompleted}</td>
                    </tr>
                </c:if>
                </c:forEach>
                </tbody>
            </c:otherwise>
            </c:choose>
        </table>
    </div>

    <hr class="my-4">

    <div class="container">
        <table class="my-group-table">
        <c:choose>
            <c:when test="${groups.isEmpty()}">
                <tr>
                <td colspan="3">가입신청 상태인 그룹이 없습니다.</td>
                <td><button type="button" onclick="location.href='/group-list'">새 그룹 찾아보기</button></td>
                </tr>
            </c:when>
            <c:otherwise>
                <h2>가입신청 그룹</h2>
                <thead>
                <tr>
                    <th>그룹명</th>
                    <th>그룹목표</th>
                    <th>모집여부</th>
                    <th>진행상황</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="item" items="${groups}">
                <c:if test="${item.isAdmitted == false}">
                    <tr>
                        <td><a href="/group-detail/${item.groupId}">${item.groupName}</a></td>
                        <td>${item.groupAim}</td>
                        <td>${item.isRecruit}</td>
                        <td>${item.isCompleted}</td>
                    </tr>
                </c:if>
                </c:forEach>
                </tbody>
            </c:otherwise>
            </c:choose>
        </table>
    </div>
</body>
</html>