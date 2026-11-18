import java.util.ArrayList;
import java.util.Scanner;

/**
 * Manages students, training centers, and internship operations.
 */

public class InternshipSystem {
	private ArrayList<Student> students = new ArrayList<>();
	private ArrayList<TrainingCenter> centers = new ArrayList<>();
	private Scanner input = new Scanner(System.in);
	
	
	/** Finds a student by KKU ID, or returns null if not found. */
	
	public Student findStudent(String id) {
	    for (Student student : students) {
	        if (student.getKkuId().equals(id)) {
	            return student;
	        }
	    }
	    return null;
	}
	
	/** Returns the center with the highest match score for the student. */
	
	public TrainingCenter getBestMatch(Student student) {
	    TrainingCenter bestMatch = null;
	    int highestScore = -1;

	    for (TrainingCenter center : centers) {
	        int score = center.calculateScore(student);

	        if (score > highestScore) {
	            highestScore = score;
	            bestMatch = center;
	        }
	    }

	    return bestMatch;
	}
	
	/** Displays every center's score and the best match for a student. */
	
	public void findMatchingTrainingCenters() {
	    System.out.print("Enter KKU ID: ");
	    String id = input.next();

	    Student student = findStudent(id);

	    if (student == null) {
	        System.out.println("Student not found.");
	        return;
	    }

	    if (student.getCourses().isEmpty()) {
	        System.out.println("No courses have been registered for this student. Please register courses first.");
	        return;
	    }

	    if (!student.hasProject()) {
	        System.out.println("No graduation project has been registered for this student. Please register the graduation project first.");
	        return;
	    }

	    System.out.printf("%-25s %-15s %-25s %s%n",
	            "Center", "City", "Field", "Score");

	    for (TrainingCenter center : centers) {
	        int score = center.calculateScore(student);
	        System.out.printf("%-25s %-15s %-25s %d%%%n",
	                center.getName(), center.getCity(), center.getField(), score);
	    }

	    TrainingCenter best = getBestMatch(student);
	    if (best != null) {
	        System.out.printf("Best Match: %s (%d%%)%n",
	                best.getName(), best.calculateScore(student));
	    }
	}
	
	/** Assigns the student to the highest-scoring center with available seats. */
	
	public void assignInternship() {
	    System.out.print("Enter KKU ID: ");
	    String id = input.next();

	    Student student = findStudent(id);

	    if (student == null) {
	        System.out.println("Student not found.");
	        return;
	    }

	    if (student.getCourses().isEmpty()) {
	        System.out.println("No courses have been registered for this student. Please register courses first.");
	        return;
	    }

	    if (!student.hasProject()) {
	        System.out.println("No graduation project has been registered for this student. Please register the graduation project first.");
	        return;
	    }

	    if (student.getInternship() != null) {
	        System.out.println("This student is already assigned to "
	                + student.getInternship().getName() + ".");
	        return;
	    }

	    TrainingCenter bestAvailable = null;
	    int highestScore = -1;

	    for (TrainingCenter center : centers) {
	        if (center.hasSeats()) {
	            int score = center.calculateScore(student);

	            if (score > highestScore) {
	                highestScore = score;
	                bestAvailable = center;
	            }
	        }
	    }

	    if (bestAvailable == null) {
	        System.out.println("No training center with available seats.");
	        return;
	    }

	    student.setInternship(bestAvailable);
	    bestAvailable.takeSeat();

	    System.out.println("Internship assigned successfully.");
	    System.out.println("Center: " + bestAvailable.getName());
	    System.out.println("City: " + bestAvailable.getCity());
	    System.out.println("Score: " + highestScore + "%");
	}

}
