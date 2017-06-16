function solve(input) {
    let map = new Map();
    for (let JSONArray of input) {
        let array = JSON.parse(JSONArray);
        let arrayString = array.sort().toString();
        if (!map.has(arrayString)) {
            map.set(arrayString, array);
        }
    }
    let sortedArray = Array.from(map.keys()).sort((a, b) => {
        if (map.get(a).length !== map.get(b).length) {
            return map.get(a).length - map.get(b).length;
        }
    });

    let result = [];
    sortedArray.forEach(k => {
        result.push(`[${map.get(k).sort((a, b) => b - a).join(', ')}]`);
    });

    console.log(result.join('\n'));
}