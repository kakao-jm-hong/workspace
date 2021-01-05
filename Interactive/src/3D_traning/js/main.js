(function () {

    const barElem = document.querySelector('.progress-bar');
    const stageElem = document.querySelector('.stage');
    const houseElem = document.querySelector('.house');
    const mousePos = { x: 0, y: 0 };
    // 화면 최대크기 (반응형)
    let maxScrolValue = 0;

    function resizeHandler() {
        maxScrolValue = document.body.offsetHeight - window.innerHeight;
    }
    window.addEventListener('scroll', function () {
        const scrollPer = pageYOffset / maxScrolValue;
        const zMove = scrollPer * 980 - 500;

        houseElem.style.transform = 'translateZ(' + zMove + 'vw)';

        // 프로그레스바 움직임
        barElem.style.width = scrollPer * 100 + '%';

    });

    window.addEventListener('mouseover', function (e) {
        mousePos.x = -1 + (e.clientX / window.innerWidth) * 2;
        mousePos.y = 1 - (e.clientY / window.innerHeight) * 2;

        stageElem.style.transform = 'rotateX(' + (mousePos.y * 5) + 'deg) rotateY(' + (mousePos.x * 5) + 'deg)';
    });

    window.addEventListener('click', function (e) {
        new Character({xPos: e.clientX / window.innerWidth * 100});
    });

    window.addEventListener('resize', resizeHandler);
    // 처음 실행시 maxScrolValue 초기화
    resizeHandler();
})();