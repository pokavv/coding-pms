<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link th:href="@{/css/bootstrap.min.css}"href="css/bootstrap.min.css" rel="stylesheet">
    <title>그룹생성</title>
    <style>
        #input-textarea {
            width: 300px;
            height: 200px;
            text-align: top;
        }

        label {
            display: block;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>

    <div class="container">
        <h2>그룹생성</h2>
        <form name="form" action="" method="post" onSubmit="return checkInput()">
            <div>
                <label for="input-name">그룹명</label>
                <input type="text" id="input-name" name="groupName" placeholder="그룹명"/>
            </div>
            <div>
                <label for="input-textarea">그룹설명</label>
                <textarea id="input-textarea" name="groupDescription"
                    class="form-control" placeholder="그룹에 대한 간단한 설명을 작성해주세요."></textarea>
            </div>
            <div>
                <label for="select-aim">그룹목표</label>
                <select id="select-aim" name="groupAim">
                    <option value="팀프로젝트">팀프로젝트</option>
                    <option value="스터디">스터디</option>
                    <option value="기타">기타</option>
                </select>
            </div>
            <hr class="my-4">
            <button type="submit">그룹생성</button>
        </form>
    </div>

    <script>
        function checkInput() {
            if (form.groupName.value == "" || form.groupDescription.value == "" || form.groupAim.value == "") {
                alert("모든 항목을 입력해주세요.");
                return false;
            }
        }
    </script>
</body>
</html>