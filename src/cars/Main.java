package cars;

import java.util.ArrayList;
import java.util.List;

/**
 * 83.	Съставете програма на избран от Вас език
 * (C#, Java, SQL, PHP), която обработва данни за авто борса.
 * За всеки автомобил се записват рег.номер, марка, модел, цвят, цена,
 * година на производство, двигател (бензин/дизел).
 * ●	Дефинирайте подходяща структура за съхранение на данните;
 * ●	Въведете инфо за 3 автомобила;
 * 	Изведете инфо за автомобилите с марка “Kia”, които са произведени между 2012 и 2015 година,
 * 	и регистрационният им номер започва с низа “PB”
 */

enum CarType {DIESEL,GASOLINE}

record Car(String plate, String brand, String model, String color, double price, int year, CarType carType) { }

public class Main {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("PB123", "dsa", "213", "blue", 2500, 2001, CarType.DIESEL));
        cars.add(new Car("PB", "Kia", "213", "blue", 2500, 2001, CarType.DIESEL));
        cars.add(new Car("PB123", "Kia", "213", "blue", 2500, 2013, CarType.DIESEL));

        List<Car> list = cars.stream()
                .filter(c -> c.brand().equals("Kia")
                        && c.year() >= 2012
                        && c.year() <= 2015
                        && c.plate().startsWith("PB"))
                .toList();

        System.out.println(list);
    }
}
