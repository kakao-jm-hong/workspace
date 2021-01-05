(function () {

    const barElem = document.querySelector('.progress-bar');
    const houseElem = document.querySelector('.house');
    // 화면 최대크기 (반응형)
    let maxScrolValue = 0;

    function resizeHandler() {
        maxScrolValue = document.body.offsetHeight - window.innerHeight;
    }
    window.addEventListener('scroll', function () {
        const scrollPer = pageYOffset / maxScrolValue;
        const zMove = scrollPer;

        // 프로그레스바 움직임
        barElem.style.width = scrollPer * 100 +'%';

    });

    // 처음 실행시 maxScrolValue 초기화
    resizeHandler();
})();