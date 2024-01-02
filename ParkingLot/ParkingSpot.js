class ParkingSpot {
    #id;
    #isFree;
    #vehicle;

    constructor(id, isFree, vehicle) {
        if(this.constructor == ParkingSpot) {
            throw new Error("Abstract class can't be instantiated");
        } else {
            this.#id = id;
            this.#isFree = isFree;
            this.#vehicle = vehicle;
        }
    }

    getIsFree() {}
    assignVehicle() {}
    removeVehicle() {}
}