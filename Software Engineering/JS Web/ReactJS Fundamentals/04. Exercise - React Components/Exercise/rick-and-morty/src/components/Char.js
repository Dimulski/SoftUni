import React from 'react'

import observerMenu from './../utils/observer'

let SingleChar = (props) => {
  return (
    <div onClick={() => {
      observerMenu.executeObserver('changeFocus', { focusedChar: Number(props.params.id) })
    }} className='char-img'>
      <img className='char-img' alt='char' src={props.params.url} />
    </div>
  )
}

export default SingleChar