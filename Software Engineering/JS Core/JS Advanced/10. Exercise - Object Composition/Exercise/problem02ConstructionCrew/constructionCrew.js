let worker = {
    weight: 80,
    experience: 1,
    bloodAlcoholLevel: 0,
    handsShaking: true
};

function fixHandShakiness(worker) {
    if (worker.handsShaking === true) {
        let desiredAlcoholLevel = 0.1 * worker.weight * worker.experience;
        worker.bloodAlcoholLevel += desiredAlcoholLevel;
        worker.handsShaking = false;
    }

    return worker;
}

console.log(fixHandShakiness(worker));