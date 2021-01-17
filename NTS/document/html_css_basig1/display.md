# DISPLAY
- 요소의 rendering box 유형을 결정 합니다.
- CSS display에서 검색해서 확인해봅니다.


## display : none;
- 보이지 않는다.
## display : inline;
- 본인 컨텐츠 내용만 채웁니다. 딱 정확히 채웁니다. \<span> 이랑 비슷합니다.
- <mark>inline은 width를 선언해도 적용되지 않습니다.</mark>
## display : block;
- 한칸을 다채우는 블럭형태입니다.
- 즉 요소가 한칸에 다있을려는 성질입니다.
## display : inline-block
- inline 처럼 본인 컨텐츠 영역만큼만 차지한다. (인라인처럼 화면에 나타나지만 블럭의 성질을 가진다.)

# display와 box model의 관계

|display|width|height|margin|padding|border|
|------|---|---|---|---|---|---|
|block|ㅇ|ㅇ|ㅇ|ㅇ|ㅇ|
|inline|X|X|좌/우|ㅇ|ㅇ|
|inline-block|ㅇ|ㅇ|ㅇ|ㅇ|ㅇ|

lnline은 부오 요소의 박스의 상/하 에는 패딩, 보더, 마진은 영향을 주지못합니다. 따라서 반영이 안됩니다.

<mark> 또한 인접한 다른 line-box에도 반영되지않습니다. 즉 콘텐츠가 겹칠 수 있기 때문에 잘 사용하지 않습니다.</mark>

# VISIBILITY
- 요소를 어떻게 숨길 것인지 결정
- visible 
- hidden (display None과는 다르다 해당영역을 유지하고 은폐)
- collapse (IE ,Firefox에서만 적용된다.)

# FLOAT
- 요소를 보통의 흐름에서 벗어나게 함.

```
float : none;
float : left;
float : right;
```
- 요소를 보통의 흐름에서 벗어나 띄워지게 함
- 주변 텍스트나 인라인요소가 주위를 감싸는 특징이 있음
- 대부분 요소의 display 값을 <mark>block</mark>으로 변경함


# CLEAR
- floating 된 요소의 영향에서 벗어나 다음 행으로 이동
```
clear : none;
clear : left;
clear : right;
clear : both;
```
- <mark> block-level 요소만 적용가능</mark>


# POSITION & OFFSET
- static
- relative
- absolute
- fixed

## static
- 스태틱일때는 offset값이 적용되지 않는다.

## relative
- 기준으로 정하는 position

## absolute
- 부모 요소중 static 이 아닌 녀석을 찾아간다.
- border를 제외한 부모의 padding 영역부터가 기준이 된다.

## fixed 
- 방향값을 가지고서부터는 화면 브라우저 좌표값을 기준으로 요소가 고정됩니다.

# Z-INDEX
- position 값이 <mark>static이 아닌 경우</mark> 지정가능
- 순서 값이 없을 경우 생성순서(코드상 순서)에 따라 쌓임
- <mark>부모가 z-index 값이 있을 경우 부모 안에서만</mark> 의미있음
- <mark>큰 값이 가장 위쪽 음수 사용 가능</mark>


