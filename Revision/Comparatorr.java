import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student {
    private int rollNo;
    private String name;

    public Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                '}';
    }
}

public class Comparatorr {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(101, "Alice"));
        students.add(new Student(102, "Bob"));
        students.add(new Student(103, "Charlie"));

        // Sorting using Comparable (natural order by rollNo)
        System.out.println("Sorting by rollNo (natural order):");
        Collections.sort(students, Comparator.comparingInt(Student::getRollNo));
        printStudents(students);

        // Sorting by name using Comparator
        System.out.println("\nSorting by name (alphabetical order):");
        Collections.sort(students, Comparator.comparing(Student::getName));
        printStudents(students);

        // Sorting in reverse order by rollNo using Comparator.reverseOrder()
        System.out.println("\nSorting by rollNo in reverse order:");
        Collections.sort(students, Comparator.comparingInt(Student::getRollNo).reversed());
        printStudents(students);
          // Sorting by name, then by rollNo for students with the same name
          System.out.println("Sorting by name, then by rollNo:");
          Collections.sort(students,
                  Comparator.comparing(Student::getName)
                          .thenComparingInt(Student::getRollNo));
          printStudents(students);
  
          // Custom sorting logic: Sorting by name length
          System.out.println("\nSorting by name length:");
          Collections.sort(students, Comparator.comparingInt(student -> student.getName().length()));
          printStudents(students);
    }

    private static void printStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

/*
 * import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> numbers = new ArrayList<>();
        numbers.add("10");
        numbers.add("3");
        numbers.add("25");
        numbers.add("1");

        // Sorting the list numerically using subtraction
        System.out.println("Sorting numbers numerically without Integer.compare:");
        Collections.sort(numbers, (s1, s2) -> Integer.parseInt(s1) - Integer.parseInt(s2));
        or
         Collections.sort(numbers, (s1, s2) -> Integer.compare(Integer.parseInt(s1), Integer.parseInt(s2)));
         or
          Collections.sort(numbers, Comparator.comparingInt(Integer::parseInt));
        printList(numbers);
    }

    private static void printList(List<String> list) {
        for (String element : list) {
            System.out.println(element);
        }
    }
}

 */
