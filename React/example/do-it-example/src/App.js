import React, { Component } from 'react';
import './App.css';
import ChildComponent from './03/ChildComponent'
class App extends Component {
  render() {
    const obj = {name:'id'}
    return (
      <ChildComponent
      boolValue={true}
      numValue={1}
      arrayValue={[1,2,3]}
      objValue={obj}
      nodeValue={<h1>shem</h1>}
      funValue={()=>{console.log('메시지')}}>

      </ChildComponent>
    );
  }
}

export default App;
