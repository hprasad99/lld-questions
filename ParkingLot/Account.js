class Account {
    #username;
    #password;
    #person;
    #status;

    constructor(username, password, person, status) {
        if(this.constructor == Account) {
            throw new Error("Abstract classes can't be instantiated.");
        } else {
            this.#username = username;
            this.#password = password;
            this.#person = person;
            this.#status = status;
        }
    }

    resetPassword() {}
}