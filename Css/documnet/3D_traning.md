# 반응형 연습
스크롤에 따른 Progress-bar 설정

## html 설정
```
<div class="progress-bar-con">
    <div class="progress-bar"></div>
</div>
```
## CSS 설정
```
body{
    height: 500vw;
}

.progress-bar-con{
    position: fixed;
    left: 0;
    top: 0;
    z-index: 100;
    width: 100vw;
    height: 5px;
    background: #555;
}
.progress-bar{
    width: 20%;
    height: 100%;
    background: #00a8ff;
}
```
## JS 설정