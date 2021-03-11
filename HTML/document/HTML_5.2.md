# HTML 5.2

## dialog 요소 추가
dialog 요소는 "모달 창"의 대안이 되는 HTML Element이다. 지금까지 플러그인을 사용하거나 독자적으로 javascript를 쓰고 구현하고 있던 것이 HTML 사양으로 추가되었다.

```
<dialog>
  <h2>Dialog Title</h2>
  <p>Dialog content and other stuff will go here</p>
</dialog>
```

open 속성이 적용 되지 않는 한 보기에서(그리고 DOM 엑세스로부터) 숨겨진다.
```
<dialog open>
```

## ES MODULES 지원
script 요소에서 type = "module"이 지원되게 되었습니다. import와 export 기능을 사용할 수 있습니다.

## WAI-ARIA1.1 준수

## Content Security Policy에 따라 link 요소에 nonce 속성이 추가

## iframe에 Payment Request API를 사용하기위한 allowpaymentrequest 속성이 추가

## HTML Element에 innerText 추가