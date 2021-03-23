import React, { Component } from 'react';

class PropsComponent extends Component {
    render() {
        return (
            <div className="message-container">
                {this.props.name}
            </div>
        );
    }
}

// 자룧료형을 선언하는 예제
PropsComponent.propTypes={
    name:propTypes.string,
};

export default PropsComponent;