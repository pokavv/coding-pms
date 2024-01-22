<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>그룹 찾기</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>

    <form id="group-search-form" object="${groupSearchCond}" method="get" class="form-inline">
        <div class="row">
            <div class="col">
                <input type="text" field="*{groupName}" name="groupName" class="form-control" placeholder="그룹명"/>
            </div>
            <div class="col">
                <label for="group-aim-select">그룹목표</label>
                <select id="group-aim-select" name="groupAim">
                    <option value="">선택하세요.</option>
                    <option value="팀프로젝트">팀프로젝트</option>
                    <option value="스터디">스터디</option>
                    <option value="기타">기타</option>
                </select>
            </div>
            <div class="col">
                <button type="submit" class="btn btn-secondary mb-2">검색</button>
            </div>
        </div>
    </form>

    <br class="my-4">

    <div class="container">
        <table class="group-table">
            <c:choose>
                <c:when test="${groups.isEmpty()}">
                    <tr>
                    <td colspan="3">조건을 만족하는 그룹이 없습니다.</td>
                    <td><button onclick="history.back()">뒤로</button></td>
                    </tr>
                </c:when>
                <c:otherwise>
                    <thead>
                        <tr>
                            <th>그룹명</th>
                            <th>그룹목표</th>
                            <th>모집여부</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="item" items="${groups}">
                        <tr>
                            <td><a href="/group-detail/${item.groupId}">${item.groupName}</a></td>
                            <td>${item.groupAim}</td>
                            <c:if test="${item.isRecruit == true}">
                            <td>모집중</td>
                            </c:if>
                            <c:if test="${item.isRecruit == false}">
                            <td>모집완료</td>
                            </c:if>
                        </tr>
                    </c:forEach>
                    </tbody>
                </c:otherwise>
            </c:choose>
        </table>
    </div>

    <div class="container">
        <button type="button" onclick="location.href='/create-group'">그룹생성</button>
    </div>
</body>
</html>