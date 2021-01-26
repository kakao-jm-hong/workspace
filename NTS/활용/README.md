# 크로스 브라우징
- 어떤 브라우저를 쓰더라도 똑같은 화면이 나와야합니다.

# CSS Reset
- 각 프로젝트에 맞춰서 사용한다.
- https://cssreset.com

## 정리
- 브라우저마다 태그를 렌더링하는 기본 스타일이 다르다.
- 모든 브라우저에서 동일한 화면을 볼 수 있도록 기본값을 초기화한다.
- reset CSS는 각 프로젝트에 맞춰서 사용한다.

# IR 기법
- Image Replacement
- 이미지를 볼 수 없는 사람들에게 적절한 텍스트를 제공해야합니다.


## 이미지 사용방법
- \<img> 는 서버에서 이미지를 내려주는 경우 사용
- \<i> 안에 백그라운드 컬러를 처리한다. 
- 이미지의 텍스트가 너무긴 경우에도 IR 기법을 많이 사용한다.

## 시멘틱 마크업 + CSS로 요소를 화면에서 숨김 + 스크린 리더가 인식

### BAD
- visibility : hidden;
- display : none;
- width: 0; height:0; font-size:0; line-height:0;

### SOSO
- opacity :0;
- text-indent : -9999px;
- z-index: -1;

### BEST
- blind
```
  <!-- 레이아웃에 영향을 끼치지 않도록 -->
    position: absolute;
    <!-- 스크린 리더가 읽을 수 있도록 -->
    width: 1px;
    height: 1px;
    <!-- 눈에 보이는 부분을 제거 -->
    overflow: hidden;
    margin: -1px;
    clip: rect(0, 0, 0, 0);
```
- top을 안쓰고 margin을 쓰는 이유는 relative가 어디있느야에 따라서 영역의 크기를 더 잡아 먹을 수 있기 때문입니다.

## 정리
- img 태그 사용 시 , 대체 텍스트가 너무 긴 경우
- 배경 이미지로 처리한 의미 있는 태그가 너무 긴 경우

# float의 해제
- 부모요소 height 부여
- 부모요소 float 속성포함
- 부모요소의 overflow 속성
- 뒤에 인접하는 형제요소의 clear 속성
- 가상요소를 이용한 clear 속성

# Layout
- 책이나 신문, 잡지 따위에서 글이나 그림 따위를 효과적으로 정리하고 배치하는 일
- 정원 따위의 설계를 이르는 말

# 1단 레이아웃
- header
- content
- footer
- 네이버 쇼핑, 네이버 사전, 네이버 포스트

# 2단 레이아웃
- header , aside , content, footer
- header , visual, content, aside, footer
- 네이버 뮤직, 네이버 날씨 

# 3단 레이아웃
- header, aside, content, aside, footer

# Fixed 레이아웃
- 상단 고정
- 하단 고정
- 상하단 고정
# Menu 란?
- 내비게이션
- 웹사이트에서 제공되는 정보를 쉽게 찾을 수 있도록 도와준다.
- 1단 메뉴
- 2단 메뉴
- 좌측 메뉴
![](2021-01-26-15-30-38.png)