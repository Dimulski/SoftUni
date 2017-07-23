let Record =  (function () {
    let closureId = 0;

    return class Record {
        constructor(temperature, humidity, pressure, windSpeed) {
            this.id = closureId++;
            this.temperature = temperature;
            this.humidity = humidity;
            this.pressure = pressure;
            this.windSpeed = windSpeed;
        }

        get status() {
            if (this.temperature < 20 && (this.pressure < 700 || this.pressure > 900)
                && this.windSpeed > 25) {
                return 'Stormy';
            }

            return 'Not stormy';
        }

        toString() {
            let result = `Reading ID: ${this.id}
            Temperature: ${this.temperature}*C
            Relative Humidity: ${this.humidity}%
            Pressure: ${this.pressure}hpa
            Wind Speed: ${this.windSpeed}m/s
            Weather: ${this.status}`;

            return result;
        }
    }
})();