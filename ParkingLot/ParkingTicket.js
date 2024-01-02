class ParkingTicket {
    #ticketNo;
    #timestamp;
    #exit;
    #amount;
    #status;
    #vehicle;
    #payment;
    #entrance;
    #exitIns;

    constructor(ticketNo, timestamp, exit, amount, status, vehicle, payment, entrance, exitIns) {
        this.#ticketNo = ticketNo;
        this.#timestamp = timestamp;
        this.#amount = amount;
        this.#exit = exit;
        this.#status = status;

        this.#vehicle = vehicle;
        this.#payment = payment;
        this.#entrance = entrance;
        this.#exitIns = exitIns;
    }
}