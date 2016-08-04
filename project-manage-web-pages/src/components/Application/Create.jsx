import React, { Component, PropTypes } from 'react';
import classnames from 'classnames';


const Todo = ({ data, onToggleComplete }) => {


  return (
    <div >
     创建应用
    </div>
  );
};

Todo.propTypes = {
  data: PropTypes.object.isRequired,
  onToggleComplete: PropTypes.func.isRequired,
};

export default Todo;

