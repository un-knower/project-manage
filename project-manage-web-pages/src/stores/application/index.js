/**
 * Created by tsxuehu on 16/8/4.
 */

import { createStore, applyMiddleware, compose, combineReducers } from 'redux';
import createSagaMiddleware from 'redux-saga';
import reducers from '../../reducers/application/index';
import sagas from '../../sagas/application/index';
import thunk from 'redux-thunk'

export default function configureStore(initialState) {
  const sagaMiddleware = createSagaMiddleware();
  const enhancer = compose(
    applyMiddleware(sagaMiddleware,thunk),
    window.devToolsExtension ? window.devToolsExtension() : f => f
  );
  const store = createStore(reducers, initialState, enhancer);
  sagaMiddleware.run(sagas);
  return store;
}



