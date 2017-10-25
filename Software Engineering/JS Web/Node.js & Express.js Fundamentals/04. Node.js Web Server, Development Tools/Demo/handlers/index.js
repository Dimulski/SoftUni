const faviconHandler = require('./favicon-handler.js')
const homeHandler = require('./home-handler.js')
const staticHandler = require('./static-file-handler.js')

module.exports = [ faviconHandler, homeHandler, staticHandler ]