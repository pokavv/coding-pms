<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>글작성</title>
</head>
<body>
    <h2>글작성</h2>
    <form action="" method="post">
        <div>
            <input type="text" name="title" placeholder="제목"/>
        </div>
        <div>
            <input type="textarea" name="content" placeholder="내용"/>
        </div>
        <button type="submit">글작성</button>
    </form>
</body>
</html>