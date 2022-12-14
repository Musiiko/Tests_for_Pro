package homework8.processor;

import homework8.model.Car;

public class CarPark implements CarParkProcessor {
    private Car[] cars;

    private Car[] fitsRange;

    public CarPark(Car[] cars) {
        this.cars = cars;
    }

    @Override
    public double parkCost() {
        double sum = 0;
        for (Car car : cars) {
            sum += car.getPrice();
        }
        return sum;
    }

    @Override
    public Car[] fuelConsumptionSort() {
        Car[] carsCopy = cars;
        for (int k = 0; k < carsCopy.length; k++) {
            for (int i = 1; i < carsCopy.length; i++) {
                if (carsCopy[i - 1].getFuelConsumption() > carsCopy[i].getFuelConsumption()) {
                    Car temp = carsCopy[i - 1];
                    carsCopy[i - 1] = carsCopy[i];
                    carsCopy[i] = temp;
                }
            }
        }
        return carsCopy;
    }

    @Override
    public Car[] fitsRange(double minSpeed, double maxSpeedAllowed) {
        Car[] resultArray = new Car[]{};
        for (Car car : cars) {
            if (car.getMaxSpeed() <= maxSpeedAllowed && car.getMaxSpeed() >= minSpeed) {
                resultArray = pushBack(car, resultArray);
            }
        }
        return resultArray;
    }

    private Car[] pushBack(Car car, Car[] carArray) {
        Car[] resultArray = new Car[carArray.length + 1];
        arrayCopy(carArray, resultArray);
        resultArray[resultArray.length - 1] = car;
        return resultArray;
    }

    private void arrayCopy(Car[] copyFromArray, Car[] copyToArray) {
        for (int i = 0; i < Math.min(copyFromArray.length, copyToArray.length); i++) {
            copyToArray[i] = copyFromArray[i];
        }
    }

    public Car[] getCars() {
        return cars;
    }

    public void setCars(Car[] cars) {
        this.cars = cars;
    }

    public Car[] getFitsRange() {
        return fitsRange;
    }

    public void setFitsRange(Car[] fitsRange) {
        this.fitsRange = fitsRange;
    }
}
