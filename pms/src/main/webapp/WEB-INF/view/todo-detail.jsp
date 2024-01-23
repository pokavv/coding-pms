<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% pageContext.setAttribute("LF", "\n"); %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link th:href="@{/css/bootstrap.min.css}"href="css/bootstrap.min.css" rel="stylesheet">
    <title>나의 TODO</title>
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>

    <hr class="my-4">
    <div class="container">
        <div>
            <label for="todo-content">내용</label>
            <input type="text" id="todo-content" name="todo-content" class="form-control"
                value="${todo.todoContent}" readonly>
        </div>
        <div>
            <label for="todo-date">등록일</label>
            <input type="text" id="todo-date" name="todo-date" class="form-control"
                value="${todo.todoDate}" readonly>
        </div>
    </div>
    <hr class="my-4">
    <div class="container">
        <c:if test="${todo.isCompleted eq false}">
        <div class="col">
            <form action="/todo-detail/${todo.todoId}/complete" method="post" name="update-form">
                <button class="w-100 btn btn-primary btn" type="submit">완료</button>
            </form>
        </div>
        </c:if>
        <div class="col">
            <form action="/todo-detail/${todo.todoId}/delete" method="post" name="delete-form">
                <button class="w-100 btn btn-warning btn" type="submit">삭제</button>
            </form>
        </div>
    </div>
    <hr class="my-4">
    <div>
        <button onclick="history.back()">뒤로</button>
    </div>
</body>
</html>