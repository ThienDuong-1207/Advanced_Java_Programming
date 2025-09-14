import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Task3_StudentManager {

    private static ArrayList<Task3_Student> students = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> displayStudents();
                case 3 -> searchStudent();
                case 4 -> removeStudent();
                case 5 -> sortStudents();
                case 0 -> {
                    System.out.println("Exiting program. Goodbye!");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // ===== Menu =====
    private static void showMenu() {
        System.out.println("\n===== STUDENT MANAGEMENT MENU =====");
        System.out.println("1. Add Student");
        System.out.println("2. Display All Students");
        System.out.println("3. Search Student by ID");
        System.out.println("4. Remove Student by ID");
        System.out.println("5. Sort Students by Grade (Descending)");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }

    // ===== Functions =====
    private static void addStudent() {
        System.out.print("Enter Student ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Grade: ");
        double grade = sc.nextDouble();
        students.add(new Task3_Student(id, name, grade));
        System.out.println("Student added successfully!");
    }

    private static void displayStudents() {
        System.out.println("\n=== List of Students ===");
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            for (Task3_Student s : students) {
                System.out.println(s);
            }
        }
    }

    private static void searchStudent() {
        System.out.print("Enter Student ID to search: ");
        String searchId = sc.nextLine();
        for (Task3_Student s : students) {
            if (s.getId().equalsIgnoreCase(searchId)) {
                System.out.println("Found: " + s);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    private static void removeStudent() {
        System.out.print("Enter Student ID to remove: ");
        String removeId = sc.nextLine();
        boolean removed = students.removeIf(s -> s.getId().equalsIgnoreCase(removeId));
        if (removed) {
            System.out.println("Student removed successfully!");
        } else {
            System.out.println("No student found with that ID.");
        }
    }

    private static void sortStudents() {
        students.sort(Comparator.comparingDouble(Task3_Student::getGrade).reversed());
        System.out.println("\n=== Students Sorted by Grade (Descending) ===");
        for (Task3_Student s : students) {
            System.out.println(s);
        }
    }
}
