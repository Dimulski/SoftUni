function calculateDistance(params) {
    let v1 = params[0];
    let v2 = params[1];
    let t = params[2];
    let s1 = v1 * t / 60 / 60 * 1000;
    let s2 = v2 * t / 60 / 60 * 1000;
    let s = Math.abs(s1 - s2);
    console.log(s);
}