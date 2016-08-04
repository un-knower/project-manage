/**
 * Created by tsxuehu on 16/8/4.
 */
export function onIncrement() {
  return (dispatch, getState) => {
    return dispatch({type:'INCREMENT'})
  }
}

export function onDecrement() {
  return (dispatch, getState) => {
    return dispatch({type:'DECREMENT'})
  }
}

export function onIncrementAsync() {
  return (dispatch, getState) => {
    return dispatch({type:'INCREMENT_ASYNC'})
  }
}
