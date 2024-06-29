package employees;

import java.util.*;

record Employee (String name, String lName, int year, double salary, int workDays){}
public class Main {
    public static void main(String[] args) {
        List<Employee> list = List.of(
                new Employee("Angel", "Mladenov", 1999, 2500, 20),
                new Employee("Angel1", "Mladenov1", 1980, 2500, 20),
                new Employee("Angel5", "Mladenov5", 1997, 2600, 20)
        );

        double averageSalary = list.stream().mapToDouble(Employee::salary).average().orElse(0);

        System.out.println(list.stream()
                .filter(e->e.year() > 1990 && e.salary()>averageSalary)
                .toList());
    }
}