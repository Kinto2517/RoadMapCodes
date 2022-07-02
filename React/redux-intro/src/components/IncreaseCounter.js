import React, { Component } from 'react'
import { bindActionCreators } from 'redux'
import {increaseCounter} from '../redux/actions/counterActions'


export default class IncreaseCounter extends Component {
  render() {
    return (
      <div>increaseCounter</div>
    )
  }
}

function mapDispatchToProps(dispatch){
    return {
        actions: bindActionCreators(increaseCounter, dispatch)
    }
}