function highlight(selector) {
    let deepestPath = 0;
    let deepestElement;
    let allInnerElements = $(`${selector} *:not(:has(*))`);
    allInnerElements.each(function (index, element){
        let currentLevel = 0;
        let initialElement = element;
        while(element){
            currentLevel++;
            element = $(element).parent()[0];
        }
        if(currentLevel > deepestPath){
            deepestPath = currentLevel;
            deepestElement = initialElement;
        }
    });
    let selectedElement = $(selector)[0];
    while(deepestElement &&  deepestElement !== selectedElement){
        $(deepestElement).addClass('highlight');
        deepestElement = $(deepestElement).parent()[0];
    }
    $(selector).addClass('highlight');
}