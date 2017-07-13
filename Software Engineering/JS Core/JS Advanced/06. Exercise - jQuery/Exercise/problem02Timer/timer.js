function timer() {
    let hours = $('#hours');
    let minutes = $('#minutes');
    let seconds = $('#seconds');
    let startBtn = $('#start-timer');
    let stopBtn = $('#stop-timer');
    let interval = null;
    let counter = 0;
    let started = false;
    startBtn.on('click', startTimer);
    stopBtn.on('click', stopTimer);

    function startTimer() {
        if (!started) {
            interval = setInterval(tick, 1000);
            started = true;
        }

        function tick() {
            counter++;
            hours.text(('0' + Math.trunc(counter / 3600 % 24)).slice(-2));
            minutes.text(('0' + Math.trunc(counter / 60 % 60)).slice(-2));
            seconds.text(('0' + Math.trunc(counter % 60)).slice(-2));
        }
    }

    function stopTimer() {
        clearInterval(interval);
        started = false;
    }
}