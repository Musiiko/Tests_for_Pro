package homework8.model;

public class Bus extends Car {
    private double passengerCapacity;


    public Bus(double maxSpeed, double price, String model, String color,
               double fuelConsumption, double passengerCapacity) {
        super(maxSpeed, price, model, color, fuelConsumption);
        this.passengerCapacity = passengerCapacity;

    }

    @Override
    public String toString() {
        return "Max speed: " + getMaxSpeed() + "\nPrice: " + getPrice() +
                "\nModel: " + getModel() + "\nColor: " + getColor() +
                "\nFuel consumption: " + getFuelConsumption() +
                "\nNumber of passengers: " + passengerCapacity + "\n";
    }

    public double getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(double passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

}