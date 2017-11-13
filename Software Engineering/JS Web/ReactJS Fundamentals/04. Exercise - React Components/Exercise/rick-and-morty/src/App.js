import React, { Component } from 'react';
import './App.css';

import Slider from './components/Slider'
import Roster from './components/Roster'
import Bio from './components/Bio'

import observerMenu from './utils/observer'

class App extends Component {
  constructor() {
    super()

    this.state = {
      focusedChar: 0
    }

    this.eventHandler = this.eventHandler.bind(this);
  }

  eventHandler = (newState) => {
    this.setState(() => {
      return { focusedChar: newState.focusedChar }
    })
  }

  componentDidMount() {
    observerMenu.addObserver('changeFocus', this.eventHandler)
  }

  render() {
    return (
      <div className="App">
        <Slider />
        <Roster />
        <Bio id={Number(this.state.focusedChar)} />
      </div>
    );
  }
}

export default App;
