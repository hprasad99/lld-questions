package FoodDeliverySystem.entity;

public class Rating {

    User user;
    int rating;
    String comment;

    public Rating(int rating, String comment) {
        this.rating = rating;
        this.comment = comment;
    }

    public int getRating() {
        return rating;
    }
}
