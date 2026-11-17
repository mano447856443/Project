/**
 * Temporary test class used to verify that the Student class works correctly.
 * This class will be removed before the final submission.
 */
public class TestStudent {

    public static void main(String[] args) {

        // Create a new student
        Student student = new Student("Sara Ali", "444000111", "Computer Science");

        // Register courses
        student.addCourse("Java Programming");
        student.addCourse("Data Structures");

        // Register graduation project
        student.setProject("AI Chatbot", "Artificial Intelligence");

        // Display student information
        System.out.println("===== Student Information =====");
        System.out.println("Name: " + student.getName());
        System.out.println("KKU ID: " + student.getKkuId());
        System.out.println("Major: " + student.getMajor());
        System.out.println("Courses: " + student.getCourses());
        System.out.println("Has Java Programming? " + student.hasCourse("Java Programming"));
        System.out.println("Has Project? " + student.hasProject());
        System.out.println("Project Title: " + student.getProjectTitle());
        System.out.println("Project Field: " + student.getProjectField());
    }
}