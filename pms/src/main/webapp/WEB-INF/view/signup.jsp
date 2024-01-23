<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>회원가입</title>
    <link th:href="@{/css/bootstrap.min.css}"href="css/bootstrap.min.css" rel="stylesheet">
    <style>
        label {
            display: block;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <h2>회원가입</h2>
    <form name="signupForm" action="" method="post">
        <div>
            <label for="userName">유저명</label>
            <input type="text" id="userName" name="userName" placeholder="이름"/>
        </div>
        <div>
            <label for="email">이메일</label>
            <input type="text" id="email" name="email" placeholder="이메일"/>
        </div>
        <div>
            <label for="password">비밀번호</label>
            <input type="password" id="password" name="password" placeholder="비밀번호"/>
        </div>
        <div>
            <label for="phone">전화번호</label>
            <input type="text" id="phone" name="phone" placeholder="전화번호"/>
        </div>
        <div>
            <label for="website">웹사이트</label>
            <input type="text" id="website" name="website" placeholder="웹사이트"/>
        </div>
        <hr class="my-4">
        <button type="button" onclick="checkInput()">회원가입</button>
        <button type="button" onclick="location.href='/login'">돌아가기</button>
    </form>

    <script>
        function checkInput() {
            var signupForm = document.signupForm;
            var userName = signupForm.userName.value;
            var email = signupForm.email.value;
            var password = signupForm.password.value;
            var phone = signupForm.phone.value;
            var website = signupForm.website.value;

            if (!userName || !email || !password || !phone || !website) {
                alert("모든 항목을 제대로 입력해주세요.");
            } else {
                signupForm.submit();
            }
        }
    </script>
</body>
</html>