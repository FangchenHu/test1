import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("students.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0];
                int age = Integer.parseInt(parts[1]);
                int grade = Integer.parseInt(parts[2]);
                students.add(new Student(name, age, grade));
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }

        StudentManagementSystem sms = new StudentManagementSystem(students);

        System.out.println("All students:");
        for (Student student : sms.getStudents()) {
            System.out.println(student.getName() + " " + student.getAge() + " " + student.getGrade());
        }

        Student student1 = sms.findStudentByName("Alice");
        if (student1 != null) {
            System.out.println("Found student: " + student1.getName() + " " + student1.getAge() + " " + student1.getGrade());
        } else {
            System.out.println("Student not found.");
        }

        sms.removeStudent(student1);

        System.out.println("All students after removing Alice:");
        for (Student student : sms.getStudents()) {
            System.out.println(student.getName() + " " + student.getAge() + " " + student.getGrade());
        }

        System.out.println("Average score: " + sms.getAverageScore());
        System.out.println("Highest score: " + sms.getHighestScore());
        System.out.println("Lowest score: " + sms.getLowestScore());

    }
}
