package homework8.model;

public class DreamCar extends Car {
    private boolean fourDoored;

    public DreamCar(double maxSpeed, double price, String model, String color,
                    double fuelConsumption, boolean fourDoored) {
        super(maxSpeed, price, model, color, fuelConsumption);
        this.fourDoored = fourDoored;
    }

    @Override
    public String toString() {
        return "Max speed: " + getMaxSpeed() + "\nPrice: " + getPrice() +
                "\nModel: " + getModel() + "\nColor: " + getColor() +
                "\nFuel consumption: " + getFuelConsumption() +
                "\nFour doored: " + fourDoored + "\n";
    }

    public boolean isFourDoored() {
        return fourDoored;
    }

    public void setFourDoored(boolean fourDoored) {
        this.fourDoored = fourDoored;
    }

}