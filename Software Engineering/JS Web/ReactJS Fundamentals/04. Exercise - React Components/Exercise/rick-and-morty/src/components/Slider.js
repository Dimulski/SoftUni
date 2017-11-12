import React, {Component} from 'react';
import left from '../resources/left.png';
import right from '../resources/right.png';
const port = '9999';

class Slider extends Component {
  constructor() {
    super()

    this.state = {
      focusedEpId : 0,
      focusedEpImageUrl : ''
    }

    this.getNewEp = (id) => {
      fetch('http://localhost:' + port + '/episodePreview/' + id).then(data => {
        return data.json()
      }).then(parsedData => {
        this.setState({ focusedEpId : parsedData.id })
        this.setState({ focusedEpImageUrl : parsedData.url })
      })
    }
  }

  changeSlide = (direction) => {
    let id = Number(this.state.focusedEpId)
    if (direction === 'left') {
      id -= 1
    } else if (direction === 'right') {
      id += 1
    }
    this.getNewEp(id)
  }

  componentDidMount() {
    fetch('http://localhost:' + port + '/episodePreview/' + this.state.focusedEpId)
      .then(data => {
        return data.json()
      })
      .then(parsedData => {
        this.setState({focusedEpImageUrl : parsedData.url})
      })
  }

  render() {
    return (
      <div>
        <div className='wrapper'>
          <img
            alt='left-arrow'
            src={left}
            className='slider-elem slider-button case-left'
            onClick={() => this.changeSlide('left')}
          />
          <img
            className='sliderImg slider-elem'
            alt='focusedEp'
            src={this.state.focusedEpImageUrl}
          />
          <img
            alt='right-arrow'
            src={right}
            className='slider-elem slider-button case-right'
            onClick={() => this.changeSlide('right')}
          />
        </div>
      </div>
    )
  }
}

export default Slider;