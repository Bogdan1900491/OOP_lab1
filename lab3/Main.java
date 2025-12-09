package lab3;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();

        students.add(new Student(1, "Anna", 89.5));
        students.add(new Student(2, "Bohdan", 75.2));
        students.add(new Student(3, "Iryna", 92.3));
        students.add(new Student(1, "Oleh", 80.0));    // дубль id = 1
        students.add(new Student(2, "Maksym", 61.4));  // дубль id = 2

        System.out.println("=== Початковий список ===");
        students.forEach(System.out::println);

        students.sort(new GradeComparator());

        System.out.println("\n=== Відсортовано за спаданням averageGrade ===");
        students.forEach(System.out::println);

        HashSet<Student> studentSet = new HashSet<>(students);

        System.out.println("\n=== Вміст HashSet (дублікати за id зникли) ===");
        studentSet.forEach(System.out::println);
    }
}