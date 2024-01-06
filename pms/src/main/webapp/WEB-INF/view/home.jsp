<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>환영합니다!</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>

    <h2>환영합니다 ${user.name}님!</h2>

    <h2>${user.name}님의 회원정보</h2>
    <p>name: ${user.name}</p>
    <p>email: ${user.email}</p>
    <p>phone: ${user.phone}</p>
    <p>website: ${user.website}</p>

    <button type="button" onclick="location.href='update'">정보수정</button>
    <form action="/logout" method="post">
        <button type="submit">로그아웃</button>
    </form>
    <form action="/delete" method="post">
        <button type="submit">회원탈퇴</button>
    </form>

    <br class="my-4">
    <label for="todo_list" class="home-label">TODO 리스트</label>
    <div id="todo_list" class="todo_list">

    </div>

    <br class="my-4">
    <label for="group_list" class="home-label">참가 그룹</label>
    <div id="group_list" class="group_list">
    </div>

<script>
    window.onload = () => {
        todoList();
        groupList();
    }

    function todoList() {
        $.ajax({
            url: `/todo-list`,
            type: 'get',
            dataType: 'json',
            async: false,
            success: function (response) {
                if (!response.length) {
                    document.querySelector('.todo_list').innerHtml = '<div class="todo_none"><p>등록된 투두가 없습니다.</p></div>';
                    return false;
                }

                const json_to_response = JSON.stringify(response);
                console.log(json_to_response);
                console.log(typeof(json_to_response))

                $.each(response, function(json_to_response, row) {
                    $("#todo_list").append(row.todoContent + " ");
                    $("#todo_list").append(row.todoDate + "<br>");
                });
            },
            error: function (request, status, error) {
                console.log(error);
            }
        })
    }

    function groupList() {
        $.ajax({
            url: `/userGroup-list`,
            type: 'get',
            dataType: 'json',
            async: false,
            success: function (response) {
                if (!response.length) {
                    document.querySelector('.group_list').innerHtml = '<div class="todo_none"><p>가입한 그룹이 없습니다.</p></div>';
                    return false;
                }

                const json_to_response = JSON.stringify(response);
                console.log(json_to_response);
                console.log(typeof(json_to_response))

                $.each(response, function(json_to_response, row) {
                    $("#group_list").append(row.groupName + " ");
                    $("#group_list").append(row.groupAim + "<br>");
                });
            },
            error: function (request, status, error) {
                console.log(error);
            }
        })
    }
</script>
</body>
</html>