<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>게시글</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>

    <hr class="my-4">
    <div class="container">
        <div>
            <label for="post-title">제목</label>
            <input type="text" id="post-content" name="post-content" class="form-control"
                value="${post.title}" readonly>
        </div>
        <div>
            <label for="post-date">등록일</label>
            <input type="text" id="post-date" name="post-date" class="form-control"
                value="${post.postDate}" readonly>
        </div>
        <div class="todo_write">
            <label for="post-content">내용</label>
            <div id="post-content" class="post-content">
                <textarea id="post-content-box" class="form-control" rows="8" cols="85" readonly>${post.content}</textarea>
            </div>
        </div>
    </div>
    <br>
    <div class="container">
        <c:if test="${isPosted == true}">
        <div class="col">
            <button type="button" class="w-100 btn btn-secondary btn"
                onclick="location.href='/post-edit/${post.postId}'">수정</button>
        </div>
        <div class="col">
            <form action="/post-detail/${post.postId}/delete" method="post" name="delete-form">
                <button class="w-100 btn btn-warning btn" type="submit">삭제</button>
            </form>
        </div>
        </c:if>
        <div class="col">
            <button onclick="history.back()">뒤로</button>
        </div>
    </div>
    <hr class="my-4">
    <label for="comment-list">댓글 ${commentCount}</label>
    <div id="comment-list" class="comment-list">

    </div>
    <div class="comment-write">
        <div id="comment-input" class="comment-input">
            <textarea id="commentContent" name="commentContent" onkeyup="countingLength(this);"
                    cols="90" rows="4" placeholder="댓글을 입력해 주세요."></textarea>
            <br>
            <span>
                <button type="button" class="add-comment-btn" onclick="addComment();">댓글등록</button>
                <i id="counter">0/300자</i>
            </span>
        </div>
    </div>

    <script>
        function hasCode(value) {
            return ((value.charCodeAt(value.length - 1) - 0xAC00) % 28) > 0;
        }

        function isValid(target, fieldName, focusTarget) {
            if (target.value.trim()) {
                return true;
            }

            const particle = (hasCode(fieldName)) ? '을' : '를';
            const elementType = (target.type === 'text' || target.type === 'password' || target.type === 'search' || target.type === 'textarea') ? '입력' :  '선택';
            alert(`${fieldName + particle} ${elementType}해 주세요.`);

            target.value = '';
            (!focusTarget ? target : focusTarget).focus();
            throw new Error(`"${target.id}" is required...!`)
        }

        function countingLength(commentContent) {
            if (commentContent.value.length > 300) {
                alert('댓글은 300자 이상 작성할 수 없습니다.');
                commentContent.value = commentContent.value.substring(0, 300);
                commentContent.focus();
            }
            document.getElementById('counter').innerText = commentContent.value.length + '/300자';
        }

        function commentClear() {
            $("#comment-list").empty();
        }

        window.onload = () => {
            commentList();
        }

        function commentList() {
            $.ajax({
                url: `/post-detail/${postId}/comment-list`,
                type: 'get',
                dataType: 'json',
                async: false,
                success: function (response) {
                    if (!response.length) {
                        $("#comment-list").append("<div><p>등록된 댓글이 없습니다.</p></div>");
                        return false;
                    }

                    const json_to_response = JSON.stringify(response);
                    console.log(json_to_response);
                    console.log(typeof(json_to_response));

                    $.each(response, function(json_to_response, row) {
                        $("#comment-list").append(row.userName + "<br>");
                        $("#comment-list").append(row.commentContent + " ");
                        $("#comment-list").append(row.commentDate + "<br>");
                    });
                },
                error: function (request, status, error) {
                    console.log(error);
                }
            })
        }

        function addComment() {
            const commentContent = document.getElementById('commentContent');
            isValid(commentContent, '댓글');

            const params = {
                commentContent : commentContent.value
            }
            console.log(params, typeof(params));

            $.ajax({
                url: `/post-detail/${postId}/add-comment`,
                type: 'post',
                contentType: 'application/json; charset=utf-8',
                data: JSON.stringify(params),
                dataType: 'script',
                async: false,
                success: function(response) {
                    alert('새로운 댓글을 등록했습니다.');
                    commentContent.value = '';
                    document.getElementById('counter').innerText = '0/300자';
                    console.log(response);

                    commentClear();
                    commentList();
                },
                error: function (request, status, error) {
                    console.log(request, error, status);
                }
            })
        }
    </script>
</body>
</html>