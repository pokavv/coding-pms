<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link th:href="@{/css/bootstrap.min.css}"href="css/bootstrap.min.css" rel="stylesheet">
<title>유저목록</title>
</head>
<body>
    <h2>유저목록</h2>
    <table>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>email</th>
            <th>password</th>
            <th>phone</th>
            <th>website</th>
        </tr>
        <c:forEach items="${list}" var="u">
        <tr>
            <td>${u.userId}</td>
            <td>${u.name}</td>
            <td>${u.email}</td>
            <td>${u.password}</td>
            <td>${u.phone}</td>
            <td>${u.website}</td>
        </tr>
        </c:forEach>
    </table>
</body>
</html>