function attachEventListeners() {
    let buttons = document.querySelectorAll('[value=Convert]');

    for (let button of buttons) {
        button.addEventListener('click', calculate);
    }

    function calculate(event) {
        let days = document.getElementById('days');
        let hours = document.getElementById('hours');
        let minutes = document.getElementById('minutes');
        let seconds = document.getElementById('seconds');
        let currentValue = 0;

        switch (event.target.getAttribute('id')) {
            case 'daysBtn':
                currentValue = days.value;
                hours.value = currentValue * 24;
                minutes.value = currentValue * 1440;
                seconds.value = currentValue * 86400;
                break;
            case 'hoursBtn':
                currentValue = hours.value;
                days.value = currentValue / 24;
                minutes.value = currentValue * 60;
                seconds.value = currentValue * 3600;
                break;
            case 'minutesBtn':
                currentValue = minutes.value;
                days.value = currentValue / 1440;
                hours.value = currentValue / 60;
                seconds.value = currentValue * 60;
                break;
            case 'secondsBtn':
                currentValue = seconds.value;
                days.value = currentValue / 86400;
                hours.value = currentValue / 3600;
                minutes.value = currentValue / 60;
                break;
        }
    }
}