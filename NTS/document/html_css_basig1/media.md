# 미디어쿼리

# 미디어쿼리 소개
- 웹이 급격하게 발전하면서 다양한 미디어 기기들이 웹을 지원하고 있습니다.
- 그에 맞춰 대부분의 웹 사이트들이 반응형으로 제작되고 있는데요.
- 미디어 쿼리는 반응형 웹 사이트 제작에 반드시 필요한 기술입니다.
- 우리 수업의 목적은 미디어쿼리 Syntax(구문)에 대해 정확히 이해하고 상요하는 것입니다.

<mark> 반응형 웹사이트를 만들때 사용합니다 </mark> <br>
<mark> 각 미디어 매체에 따라 다른 스타일 시트를 적용할 수 있게 맏느는 것!</mark>

# 미디어 쿼리 구문
```
@media media queries{...}
```
mideia queris문의 참/거짓 유무로 동작하게 됩니다.

- Media Types(미디어 타입)  <mark>all, print, scree</mark>
- Media Features(미디어 특성) <mark> width, orientation</mark>
    - 가로모드 세로모드는 width나 height값을 비교해서 알 수 있습니다.


# 미디어쿼리 syntax
- media_query_list <mark>복수형</mark>
- midia_query
- expression

[O] : 있을수도 or 없을수도 <br>
a|b : a or b <br>
O?  : 0 or 1 <br>
O* : 0 or 1 or ... n <br>

## 요약
med_query_list
- 여러개의 미디어 쿼리로 이루어진 리스트로 작성 가능하며, 쉼표를 이용해서 구분합니다.

media_query
- A 형태
  - 미디어 타입에 and 키워드를 이용해서 미디어 표현식을 붙일 수 있습니다.
  - 미디어 타입 앞에는 only 또는 not 키워드가 올 수 있습니다.
  - 미디어 표현식은 생략 가능하기 때문에 미디어 타입 단독으로 사용될 수 있습니다.
- B 형태
  - 미디어 타입 없이 미디어 표현식이 바로 나올 수 있습니다.(미디어 타입이 명시되지 않으면 all로 간주합니다.)
  - 미디어 표현식은 and 키워드를 이용해서 계속해서 나올 수 있습니다.

expression
- 미디어 표현식은 괄호로 감싸야 하며, 특성 이름과 해당하는 값으로 이루어집니다. 이름과 값은 : 기호로 연결합니다.
    - 또, 값이 없이 특성 이름만으로 작성할 수 있습니다.


## 예제코드

```
@media-scree{...}
```
: 미디어 타입이 screen 이면 적용됩니다.
```
@medi screen and (min-width: 768px){...}
```
: 미디어 타입이 screen 이고 widthrk 768px 이상이면 적용됩니다. 두개 중 하나라도 만족하지 않으면 거짓이 됩니다.
```
media(min-width:768px) and (max-width:1024px){...}
```
: and는 연결된 모든 표현식이 참이면 적용됩니다. (and 키워드는 연결된 부분이 모두 참이어야 적용이 됩니다.)
```
media(color-index)
```
: 미디어 장치가 color-index를 지원하면 적용됩니다.
```
@media screen and (min-width:768px), screen and (orientation: portait),...
```
: 쉼표로 연결된 미디어 쿼리 중 하나라도 참이면 적용됩니다. (and 키워드와 반대라고 생각하면 됩니다.)
```
@media not screen and (min-width : 768px)
```
: not 키워드는 하나의 media_query 전체를 부정합니다.<br>
: not(screen and (min-width:768px))  옳바른 해석<br>
: @media not screen and (min-width:768px).print
- <mark> print 에는 적요이 안됩니다</mark>

# 미디어 쿼리 선언 방법
1. <mark>가장많이 쓰는 @media</mark>
    - @media screen and (color)
2. \<link rel="stylesheet" media="screen and (color)" href="example.css>
    - <link>태그의 media 속성에 미디어 쿼리를 선언합니다. 미디어 쿼리가 참이면 뒤에 css파일 규칙을 적용합니다.
3. \@import url(example.css) screen and (color)
    - css 파일 내부에 또는 <style> 태그 내부에 사용가능 합니다. \@import 문 뒤에 미디어 쿼리를 선언합니다. 

[실습 1](src4/practice1.html)
[실습 2](src4/practice2.html)
[실습 3](src4/practice3.html)

# 학습하기 (주요링크)
- https://www.w3.org/TR/css3-mediaqueries/
- https://www.w3.org/TR/mediaqueries-4/
- https://mediaqueri.es/