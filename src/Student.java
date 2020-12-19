public class Student  {

    private double GPA;

    public Student(double GPA) {
        this.GPA = GPA;
    }

    public double getGPA() { return this.GPA; }

    public void setGPA(double GPA) { this.GPA = GPA; }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        Student student = (Student) obj;
        return student.getGPA() == this.GPA;
    }

    @Override
    public String toString() {
        return "Student GPA: " +  this.GPA;
    }

}
