function moviePrices([title, day]) { // why
    let theGodfather = [12, 10, 15, 12.50, 15, 25, 30];
    let schindlersList = [8.50, 8.50, 8.50, 8.50, 8.50, 15, 15];
    let casablanca = [8, 8, 8, 8, 8, 10, 10];
    let theWizardOfOz = [10, 10, 10, 10, 10, 15, 15];
    switch (title.toLowerCase()) {
        case 'the godfather':
            switch (day.toLowerCase()) {
                case 'monday':
                    console.log(theGodfather[0]);
                    break;
                case 'tuesday':
                    console.log(theGodfather[1]);
                    break;
                case 'wednesday':
                    console.log(theGodfather[2]);
                    break;
                case 'thursday':
                    console.log(theGodfather[3]);
                    break;
                case 'friday':
                    console.log(theGodfather[4]);
                    break;
                case 'saturday':
                    console.log(theGodfather[5]);
                    break;
                case 'sunday':
                    console.log(theGodfather[6]);
                    break;
                default: console.log('error');
                    break;
            }
            break;
        case 'schindler\'s list':
            switch (day.toLowerCase()) {
                case 'monday':
                    console.log(schindlersList[0]);
                    break;
                case 'tuesday':
                    console.log(schindlersList[1]);
                    break;
                case 'wednesday':
                    console.log(schindlersList[2]);
                    break;
                case 'thursday':
                    console.log(schindlersList[3]);
                    break;
                case 'friday':
                    console.log(schindlersList[4]);
                    break;
                case 'saturday':
                    console.log(schindlersList[5]);
                    break;
                case 'sunday':
                    console.log(schindlersList[6]);
                    break;
                default: console.log('error');
                    break;
            }
            break;
        case 'casablanca':
            switch (day.toLowerCase()) {
                case 'monday':
                    console.log(casablanca[0]);
                    break;
                case 'tuesday':
                    console.log(casablanca[1]);
                    break;
                case 'wednesday':
                    console.log(casablanca[2]);
                    break;
                case 'thursday':
                    console.log(casablanca[3]);
                    break;
                case 'friday':
                    console.log(casablanca[4]);
                    break;
                case 'saturday':
                    console.log(casablanca[5]);
                    break;
                case 'sunday':
                    console.log(casablanca[6]);
                    break;
                default: console.log('error');
                    break;
            }
            break;
        case 'the wizard of oz':
            switch (day.toLowerCase()) {
                case 'monday':
                    console.log(theWizardOfOz[0]);
                    break;
                case 'tuesday':
                    console.log(theWizardOfOz[1]);
                    break;
                case 'wednesday':
                    console.log(theWizardOfOz[2]);
                    break;
                case 'thursday':
                    console.log(theWizardOfOz[3]);
                    break;
                case 'friday':
                    console.log(theWizardOfOz[4]);
                    break;
                case 'saturday':
                    console.log(theWizardOfOz[5]);
                    break;
                case 'sunday':
                    console.log(theWizardOfOz[6]);
                    break;
                default: console.log('error');
                    break;
            }
            break;
        default : console.log('error');
    }
}