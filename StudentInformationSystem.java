import java.util.Scanner;

public class StudentInformationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Student information variables
        String studentName;
        int studentAge;
        String studentMajor;
        double studentGPA;

        // Display menu
        System.out.println("Student Information System");
        System.out.println("----------------------------");
        System.out.println("1. Add Student");
        System.out.println("2. Display Student Information");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                // Add student
                System.out.print("Enter student name: ");
                studentName = scanner.next();
                System.out.print("Enter student age: ");
                studentAge = scanner.nextInt();
                System.out.print("Enter student major: ");
                studentMajor = scanner.next();
                System.out.print("Enter student GPA: ");
                studentGPA = scanner.nextDouble();

                System.out.println("Student added successfully!");
                break;

            case 2:
                // Display student information
                System.out.println("Enter student name to display information: ");
                studentName = scanner.next();

                // Assume student information is stored in a database or file
                // For simplicity, we'll just display a hardcoded message
                System.out.println("Student Information:");
                System.out.println("Name: " + studentName);
                System.out.println("Age: 20");
                System.out.println("Major: Computer Science");
                System.out.println("GPA: 3.5");
                break;

            case 3:
                // Exit
                System.out.println("Goodbye!");
                System.exit(0);
                break;

            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}