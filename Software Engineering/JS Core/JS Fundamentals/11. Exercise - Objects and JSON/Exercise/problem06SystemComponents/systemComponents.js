function buildOrderedDatabase(input) {
    let systemsComponents = new Map();
    for (let line of input) {
        let [system, component, subcomponent] = line.split(' \| ');

        if (!systemsComponents.has(system)) {
            systemsComponents.set(system, new Map());
        }
        if (!systemsComponents.get(system).has(component)) {
            systemsComponents.get(system).set(component, []);
        }

        systemsComponents.get(system).get(component).push(subcomponent);
    }

    let result = [];
    let sortedSystemsArray = Array.from(systemsComponents.keys()).sort((a, b) => {
        if (systemsComponents.get(a).size !== systemsComponents.get(b).size) {
            return systemsComponents.get(b).size - systemsComponents.get(a).size;
        } else {
            if (a < b) {
                return -1;
            } else if (a > b) {
                return 1;
            }
            return 0;
        }
    });

    sortedSystemsArray.forEach(s => {
        result.push(s);
        let sortedComponents = [...systemsComponents.get(s)].sort((a, b) => b[1].length - a[1].length);
        sortedComponents.forEach(c => {
            result.push(`|||${c[0]}`);
            c[1].forEach(s => result.push(`||||||${s}`));
        })
    });

    console.log(result.join('\n'));
}