/**
 * Created by tsxuehu on 16/8/3.
 */
export default function counter(state, action) {

  const value = state['value'];
  var now = 0;
  switch (action.type) {
    case 'INCREMENT':
      now = value + 1;
      break;
    case 'INCREMENT_IF_ODD':
      now = (value % 2 !== 0) ? value + 1 : value;
      break;
    case 'DECREMENT':
      now = value - 1;
      break;
    default:
      now = value;
      break;


  }
  return {value: now}
}
