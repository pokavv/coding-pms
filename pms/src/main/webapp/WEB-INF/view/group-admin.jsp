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
        <h2>${groupName} 관리자 페이지</h1>
        </div>
        <div>
            <h3>관리자 목록</h2>
            <table>
            <c:choose>
            <c:when test="${manager.isEmpty()}">
                <tr>
                <td>그룹 내 관리자가 없습니다.</td>
                </tr>
            </c:when>
            <c:otherwise>
                <thead>
                    <tr>
                    <th>이름<th>
                    <th>이메일<th>
                    <th>전화번호<th>
                    <th>웹사이트<th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="item" items="${manager}">
                    <tr>
                    <td>${item.userName}<td>
                    <td>${item.email}<td>
                    <td>${item.phone}<td>
                    <td>${item.website}<td>
                    </tr>
                </c:forEach>
                </tbody>
                </table>
            </c:otherwise>
            </c:choose>
        </div>
        <hr class="my-4">
        <div>
            <h3>그룹 회원 목록</h2>
            <table>
            <c:choose>
            <c:when test="${member.isEmpty()}">
                <tr>
                <td>그룹 내 가입된 일반유저가 없습니다.</td>
                </tr>
            </c:when>
            <c:otherwise>
                <thead>
                    <tr>
                    <th>이름<th>
                    <th>이메일<th>
                    <th>전화번호<th>
                    <th>웹사이트<th>
                    <th>관리자권한</th>
                    <th>회원삭제</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="item" items="${member}">
                    <tr>
                    <td>${item.userName}<td>
                    <td>${item.email}<td>
                    <td>${item.phone}<td>
                    <td>${item.website}<td>
                    <td><button type="button"
                            onclick="location.href='/my-group/${item.groupId}/admin/${item.userId}/grant-auth-true'">등록</button></td>
                    <td><button type="button"
                            onclick="location.href='/my-group/${item.groupId}/admin/${item.userId}/delete-user'">삭제</button></td>
                    </tr>
                </c:forEach>
                </tbody>
                </table>
            </c:otherwise>
            </c:choose>
        </div>
        <hr class="my-4">
        <div>
            <h3>가입 신청 목록</h2>
            <c:choose>
            <c:when test="${junior.isEmpty()}">
                <tr>
                <td>아직 가입 신청한 유저가 없습니다.</td>
                </tr>
            </c:when>
            <c:otherwise>
            <table>
                <thead>
                    <tr>
                    <th>이름<th>
                    <th>이메일<th>
                    <th>전화번호<th>
                    <th>웹사이트<th>
                    <th>가입신청</th>
                    <th>회원삭제</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="item" items="${junior}">
                    <tr>
                    <td>${item.userName}<td>
                    <td>${item.email}<td>
                    <td>${item.phone}<td>
                    <td>${item.website}<td>
                    <td><button type="button"
                            onclick="location.href='/my-group/${item.groupId}/admin/${item.userId}/grant-auth-true'">승인</button></td>
                    <td><button type="button"
                            onclick="location.href='/my-group/${item.groupId}/admin/${item.userId}/delete-user'">삭제</button></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            </c:otherwise>
            </c:choose>
        </div>

        <hr class="my-4">

        <div>
            <button type="button" onclick="location.href='/my-group/${groupId}'">그룹으로</button>
        </div>
    </div>
</body>
</html>