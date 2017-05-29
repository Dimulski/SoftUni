function assignProperties(params) {
    let [property1, value1, property2, value2, property3, value3] = params;
    let resultObject = {[property1]: value1, [property2]: value2, [property3]: value3};
    console.log(resultObject);
}