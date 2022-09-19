package homework8.processor;


import homework8.model.Car;

public interface CarParkProcessor {
    double parkCost();

    Car[] fuelConsumptionSort();

    Car[] fitsRange(double minSpeed, double maxSpeedAllowed);
}