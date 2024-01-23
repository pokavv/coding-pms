<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <title>헤더</title>
    <style>
        div, h3, #nav, ul, li {
            display: inline-block
        }
    </style>
</head>
<body>
<section>
    <header id="header">
        <div id="profile">
            <!-- <span class="profile-img">
                <img src="/images/logo.png" style="height: 200px; width: 200px;" alt="에러">
            </span> -->
            <h3>현재 로그인: ${sessionScope.username}</h3>
        </div>
        <nav id="nav">
            <ul class="main-menu">
                <li><a href="/" class="home">홈</a></li>
                <li><a href="/home-group-list" class="group-list">그룹 찾기</a></li>
                <li><a href="/my-group" class="my-group">내 그룹</a></li>
                <li><a href="/my-info" class="my-info">내 정보</a></li>
            </ul>
        </nav>
        <div>
            <form action="/logout" method="post">
                <button type="submit">로그아웃</button>
            </form>
        </div>
        <hr class="my-4">
    </header>
</section>
</body>
</html>