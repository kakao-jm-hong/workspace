function Character(info) {
    this.mainElem = document.createElement('div');
    this.mainElem.classList.add('character');
    this.mainElem.innerHTML = ''
        + '<div class="character-con">'
        + '<div class="character-front"></div>'
        + '<div class="character-back"></div>'
        + '<div class="character-left"></div>'
        + '<div class="character-right"></div>'
        + '<div class="character-top"></div>'
        + '<div class="character-bottom"></div>'
        + '</div>'

    this.mainElem.style.left = info.xPos + '%';
    document.querySelector('.stage').appendChild(this.mainElem);

    this.scrollState = false;
    this.lastScrollTop = 0;
    this.speed = Math.random(10);
    this.direction;
    this.xPos = info.xPos;
    this.runningState = false;
    this.rafId;
    this.init();
}

Character.prototype = {
    constructor: Character,
    init: function () {
        const self = this;

        window.addEventListener('scroll', function () {
            clearTimeout(self.scrollState);
            if (!self.scrollState) {
                self.mainElem.classList.add('running');
            }

            self.scrollState = setTimeout(function () {
                self.scrollState = false;
                self.mainElem.classList.remove('running');
            }, 500);

            if (self.lastScrollTop > pageYOffset) {
                self.mainElem.setAttribute('data-direction', 'backward');
            } else {
                self.mainElem.setAttribute('data-direction', 'forward');
            }
            self.lastScrollTop = pageYOffset;
        });

        window.addEventListener('keydown', function (e) {
            if (self.runningState) return;
            if (e.keyCode == 37) {
                // ¿ÞÂÊ
                self.mainElem.setAttribute('data-direction', 'left');
                self.mainElem.classList.add('running');
                self.direction = 'left';
                self.run(self);
            } else if (e.keyCode == 39) {
                // ¿À¸¥ÂÊ
                self.mainElem.setAttribute('data-direction', 'right');
                self.mainElem.classList.add('running');
                self.direction = 'right';
                self.run(self);
            }
            self.runningState = true;
        });

        window.addEventListener('keyup', function (e) {
            self.mainElem.classList.remove('running');
            self.runningState = false;
            cancelAnimationFrame(self.rafId);
        });
    },
    run: function (self) {
        if (self.direction == 'left') {
            self.xPos -= this.speed;
        } else if (self.direction == 'right') {
            self.xPos += this.speed;
        }

        if (self.xPos < 2)
            self.xPos = 2;
        if (self.xPos > 88)
            self.xPos = 88;

        self.mainElem.style.left = self.xPos + '%';
        self.rafId = requestAnimationFrame(function () {
            self.run(self);
        });
    }
}