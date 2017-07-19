function validateRequest(request) {
    String.prototype.capitalize = function() {
        return this.charAt(0).toUpperCase() + this.slice(1);
    };

    let method = request.method;
    let uri = request.uri;
    let version = request.version;
    let message = request.message;
    let properties = {
        method: false,
        uri: false,
        version: false,
        message: false
    };

    // test presence of object properties
    for (let prop in request) {
        properties[prop] = true;
    }

    for (let prop in properties) {
        if (properties[prop] === false){
            if(prop.toString() !== 'uri'){
                throw new Error(`Invalid request header: Invalid ${prop.toString().capitalize()}`);
            }else{
                throw new Error(`Invalid request header: Invalid ${prop.toString().capitalize()}`);
            }
        }
    }

    if(method !== 'GET' && method !== 'POST' && method !== 'DELETE' && method !== 'CONNECT'){
        throw new Error('Invalid request header: Invalid Method');
    }

    let uriRegex = /(^[A-Za-z0-9\.]+$)|(^\*$)/g;
    if(!uriRegex.test(uri) || uri === ''){
        throw new Error(`Invalid request header: Invalid URI`);
    }

    if(version !== 'HTTP/0.9' && version !== 'HTTP/1.0' && version !== 'HTTP/1.1' && version !== 'HTTP/2.0'){
        throw new Error(`Invalid request header: Invalid Version`);
    }

    let messageRegex = /^[^<>\\&'"]*$/g;
    if(!messageRegex.test(message)){
        throw new Error(`Invalid request header: Invalid Message`);
    }

    return request;
}

// console.log(
//     validateRequest({
//         method: 'POST',
//         uri: 'home.bash',
//         message: 'rm -rf /*'
//     }));

console.log(
    validateRequest({
        method: 'OPTIONS',
        uri: 'git.master',
        version: 'HTTP/1.1',
        message: '-recursive'
    }));



