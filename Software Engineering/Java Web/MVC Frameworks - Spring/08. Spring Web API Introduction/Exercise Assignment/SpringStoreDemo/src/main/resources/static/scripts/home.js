window.onload = function () {

    function buy(id) {
        //TODO: Implement the function
    }

    function trailer(id) {
        //TODO: Implement the function
    }

    $(".btn-trailer").click(trailerOnClick);
    $(".btn-buy").click(buyOnClick);

    function trailerOnClick(event)  {
        let element = $(event.target);
        let id = element.attr('data-id');
        trailer(id);
    }

    function buyOnClick(event)  {
        let element = $(event.target);
        let id = element.attr('data-id');
        buy(id);
    }

};
