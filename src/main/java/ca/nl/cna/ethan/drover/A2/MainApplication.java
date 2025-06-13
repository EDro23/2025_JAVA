package ca.nl.cna.ethan.drover.A2;

import java.io.File;
import java.io.IOException;
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
        List<Student> students = null;

        while (true) {
            System.out.print("Enter file name: ");
            String fileName = scanner.nextLine();
            inputFile = new File(fileName);

            try {
                if (inputFile.exists() && inputFile.isFile()) {
                    students = StudentFileManager.loadStudents(inputFile, System.out);
                    break;
                } else {
                    System.out.println("File not found");
                }
            } catch (IOException e) {
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
            System.out.println("Choice: ");

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

        System.out.println("Enter output file name: ");
        File outputFile = new File(scanner.nextLine());

        try {
            StudentFileManager.saveStudents(students, outputFile, System.out);
            System.out.println("Student list saved");
        } catch (IOException e) {
            System.err.println("Error saving file: " + e.getMessage());
        }

        scanner.close();

    }
}
