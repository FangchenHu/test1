import java.util.List;

public class StudentManagementSystem {
    private List<Student> students;

    public StudentManagementSystem(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public void updateStudent(Student student) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equals(student.getName())) {
                students.set(i, student);
                break;
            }
        }
    }

    public Student findStudentByName(String name) {
        for (Student student : students) {
            if (student.getName().equals(name)) {
                return student;
            }
        }
        return null;
    }

    public List<Student> getStudents() {
        return students;
    }

    public double getAverageScore() {
        double sum = 0.0;
        for (Student student : students) {
            sum += student.getGrade();
        }
        return sum / students.size();
    }

    public int getHighestScore() {
        int maxScore = Integer.MIN_VALUE;
        for (Student student : students) {
            if (student.getGrade() > maxScore) {
                maxScore = student.getGrade();
            }
        }
        return maxScore;
    }

    public int getLowestScore() {
        int minScore = Integer.MAX_VALUE;
        for (Student student : students) {
            if (student.getGrade() < minScore) {
                minScore = student.getGrade();
            }
        }
        return minScore;
    }
}
