<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>그룹 상세</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>

    <hr class="my-4">

    <div class="container">
        <div class-"py-5 text-center">
            <h2>${group.groupName}</h2>
        </div>
        <div>
            <label for="group-description">그룹설명</label>
            <textarea id="group-description" class="form-control" rows="8" cols="85" readonly>
                ${group.groupDescription}</textarea>
        </div>
        <div>
            <label for="group-aim">그룹목표</label>
            <input id="group-aim" class="form-control" value="${group.groupAim}" readonly />
        </div>
        <div>
            <label for="group-created-date">그룹생성일자</label>
            <input id="group-created-date" class="form-control" value="${group.createdDate}" readonly />
        </div>
        <div>
            <label for="group-is-recruit">모집여부</label>
            <c:if test="${group.isRecruit == true}">
                <span id="group-is-recruit" class="form-control">모집중</span>
            </c:if>
            <c:if test="${group.isRecruit == false}">
                <span id="group-is-recruit" class="form-control">모집완료</span>
            </c:if>
        </div>
    </div>

    <hr class="my-4">

    <div class="container">
        <div>
            <button type="button" class="group-join-btn" onclick="location.href='/group-join/${group.groupId}/${userId}'">그룹가입</button>
        </div>
        <div>
            <button type="button" class="group-list-btn" onclick="location.href='/group-list'">그룹목록</button>
        </div>
</body>
</html>