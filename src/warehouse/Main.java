package warehouse;

import java.util.List;

/**
Съставете програма на избран от Вас език (C++, C#,SQL, Java, PHP) за
въвеждане на следната информация за продуктите в един склад. За всеки
продукт да се въведат: код, име на продукта, тегло в кг и цена в лева.

1-  Да се изведе списък с всички продукти, по-тежки от 10 кг., съдържащ код,
    име на продукта, тегло в кг и цена в лв.
2-  Да се намерят и изведат общото тегло и общата цена на стоките.
*/
record Product(String code, String name,int weight, double price) {
    @Override
    public String toString() {
        return "Product [code=" + code + ", name=" + name + ", weight=" + weight + "кг , price=" + price+"лв";
    }
}
public class Main {

    public static void main(String[] args) {
        Product product = new Product("1,", "a", 23, 32);

        Product product1 = new Product("2", "b", 45, 32);
        List<Product> products = List.of(product1, product);

        //1
        List<Product> list = products.stream().filter(p -> p.weight() > 10).toList();
        System.out.println(list);

        //2
        int totalWeight = products.stream().mapToInt(Product::weight).sum();
        double totalPrice = products.stream().mapToDouble(Product::price).sum();

        System.out.println(totalWeight);
        System.out.println(totalPrice);
    }
}
