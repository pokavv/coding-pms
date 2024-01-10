<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>그룹 찾기</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>

    <form object="${groupSearchCond}" method="get" class="form-inline">
        <div class="row">
            <div class="col">
                <input type="text" field="*{groupName}" class="form-control" placeholder="그룹명"/>
            </div>
            <div class="col">
                <input type"text" field="^{groupAim}" class="form-control" placeholder="그룹목표"/>
            </div>
        </div>
    </form>

    <br class="my-4">

    <div class="container">
        <table class="group-table">
            <tr>
                <th>그룹명</th>
                <th>그룹목표</th>
                <th>그룹생성일</th>
            </tr>

            <tr>
                <td>그룹1</td>
                <td>팀프로젝트</td>
                <td>2024-01-07</td>
            </tr>
        </table>
    </div>
</body>
</html>