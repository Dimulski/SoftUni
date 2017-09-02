function attachEvents() {
    $('#submit').click(getWeather);

    async function getWeather() {
        try {
            let code = '';
            let locations = await $.ajax({url: 'https://judgetests.firebaseio.com/locations.json'});
            for (let location of locations) {
                if (location.name === $('#location').val()) {
                    code = location.code;
                }
            }
            if (code !== '') {
                let [todayForecast, upcomingForecast] = await Promise.all([
                    $.ajax({url: `https://judgetests.firebaseio.com/forecast/today/${code}.json`}),
                    $.ajax({url: `https://judgetests.firebaseio.com/forecast/upcoming/${code}.json`})]);
                displayData(todayForecast, upcomingForecast);
            }
        } catch (error) {
            console.log(error);
            $('#forecast').css('display', '');
            $('#current').text('Error');
            $('#upcoming').empty();
        }

        function displayData(todayForecast, upcomingForecast) {
            let symbols = {
                'Sunny': '&#x2600;',
                'Partly sunny': '&#x26C5;',
                'Overcast': '&#x2601;',
                'Rain': '&#x2614;',
                'Degrees': '&#176;'
            };
            $('#forecast').css('display', '');
            let current = $('#current');
            current.append($(`<span class="condition symbol">${symbols[todayForecast.forecast.condition]}</span>`));
            $('<span class="condition">')
                .append($(`<span class="forecast-data">${todayForecast.name}</span>`))
                .append($(`<span class="forecast-data">${todayForecast.forecast.low}°/${todayForecast.forecast.high}°</span>`))
                .append($(`<span class="forecast-data">${todayForecast.forecast.condition}</span>`))
                .appendTo(current);
            let upcoming = $('#upcoming');
            for (let forecast of upcomingForecast.forecast) {
                $('<span class="upcoming">')
                    .append($(`<span class="symbol">${symbols[forecast.condition]}</span>`))
                    .append($(`<span class="forecast-data">${forecast.low}°/${forecast.high}°</span>`))
                    .append($(`<span class="forecast-data">${forecast.condition}</span>`))
                    .appendTo(upcoming);
            }
        }
    }
}