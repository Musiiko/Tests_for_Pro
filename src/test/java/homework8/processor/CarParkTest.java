package homework8.processor;

import homework8.model.Bus;
import homework8.model.Car;
import homework8.model.DreamCar;
import homework8.model.Truck;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarParkTest {
    @Test
    public void testParkCost() {
        double expectedCost = 267500.0;
        Car[] cars = new Car[4];
        cars[0] = new Truck(160, 50000, "MAN", "white", 30,
                30, 2.6);
        cars[1] = new DreamCar(200, 80000, "BMW", "black", 32,
                true);
        cars[2] = new Bus(120, 67000, "Mercedes", "grey",
                33, 60);
        cars[3] = new Truck(180, 70500, "Mercedes", "green", 35,
                35, 3.2);
        CarPark park = new CarPark(cars);
        assertEquals(park.parkCost(), expectedCost);
    }

    @Test
    public void testFuelConsumptionSort() {
        Car[] cars = new Car[4];
        cars[0] = new Truck(160, 50000, "MAN", "white", 30,
                30, 2.6);
        cars[1] = new DreamCar(200, 80000, "BMW", "black", 32,
                true);
        cars[2] = new Bus(120, 67000, "Mercedes", "grey",
                33, 60);
        cars[3] = new Truck(180, 70500, "Mercedes", "green", 35,
                35, 3.2);
        CarPark park = new CarPark(cars);
        Car[] sortedArray = {cars[0], cars[1], cars[2], cars[3]};
        assertEquals(park.fuelConsumptionSort(), sortedArray);
    }

    @Test
    public void testFitsRange() {
        Car[] cars = new Car[4];
        cars[0] = new Truck(160, 50000, "MAN", "white", 30,
                30, 2.6);
        cars[1] = new DreamCar(200.0, 80000, "BMW", "black", 32,
                true);
        cars[2] = new Bus(120, 67000, "Mercedes", "grey",
                33, 60);
        cars[3] = new Truck(180, 70500, "Mercedes", "green", 35,
                35, 3.2);
        CarPark park = new CarPark(cars);
        Car[] expectedArray = {cars[0], cars[1], cars[3]};
        double maxSpeedAllowed = 220.0;
        double minSpeed = 150.0;
        assertEquals(park.fitsRange(minSpeed, maxSpeedAllowed), expectedArray);
    }

}