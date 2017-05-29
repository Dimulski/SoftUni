function calculateDistanceIn3D(params) {
    let a1 = params[0];
    let b1 = params[1];
    let c1 = params[2];
    let a2 = params[3];
    let b2 = params[4];
    let c2 = params[5];
    let d = Math.sqrt(Math.pow(a2 - a1, 2) + Math.pow(b2 - b1, 2) + Math.pow(c2 - c1, 2));
    console.log(d);
}