import java.util.Scanner;

public class Student {
    private String id;
    private String name;
    private double score;

    // Constructor
    public Student(String id, String name, double score) {
        this.id = id;
        setName(name);  // Set name using setter to apply validation
        setScore(score);  // Set score using setter to apply validation
    }

    // Getter and setter for ID
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Getter and setter for Name with validation
    public String getName() {
        return name;
    }

    public void setName(String name) {
        // Check for a valid name (not empty or null)
        while (name == null || name.trim().isEmpty()) {
            System.out.print("Invalid name. Please enter again: ");
            name = new Scanner(System.in).nextLine();
        }
        this.name = name;
    }

    // Getter and setter for Score with validation
    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        // Ensure score is between 0 and 10
        while (score < 0 || score > 10) {
            System.out.print("Invalid score (must be between 0 and 10). Please enter again: ");
            score = new Scanner(System.in).nextDouble();
        }
        this.score = score;
    }

    // Ranking method
    public String getRank() {
        if (score < 5.0) return "Fail";
        else if (score < 6.5) return "Average";
        else if (score < 7.5) return "Good";
        else if (score < 9.0) return "Very Good";
        else return "Excellent";
    }

    // toString method
    @Override
    public String toString() {
        return String.format("%-10s %-20s %-5.1f %-10s", id, name, score, getRank());
    }
}
