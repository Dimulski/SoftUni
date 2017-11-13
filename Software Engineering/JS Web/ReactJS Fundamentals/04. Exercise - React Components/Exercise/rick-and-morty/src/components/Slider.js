import React, { Component } from 'react'

import left from './../resources/left.png'
import right from './../resources/right.png'

const port = '9999';

class Slider extends Component {
  constructor() {
    super()

    this.state = {
      focusedEpId: 0,
      imgUrl: ""
    }

    this.getNewEp = (id) => {
      fetch('http://localhost:' + port + '/episodePreview/' + id)
        .then(data => {
          return data.json()
        }).then(parsedData => {
          this.setState({ focusedEpId: parsedData.id })
          this.setState({ imgUrl: parsedData.url })
        })
    }
  }

  componentDidMount() {
    fetch('http://localhost:' + port + '/episodePreview/' + this.state.focusedEpId)
      .then(data => {
        return data.json()
      }).then(parsedData => {
        this.setState({ imgUrl: parsedData.url })
      })
  }

  render() {
    return (
      <div className='warper'>
        <img onClick={() => {
          this.getNewEp(Number(this.state.focusedEpId) - 1)
        }} className="slider-button case-left" alt="left" src={left} />
        <img className="sliderImg" alt="hello" src={this.state.imgUrl} />
        <img onClick={() => {
          this.getNewEp(Number(this.state.focusedEpId) + 1)
        }} className="slider-button case-right" alt="right" src={right} />
      </div>
    )
  }
}

export default Slider