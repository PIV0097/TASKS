package university;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class University {
    static public Optional<Student> lernJava(List<Student> students) {
        return students.stream()
                .filter(student -> student.getCourses().contains("Java"))
                .findFirst();
    }
    static public double averageStudents(List<Student> students){
        return students.stream()
                .mapToDouble(Student::getAge)
                .average()
                .orElse(0.0);
    }

    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Petr", 15, 3.5, List.of("Java", "Kotlin")),
                new Student("Pasha", 62, 4.2, List.of("Java", "Kotlin")),
                new Student("Pele", 17, 4.6, List.of("Kotlin")),
                new Student("Aura", 26, 5.0, List.of("Dart", "Kotlin")),
                new Student("Gena", 28, 4.7, List.of("Flutter", "Dart")),
                new Student("Reno", 30, 4.0, List.of("C++", "C1")),
                new Student("Misha", 18, 4.3, List.of("C#", "C", "Java"))
        );

        List<Student> bestStudent = students.stream()
                .filter(student ->
                        student.getAge() > 20 &&
                                student.getAverageGrade() > 4.5
                )
                .toList();

        System.out.println("Список отличников старше 20 лет:");
        bestStudent.forEach(student ->
                System.out.printf("""
                        Имя: %s
                        Возраст: %d
                        Средний балл: %.2f
                        Изучаемые языки: %s
                        """, student.getName(), student.getAge(), student.getAverageGrade(), String.join(", ", student.getCourses())));
        System.out.println();
        System.out.println("Список всех студентов:");
        students.stream()
                        .sorted(Comparator.comparingDouble(Student::getAverageGrade).reversed())
                                .map(Student::getName)
                                        .forEach(System.out::println);

        System.out.println();
        System.out.println("Студент, изучающий курс \"Java\"");
        lernJava(students).ifPresent(student -> System.out.printf("""
                 Имя: %s
                 Возраст: %d
                 Средний балл: %.2f
                """, student.getName(), student.getAge(), student.getAverageGrade()));

        System.out.println();
        System.out.println("Средний возраст студентов:");
        System.out.println(averageStudents(students));

    }
}
