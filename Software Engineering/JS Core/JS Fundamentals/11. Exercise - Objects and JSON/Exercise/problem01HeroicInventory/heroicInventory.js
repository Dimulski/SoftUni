function heroicInventory(input) {
    let heroData = [];
    for (let i = 0; i < input.length; i++) {
        let currentHeroArguments = input[i].split(" / ");

        let currentHeroName = currentHeroArguments[0];
        let currentHeroLevel = Number(currentHeroArguments[1]);
        let currentHeroItems = [];
        if (currentHeroArguments.length > 2) {
            currentHeroItems = currentHeroArguments[2].split(", ");
        }

        let hero = {
            name: currentHeroName,
            level: currentHeroLevel,
            items: currentHeroItems
        };
        heroData.push(hero);
    }

    console.log(JSON.stringify(heroData));
}