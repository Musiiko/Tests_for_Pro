package homework8.model;

public class Truck extends Car {
    private double loadCapacity;
    private double height;

    public Truck(double maxSpeed, double price, String model, String color,
                 double fuelConsumption, double loadCapacity, double height) {
        super(maxSpeed, price, model, color, fuelConsumption);
        this.loadCapacity = loadCapacity;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Max speed: " + getMaxSpeed() + "\nPrice: " + getPrice() +
                "\nModel: " + getModel() + "\nColor: " + getColor() +
                "\nFuel consumption: " + getFuelConsumption() +
                "\nLoad capacity: " + loadCapacity +
                "\nHeight: " + height + "\n";
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

}
