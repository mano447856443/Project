/**
 * Stores training center details and matching information.
 */

public class TrainingCenter {
    private String name;
    private String city;
    private String field;
    private String[] relatedCourses;
    private int seats;

    
 public TrainingCenter(String name, String city, String field,
            String[] relatedCourses, int seats) {
this.name = name;
this.city = city;
this.field = field;
this.relatedCourses = relatedCourses;
this.seats = seats;

 }
 
 /** Checks whether the center has an available seat. */
 
public boolean hasSeats() {
    return seats > 0;
}

/** Decreases the available seats by one when a seat is available. */

public void takeSeat() {
        if (seats > 0) {
            seats--;
        }
    
}

    
/**
 * Calculates the match score based on the project field and related courses.
 */

public int calculateScore(Student student) {
    int score = 0;

    if (student.getProjectField().equalsIgnoreCase(field)) {
        score += 60;
    }

    int matchedCourses = 0;
    for (String course : relatedCourses) {
        if (student.hasCourse(course)) {
            score += 20;
            matchedCourses++;

            if (matchedCourses == 2) {
                break;
            }
        }
    }

    return score;
}
    public String getName() {
        return name;
    }
    public String getCity() {
        return city;
    }

    public String getField() {
        return field;
    }

    public String[] getRelatedCourses() {
        return relatedCourses;
    }

    public int getSeats() {
        return seats;
    }
}