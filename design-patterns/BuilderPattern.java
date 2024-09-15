
public class BuilderPattern {
    public static void main(String[] args) {
        Student student = new Student.builder(1, "Vivek", "CSE").hasGraduated(true).build();
        System.out.println(student);
    }
}

class Student {
    private final int rollNo; //mandatory field
    private final String name; //mandatory field
    private final String branch; //mandatory field
    private final boolean enrolledInCourse; //optional field
    private final boolean hasGraduated; //optional field

    // Private constructor to prevent modification after creation
    private Student(builder studentBuilder) {
        this.rollNo = studentBuilder.rollNo;
        this.name = studentBuilder.name;
        this.branch = studentBuilder.branch;
        this.enrolledInCourse = studentBuilder.enrolledInCourse;
        this.hasGraduated = studentBuilder.hasGraduated;
    }

    @Override
    public String toString() {
        return this.rollNo + ", " + this.name + ", " + this.branch + ", " + this.enrolledInCourse + ", " + this.hasGraduated;
    }

    // Builder class (mutable, helper for building the immutable object)
    public static class builder {
        private final int rollNo;
        private final String name;
        private final String branch;
        private boolean enrolledInCourse;
        private boolean hasGraduated;

        public builder(int rollNo, String name, String branch) {
            this.rollNo = rollNo;
            this.name = name;
            this.branch = branch;
            this.enrolledInCourse = false;
            this.hasGraduated = false;
        }

        // Setter methods for optional fields
        public builder enrolledInCourse(boolean enrolledInCourse) {
            this.enrolledInCourse = enrolledInCourse;
            return this;
        }

        public builder hasGraduated(boolean hasGraduated) {
            this.hasGraduated = hasGraduated;
            return this;
        }

        // Method to build the final object (immutable)
        public Student build() {
            return new Student(this); // Returns a fully constructed immutable object
        }

    }

}
