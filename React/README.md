# React

## 컴포넌트
input을 주면 DOM을 생성하고 event 발생 시 DOM을 업데이트.
<br>
DOM의 업데이트는 상위 component의 render()가 실행될 때 혹은 setState()메서드로 state가 업데이트될 때 발생

## props 와 state
- props은 상위 컴퍼넌트가 전달해주는 input param, readOnly
- state 내부 데이터, 수정가능 <mark>this.setState()</mark>
- dom을 업데이트할려면 항상 render가 호출되어야합니다.
- setState한다음 그다음줄에 state를 참조하면 안된다.


## 에어비엔비 스타일을 쓰면좋습니다.


## Virtual DOM
- render() 호출 시 DOM 업데이트 최소화
- 그럼에도 불구하고 불필요한 render() 호출을 안해야 함.
  - this.setState() 호출 남발하지 말자
  - shouldComponentUpdate() 활용. props, state 변경되었으나 렌더링 필요 없을 때
<br>
concat메소드를 이용해서 Imutable을 만족하게 설계하자.
<br>
JSX = HTML + JavaScript