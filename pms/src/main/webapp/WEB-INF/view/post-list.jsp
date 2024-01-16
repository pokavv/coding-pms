<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>게시판</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>

    <h2>${groupName}</h2>

    <form id="posts-search-form" object="${postSearchCond}" method="get" class="form-inline">
        <div class="row">
            <div class="col">
                <input type="text" field="*{title}" name="title" class="form-control" placeholder="제목"/>
            </div>
            <div class="col">
                <input type="text" field="*{userName}" name="userName" class="form-control" placeholder="작성자"/>
            </div>
            <div class="col">
                <button type="submit" class="btn btn-secondary mb-2">검색</button>
            </div>
        </div>
    </form>

    <hr class="my-4">

    <div class="container">
        <table class="post-table">
            <c:choose>
                <c:when test="${posts.isEmpty()}">
                    <tr>
                    <td colspan="3">게시글이 없습니다.</td>
                    <td><button onclick="history.back()">뒤로</button></td>
                    </tr>
                </c:when>
                <c:otherwise>
                    <thead>
                        <tr>
                            <th>제목</th>
                            <th>내용</th>
                            <th>작성자</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="item" items="${posts}">
                        <tr>
                            <td><a href="/post-detail/${item.postId}">${item.title}</a></td>
                            <td>${item.userName}</td>
                            <td>${item.postDate}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </c:otherwise>
            </c:choose>
        </table>
        <br>
        <div>
            <button type="button" onclick="location.href='/add-post/${groupId}'">글작성</button>
        </div>
    </div>
</body>
</html>