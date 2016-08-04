/**
 * Created by tsxuehu on 16/8/4.
 */
export function onIncrement(login, nextPage) {
  return (dispatch, getState) => {
    return dispatch({type:'INCREMENT'})
  }
}

export function onDecrement(login, nextPage) {
  return (dispatch, getState) => {
    return dispatch({type:'DECREMENT'})
  }
}

export function onIncrementAsync(login, nextPage) {
  return (dispatch, getState) => {
    return dispatch({type:'INCREMENT_ASYNC'})
  }
}
