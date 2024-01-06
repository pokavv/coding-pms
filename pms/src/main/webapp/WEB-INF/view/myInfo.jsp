<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>내 정보</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>

    <br class="my-4">
    <div class="container">
        <table class="my-info-table">
            <tr>
                <th>이름</th>
                <th>이메일</th>
                <th>전화번호</th>
            </tr>

            <tr>
                <td>유저1</td>
                <td>유저@naver.com</td>
                <td>01012341234</td>
            </tr>
        </table>

        <button type="button" onclick="location.href='update'">정보수정</button>
        <form action="/logout" method="post">
            <button type="submit">로그아웃</button>
        </form>
        <form action="/delete" method="post">
            <button type="submit">회원탈퇴</button>
        </form>
    </div>
</body>
</html>