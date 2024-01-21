<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>정보수정</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
    <h2>회원정보수정</h2>
    <form action="" method="post" accept-charset="utf-8">
        <div>현재 비밀번호 :
            <input type="password" id="pw" name="old_password" placeholder="현재 비밀번호" required/>
        </div>
        <hr class="my-4">
        <div>새 비밀번호 :
            <input type="password" id="new_pw" name="new_password" placeholder="새 비밀번호" required/>
        </div>
        <div>새 비밀번호 확인 :
            <input type="password" id="check_pw" name="check_password" placeholder="새 비밀번호 확인" required/>
        </div>
        <div>
            <button id="change-password" type="submit" onclick="return validatePw();">저장</button>
        </div>
    </form>
<script>
    function validatePw() {
        if ($('#new_pw').val() != $('#check_pw').val()) {
            alert("비밀번호가 일치하지 않습니다.");
            return false;
        }
    }
</script>
</body>
</html>