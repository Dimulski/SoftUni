const fs = require('fs');
let db = {};

let put = (key, value) => {
    if (typeof key !== 'string') {
        console.log('Key is not a string');
        return;
    }

    if (db.hasOwnProperty(key)) {
        console.log('Key already exists');
        return;
    }

    db[key] = value;
};

let get = (key) => {
    if (typeof key !== 'string') {
        console.log('Key is not a string');
        return;
    }

    if (!db.hasOwnProperty(key)) {
        console.log('Cannot find the specified key in database');
        return;
    }

    return db[key];
};

let getAll = () => {
    if (Object.keys(db).length === 0){
        console.log('Database is empty.');
        return;
    }

    return db;
};

let update = (key, newValue) => {
    if (typeof key !== 'string') {
        console.log('Key is not a string');
        return;
    }

    if (!db.hasOwnProperty(key)) {
        console.log('Cannot find the specified key in database');
        return;
    }

    db[key] = newValue;
};

let remove = (key) => {
    if (typeof key !== 'string') {
        console.log('Key is not a string');
        return;
    }

    if (!db.hasOwnProperty(key)) {
        console.log('Cannot find the specified key in database');
        return;
    }

    delete db[key];
}

let clear = () => {
    db = {};
};

let save = () => {
    return new Promise((resolve, reject) => {
        fs.writeFile('./storage.json', JSON.stringify(db) ,'utf8', (err, data) => {
            if (err) {
                console.log('Error saving data to storage');
                console.log(err);
                return;
            }

            resolve();
        })
    })
    // fs.writeFileSync('./storage.json', JSON.stringify(db), 'utf8');
};

let load = () => {
    return new Promise((resolve, reject) => {
        fs.readFile('./storage.json', 'utf8', (err, data) => {
            if (err) {
                console.log('Error loading data from storage.');
                console.log(err);
                return;
            }

            storage = JSON.parse(data);
            resolve();
        });
    });
};

module.exports =  {
    put: put,
    get:get,
    getAll: getAll,
    update: update,
    delete: remove,
    clear: clear,
    save: save,
    load: load,
};