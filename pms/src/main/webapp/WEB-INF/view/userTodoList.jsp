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

    <h2>TODO List</h2>

    <div class="container">
        <div class="uncompleted-todo">
            <h2>진행중인 TODO 목록</h2>
            <table class="uncompleted-todo-table">
                <c:if test="${todoUncompleted.isEmpty()}">
                    <tr>
                    <td colspan="3">현재 데이터가 없습니다.</td>
                    </tr>
                </c:if>
                <c:forEach var="item" items="${todoUncompleted}">
                    <tr>
                        <td>"${item.todoContent}"</td>
                        <td>"${item.todoDate}"</td>
                        <td><button class="complete-btn" type="button">완료</button></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <br class="my-4">
        <div class="completed-todo">
            <h2>완료한 TODO 목록</h2>
            <table class="completed-todo-table">
                <c:if test="${todoCompleted.isEmpty()}">
                    <tr>
                    <td colspan="3">현재 데이터가 없습니다.</td>
                    </tr>
                </c:if>
                <c:forEach var="item" items="${todoCompleted}">
                    <tr>
                        <td>"${item.todoContent}"</td>
                        <td>"${item.todoDate}"</td>
                        <td><button class="complete-btn" type="button">완료</button></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</body>
</html>