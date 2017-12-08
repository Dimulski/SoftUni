var Ticket = /** @class */ (function () {
    function Ticket(destination, price, status) {
        this.destination = destination;
        this.price = price;
        this.status = status;
    }
    return Ticket;
}());
function manageTickets(tickets, sortingCriteria) {
    var ticketDatabase = new Array();
    console.log(ticketDatabase);
    tickets.forEach(function (ticketStr) {
        var ticketParams = ticketStr.split("|");
        var destinationName = ticketParams[0];
        var price = Number(ticketParams[1]);
        var status = ticketParams[2];
        var ticket = new Ticket(destinationName, price, status);
        ticketDatabase.push(ticket);
    });
    console.log(ticketDatabase.sort(function (a, b) {
        switch (sortingCriteria) {
            case 'destination': {
                return a.destination.localeCompare(b.destination);
            }
            case 'price': {
                return a.price - b.price;
            }
            case 'status': {
                return a.status.localeCompare(b.status);
            }
        }
    }));
}
manageTickets([
    'Philadelphia|94.20|available',
    'New York City|95.99|available',
    'New York City|95.99|sold',
    'Boston|126.20|departed'
], 'destination');
manageTickets(['Philadelphia|94.20|available',
    'New York City|95.99|available',
    'New York City|95.99|sold',
    'Boston|126.20|departed'], 'status');
