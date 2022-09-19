package homework8;
/* Таксопарк. Определить иерархию автомобилей. Создать таксопарк.
Подсчитать стоимость автопарка. Провести сортировку автомобилей парка по расходу топлива.
Найти автомобили в компании, соответствующие заданному диапазону параметров скорости.
Для каждого класса автомобилей определить toString() и использовать его для печати объекта.
Сделать таксопарк интерфейсом, определить в нем действия, которые должен выполнять таксопарк.
Создать конкретный таксопарк который будет реализовывать интерфейс таксопарка.
Грамотно распределить по пакетам классы.
- базовый класс транспортного средства абстрактный;
- каждый наследник должен определять новые свойства(свойство);
- в классе таксопарка ничего не печатать!!!(System.out.println());
- массив, который будет возвращен методом поиска автомобилей по скорости расширять
динамически(не считать сразу кол-во подходящих под критерий автомобилей);
- в метод по поиску машин по диапазону задавать min и max скорость и проверять,
входит ли максимальная скорость текущего автомобиля в диапазон;
- сортировка своя (Arrays.sort не использовать);
- System.arrayсopy не использовать;
- написать JUnit тесты; */

import homework8.model.Bus;
import homework8.model.Car;
import homework8.model.DreamCar;
import homework8.model.Truck;
import homework8.processor.CarPark;

public class Main {
    public static void main(String[] args) {
        double maxSpeedAllowed = 220;
        double minSpeed = 150;
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

        System.out.println("Full car park :\n");
        printCars(cars);

        System.out.println("Sorted car park:\n");
        printCars(park.fuelConsumptionSort());

        System.out.println("Cars from the range (" + minSpeed + " - " + maxSpeedAllowed + " km/h):\n");
        Car[] fitsTheRange = park.fitsRange(minSpeed, maxSpeedAllowed);
        printCars(fitsTheRange);

        System.out.println("Car park cost: " + park.parkCost());
    }

    public static void printCars(Car[] car) {
        for (Car iterator : car) {
            System.out.println(iterator);
        }
    }

}
