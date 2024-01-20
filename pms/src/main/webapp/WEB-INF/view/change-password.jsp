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
    <form action="" method="post" accept-charset="utf-8">
        <div>현재 비밀번호 :
            <input type="password" id="old-password" name="old-password" placeholder="현재 비밀번호"/>
        </div>
        <hr class="my-4">
        <div>새 비밀번호 :
            <input type="password" id="new-password" name="new-password" placeholder="새 비밀번호"/>
        </div>
        <div>새 비밀번호 확인 :
            <input type="password" id="check-new-password" name="check-new-password" placeholder="새 비밀번호 확인"/>
        </div>
        <div>
            <button type="submit">저장</button>
        </div>
    </form>
</body>

<script type="text/javascript">
    function checkPassword() {
        var password = document.getElementById('new-password').value;
        var checkPassword = document.getElementById('check-new-password').value;
        if (password != checkPassword) {
            alert("비밀번호가 일치하지 않습니다.");
            return false;
        }
        return true;
    }
</script>
</html>