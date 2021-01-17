# 단위, 배경, 박스모델
- 절대 길이
  - px - pixels (1px = 1/96 of 1 in)
  - pt - points (1pt = 1/72 of 1 in)

- 상대 길이
  - % - Percentage
  - em - font size of the element (상위 요소의 상속받은 px기준으로 배율)
  - rem - root의 font size 기준으로 값을 환산합니다.
  - vw - viewport의 width값을 기준으로 1%의 값으로 계산됩니다.

# 속성-색상

```
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>color</title>
</head>
<body>
    <h1 style="color: red"> heading </h1>
    <h1 style="color: #ff0000"> heading </h1>
    <h1 style="color: #f00"> heading </h1>
    <h1 style="color: rgb(255,0,0)"> heading </h1>    
    <h1 style="color: rgba(255,0,0, 0.5)"> heading </h1>
</body>
</html>
```

# 속성-background
- background-color
- background-image
- background-repeat
- background-position
- background-attachment

## background 관련 속성
- background-color
- 기본 값 : transparent (투명속성)
- background-image
- 기본 값 : none
- background-repate 
- 기본값 : repeat 

## background-attachment
- 기본 값 : scroll : 요소 자체를 기준으로 고정
- local : 요소의 내용을 기준으로 고정되어 있습니다.
- fixed : 뷰포트를 기준으로 고정되어 있습니다.

배경의 색상을 지정하는 속성입니다.
앞선 색상 강의에서 배운 색상 

# BOX MODEL

## Content 여역
- 요소의 실제 내용을 포함하는 영역입니다. 따라서 크기는 내용의 너비 높이를 나타냅니다

## Border 영역
- content 영역을 감싸는 테두리 선을 border라고 합니다.

## padding 영역
- content 영역과 테두리 사이의 여백을 padding 이라고 합니다.
- content 영역에 배경이나 색이 있을경우 padding 영역까지 영향을 미칩니다.

## Margin 영역
- border 바깥쪽의 영역을 margin이라고 합니다.
- border 영역을 다른 요소와 구별하기 위해 쓰이는 빈 영역입니다.
- 즉, 주변 요소와 여백(간격)을 margin을 이용해 지정할 수 있습니다.

# 속성-border
## 두께
```
border-width:[top][right][bottom][left];
```
## 선 모양
```
border-style:[top][right][bottom][left];
```
- none : border를 표시하지 않는다.
- solid : border를 실선 모양으로 나타냅니다.
- double : boder를 이중 실선 모양으로 나타냅니다.
- dotted : border를 점선 모양으로 나타냅니다.

## 색
```
border-color :[top][right][bottom][left];
```

## 축약
```
border:[-width][-style][-color];
```
[소스코드](src2/border.html)
# 속성-padding

## syntax
padding : 20px 30px 40px 30px 일 때, 좌우의 패딩 값이 같을 때 padding: 20px 30px 40px 와 같이 함축하여 사용할 수 있습니다.
padding : 20px 30px 20px 일 때 좌우 값 , 20px 30px 와 같이 함축해서 사용가능
padding : 20px 상하좌우 같을 때.

[소스코드](src2/padding.html)

# 속성-margin
- padding과 사용법은 비슷합니다. 단 auto라는 값이 있습니다.
- margin : [-top][-right][-bottom][-left]

## margin collapse
- 수직 방향으롬나 일워지며, 좌우에 대해서는 일어나지 않습니다.
- 좀더 큰 마진을 같는 div로 병합됩니다.

# margin & padding 

- <mark>margin 만 - 와 auto를 사용할 수 있다.</mark>
- 단위 (px, %)
- %는 가로축을 기죽으로 적용이 된다.

# width
- width : auto
- width : 100px
- width : 100%

<mark>width는 기본적으로 content영역의 넓이를 기준으로 합니다.!!! 상속시에도 부모의 content즉 순수 width를 기준으로 합니다.</mark>

# height
- height도 margin과 동일합니다.
- 단 height