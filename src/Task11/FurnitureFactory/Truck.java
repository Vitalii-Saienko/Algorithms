package Task11.FurnitureFactory;

public class Truck {
    private int weightCapacity;

    public Truck(int capacity) {
        this.weightCapacity = capacity;
    }

    public int getWeightCapacity() {
        return weightCapacity;
    }

    public void setWeightCapacity(int weightCapacity) {
        this.weightCapacity = weightCapacity;
    }

    @Override
    public String toString() {
        return "{cargo space: " + weightCapacity + " kilogram}'";
    }
}
