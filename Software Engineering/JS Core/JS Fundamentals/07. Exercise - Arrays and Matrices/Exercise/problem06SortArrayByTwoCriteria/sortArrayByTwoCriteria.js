function sortArrays(array) {
    return array.sort(function (a, b) {
        if (a.length == b.length) {
            if (a.toLowerCase() < b.toLowerCase()) {
                return -1;
            } else if (a.toLowerCase() > b.toLowerCase()) {
                return 1;
            } else {
                return 0;
            }
        }
        return a.length - b.length;
    }).forEach(e => console.log(e));
}