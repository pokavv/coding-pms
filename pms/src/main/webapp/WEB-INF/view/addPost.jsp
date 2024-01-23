<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link th:href="@{/css/bootstrap.min.css}"href="css/bootstrap.min.css" rel="stylesheet">
    <title>글작성</title>
</head>
<body>
<div class="container">
    <div class="py-5 text-center">
        <h2>글작성</h2>
        <form action="" method="post" enctype="multipart/form-data">
            <div>
                <input type="text" name="title" placeholder="제목"/>
            </div>
            <div>
                <input type="textarea" name="content" class="form-control" rows="8" cols="85" placeholder="내용"/>
            </div>
            <div>
                <th>첨부파일</th>
                <tr>
                <td>
                    <div class="file-list">
                    </div>
                    <div class="file-input">
                        <input type="text" readonly/>
                        <label>
                            <input type="file" name="files" onchange="getFile(this);"/>
                        </label>
                    </div>
                    <button type="button" onlick="removeFile(this);" class="btn del_btn">삭제</button>
                    <button type="button" onlick="addFile();" class="btn add_btn">추가</button>
                </td>
                </tr>
            </div>
            <button type="submit">글작성</button>
        </form>
    </div>
</div>

<script>
    // 파일 선택
    function getFile(element) {
        const file = element.files[0];
        const fileName = element.closest('.file-input').firstElementChild;

        console.log(file);
        console.log(fileName);

        // onclick = 취소
        if (!file) {
            fileName.value = '';
            return false;
        }

        // fileSize > 10MB
        const fileSize = Math.floor(file.size / 1024 / 1024);
        if (fileSize > 10) {
            alert('10MB 이하의 파일을 업로드해주세요.');
            fileName.value = '';
            element.value = '';
            return false;
        }

        // fileName 지정
        fileName.value = file.name;
    }

    // 파일 추가
    function addFile() {
        const fileDiv = document.createElement('div');
        fileDiv.innerHTML = `
            <div class="file-input">
                <input type="text" readonly/>
                <label>
                    <input type="file" name="files" onchange="getFile(this);"/>
                </label>
            </div>
            <button type="button" onclick="removeFile(this);" class="btn del_btn"><span>삭제</span></button>
        `;
        document.querySelector('.file-list').appendChild(fileDiv);
    }

    // 파일 삭제
    function removeFile(element) {
        const fileAddBtn = element.nextElementSibling;
        if (fileAddBtn) {
            const inputs = element.previousElementSibling.querySelectorAll('input');
            inputs.forEach(input => input.value = '')
            return false;
        }
        element.parentElement.remove();
    }
</script>
</body>
</html>