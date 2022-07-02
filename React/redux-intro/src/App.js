import React, { Component } from 'react'
import Counter from './components/Counter'
import IncreaseByTwoCounter from './components/IncreaseByTwoCounter'
import DecreaseCounter from './components/DecreaseCounter'
import IncreaseCounter from './components/IncreaseCounter'


export default class App extends Component {
  render() {
    return (
      <div>

      <Counter/>
      <IncreaseCounter></IncreaseCounter>
      <DecreaseCounter></DecreaseCounter>
      <IncreaseByTwoCounter></IncreaseByTwoCounter>
      </div>
    )
  }
}
