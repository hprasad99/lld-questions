class Address {
    #zipcode;
    #address;
    #city;
    #state;
    #country;

    constructor(zipcode, address, city, state, country) {
        this.#address = address;
        this.#zipcode = zipcode;
        this.#city = city;
        this.#state = state;
        this.#country = country;
    }
}