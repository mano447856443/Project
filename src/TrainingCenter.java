// Temporary class for testing purposes only
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
public boolean hasSeats() {
    return seats > 0;
}

public void takeSeat() {
        if (seats > 0) {
            seats--;
        }
    
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