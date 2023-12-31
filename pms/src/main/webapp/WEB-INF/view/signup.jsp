<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>회원가입</title>
</head>
<body>
    <h2>회원가입</h2>
    <form action="/signup" method="post">
        <div>
            <input type="text" name="name" placeholder="이름"/>
        </div>
        <div>
            <input type="text" name="email" placeholder="이메일"/>
        </div>
        <div>
            <input type="password" name="password" placeholder="비밀번호"/>
        </div>
        <div>
            <input type="text" name="phone" placeholder="전화번호"/>
        </div>
        <div>
            <input type="text" name="website" placeholder="웹사이트"/>
        </div>
        <button type="submit">회원가입</button>
    </form>
</body>
</html>