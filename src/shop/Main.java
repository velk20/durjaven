package shop;

import java.util.*;

/**
 * Съставете програма на избран от Вас език (C++, C#, Java, PHP) за въвеждане на следната
информация за стоките в един магазин: код, наименование на стоката, размери в мм
(Ширина, Дължина, Височина - три отделни стойности), бройки и единична цена.

 Да се изведе списък с всички стоки с наличност над 50 бройки, съдържащ код, наименование
на стоката, размери в мм (във формат Ш х Д х В), бройки и единична цена.
 Да се намери
и изведе общата цена на всички стоки в магазина.*/

record Stock(String id,String name, Metrics metrics , int volume, double price){}

record Metrics(int h, int w, int l) {
    @Override
    public String toString() {
        return w + "x" + h + "x" + l + "mm";
    }
}

public class Main {
    static Stock createStock(Scanner scanner){
        System.out.print("Product id: ");
        String id = scanner.nextLine();
        System.out.print("Product name: ");
        String name = scanner.nextLine();
        System.out.print("Product metrics H:");
        int h = Integer.parseInt(scanner.nextLine());
        System.out.print("Product metrics W:");
        int w = Integer.parseInt(scanner.nextLine());
        System.out.print("Product metrics L:");
        int l = Integer.parseInt(scanner.nextLine());
        System.out.print("Product volume: ");
        int v = Integer.parseInt(scanner.nextLine());
        System.out.print("Product price: ");
        double price = Double.parseDouble(scanner.nextLine());

        return new Stock(id, name, new Metrics(h, w, l), v, price);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Stock> stocks = new ArrayList<>();

        System.out.print("Enter number of products: ");

        int products = Integer.parseInt(scanner.nextLine());
        while (products > 0) {
            stocks.add(createStock(scanner));
            products--;
        }


        //1
        List<Stock> list = stocks.stream().filter(s -> s.volume() > 50).toList();
        System.out.println("Products with more that 50 quantity: " + list);

        //2
        System.out.println("Sum of prices of products: " + stocks.stream()
                .mapToDouble(Stock::price)
                .sum());
    }
}
