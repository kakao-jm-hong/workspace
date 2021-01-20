# 웹 표준 제정 단계 (W3C)
- Wd -> CR -> PR -> REC

# 크로스 브라우징(Cross Browsing)
- 웹 표준 기술을 사용하여 운영체제, 브라우저 등에 따라 어느 한쪽으로 최적하되거나 종속되지 않도록 공통 요소를 사용하여 웹 페이지를 제작하는 기법

# 문서의 기본 구조
```
<!DOCTYPE html>
<head>
    <meta charset ="UTF-8">
    <title>HTML</title>
    <link rel="stylesheet" href="./css/style.css">
    <script src="./js/jquery.min.js"></script>
</head>
<body>
    <h1>Hellow world</h1>
</body>
</html>
```

# 콘텐츠 모델
- 메타데이터 콘텐츠
  - link, meta, scirpt, style
- 플로우 콘텐츠 (bdoy안)
  - a, address article, aside
- 섹셔닝 콘텐츠
  - article, aside, nav, section
- 헤딩 콘텐츠
  - h1, h2, h3, h4, h5, h6
- 프레이징 콘텐츠 (텍스트를 꾸며주는 요소)
  - br, u, samp, ruby, progress
- 임베디드 콘텐츠
  - audio, canvas, embed, iframe, img, math, object, picture, svg, video
- 인터랙티브 콘텐츠
  - a, audio, button, details, embed

<mark>섹셔닝 콘텐츠</mark>
```
\<section>,\<article>,\<nav>,\<aside>

HTML5 전용 아이템.
명시적 개요를 생성하는 개요 컨테이너.
헤딩을 함께 사용하면 헤딩 수준이 자동으로 바뀜.
```

```
명시적 섹션 : 
섹셔닝 콘텐츠(section, article, nav, aside)를 사용하여 명시적으로 개요를 생성하도록 만든 섹션. 
개요 = 섹셔닝 콘텐츠

암시적 섹션 : 
섹셔닝 콘텐츠(section, article, nav, aside)를 사용하지 않고 헤딩 만을 사용하여 암시적으로 개요를 생성하도록 만든 섹션.
개요 = 헤딩 블럭
```

# 글로벌 속성
- id
- class
- hidden
- lagn
- style
- tabindex ( 사용자가 키보드로 페이지 이동할 때 이동 순서를 지정)
- title

```
<button type="button" disabled>버튼</button> 
```

# 빈 태그
- br
- hr
- img
- input
- link
- meta

# 주석 (실무)
```
<!-- [D] 버튼을 클릭했을 경우, button.btn 에 on 클래스 추가해주세요 -->
<button type="button" class = "btn"> 전체 카테고리 보기</button>
```

```
<!-- head -->
<div class ="header">
<!-- //head>
```

# label
- 명시적 for에 아이디값 삽입
- 태그안에 쓰기

# 폼 요소의 속성
- name : 폼요소들을 
- value : 사용자가 입력하기 전에 사전 입력되어 있는 값을 설정합니다.
- id : label 연결점, 현재 페이지에서 유일한 값으로 지정

# 요소 상태에 따른 속성
- disabled : 해당 폼 요소를 사용할 수 없게 됩니다.
- readonly : 읽기 전용으로 값을 변경할 수 없습니다.
- required : 특정 form 요소를 필수 입력으로 지정합니다. 입력하지 않으면 sumbit이 불가능합니다.
- checked : radio나 checkbox 형태의 input에서 기본 선택됨으로 지정할 수 있습니다.

# 시멘틱 마크업
- SEO : Search Engine Optimization

## Mark
- \<b> 태그보다는 \<mark> 태그를 사용하고 CSS를 적용하는 방법을 권장합니다.