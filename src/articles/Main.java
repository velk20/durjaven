package articles;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Съставете програма на избран от Вас език (C++, C#, Java, PHP) за въвеждане на списък от артикули,
 които се задават чрез име (низ) и единична цена (реално число). Намерете в списъка артикула с
 най-ниска цена и изведете информацията за него във вида: име и цена. Ако има повече от един
 артикул със същата цена, изведете списък с имената на всички тези артикули.
 */

record Article(String name, double price) {}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of articles: ");
        int n = Integer.parseInt(sc.nextLine());
        List<Article> articles = new ArrayList<>();

        while (n > 0) {
            System.out.print("Enter article name: ");
            String name = sc.nextLine();
            System.out.print("Enter article price: ");
            double price = Double.parseDouble(sc.nextLine());
            articles.add(new Article(name, price));
            n--;
        }

        double lowestPrice = Double.MAX_VALUE;
        List<Article> lowestArticles = new ArrayList<>();
        for (Article article : articles) {
            if (article.price() < lowestPrice) {
                lowestPrice = article.price();
                lowestArticles.clear();
                lowestArticles.add(article);
            } else if (article.price() == lowestPrice) {
                lowestArticles.add(article);
            }
        }

        if (lowestArticles.size() > 1) {
            System.out.println(lowestArticles);
        }else {
            System.out.println(lowestArticles.get(0));
        }
    }
}
