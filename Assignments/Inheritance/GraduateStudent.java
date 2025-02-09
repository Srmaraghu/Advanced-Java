class GraduateStudent extends Student {
    String degree;

    // Constructor
    GraduateStudent(String name, int age, String studentID, String degree) {
        super(name,age, studentID); // Call the constructor of Student
        this.degree = degree;
    }

    void displayGraduate() {
        displayStudent(); // Call method from Student class
        System.out.println("Degree: " + degree);
    }
}
