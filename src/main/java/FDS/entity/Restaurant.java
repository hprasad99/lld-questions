package FDS.entity;

public class Restaurant {
    private int id;
    private String name;
    private float rating;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getNumRatings() {
        return numRatings;
    }

    public void setNumRatings(int numRatings) {
        this.numRatings = numRatings;
    }

    public Restaurant(int id, String name, float rating, int numRatings) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.numRatings = numRatings;
    }

    public Restaurant() {
    }

    private int numRatings;


}
