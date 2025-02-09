
public class Student extends Person {
    String studentId;

    public Student(String name, int age, String studentId) {
        super(name, age);
        this.studentId = studentId;
    }

    public void displayStudent() {
        displayDetails();
        System.out.println("StudentId: " + studentId);
    }
}
