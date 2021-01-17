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