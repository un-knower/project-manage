/**
 * Created by tsxuehu on 16/8/3.
 */


import React, { Component, PropTypes } from 'react'
import { connect } from 'react-redux'
import { onIncrement, onDecrement ,onIncrementAsync } from '../../actions/application'



class Counter extends Component{


  render() {
    const { value ,onIncrement, onDecrement ,onIncrementAsync} = this.props;

    return (
      <div>
        <button onClick={onIncrement}>
          Increment
        </button>
        {' '}
        <button onClick={onDecrement}>
          Decrement
        </button>
        {' '}
        <button onClick={onIncrementAsync}>
          Increment after 1 second
        </button>
        <hr />
        <div>
          Clicked: {value} times
        </div>
      </div>
    )
  }
}

Counter.propTypes = {
  value: PropTypes.number.isRequired,
  onIncrement: PropTypes.func.isRequired,
  onDecrement: PropTypes.func.isRequired,
  onIncrementAsync: PropTypes.func.isRequired
}

function mapState(state, ownProps) {
  let value = state['value'];
  return {value};
}

export default connect(mapState, {
  onIncrement,
  onDecrement,
  onIncrementAsync
})(Counter)
