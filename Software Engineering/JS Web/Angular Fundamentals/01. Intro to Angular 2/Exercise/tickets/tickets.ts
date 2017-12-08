class Ticket {
  destination: string;
  price: number;
  status: string;

  constructor(destination, price, status) {
    this.destination = destination;
    this.price = price;
    this.status = status;
  }
}

function manageTickets(tickets: Array<string>, sortingCriteria: string) {
  let ticketDatabase: Array<Ticket> = new Array();
  console.log(ticketDatabase);
  tickets.forEach(ticketStr => {
    let ticketParams = ticketStr.split("|");
    let destinationName: string = ticketParams[0];
    let price: number = Number(ticketParams[1]);
    let status: string = ticketParams[2];
    let ticket: Ticket = new Ticket(destinationName, price, status);
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
'Boston|126.20|departed'],
'destination');

manageTickets(['Philadelphia|94.20|available',
'New York City|95.99|available',
'New York City|95.99|sold',
'Boston|126.20|departed'],
'status');