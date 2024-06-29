package gasoline;

import java.time.LocalDate;
import java.util.*;

/**
 * Съставете програма на избран от Вас език (C++, C#, Java, PHP)
 * за въвеждане на следната информация за зареждането на гориво в един автомобил.
 * За всяко зареждане да се въведат: дата, количество в литри и цена в лева.
 * - Да сеизведе списък с всички зареждания с цена над 100 лв., съдържащ дата, количество в
 * литри и цена в лв. За изведените зареждания, да се намерят и изведат общото тегло
 * в кг. (ако знаем, че един литър гориво тежи 0.75 кг) и общата цена в лв.
 */

record Fillup(LocalDate date, double liters, double price) {

}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Fillup> list = new ArrayList<>();
        System.out.print("Enter count fillups: ");
        int count = sc.nextInt();
        while (count > 0) {
            System.out.print("Year: ");
            int year = sc.nextInt();
            System.out.print("Month: ");
            int month = sc.nextInt();
            System.out.print("Day: ");
            int day = sc.nextInt();
            System.out.print("Liters: ");
            double liters = sc.nextDouble();
            System.out.print("Price: ");
            double price = sc.nextDouble();
            list.add(new Fillup(LocalDate.of(year, month, day), liters, price));

            count--;
        }

        //1
        List<Fillup> list1 = list.stream().filter(f -> f.price() > 100).toList();
        System.out.println(list1);

        //2
        double allLiters = list1.stream().mapToDouble(Fillup::liters).sum();
        System.out.println(allLiters * 0.75);

        //3
        double total = list1.stream().mapToDouble(Fillup::price).sum();
        System.out.println("Total: " + total+" лв.");
    }
}
