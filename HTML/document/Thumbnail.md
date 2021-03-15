# 원본유지 이미지
CSS 작업을 하다보면 원본의 이미지 비율을 그대로해서 높이와 넓이를 설정해야할 때가 있습니다.
<br>그럴때 \<img>를 사용하게 된다면 어려움이 발생합니다.
<br> % 나 vw속성을 이용해서 설정합니다. 이때 height대신 padding을 사용하여 높이를 설정할 수 있습니다.

## 단위 %
- padding-top = n %
- 비율 a:b 유지 => (b/a)*100 %
- ex ) 16:9 비율 적용 => (9/16) * 100 =56.25%

```
.child {
    background: url('http://url) no-repeat top center;
    background-size: cover;
    padding-top: 56.25%;    // 16:9 비율 => (9/16)*100=56.25
}
```

## 원본유지
```
.image {
    min-height: 280px;
    max-height: 480px;
    background-repeat: no-repeat;
    background-position: center;
    background-size: auto 100%;
}
```