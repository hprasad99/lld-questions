class Payment {
    #amount;
    #status;
    #timestamp;

    constructor(amount, status, timestamp) {
        if(this.constructor == Payment) {
            throw new Error("Abstract clases can't be instatiated.")
        } else {
            this.#amount = amount;
            this.#status = status;
            this.#timestamp = timestamp;
        }
    }

    initiateTransaction() {}
}