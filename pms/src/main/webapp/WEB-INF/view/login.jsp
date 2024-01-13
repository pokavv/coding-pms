<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>로그인</title>
</head>
<body>
    <form action="" method="post">
        <h2>로그인</h2>
        <div>
            <img src="/images/logo.png" class="img-thumbnail" style="height: 200px; width: 200px;" alt="이 글이 보이면 필터 에러">
        <div>
            <input type="text" name="email" placeholder="이메일"/>
        </div>
        <div>
            <input type="password" name="password" placeholder="비밀번호"/>
        <div>
        <button type="submit">로그인</button>
        <button type="button" onclick="location.href='signup'">회원가입</button>
    </form>
</body>
</html>