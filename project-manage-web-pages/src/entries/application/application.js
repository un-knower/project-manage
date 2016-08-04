import React from 'react';
import ReactDOM from 'react-dom';
import { Provider } from 'react-redux';

import configureStore from '../../stores/application';


import './application.html';
import './application.less';






//////////////////////
// Render
let render = () => {
  const Counter = require('../../components/application/Counter');
  ReactDOM.render(
    <Provider store={configureStore({value:0})}>
      <Counter />
    </Provider>
    , document.getElementById('root'));
};

render();
