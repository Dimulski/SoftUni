function drawHelix(length) {
    let result = '';
    let letters = ['A', 'T', 'C', 'G', 'T', 'T', 'A', 'G', 'G', 'G', 'A'];
    let widthCounter = 0;
    let letterCounter = 0;
    let reverse = false;
    for (let i = 0; i < length; i++) {
        if (letterCounter >= 9) {
            letterCounter = 0;
        }
        if (widthCounter === 2) {
            reverse = true;
        }
        if (widthCounter <= 0) {
            reverse = false;
        }

        switch (widthCounter) {
            case 0:
                result += '**' + letters[letterCounter] + letters[letterCounter + 1] + '**\n';
                break;
            case 1:
                result += '*' + letters[letterCounter] + '--' + letters[letterCounter + 1] + '*\n';
                break;
            case 2:
                result += letters[letterCounter] + '----' + letters[letterCounter + 1] + '\n';
        }

        if (reverse) {
            widthCounter--;
        } else {
            widthCounter++;
        }
        letterCounter += 2;
    }

    console.log(result);
}