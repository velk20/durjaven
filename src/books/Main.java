package books;

import java.util.ArrayList;
import java.util.List;

/*Съставете програма на избран от Вас език (C++, C#, Java, PHP) за въвеждане на
следната информация за книгите в книжарница: номенклатурен номер, име на автор,
заглавие на книга, единична цена и година на издаване. Да се изведе списък с всички книги,
издадени след 2010 г., съдържащ  номенклатурен номер, име на автор, заглавие на книгата и година
на издаване. Да се намери и изведе средната цена на книга в книжарницата.*/
record Book(String id,String aName,String title,double price, int year ) { }
class Main {
    public static void main(String[] args) {
        Book book = new Book("1", "angel", "Harry Potter", 20, 2001);
        Book book1 = new Book("1", "angel", "Harry Potter", 20, 2011);

        List<Book> list = new ArrayList<>();
        list.add(book);
        list.add(book1);


        //1
        List<Book> list1 = list.stream().filter(b -> b.year() > 2010).toList();
        System.out.println(list1);

        //2
        System.out.println(list.stream().mapToDouble(Book::price).average().orElse(0));
    }
}
