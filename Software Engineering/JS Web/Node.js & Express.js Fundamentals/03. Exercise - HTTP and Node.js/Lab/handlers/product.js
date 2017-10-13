const url = require('url');
const database = require('../config/database');
const fs = require('fs');
const path = require('path');
const qs = require('querystring');

module.exports = (req, res) => {
    req.pathname = req.pathname || url.parse(req.url).pathname

    if (req.pathname === '/product/add' && req.method === 'GET') {
        let filePath = path.normalize(
            path.join(__dirname, '../views/products/add.html'));
            fs.readFile(filePath, (err, data) => {
                if (err) {
                    console.log(err);
                }

                res.write(data);
            });
    } else {
        return ture;
    }
}