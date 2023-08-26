package greedyAlgorithm.Vacation;

public class Vacation {
    private int placeRating;
    private int days;
    private String name;

    public Vacation(int placeRating, int days, String name) {
        this.placeRating = placeRating;
        this.days = days;
        this.name = name;
    }

    public int getPlaceRating() {
        return placeRating;
    }

    public int getDays() {
        return days;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + ", rating = " + placeRating + ", days to spent there = " + days;
    }
}
