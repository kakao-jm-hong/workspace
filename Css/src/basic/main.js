(function () {
    const but = window.document.getElementById('modal-switch');
    window.addEventListener('click', function (e) {
        if(e.target.classList.contains('modal')){
            console.log('test');
            but.checked = false;
        }
    });
})()