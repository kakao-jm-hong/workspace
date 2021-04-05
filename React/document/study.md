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