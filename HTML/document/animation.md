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

 ## 주요속성
 - animation-name : 애니메이션의 중간 상태를 지정하기 위한 이름을 정의합니다. 중간 상태는 @keyframes 규칙을 이용하여 기술합니다.
- animation-duration : 한 싸이클의 애니메이션이 얼마에 걸쳐 일어날지 지정합니다.
- animation-delay :엘리먼트가 로드되고 나서 언제 애니메이션이 시작될지 지정합니다.
- animation-direction : 애니메이션이 종료되고 다시 처음부터 시작할지 역방향으로 진행할지 지정합니다.
- animation-iteration-count : 애니메이션이 몇 번 반복될지 지정합니다. infinite 로 지정하여 무한히 반복할 수 있습니다.
- animation-play-state : 애니메이션을 멈추거나 다시 시작할 수 있습니다.
animation-timing-function : 중간 상태들의 전환을 어떤 시간간격으로 진행할지 지정합니다.
animation-fill-mode : 애니메이션이 시작되기 전이나 끝나고 난 후 어떤 값이 적용될지 지정합니다.


출처: https://webclub.tistory.com/621 [Web Club]

# 성능이슈

## reflow
생성된 DOM 노드의 레이아웃(너비, 높이 등) 변경 시 영향받는 모든 노드(자식, 부모)의 수치를 다시 계산하여 렌더 트리를 재생성하는 작업입니다.

## repaint
reflow 과정이 끝난 후 재생성된 렌더 트리를 다시 그리는 작업으로 수치와 상관없는 background-color, visibility, outline 등의 스타일 변경시에는 reflow 과정이 생략 된 repaint 작업만 수행합니다.

## reflow를 피하거나 최소화 하는 방법
- 1. 클래스 변화에 따른 스타일 변화를 원할 경우, 최대한 DOM 구조 상 끝단에 위치한 노드에 추가합니다.
- 2. 애니메이션이 들어간 엘리먼트는 가급적 position: fixed 또는 position: absolute로 지정합니다.
- 3. JS를 통해 스타일변화를 주어야 할 경우, 가급적 한번에 처리합니다.
- 4. 인라인 스타일을 최대한 배제합니다.
- 5. 테이블 레이아웃을 피하는 것이 좋습니다.