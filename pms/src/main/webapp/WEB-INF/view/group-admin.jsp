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

    <div class="container">
        <div>
            <table>
                <thead>
                    <tr>
                        <th>유저명</th>
                        <th>이메일</th>
                        <th>전화번호</th>
                        <th>웹사이트</th>
                        <th>가입승인</th>
                        <th>관리권한</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="item" items="${users}">
                    <tr>
                        <td>${item.userName}</td>
                        <td>${item.email}</td>
                        <td>${item.phone}</td>
                        <c:if test="${item.website != null}">
                        <td>${item.website}</td>
                        </c:if>
                        <c:choose>
                            <c:when test="${item.userId}">
                                <button>가입승인</button>
                            </c:when>
                            <c:otherwise>
                                <button>가입완료</button>
                            </c:otherwise>
                        </c:choose>
                        <c:choose>
                            <c:when test="${item.userId}">
                                <button>관리자부여</button>
                            </c:when>
                            <c:otherwise>
                                <button>관리자유저</button>
                            </c:otherwise>
                        </c:choose>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div>
        </div>

    </div>
</body>
</html>