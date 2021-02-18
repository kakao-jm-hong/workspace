(function(){
    var todo = document.getElementById('todo');
    var button = document.getElementById('add');
    var todolist = document.getElementById('todolist');
    var todoTemplate= "<li><input type=\"checkbox\"><span>{{todo}}</span></li>";

    function createTodoForStr(todoVal){
        // 여기서 생성한다.
        var todoStr = todoTemplate.replace("{{todo}}",todoVal);
        todolist.insertAdjacentHTML("beforeend",todoStr);
    }
    // 핸들바 사용
    // var template = Handlebars.compile(todoTemplate);
    // var html =template({
    //     "key":"value"
    // });
    
    // DOM 사용
    // function createTodo(todoVal){
    //     var li = document.createElement("li");
    //     var span =document.createElement("span");
    //     var input = document.createElement("input");
    //     input.setAttribute("type","checkbox");
    //     span.innerText = todoVal;
    
    //     li.appendChild(input);
    //     li.appendChild(span);
    //     todolist.appendChild(li);
    // }

    button.addEventListener("click",function(e){
        
        // createTodo(todo.value);
        createTodoForStr(todo.value);
        todo.value = "";
    } )
})();

