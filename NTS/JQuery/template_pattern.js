(function(){
    var todo = document.getElementById('todo');
    var button = document.getElementById('add');
    var todolist = document.getElementById('todolist');

    function createTodoForStr(todoVal,html){
        todolist.insertAdjacentHTML("beforeend",html);
    }
    
    function createTodo(todoVal){
        var li = document.createElement("li");
        var span =document.createElement("span");
        var input = document.createElement("input");
        input.setAttribute("type","checkbox");
        span.innerText = todoVal;
    
        li.appendChild(input);
        li.appendChild(span);
        todolist.appendChild(li);
    }

    button.addEventListener("click",function(e){
        createTodo(todo.value);
        todo.value = "";
    } )
})();

