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

# TAP
## 색인
- 색인 또는 목록이라는 의미이며, 데이터를 기록할 경우 그 데이터의 이름, 데이터의 크기 등의 속성과 그 기록 장소 등을 표로 표시하는 것, 즉 참조용 데이터를 색인표 또는 인덱스라고 합니다.
- 여러 문서 또는 패널을 하나의 창에 두고 전환하여 볼 수 있도록 한 인터페이스

# 탭과 내빅이션의 차이
- 내비게이션 : 다른 화면으로 이동
- 탭 : 화면 이동 없이 선택한 탭과 연관된 콘텐츠가 보임

## 탭 UI로 만들어진 사이트
- 네이버뉴스 사이트 (가장 많이 본 뉴스 : 우측)
- 네이버 만화(인기급상승 만화 : 우측)
```
    position: absolute;
    z-index: -1;
    color: transparent;
```

# Image List 란?
- 이미지 리스트는 다른 말로 섬네일 리스트라고도 불립니다.
- 섬네일의 사전적 의미로는 엄지 손톱, 작은 물건이라는 뜻을 가지고 있습니다.
- 인터넷에선 작은 크기의 견본 이미지를 가리켜 섬네일이라고 부릅니다.

# 텍스트 말줄임
- 말줄임을 하기위해서는 고정너비를 가져야합니다.
```
overflow ; hidden;
text-overflow: ellipsis;
white-space:nowrap;
```


## 텍스트 말줄임
```
<p class="elip1">가나다라마바사아자차카타파하가나다라마바사아자차카타파하가나다라마바사아자차카타파하</p>
<p class="elip2">가나다라마바사아자차카타파하가나다라마바사아자차카타파하가나다라마바사아자차카타파하</p>
<p class="elip3">가나다라마바사아자차카타파하가나다라마바사아자차카타파하가나다라마바사아자차카타파하</p>
```
```
p {
  width: 200px;
  background-color: yellow;
  font-size: 16px;
  line-height: 20px;
}
.elip1 {
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}
.elip2 {
  max-height: 40px; /* webkit 외 브라우저 대응, line-height*line수 */
  overflow: hidden;
  text-overflow: ellipsis;
  display: -webkit-box;
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 2;
}
.elip3 {
  max-height: 60px; 
  overflow: hidden;
  text-overflow: ellipsis;
  display: -webkit-box;
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 3;
}
```
## 이미지 액자 효과
```
<div class="img_wrap">
  <img src="https://images.unsplash.com/photo-1544911845-1f34a3eb46b1?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1350&q=80" width="200" height="134" alt="임시 이미지">
<div>

```
```
.img_wrap {
  position: relative;
  width: 200px;
  height: 134px;
}
.img_wrap:after {
  position: absolute;
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;
  content: '';
  border: 1px solid rgba(0, 0, 0, 0.3);
  background-color: rgba(0, 0, 0, 0.15);
}
```

## 요소 감추기
```
position: absolute;
z-index: -1;
color: transparent;
```