package library;


import java.util.ArrayList;
import java.util.List;

/**
82.	Съставете програма на избран от Вас език (C#, Java, SQL, PHP)
за обработване на информация за книги, които се задават чрез име,
автор, година на издаване, цена и брой страници.
Изведете списък с книгите, издадени след 2015г.
и с цена над средната.
*/
record Book(String title, String author, int year, double price, int pages) {}
public class Main {
    public static void main(String[] args) {
        Book b1 = new Book("12", "das", 2016, 200, 205);
        Book b2 = new Book("12", "das", 2016, 250, 205);

        List<Book> books = List.of(b1, b2);

        double avgPrice = books.stream()
                .mapToDouble(Book::price)
                .average()
                .orElse(0);

        System.out.println(books.stream().filter(b -> b.year() > 2015 && b.price() > avgPrice).toList());
    }
}
