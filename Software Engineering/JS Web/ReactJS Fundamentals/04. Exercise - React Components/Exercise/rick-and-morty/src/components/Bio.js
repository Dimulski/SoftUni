import React, { Component } from 'react'

import Char from './Char'

const port = '9999';

class Bio extends Component {
  constructor(props) {
    super(props)

    this.state = {
      id: this.props.id,
      curChar: {
        url: ''
      }
    }
  }

  componentDidMount() {
    fetch('http://localhost:' + port + '/character/' + this.state.id).then(data => {
      return data.json()
    }).then(parsedData => {
      this.setState({ curChar: parsedData })
    })
  }

  componentDidUpdate() {
    try {
      if (this.state.id !== this.props.id) {
        fetch('http://localhost:' + port + '/character/' + this.props.id).then(data => {
          return data.json()
        }).then(parsedData => {
          this.setState({ id: parsedData.id, curChar: parsedData })
        })
      }
    } catch (e) {
      console.log(e)
    }
  }

  render() {
    return (
      <div>
        <fieldset>
          {<Char params={({ url: this.state.curChar.url })} />}
          <p>{this.state.curChar.bio}</p>
        </fieldset>
      </div>
    )
  }
}

export default Bio;