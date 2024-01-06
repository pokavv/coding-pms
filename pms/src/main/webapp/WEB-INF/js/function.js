//<script inline="javascript">
//    /*<![CDATA[*/
//
//        function hasCode(value) {
//            return ((value.charCodeAt(value.length - 1) - 0xAC00) % 28) > 0;
//        }
//
//        function isValid(target, fieldName, focusTarget) {
//            if (target.value.trim()) {
//                return true;
//            }
//
//            const particle = (hasCode(fieldName)) ? '을' : '를'
//            const elementType = (target.type === 'text' || target.type === 'password' || target.type === 'search' || target.type === 'textArea') ? '입력' : '선택';
//            alert( `${fieldName + particle} ${elementType}해 주세요.` );
//
//            target.value = '';
//            (!focusTarget ? target : focusTarget).focus();
//            throw new Error(`"${target.id}" is required...`)
//        }
//
//        function countingLength(todoContent) {
//            if (todoContent.value.length > 300) {
//                alert('댓글을 300자 이하로 입력해 주세요.');
//                todoContent.value = todoContent.value.substring(0, 300);
//                todoContent.focus();
//            }
//            document.getElementById('counter').innerText = todoContent.value.length + '/300자';
//        }
//
//        window.onload = () => {
//            todoList();
//            groupList();
//        }
//
//        function groupList() {
//            $.ajax({
//                url: `/userGroup-list`,
//                type: 'get',
//                async: false,
//                success: function (response) {
//                    if (!response.length) {
//                        document.querySelector('group_list').innerHTML = '<div class="group_none"><p>가입된 그룹이 없습니다.</p></div>';
//                        return false;
//                    }
//
//                    let groupHtml = '';
//
//                    console.log(response);
//                    console.log(typeof(response));
//
//                    response.forEach(row => {
//                        groupHtml += `
//                            <div>
//                            <div class="group_body">
//                            <span class="form-control">${row.groupName}</span>
//                            <div class="group_date">${row.groupDate}</div>
//                            </div>
//                        `;
//                        })
//
//                        document.querySelector('.group_list').innerHtml = groupHtml;
//                        console.log(response);
//                    },
//                    error: function (request, status, error) {
//                        console.log(error);
//                    }
//            })
//        }
//
//        function todoList() {
//            const userId = [[ ${user.userId} ]]
//            console.log(userId);
//
//            $.ajax({
//                url: `/todo-list`,
//                type: 'get',
//                dataType: 'json',
//                async: false,
//                success: function (response) {
//                    if (!response.length) {
//                        document.querySelector('.todo_list').innerHTML = '<div class="todo_none"><p>등록된 todo가 없습니다.</p></div>';
//                        return false;
//                    }
//
//                    let todoHtml = '';
//
//                    console.log(response);
//                    console.log(typeof(response));
//
//                    response.forEach(row => {
//                        console.log("response.forEach = " + row);
//                        todoHtml += `
//                            <div>
//                                <div class="todo_body">
//                                    <span class="form-control">${row.todoContent}</span>
//                                    <div class="todo_date">${row.todoDate}</div>
//                                </div>
//                                <p class="func_btn">
//                                    <button type="button" class="todo_btn"><span class="icons icon_modify">수정</span></button>
//                                    <button type="button" class="todo_btn"><span class="icons icon_del">삭제</span></button>
//                                </p>
//                            </div>
//                        `;
//                    })
//
//                    document.querySelector('.todo_list').innerHTML = todoHtml;
//                    console.log(response);
//                },
//            error: function (request, status, error) {
//                console.log(error)
//                }
//            })
//        }
//
//        function addTodo() {
//            const todoContent = document.getElementById('todoContent');
//            isValid(todoContent, 'todo');
//
//            const userId = [[ ${user.userId} ]];
//            const params = {
//                userId : userId,
//                todoContent : todoContent.value,
//            }
//
//            $.ajax({
//                url : `/todo-list`,
//                type : 'post',
//                contentType : 'application/json; charset=utf-8',
//                data : JSON.stringify(params),
//                dataType : 'script',
//                async : false,
//                success : function (response) {
//                    alert('새로운 todo가 추가되었습니다.');
//                    todoContent.value = '';
//                    document.getElementById('counter').innerText = '0/300자';
//                    todoList();
//                    console.log(response);
//                },
//                error : function (request, status, error) {
//                    console.log(request);
//                    console.log(error);
//                    console.log(status);
//                }
//            })
//        }
//        /*]]>*/
//    </script>