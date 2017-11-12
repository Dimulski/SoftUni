import React, { Component } from 'react';
import './App.css';
import Slider from './components/Slider';

class App extends Component {
  constructor() {
    super()

    this.state = {
      
    }
  }
  render() {
    return (
      <div className='App'>
        <Slider />
      </div>
    )
  }
}

export default App;
