import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagement management = new StudentManagement();

        while (true) {
            try {
                System.out.println("\n=== MENU ===");
                System.out.println("1. Add student");
                System.out.println("2. Display student list");
                System.out.println("3. Update student score");
                System.out.println("4. Delete student");
                System.out.println("5. Search for a student");
                System.out.println("6. Sort students by score");
                System.out.println("7. Sort students by name");
                System.out.println("8. Exit");
                System.out.print("Choose an option (1-8): ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Enter student ID: ");
                        String id = scanner.nextLine();

                        String name;
                        while (true) {
                            System.out.print("Enter student name: ");
                            name = scanner.nextLine();
                            if (name.matches("[a-zA-Z\\s]+")) { // Check if name contains only letters and spaces
                                break;
                            } else {
                                System.out.println("Invalid name! Please enter letters only.");
                            }
                        }

                        double score;
                        while (true) {
                            System.out.print("Enter student score (0-10): ");
                            score = Double.parseDouble(scanner.nextLine());
                            if (score >= 0 && score <= 10) {
                                break;
                            } else {
                                System.out.println("Invalid score! Please enter a value between 0 and 10.");
                            }
                        }

                        management.addLast(new Student(id, name, score));
                        System.out.println("Student added successfully.");
                        break;

                    case 2:
                        management.traverse();
                        break;

                    case 3:
                        System.out.print("Enter the student ID to update: ");
                        id = scanner.nextLine();

                        while (true) {
                            System.out.print("Enter new score (0-10): ");
                            score = Double.parseDouble(scanner.nextLine());
                            if (score >= 0 && score <= 10) {
                                break;
                            } else {
                                System.out.println("Invalid score! Please enter a value between 0 and 10.");
                            }
                        }
                        management.updateStudent(id, score);
                        break;

                    case 4:
                        System.out.print("Enter the student ID to delete: ");
                        id = scanner.nextLine();
                        management.deleteById(id);
                        break;

                    case 5:
                        System.out.print("Enter the student ID to search: ");
                        id = scanner.nextLine();
                        Student student = management.searchById(id);
                        if (student != null) {
                            System.out.println(student);
                        } else {
                            System.out.println("Student not found!");
                        }
                        break;

                    case 6:
                        management.bubbleSortByScore();
                        break;

                    case 7:
                        management.insertionSortByName();
                        break;

                    case 8:
                        System.out.println("Exiting program.");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input error! Please enter an integer.");
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }
}
