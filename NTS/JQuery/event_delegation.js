(function () {
    var todo = document.getElementById('todo');
    var button = document.getElementById('add');
    var todolist = document.getElementById('todolist');
    var inputList = document.querySelectorAll("li input");

    function toggle(e) {
        if (e.target.parentNode.className === "complete") {
            e.target.parentNode.className = "";
        } else {
            e.target.parentNode.className = "complete";
        }
    }
    // DOM 사용
    function createTodo(todoVal) {
        var li = document.createElement("li");
        var span = document.createElement("span");
        var input = document.createElement("input");
        input.setAttribute("type", "checkbox");
        input.addEventListener("click", toggle);
        span.innerText = todoVal;

        li.appendChild(input);
        li.appendChild(span);
        todolist.appendChild(li);
    }

    button.addEventListener("click", function (e) {
        createTodo(todo.value);
        todo.value = "";
    });

    // 이방법이 밑에 방법보다 더좋음.
    // 대신 영역을 좁게 사용하자 document 전체를 바인딩 하면 느리다.
    todolist.addEventListener("click",function(e){
        if(e.target.tagName==="INPUT"){
            toggle(e);
        }
    } );
    
    // for (var i = 0; i < inputList.length; i++) {
    //     inputList[i].addEventListener("click", toggle);
    // }
})();

