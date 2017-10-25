const http = require('http')
const url = require('url')
const handlers = require('./handlers/index')
const port = 3333

http
  .createServer((req, res) => {
    req.path = url.parse(req.url).pathname
    for (let index = 0; index < handlers.length; index++) {
      let handler = handlers[index]
      let result = handler(req, res)
      if (!result) {
        break
      }
    }
  })
  .listen(port)

console.log(`Server is listening to port ${port}`)
