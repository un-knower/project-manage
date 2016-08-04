import React from 'react';
import ReactDOM from 'react-dom';
import { Provider } from 'react-redux';
import { createStore, applyMiddleware, compose, combineReducers } from 'redux';
import createSagaMiddleware from 'redux-saga';

import reducers from '../../reducers/application/index';
import sagas from '../../sagas/application/index';

import './application.html';
import './application.less';

//////////////////////
// Store

const sagaMiddleware = createSagaMiddleware();
const initialState = {};
const enhancer = compose(
  applyMiddleware(sagaMiddleware),
  window.devToolsExtension ? window.devToolsExtension() : f => f
);
const store = createStore(combineReducers({
  ...reducers
}), initialState, enhancer);
sagaMiddleware.run(sagas);



//////////////////////
// Render
let render = () => {
  const Counter = require('../../components/application/Counter');
  ReactDOM.render(
    <Provider store={store}>
      <Counter />
    </Provider>
    , document.getElementById('root'));
};

render();
