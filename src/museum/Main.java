package museum;

import java.util.ArrayList;
import java.util.List;

/*Съставете програма на избран от Вас език (C++, C#, Java, PHP) за въвеждане на следната
информация за експонатите в един музей: код, наименование на експоната, размери в метри
(Ширина, Дължина, Височина - три отделни числови стойности), датировка (цяло число – в години, например
1918 за 1918-та година, -400 за 400 година пр. н.е.) и оценка(цена) в лева.
Да се изведе списък с всички
експонати с височина по-голяма от 1 метър, съдържащ код, наименование на експоната, размери (във формат Ш х Д х В),
датировката (във формат „ГГГГ г.“ или „ГГГГ г. пр. н.е“ в зависимост от датировката) и оценка(цена) в лева.

Да се изведе списък с всички експонати с датировка преди новата ера, съдържащ код, наименование на експоната,
размери (във формат Ш х Д х В), датировката (във формат „ГГГГ г.“ или „ГГГГ г. пр. н.е“ в зависимост от датировката)
и оценка(цена) в лева.

Да се намери и изведе общата цена (на база на оценките) на всички експонати в музея (в хиляди левове).*/

record Metrics(int w, int l, int h) {}

record Museum(String identifier, String name, Metrics metrics, int year, double price) {
    @Override
    public String toString() {
        return "Museum{" +
                "identifier='" + identifier + '\'' +
                ", name='" + name + '\'' +
                ", metrics=> W:" + metrics.w() + ",L:" + metrics.l() + ",H:" + metrics.h()+
                ", year=" + year + "г. "+ (this.year <0 ? "пр. н.е" : "") +
                ", price=" + price +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        Museum m1 = new Museum("1", "art1", new Metrics(1, 2, 3), -2001, 200);
        Museum m2 = new Museum("2", "art2", new Metrics(1, 2, 4), 2022, 2020);
        List<Museum> list = new ArrayList<>();
        list.add(m1);
        list.add(m2);

        List<Museum> list1 = list.stream().filter(m -> m.metrics().h() > 1).toList();
        System.out.println(list1);

        List<Museum> list2 = list.stream().filter(m -> m.year() < 0).toList();
        System.out.println(list2);

        double totalPrice = list.stream().mapToDouble(Museum::price).sum();

        System.out.println("Total price: " + totalPrice);

    }


}
