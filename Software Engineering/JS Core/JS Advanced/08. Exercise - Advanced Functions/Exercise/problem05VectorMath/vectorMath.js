let f = (function () {
    return {
        add: function (vec1, vec2) {
            return [vec1[0] + vec2[0], vec1[1] + vec2[1]];
        },
        multiply: function (vec1, scalar) {
            return [vec1[0] * scalar, vec1[1] * scalar];
        },
        length: function (vec1) {
            return Math.sqrt(Math.pow(vec1[0], 2) + Math.pow(vec1[1], 2));
        },
        dot: function (vec1, vec2) {
            return vec1[0] * vec2[0] + vec1[1] * vec2[1];
        },
        cross: function (vec1, vec2) {
            return vec1[0] * vec2[1] - vec1[1] * vec2[0];
        }
    }

})();

console.log(f.add([1, 1], [1, 0]));
console.log(f.multiply([3.5, -2], 2));
