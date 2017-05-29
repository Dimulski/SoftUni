function compoundInterest(params) {
    let p = params[0];
    let i = params[1];
    let compoundPeriodInMonths = params[2];
    n = 12 / compoundPeriodInMonths;
    let t = params[3];
    let f = p * Math.pow(1 + i / 100 / n,n * t);
    console.log(f);
}