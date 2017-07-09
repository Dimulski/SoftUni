function attachEventListeners() {
    document.getElementById('convert').addEventListener('click', convert);

    let units = {
        'km' : 1000,
        'm' : 1,
        'cm' : 0.01,
        'mm' : 0.001,
        'mi' : 1609.34,
        'yrd' : 0.9144,
        'ft' : 0.3048,
        'in' : 0.0254
    };

    function convert(event) {
        let input = document.getElementById('inputDistance').value;
        let result = document.getElementById('outputDistance');
        let inputUnit = document.getElementById('inputUnits').value;
        let outputUnit = document.getElementById('outputUnits').value;

        result.value = input*units[inputUnit] / units[outputUnit];
    }
}