<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>정보수정</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
    <div class="container">
        <div class="col">
            <h2>비밀번호 변경에 실패했습니다! 다시 시도해주세요.</h2>
        </div>
        <div>
            <button type="button" onclick="location.href='/my-info'">돌아가기</button>
        </div>
    </div>
</body>
</html>