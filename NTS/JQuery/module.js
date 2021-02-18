
// 즉시 실행함수
var Foo = (function () {
    function add() {
        baz();
    }
    function destroy() {

    }
    function baz() {

    }
    function init() {
        document.getElementById('foo').addEventListener("click", add);
        document.getElementById('bar').addEventListener("click", destroy);
    }

    var foo = 1;
    var bar = 1;
    return { 
        init : init,
        bar: bar
    }
})();


document.addEventListener("DOMContentLoaded", function () {
    Foo.init();
    console.log(Foo.bar);
});