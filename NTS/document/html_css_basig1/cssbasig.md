# CSS (Cascading Style Sheets)
- HTML(마크업 언어)를 꾸며주는 표현용 언어
- HTML이 문서의 정보, 구조를 설계한다면 CSS는 문서를 보기 좋게 디자인 합니다.
  
# CSS 문법
```
h1 { color:yellow; font-size:2em;}
```
- selector(선택자) - "h1"
- property(속성) - "color" , "font-size"
- value(값) - "yellow","2em"
- declaration(선언) - "color: yellow", "font-size:2em"
- declaration block(선언부) - "{ color:yellow; font-size:2em;}"
- rule set(규칙) - "h1 { color:yellow; font-size:2em;}"

## CSS의 적용

### Inline
- 해당 요소에 직접 스타일 속성을 이용해서 규칙들을 선언하는 방법입니다.
- 해당 요소에 직접 입력하기 때문에 선택자는 필요하지 않게 되고, 선언부에 내용만 스타일 속성의 값으로 넣어주면 됩니다.
- Inline 스타일 방식이라고 부릅니다.

```
<div style="color:red">내용</div>
```

### Internal
- Internal은 문서에 \<style>을 활용한 방법입니다.
- \<style>은 \<head>내부에 들어가며 \<style>안에 스타일 규칙이 들어갑니다.
  
### External
- *.css 외부 시트파일을 이용한다.

```
// style.css
div{color : red;}
```
- head에 적용한다.
```
<link rel="stylesheet" href="css/style.css">
```

### Import
- import는 스타일 시트 내에서 다른 스타일 시트 파일을 불러오는 방식입니다.
```
@import url("css/style.css");
```

[소스코드](src2/test1.html)

# 선택자 1

## 요소 선택자
```
h1{color:yellow;}
h2{color:yellow;}
h3{color:yellow;}
h4{color:yellow;}
h5{color:yellow;}
h6{color:yellow;}
```
## 그룹화
```
h1,h2,h3,h4,h5,h6{
    color:yellow;
}
```

## 전체 선택자
```
*{
    color:yellow;
}
```

# 선택자 2
- class
- id
  
## class 선택자
```
.foo{font-size:30px;}
```
```
<p class="foo">...</p>
```

## id 선택자
- id 선택자는 class 선택자와 비슷합니다.
- \# 을 사용한다.
- 요소에는 id를 사용한다.

```
#bar {background-color:yellow;}
```
```
<p id="bar">...</p>
```
## 음... 그럼 차이점이 없는게 아닌가..?
- 기호가 아닌 \# 기호!
- 태그의 class 속성이 아닌 id 속성을 차좀
- 문서 내에 유일한 요소에 사용
- 구체성

<mark>가장 큰 차이점은 역시 class와 달리 id는 문서 내에서 유일해야 한다는 점입니다.</mark>
결국 id 선택자로 규칙을 적용할 수 있는 요소는 단 하나뿐입니다.
그리고 마지막으로 구체성의 값이 다릅니다(이에 대한 자세한 설명은 이후 구체성 수업에서 다룹니다.)

# 선택자 3
```
p.bar{...}

.foo.bar{...}

#foo.bar{...}
```
- 첫 번째 p요소와 bar클래스를 가지고 있는 경우
- 두 번째 foo 클래스와 bar 클래스를 가지고 있는 경우
- 세 번째 foo 아이디와 bar 클래스를 가지고 있는 경우

## 속성 선택자
```
p[class]{color:silver;}
p[class][id]{text-decoration:underline;}
```
```
<p class="foo">Hello</p>
<p class="bar">CSS</p>
<p class="baz" id ="title>HTML</p>
```
- 속성 선택자는 대괄호를 이용해서 선언하며 대괄호 안에 속성 이름이 들어갑니다.
- 요소에 해당 이름의 속성이 있다면 해당 사항이 적용됩니다.
- 첫 번째는 \<p> 이면서 class 속성이 있으면 적용됩니다.
- 두 번재는 \<p> 이면서 class 와 id 속성이 있어야 적용됩니다.

## 정확한 속성값으로 선택
```
p[class="foo"]{color:silver;}
p[id="title"]{text-decoration:underline;}
```
- p[class="foo"]는 \<p>이면서 class 속성값이 foo이면 적용되고, p[id="title"]는 \<p> 이면서 id 속성값이 title일때 적용된다.


## 부분 속성값으로 선택
- [class~="bar"] : class 속성의 값이 공백으로 구분한 "bar" 단어가 포함되는 요소 선택 (정확한 맵핑)
- [class^="bar"] : class 속성의 값이 "bar"로 시작하는 요소 선택
- [class&="bar"] : class 속성의 값이 "bar"로 끝나는 요소 선택
- [class*="bar"] : class 속성의 값이 "bar" 문자가 포함되는 요소 선택


### 테스팅
```
<p class = "color hot">red</p>
<p class = "cool color">blue</p>
<p class = "colorful nature">rainbow</p>
```
```
p[class~="color"]{font-style:italic;} // 1, 2 요소 선택
p[class^="color"]{font-style:italic;} // 1, 3 요소 선택
p[class&="color"]{font-style:italic;} // 2 요소 선택
p[class~="color"]{font-style:italic;} // 1, 2, 3 요소 선택

```

# 문서 구조 관련 선택자

## 자손 선택자
```
div span{color:red;}
```
- 자손 선택자는 선택자 사이에 아무 기호없이 그냥 공백으로 구분을 합니다.
- 이 선택자는 \<div>의 자손 요소인 \<span>를 선택하는 선택자 입니다.

## 자식 선택자
```
div > h1 {color:red;}
```
- 자식 선택자는 선택자 사이에 닫는 꺽쇠 기호(>)
- \<div> 의 <mark>직계자식</mark>요소인 \<h1>를 선택하는 선택자입니다.

## 인접 형제 선택자
```
div + p{color:red;}
```
- 인접 형제 선택자는 선택자 사이에 + 기호
- 공백이 있거나 없어도 됩니다 (자식 선택자라 마찬가지 div>p)
- 인접 형제 선택자는 형제 관계이면서 바로 뒤에 인접해 있는 요소를 선택하는 선택자입니다.

<mark>유의할 점은 요소들이 나열되어 있더라도 제일 우측에 있는 요소가 실제 선택되는 요소라는 것입니다.</mark>

## 틸트 선택자
```
ul ~ p{
    color: red;
}
```
- 형제 선택자보다 덜 엄격합니다. 이 선택자는 ul 아래 있는 모든 p 요소를 선택합니다.

# 가상 선택자 1
- 가상 클래스
- 브라우저가 특정 상황에서 직접 효과를 주는 클래스이다.
- ":hover 가상 클래스 선택자를 이용해서 스타일 규칙을 만든다. (hover는 마우스 커서가 올라갔을 때 적용이 되도록 정의 되도록 정의되어 있습니다.)"
  
## 가상클래스 정리!
- [가상클래스 정리](virtualclass.md)

## 문서 구조와 관련된 가상 클래스
- :first-child : 첫 번째 자식 요소 선택
- :last-child : 마지막 자식 요소 선택

```
<ul>
    <li>HTML</li>
    <li>CSS</li>
    <li>JS</li>
</ul>
```
```
li:first-child { color: red; }
li:last-child { color: blue; }
```

실제 위의 코드는 아래와 같습니다.
```
<ul>
    <li class="first-child">HTML</li>
    <li>CSS</li>
    <li class="last-child">JS</li>
</ul>
```

## 앵커 요소와 관련된 가상 클래스
- :link : 하이퍼 링크이면서 아직 방문하지 않은 앵커
- :visited : 이미 방문한 하이퍼링크를 의미
하이퍼 링크는 앵커 요소에 href 속성이 있는 것을 의미합니다.
```
a:link { color: blue; }
a:visited { color: gray; }
```

## 사용자 동작과 관련된 가상 클래스
- \<a>에 주로 많이 쓰입니다.
- :focus: 현재 입력 초점을 가진 요소에 적용
- :hover: 마우스 포인터가 있는 요소에 적용
- :active: 사용자 입력으로 활성화된 요소에 적용
```
a:focus { background-color: yellow; }
a:hover { font-weight: bold; }
a:active { color: red; }
```

# 가상 요소(pseudo element)
- 가상 요소는 HTML 코드에 존재하지 않는 구조 요소에 스타일을 부여할 수가 있습니다.
- 기본적으로 ::(더블 콜론) 기호를 사용합니다.
- 하지만 하위 브라우저에서 :: 문법을 지원하지 않는 경우가 있어서 : 기호를 사용합니다.
[다른 가상 요소](otherVirtual.md)

## 자주 사용하는 가상 요소
- :before : 가장 앞에 요소를 삽입
- :after : 가장 뒤에 요소를 삽입
- :first-line : 요소의 첫 번째 줄에 있는 텍스트
- :first-letter : 블록 레벨 요소의 첫 번째 문자.

```
<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
```
```
p::before { content: "###" }
p::after { content: "!!!" }
p::first-line { ... }
p::first-letter { ... }
```
[소스코드](./src2/test2.html)

# 구체성
- 어떤 요소에 적용된 CSS 스타일에 상충할 때 어떤 스타일을 적용할지 결정하기 위해
- 브라우저는 각 스타일에 구체성을 부여하고 판단하여 우선으로 적용할 것을 선택합니다.

<mark> 구체성은 다음과 같은 규칙을 가지고 있습니다 </mark>
- 0, 1, 0, 0 : 선택자에 있는 모든 id 속성값
- 0, 0, 1, 0 : 선택자에 있는 모든 class 속성값, 기타 속성, 가상 클래스
- 0, 0, 0, 1 : 선택자에 있는 모든 요소, 가상 요소
- 전체 선택자는 0, 0, 0, 0을 가진다.
- 조합자( >, +)는 구체성에 영향을 주지 않는다.


```
h1 { ... }  /* 0,0,0,1 */
body h1 { ... }  /* 0,0,0,2 */
.grape { ... }  /* 0,0,1,0 */
*.bright { ... }  /* 0,0,1,0 */
p.bright em.dark { ... }  /* 0,0,2,2 */
#page { ... }  /* 0,1,0,0 */
div#page { ... }  /* 0,1,0,1 */
```

## 인라인 스타일
```
p#page {color : red;}
```
```
<p id="page" style="color:blue"> Lorem impusm dolor sit.</p>
```
- 결론적으로 인라인의 blue가 적용된다. 인라인은 <mark>1,0,0,0</mark> 우선순위를 가진다

## important
- important 키워드는 별도의 구체성 값은 없지만, 모든 구체성을 무시하고 우선권을 갖습니다.
- importnat 키워드는 속성값 뒤 한 칸 공백을 주고 느낌표 기호와 함께 씁니다.
```
p#page {color:red!important;}
```
# 상속

상속되는 속성
```
h1{color:gray;}
```
```
<h1>Hello, <em>CSS</em></h1>
```
- 위 코드에서 <em>은 부모인 <h1>의 color:gray를 상속받습니다.
- 상속은 자연스러운 현상처럼 보이지만, 모든 속성이 다 상속되는 것은 아닙니다.
- 아직 속성에 대해 다 배우지는 않았지만, margin, padding, background, border 등 박스 모델 속성들은 상속 되지 않습니다 ^_^

<mark>상속되는 속성의 구체성</mark>
```
*{
    color:red;
}
h1#page{color:gray;}
```
```
<h1 id="page">Hello,<em>CSS</em></h1>
```
- CSS에는 RED가 채택된다. 그 이유는 바로 상속된 속성은 아무런 구체성을 가지지 못하기 때문입니다.
- 0,0,0,0 이라는 구체성도 가지지 못한다. 만약 전체 선택자가 없었으면 구체성이 없어도 되엇을 것

# 캐스케이딩

## cascading 규칙
- 중요도(!important)와 출처
- 구체성
- 선언 순서

<mark>모든 스타일은 아래의 규칙에 따라 단계적으로 적용됩니다 </mark>

1. 스타일 규칙들을 모아서 중요도가 명시적으로 선언되었는지에 따라 분류합니다.
   1. 중요도가 명시적으로 선언된 규칙들은 그렇지 않은 규칙들보다 우선합니다.
   2. 중요도가 있는 규칙들끼리는 아래 다른 규칙들을 적용받습니다.
2. 스타일 규칙들을 출처에 따라 분류합니다.
   1. 제작자 스타일 규칙이 사용자 에이전트 스타일 규칙보다 우선합니다.
3. 스타일 규칙들을 구체성에 따라 분류합니다.
   1. 구체성이 높은 규칙들이 우선합니다.
4. 스타일 규칙들을 선언 순서에 따라 분류합니다.
   1. 뒤에 선언된 규칙일수록 우선합니다.

```
<p id="bright>Hello, CSS</p>
```
```
p#bright{color:silver;}
p{color:red;}
```
```
p{color:silver;}
p{color:red;}
```

위의 경우에는 구체성에 따라 silver <br>
아래의 경우에는 선언 순서에 따라 red

# 이외 선택자 정리

## [attribute~=value] 
- [title~=flower] : 속성 title의 값이 "flower" 을 <mark>포함</mark>하였는가?

## [attribute|=value]
- [title|=en] : title이 "en"으로 <mark>시작</mark>하는 가?

## X[href$=".jpg"]
- .jpg로 끝나는 url 링크가 걸린 전체 앵커
```
a[href$=".jpg"],
a[href$=".jpeg"],
a[href$=".png"],
a[href$=".gif"] {
   color: red;
}
```

이방법이 어려우므로 다음 방법을 사용한다.
```
<a href="path/to/image.jpg" data-filetype="image"> Image Link </a>
```
```
a[data-filetype="image"] {
   color: red;
}
```
