function showArgumentInfo() {
    let record = [];
    for (let i = 0; i < arguments.length; i++) {
        let type = typeof arguments[i];
        console.log(`${type}: ${arguments[i]}`);
        if(!record.hasOwnProperty(typeof arguments[i])){
            record[type] = 1;
            continue;
        }
        record[type]++;
    }
    Object.keys(record).sort((a, b)=>record[b] - record[a])
        .forEach(k => console.log(`${k} = ${record[k]}`));
}

showArgumentInfo({ name: 'bob'}, 3.333, 9.999);