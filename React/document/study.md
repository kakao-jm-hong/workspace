# 컴포넌트

## 함수형
```
import React from 'react';

const Name = () => {
    return(
        <h2>test Name </h2>
    );
}
export default Name;
```
## 클래스형
```
import Reac from 'react';

// React.Componet를 상속한 클래스로 선언
class Name extends React.Componet {
    render(
        <h2>test Name</h2>
    );
}
export default Name;
```

- 짧은 함수형
```
import React from 'react';

const Name = () =>(
    <h2>Name</h2>
);
export default Name;
```

- 클래스형 컴포넌트를 사용하는 경우라도 컴포넌트 내부에 선언하는 서브 컴포넌트는 항상 함수형으로 사용합니다.
```
import React from 'react';

const Sub = () =>{
    return <p> 서브 </p>;
};

class Main extends React.Componet {
    render(){
        return (
            <div>
                <p>메인</p>
                <SubComponent />
            </div>
        );
    }
}

export default Main;
```

# 신규 컴포넌트 처리
```
import React from 'react';

const DEMO = {
    name : 'test',
    password : '1234'
}

const Example = () =>{
    const {id, title } = DEMO;

    return (
        <div>
            <p>{id}</p>
            <p>{title}</p>
        </div>
    )
}

export default Example;
```

## 컴포넌트 내부에 서브 컴포넌트가 있는 경우.
```
import React from 'react';

const DEMO_PROPS = {
    name : 'test',
    pass : 1234
}

const DEMO_PROPS_SUB = {
    type : 'admin'
};

const SUB = () => {
    const { type } = DEMO_PROPS_BADGE;
    return type === 'admin' && <img ... />
};

class Component extends React.Component {
    render(){
        const {name, title} = DEMO_PROPS;

        return(
            <div>
                <p>{name}</p>
                <p>{title}</p>
                <SUB/>
            </div>
        )
    }
}
export default Component;
```

# 자식 컴퍼넌트에 값 전달하는 방법

## Parent
```
import React from 'react';
import ChildComponet from './ChildComponent';

const DEMO = {
    category : 'food',
    title: '제목'
};

const Parent = () => {
    const { title, category } = DEMO;

    return(
        <div>
            <p>{title}</p>
            <ChildComponet category = {category}/>
        </div>
    )
}
export default Parent;
```
## Child
```
import React from 'react';

const DEMO = {
    contents: '내용'
};

const Child = (props) => {
    const { contnets } = DEMO_PROPS;
    // 부모에서 전달하는 category 값
    const { category} = props;
    // 카테고리-wrap 으로 클래스 가공
    const wrapCalss = `{category}-wrap`;

    return (
        <div className={wrapClass}>
            <p>{contents}</p>
        </div>
    );
}

export default Child;
```

# 클래스형이라면..?

## parent
```
import React from 'react';
import Child from './Child';

const DEMO = {
    category: 'food',
    title : '제목'
};

class Parent extens React.Componet {
    render(){
        const {title, category} = DEMO_PROPS;

        return (
            <div>
                <p>{title}</p>
                <Child category={category}/>
            </div>
        )
    }
}
exprot default Parent;
```

## child
```
import React from 'react';

const DEMO_PROPS = {
    contents: '내용';
};

class Child extends React.Componet {
    render(){
        const { contents } = DEMO_PROPS;

        const { category } = this.props;

        const wrapCalss = `${category}-wrap`;

        return (
            <div className={wrapClass}>
                <p>{contens}</p>
            </div>
        );
    }
}
export default Child;
```

## 컴퍼논트 내에 있는 서브 컴포넌트에 props를 전달

```
import React from 'react';

const DEMO_PROPS = {
    category: 'food',
    title: '제목',
    content: '내용',
};

const Sub = (props) => {
    const {category, content} = props;

    return (
        <div className={category}>
            <p>{content}</p>
        </div>
    );
};

class Main extends React.Componet {
    render(){
        const { category, title, content } = DEMO_PROPS;

        return (
            <div>
                <p>{title}</p>

                <SubComponent
                    category = {category}
                    content = {content}
                >
            </div>
        );
    }
}
export default Main;
```

# DefaultProps
```
import React from 'react';

class Child extends React.Component {
    render (){
        const { title } = this.props;

        return (
            <div>
                <p>{title}</p>
            </div>
        )
    }
}

Child.defaultProps = {
    title: '제목이 없습니다.'
};
export default Child;
```
## className 동적처리
```
render(){
    const { isLogin } = DEMO;

    const expandClass = classnames({
        // 오른쪽 true인경우 노출
        'expand' : !isLogin
    });

    return (
        <div className={expandClass}>
            ...
        </div>
    );
}
export default ExampleComponent;
```

## 다중으로 처리
```
    const expandClass = classnames({
        'expand': !isLogin, // 로그인이 아닌 경우라면 expand 클래스 노출
        'info-wrap': userType !== 'admin' // admin이 아니면 info-wrap 클래스 노출
    });

    const loginClass = classnames({
        'login': isLogin, // 로그인이면 login 클래스 노출
        'user-admin': userType === 'admin', // admin이면 user-admin 클래스 노출
        'user-staff': userType !== 'admin' // admin이 아니면 user-staff 클래스 노출
    });
```

## 조건부 렌더링
```
    return isLogin && (
        <div>
            ...
        </div>
    );
```

## 특정부분 렌더링
```
    {isLogin && (
        <p>
            ...
        </p>
    )}
```

## 삼항 연산자
```
    // admin 유저가 로그인한 상태
    const visible = isLogin && userType === 'admin';

    // admin 유저가 로그인 했을 때만 컴포넌트 출력
    return visible ? (
        <div>
            ...
        </div>
    ) : (
        <div>
            ...
        </div>
    );
```

## 변수에 담아서 렌더링
```
    render() {
        const { isLogin } = DEMO_PROPS;

        // 로그인 일 때 노출
        const userImage = isLogin && (
            <p>
                <img ... />
            </p>
        );

        return (
            <div>
                <p> ... </p>
                {/* 로그인 상태에서만 표시 */}
                {userImage}
            </div>
        );
    }
```

## switch 렌더링
```
    render() {
        const { userType } = DEMO_PROPS;

        // 조건 별로 컴포넌트 출력
        switch(userType) {
            case 'admin' :
                return (
                    <div> ... </div>
                );
            case 'user' :
                return (
                    <div> ... </div>
                );
            default :
                /*
                    // 기본 값이 없는 경우
                    return null;
                */
                return (
                    <div> ... </div>
                );
        }
    }
```

## 노출할 컨텐츠를 컴포넌트 외부에서 관리하는 경우
```
    return (
        // #1 Box 컴포넌트에서 출력할 내용을 부모 컴포넌트가 전달
        <Box>
            <p>Box 컴포넌트에서 출력할 내용</p>
            <p>Box 컴포넌트에서 출력할 내용</p>
            <p>Box 컴포넌트에서 출력할 내용</p>
        </Box>
    );
```
```
class Box extends React.Component {
    render() {
        return (
            <div className="box">
                <div className="content">
                    {/* #2 this.props.children을 이용하여 외부에서 입력한 내용을 출력 */}
                    {this.props.children}
                </div>

                <button>내용 펼치기</button>
            </div>
        );
    }
}
```

## 반복문
```
const DEMO_PROPS = {
    itemList: [
        {id: 1},
        {id: 2},
        {id: 3}
    ]
};

class ExampleComponent extends React.Component {
    render() {
        const { itemList } = DEMO_PROPS;

        return (
            <ul>
                {itemList.map((item) => (
                    // #2 key 추가
                    <li key={item.id}>목록</li>
                ))}
            </ul>
        );
    }
}

```

## 스프레드 연산자
```
// #1 목록 데이터 정의
const DEMO_PROPS = {
    itemList: [
        {
            id: 1,
            title: '제목 1'
        },
        {
            id: 2,
            title: '제목 2'
        },
        {
            id: 3,
            title: '제목 3'
        }
    ]
};

class ListComponent extends React.Component {
    render() {
        const { itemList } = DEMO_PROPS;

        return (
            <ul>
                {itemList.map((item) => (
                    // #2 key를 추가하고 item 속성들을 스프레드 연산자를 이용해 props로 전달
                    <ItemComponent key={item.id} {...item} />
                ))}
            </ul>
        );
    }
}

```