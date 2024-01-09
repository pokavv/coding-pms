<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% pageContext.setAttribute("LF", "\n"); %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>나의 TODO</title>
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>

    <hr class="my-4">
    <div class="container">
        <div class="py-5 text-center">
            <label for="todo-content">내용</label>
        </div>
    </div>
</body>
</html>