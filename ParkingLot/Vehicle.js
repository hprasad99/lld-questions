class Vehicle {
    #licenseNo;

    constructor(licenseNo) {
        if(this.constructor == Vehicle) {
            throw new Error("Abstract classes can't be instantiated.");
        } else {
            this.#licenseNo = licenseNo;
        }
    }

    assignTicket(ticket) {}
}