# Animation

## @keyfames
```
@keyframes tutsFade {
  0% {
    opacity: 1;
  }
  100% {
    opacity: 0;
  }
}
```

또는

```
@keyframes tutsFade {
  from {
    opacity: 1;
  }
  to {
    opacity: 0;
  }
}
```

또는

```
@keyframes tutsFade {
  to {
    opacity: 0;
  }
}
```

## 사용법
```
.element {
  //keyframe 이름
  animation-name: tutsFade;
  //지연시간
  animation-duration: 4s;
  //반복회수
  animation-delay: 1s;
  //반복회수
  animation-iteration-count: infinite;
  animation-timing-function: linear;
  //루프 방향, 정방향으로 반복
  animation-direction: alternate;
}
```
혹은
```
.element {
  animation: tutsFade 4s 1s infinite linear alternate;
}
```

## 예시

```
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        @keyframes square-to-circle {
            0% {
                border-radius: 0 0 0 0;
                background: coral;
                transform: rotate(0deg);
            }

            25% {
                border-radius: 50% 0 0 0;
                background: darksalmon;
                transform: rotate(45deg);
            }

            50% {
                border-radius: 50% 50% 0 0;
                background: indianred;
                transform: rotate(90deg);
            }

            75% {
                border-radius: 50% 50% 50% 0;
                background: lightcoral;
                transform: rotate(135deg);
            }

            100% {
                border-radius: 50%;
                background: darksalmon;
                transform: rotate(180deg);
            }
        }

        div {
            width: 200px;
            height: 200px;
            background-color: coral;
            animation: square-to-circle 2s 1s infinite alternate;
        }
    </style>
</head>

<body>
    <div></div>
</body>

</html>
```

## animation-timing-function

 이것은 속도를 정의하고 가속도나 감속도를 움직임에 더할 수 있습니다. 이 기능은 아주 자세한 값이 필요 할 수 있으며 그러므로 수동으로 직접 계산하기보다는 많은 무료 리소스 웹사이트를 사용하여 커스텀된 애니메이션 타이밍 기능을 이용하세요.

 ```
 div {
  width: 200px;
  height: 200px;
  background-color: coral;
  animation: square-to-circle 2s 1s infinite cubic-bezier(1,.015,.295,1.225) alternate;  
}
 ```