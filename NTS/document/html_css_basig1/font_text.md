# 폰트 & 텍스트

```
font-family: family-name | generic-family ( | initial | inherit );
```

```
font-family: Helvetica, Dotum, '돋움', Apple SD Gothic Neo, sans-serif; 
```

# LINE - HEIGHT
- em + 상하단 여백 의 간격
- line-height : normal -> 1.2 정도된다.
- numberfont-size 기준으로 설정한 숫자만큼 배율로 적용합니다.
- % 부모 요소에서 %값이 그대로 상속되는 것이 아니고, %에 의해 이미 계산되 px값이 상속됩니다.

```
body { font-size: 20px; line-height: 2; }    /* line-height = 40px; */
p { font-size: 10px; }                                  /* line-height = 20px; */


body { font-size: 20px; line-height: 200%; }    /* line-height = 40px; */
p { font-size: 10px; }             
```

<mark>이처럼 계산된 값이 아닌 숫자 값을 상속한다는 사실 때문에, 숫자 값을 사용하면 부모 엘리먼트에서 계산된 값 대신 비율을 그대로 상속받을 수 있으므로, 가능하면 단위가 없는 값을 사용하는 것이 좋습니다.</mark>

# 속성-font-weight
- normal 기본 값(400)
- bold 굵게 표현(700)
- bolder 부모 요소 보다 두껍게 표현
- lighter 부모 요소 보다 얇게 표현
- number 100, 200, 300, 400, 500, 600, 700, 800, 900 (클수록 두껍게 표현)

```
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="utf-8">
    <title>gd</title>
        <link href='//fonts.googleapis.com/css?family=Open+Sans:400,600,700,800,300' rel='stylesheet' type='text/css'>
    <style>
        body{
            padding:0 20px;
            font-family: 'Open Sans';
        }

        .w100{font-weight: 100;}
        .w200{font-weight: 200;}
        .w300{font-weight: 300;}
        .w400{font-weight: 400;}
        .w500{font-weight: 500;}
        .w600{font-weight: 600;}
        .w700{font-weight: 700;}
        .w800{font-weight: 800;}
        .w900{font-weight: 900;}
        .w1000{font-weight: 1000;}
    </style>
</head>
<body>
    <p class="w100">This is 100 weight</p>
    <p class="w200">This is 200 weight</p>
    <p class="w300">This is 300 weight</p>
    <p class="w400">This åis 400 weight</p>
    <p class="w500">This is 500 weight</p>
    <p class="w600">This is 600 weight</p>
    <p class="w700">This is 700 weight</p>
    <p class="w800">This is 800 weight</p>
    <p class="w900">This is 900 weight</p>
    <p class="w1000">This is 1000 weight</p>
</body>

</html>
```

# font-style 속성
```
font-style:normal|italic|oblique|intial|inherit;
```
- font-style:normal;
- font-style:italic;
- font-style:oblique (옵르릭 사선 각도 추가가능 -90 ~ 90)

# font-valiant
- small-caps
- 소문자로 변경해준다.

```
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="utf-8">
    <title>font-variant</title>
    <style>
        p {
            font-variant: small-caps;
        }
    </style>
</head>

<body>
<p>Font-VAriant:Small-Caps</p>
</body>


</html>
```

# 속성-font
- font의 경우 앞서 배운 fornt와 관련된 다양한 값을 축약 속성에 넣을 수 있습니다.
- 다만 속성마다 선언 순서를 지켜야 하는 제약이 있습니다.
- <mark>실무에서 선호하는 편은 아닙니다</mark>

# 웹 폰트

```
@font-face{
    font-family: myFirstFont;
    src: url(~~);
    font-weight : 400;
}
```
# vertical-align
- sub : 부모 아래 첨자 기준으로 정렬
- super : 부모 위 첨자 기준으로 정렬
- text-top : 부모 텍스트의 맨위
- text-bottom : 부모 텍스트의 맨 아래

# text aligin
- center
- left
- right
- center
- justify (양끝정렬)
- initial

```
<!DOCTYPE>
<html lagn="ko">

<head>
    <meta charset="utf-8">
    <title>text-align</title>
    <style>
        p{
            max-width: 360px;
            border: 1px solid #888;
            padding: 10px;
        }
    </style>
</head>
<body>
    <h1>text-aligin</h1>
    <h2>left</h2>
    <p style="text-align:left"> Lorem ipsum dolor, sit amet consectetur adipisicing elit. Expedita ullam autem voluptatum.</p>
    <h2>right</h2>
    <p style="text-align:right">Lorem ipsum, dolor sit amet consectetur adipisicing elit. Distinctio, corporis!</p>
    <h2>center</h2>
    <p style="text-align:center">Lorem ipsum dolor sit amet consectetur adipisicing elit. Aut, nisi.</p>
    <h2>justify</h2>
    <p style="text-align: justify;">Lorem ipsum dolor sit amet consectetur adipisicing elit. Alias!</p>
</body>
</html>
```

# text-indent
```
text-indent:length|initial|inherit
```

# text-decoratino 속성
- 기본 값 : none currentColor solid
- underline : 밑 줄
- overline : 윗 줄
- line-through 중간을 지나는 줄로 꾸밈을 설정

## 속성값
- solid
- double
- dotted
- dashed
- wavy

# 속성-단어 관련 속성
- white-space (nowrap) 
- letter-spacing(글 자간,글자와 글자사이 간격 : 3px )
- word-spacing (글 단어간 간격)
- word-break(단어를 어디에서 자를지)
- word-wrap