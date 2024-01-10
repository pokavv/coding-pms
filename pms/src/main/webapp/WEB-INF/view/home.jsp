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

    <hr class="my-4">
    <h2>${user.name}님의 회원정보</h2>
    <p>name: ${user.name}</p>
    <p>email: ${user.email}</p>
    <p>phone: ${user.phone}</p>
    <p>website: ${user.website}</p>

    <br>
    <button type="button" onclick="location.href='update'">정보수정</button>
    <form action="/logout" method="post">
        <button type="submit">로그아웃</button>
    </form>
    <form action="/delete" method="post">
        <button type="submit">회원탈퇴</button>
    </form>

    <hr class="my-4">

    <h2>TODO 리스트</h2>
    <div id="todo_list" class="todo_list">

    </div>

    <br>
    <button class="w-100 btn btn-secondary btn" type="button">
        <a href="/todo-list/${userId}">
            전체TODO보기
        </a>
    </button>
    <br>

    <div class="todo_write">
        <h4>TODO 추가</h4>
        <div id="todo_input" class="todo_input">
            <p><textarea id="todoContent" name="todoContent" onkeyup="countingLength(this);"
                cols="90" rows="4" placeholder="새로운 TODO를 입력해 보세요!"></textarea></p>
            <span>
                <button type="button" class="btn-save" onclick="addTodo();">등록</button>
                <i id="counter">0/300자</i>
            </span>
        </div>
    </div>

    <hr class="my-4">
    <h2>참가 그룹</h2>
    <div id="group_list" class="group_list">
    </div>

<script>

    function hasCode(value) {
        return ((value.charCodeAt(value.length - 1) - 0xAC00) % 28) > 0;
    }

    function isValid(target, fieldName, focusTarget) {
        if (target.value.trim()) {
            return true;
        }

        const particle = (hasCode(fieldName)) ? '을' : '를';
        const elementType = (target.type === 'text' || target.type === 'password' || target.type === 'search' || target.type === 'textarea') ? '입력' : '선택';
        alert( `${fieldName + particle} ${elementType}해 주세요.`);

        target.value = '';
        (!focusTarget ? target : focusTarget).focus();
        throw new Error(`"${target.id}" is required...!`)
    }

    function countingLength(todoContent) {
        if (todoContent.value.length > 300) {
            alert('TODO를 300자 이하로 입력해 주세요.');
            todoContent.value = todoContent.value.substring(0, 300);
            todoContent.focus();
        }
        document.getElementById('counter').innerText = todoContent.value.length + '/300자';
    }

    function todoClear() {
        $("#todo_list").empty();
    }

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

    function addTodo() {
        const todoContent = document.getElementById('todoContent');
        isValid(todoContent, 'TODO');

        const params = {
            todoContent : todoContent.value
        }
        console.log(params, typeof(params));

        $.ajax({
            url: `/add-todo`,
            type: 'post',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(params),
            dataType: 'script',
            async: false,
            success: function(response) {
                alert('새로운 TODO를 등록했습니다.');
                todoContent.value = '';
                document.getElementById('counter').innerText = '0/300자';
                console.log(response);
                todoClear();
                todoList();
            },
            error: function(request, status, error) {
                console.log(request, error, status);
            }
        })
    }
</script>
</body>
</html>