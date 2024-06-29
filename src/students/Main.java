package students;

import java.util.ArrayList;
import java.util.List;

/**
 * //60. Съставете програма на избран от Вас език (C#, Java, SQL, PHP),
 * // която обработва данни за кандидат-студенти.
 * // За всеки кандидат-студент се записват входящ номер, име, фамилия, град, телефон, успех от дипломата.
 * //а. Дефинирайте структура за съхранение на данни
 * //b. Запишете информация за 3 кандидат-студенти
 * //с. Изведете информация за кандидат-студентите, които са с успех от дипломата над 5.00 Фамилията им съдържа низа "петров"
 */

record Student(String name, int age) {}
public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("John", 18));
        students.add(new Student("Jane", 18));
        students.add(new Student("Jack", 18));
        students.add(new Student("Jill", 18));

        System.out.println(students
                .stream()
                .filter(s -> s.name().contains("Ja") && s.age() >= 18)
                .toList());
    }
}
