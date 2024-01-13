<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>그룹 상세</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>

    <hr class="my-4">

    <div class="container">
        <div class-"py-5 text-center">
            <h2>해당 그룹에 가입신청을 하시겠습니까?</h2>
        </div>
        <div class="row">
            <form action="" method="post">
            <div class="col">
                <button type="submit" class="group-join-btn">가입신청</button>
            </div>
            </form>
            <div class="col">
                <button class="back-btn" onclick="history.back()">뒤로</button>
            </div>
        </div>
    </div>

    <hr class="my-4">
</body>
</html>