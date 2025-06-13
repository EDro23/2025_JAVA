package ca.nl.cna.ethan.drover.A2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Main application for the console of the student database
 */
public class MainApplication {

    public static void main(String[] args) {
        System.out.println("Fun with Student Database");

        Scanner scanner = new Scanner(System.in);
        File inputFile = null;
        List<Student> students = new ArrayList<>();
        StudentFileManager manager = null;

        while (true) {
            System.out.print("Enter input file name: ");
            String fileName = scanner.nextLine();
            inputFile = new File(fileName);

            try {
                if (inputFile.exists() && inputFile.isFile()) {
                    manager = new StudentFileManager(fileName);
                    students = manager.loadStudents(System.out);
                    break;
                } else {
                    System.out.println("File not found");
                }
            } catch (Exception e) {
                System.err.println("Error loading file: " + e.getMessage());
            }
        }

        boolean running = true;

        while (running) {
            System.out.println("\nMenu: ");
            System.out.println("1. Show students");
            System.out.println("2. Add Student");
            System.out.println("3. Remove Student");
            System.out.println("4. Modify student");
            System.out.println("5. Save & Exit");
            System.out.print("Choice: ");

            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                StudentUI.printStudents(students);
            }
            else if (choice.equals("2")) {
                StudentUI.addStudent(scanner, students);
            }
            else if (choice.equals("3")) {
                StudentUI.removeStudent(scanner, students);
            }
            else if (choice.equals("4")) {
                StudentUI.ModifyStudent(scanner, students);
            }
            else if (choice.equals("5")) {
                running = false;
            } else {
                System.out.println("Invalid choice");
            }
        }

        // Prompt for output filename and save students
        System.out.print("Enter output file name: ");
        String outputFileName = scanner.nextLine();
        manager = new StudentFileManager(outputFileName);

        try {
            if (manager.saveStudents(new ArrayList<>(students))) {
                System.out.println("Student list saved");
            } else {
                System.err.println("Failed to save student list");
            }
        } catch (Exception e) {
            System.err.println("Error saving file: " + e.getMessage());
        }

        scanner.close();
    }
}

