<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>정보수정</title>
</head>
<body>
    <h2>회원정보수정</h2>
    <form action="/update" method="post" accept-charset="utf-8">
        <p>이름
            <input type="text" name="name" value="${user.name}"/>
        </p>
        <p>이메일
            <input type="text" name="email" value="${user.email}"/>
        </p>
        <p>비밀번호
            <input type="password" name="password" value="${user.password}"/>
        </p>
        <p>전화번호
            <input type="text" name="phone" value="${user.phone}"/>
        </p>
        <p>웹사이트
            <input type="text" name="website" value="${user.website}"/>
        </p>
        <button type="submit">저장</button>
    </form>
</body>
</html>