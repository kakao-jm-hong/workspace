function getStyle(ele, style) {
    return window.getComputedStyle(ele, null).getPropertyValue(style);
}

function init() {
    var foo = document.getElementById('foo');

    console.log("foo");

    foo.addEventListener("click", function () {
        console.log("click");
    });
}

// html 맨밑에 넣기 힘들 때.
window.addEventListener("load", function () {
    init();
});

// 전부다 load된 이후.
// window.addEventListener("load", function ()
// DOM이 로드된 이후
window.addEventListener("DOMContentLoaded", function () {
    init();
    var bar = document.getElementById('bar'); 
    console.log(bar);
})