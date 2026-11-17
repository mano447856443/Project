import java.util.ArrayList;

/**
 * Represents a BSc student in the Internship Matching System.
 * Stores personal information, registered courses, graduation project details,
 * and the assigned training center.
 */
public class Student {

    // ===== Attributes =====
    private String name;
    private String kkuId;
    private String major;
    private ArrayList<String> courses;
    private String projectTitle;
    private String projectField;
    private TrainingCenter internship;

    // ===== Constructor =====
    public Student(String name, String kkuId, String major) {
        this.name = name;
        this.kkuId = kkuId;
        this.major = major;
        this.courses = new ArrayList<>();
    }

    // ===== Course Operations =====

    /**
     * Adds a new course to the student's registered courses list.
     * @param course the name of the course to add
     */
    public void addCourse(String course) {
        courses.add(course);
    }

    /**
     * Checks whether the student has already registered a specific course.
     * @param course the course name to check
     * @return true if the course exists, false otherwise
     */
    public boolean hasCourse(String course) {
        return courses.contains(course);
    }

    // ===== Graduation Project Operations =====

    /**
     * Registers the student's graduation project.
     * @param title the project title
     * @param field the project field
     */
    public void setProject(String title, String field) {
        this.projectTitle = title;
        this.projectField = field;
    }

    /**
     * Checks whether the student has registered a graduation project.
     * @return true if a project title exists, false otherwise
     */
    public boolean hasProject() {
        return projectTitle != null && !projectTitle.isEmpty();
    }

    // ===== Internship Operations =====

    /**
     * Assigns a training center to the student.
     * @param center the training center to assign
     */
    public void setInternship(TrainingCenter center) {
        this.internship = center;
    }

    // ===== Getters =====
    public String getName() { return name; }
    public String getKkuId() { return kkuId; }
    public String getMajor() { return major; }
    public ArrayList<String> getCourses() { return courses; }
    public String getProjectTitle() { return projectTitle; }
    public String getProjectField() { return projectField; }
    public TrainingCenter getInternship() { return internship; }
}