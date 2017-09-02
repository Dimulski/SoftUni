function attachEvents() {
    const username = "pesho";
    const password = "pass123";
    const authHeader = {
        'Authorization': 'Basic ' + btoa(`${username}:${password}`),
        'Content-type': 'application/json'
    };
    $('.load').click(listAllCatches);
    $('.add').click(addCatch);

    async function listAllCatches() {
        let catches = await $.ajax({
            url: 'https://baas.kinvey.com/appdata/kid_SyAKsv7uW/biggestCatches',
            headers: authHeader
        });
        let catchContainer = $('#catches');
        catchContainer.empty();
        for (let fishCatch of catches) {
            let catchElement = $(`<div class="catch" data-id="${fishCatch._id}">`)
                .append($('<label>Angler</label>'))
                .append($(`<input type="text" class="angler" value="${fishCatch.angler}"/>`))
                .append($('<label>Weight</label>'))
                .append($(`<input type="number" class="weight" value="${fishCatch.weight}"/>`))
                .append($('<label>Species</label>'))
                .append($(`<input type="text" class="species" value="${fishCatch.species}"/>`))
                .append($('<label>Location</label>'))
                .append($(`<input type="text" class="location" value="${fishCatch.location}"/>`))
                .append($('<label>Bait</label>'))
                .append($(`<input type="text" class="bait" value="${fishCatch.bait}"/>`))
                .append($('<label>Capture Time</label>'))
                .append($(`<input type="number" class="captureTime" value="${fishCatch.captureTime}"/>`))
                .append($('<button class="update">Update</button>').click(updateCatch))
                .append($('<button class="delete">Delete</button>').click(deleteCatch))
                .appendTo(catchContainer);
        }
    }

    async function updateCatch() {
        let catchElement = $(this).parent();
        let catchJSON = createDataJSON(catchElement);
        $.ajax({
            method: 'PUT',
            url: `https://baas.kinvey.com/appdata/kid_SyAKsv7uW/biggestCatches/${catchElement.attr('data-id')}`,
            headers: authHeader,
            data: JSON.stringify(catchJSON)
        });
    }
    
    async function deleteCatch() {
        let catchElement = $(this).parent();
        $.ajax({
            method: 'DELETE',
            url: `https://baas.kinvey.com/appdata/kid_SyAKsv7uW/biggestCatches/${catchElement.attr('data-id')}`,
            headers: authHeader,
            complete: catchElement.remove()
        })
    }
    
    function addCatch() {
        let catchElement = $('#addForm');
        let dataObj = createDataJSON(catchElement);
        $.ajax({
            method: "POST",
            url: 'https://baas.kinvey.com/appdata/kid_SyAKsv7uW/biggestCatches',
            headers: authHeader,
            data: JSON.stringify(dataObj),
            complete: listAllCatches
        })
    }

    function createDataJSON(catchElement) {
        return {
            captureTime: Number(catchElement.find('.captureTime').val()),
            bait: catchElement.find('.bait').val(),
            location: catchElement.find('.location').val(),
            species: catchElement.find('.species').val(),
            weight: Number(catchElement.find('.weight').val()),
            angler: catchElement.find('.angler').val(),
        };
    }

    function handleError(error) {
        console.warn(error);
    }
}