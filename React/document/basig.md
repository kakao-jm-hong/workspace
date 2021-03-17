# React

```
ReactDOM.render(
  <h1>Hello, world!</h1>,
  document.getElementById('root')
);
```

# JSX

```
const element = <h1>Hello, world!</h1>;
```

## JSX에 표현식 포함하기

```
const name = 'Josh Perez';
const element = <h1>Hello, {name}</h1>;

ReactDOM.render(
  element,
  document.getElementById('root')
);
```

```
function formatName(user) {
  return user.firstName + ' ' + user.lastName;
}

const user = {
  firstName: 'Harper',
  lastName: 'Perez'
};

const element = (
  <h1>
    Hello, {formatName(user)}!
  </h1>
);

ReactDOM.render(
  element,
  document.getElementById('root')
);
```

## JSX도 표현식입니다.

```
function getGreeting(user) {
  if (user) {
    return <h1>Hello, {formatName(user)}!</h1>;
  }
  return <h1>Hello, Stranger.</h1>;
}
```

## JSX 속성 정의

### 리터럴 정의

```
const element = <div tabIndex="0"></div>;
```

### 중괄호로 어트리뷰트에 JavaScript 표현식을 삽입할 수도 있습니다.

```
const element = <img src={user.avatarUrl}></img>;
```

<b>JSX는 camelCase 프로퍼티 명명 규칙을 사용합니다.</b>

## JSX로 자식 정의

- 태그가 비어있다면 XML처럼 /> 이용

```
const element = <img src={user.avatarUrl} />;
```

# JSX 객체 표현

```
const element = (
  <h1 className="greeting">
    Hello, world!
  </h1>
);
```

```
const element = React.createElement(
  'h1',
  {className: 'greeting'},
  'Hello, world!'
);
```

위에 두코드는 동일하고 아래와같은 구조를 생성한다.

```
// 주의: 다음 구조는 단순화되었습니다
const element = {
  type: 'h1',
  props: {
    className: 'greeting',
    children: 'Hello, world!'
  }
};
```
