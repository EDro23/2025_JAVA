package ca.nl.cna.ethan.drover.A2;

import java.util.List;
import java.util.Scanner;

/**
 * A user interface class for a database of student objects and managing them
 * Provides methods for printing, adding, removing, and modifying student information.
 * Saving to a file at the end.
 */
public class StudentUI {

    /**
     * Prints a formatted list of all students in the list.
     *
     * @param students The list of students to print.
     */
    public static void printStudents(List<Student> students) {
        for (Student student : students) {
            System.out.printf("%s %s %s %s %s %d %.2f%n\n",
                    student.getFirstName(),
                    student.getLastName(),
                    student.getStudentNumber(),
                    student.getEmail(),
                    student.getPhoneNumber(),
                    student.getCourseCredits(),
                    student.getBalanceOwing());
        }
    }

    /**
     * Prompts the user to enter new student information, validates the input,
     * and adds the student to the provided list.
     *
     * @param scanner  The Scanner object for user input.
     * @param students The list of students to which the new student will be added.
     */
    public static void addStudent(Scanner scanner, List<Student> students) {
        try {
            System.out.print("First Name: ");
            String firstName = scanner.nextLine();

            System.out.print("Last Name: ");
            String lastName = scanner.nextLine();

            String studentNumber;
            while (true) {
                System.out.print("Student Number (9 Digits): ");
                studentNumber = scanner.nextLine();
                try {
                    if (Student.isValidStudentNumber(Integer.parseInt(studentNumber))) {
                        break;
                    } else {
                        System.out.println("Invalid Student Number. Try again.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number format. Try again.");
                }
            }

            String email;
            while (true) {
                System.out.print("Email: ");
                email = scanner.nextLine();
                if (Student.isValidEmail(email)) {
                    break;
                } else {
                    System.out.println("Invalid Email. Try again.");
                }
            }

            String phoneNumber;
            while (true) {
                System.out.print("Phone Number: ");
                phoneNumber = scanner.nextLine();
                if (Student.isValidPhoneNumber(phoneNumber)) {
                    break;
                } else {
                    System.out.println("Invalid Phone Number. Try again.");
                }
            }

            int courseCredits;
            while (true) {
                System.out.print("Course Credits: ");
                try {
                    courseCredits = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number. Please enter a valid integer.");
                }
            }

            int balanceOwing;
            while (true) {
                System.out.print("Balance Owing: ");
                try {
                    balanceOwing = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number. Please enter a valid integer.");
                }
            }

            students.add(new Student(firstName, lastName, studentNumber, email, phoneNumber, courseCredits, balanceOwing));
            System.out.println("Student added.");
        } catch (Exception e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }

    /**
     * Prompts the user to enter a student number, then removes
     * the matching student from the list if found there.
     *
     * @param scanner  The Scanner object for user input.
     * @param students The list of students from which to remove the student.
     */
    public static void removeStudent(Scanner scanner, List<Student> students) {
        System.out.print("Student number to remove: ");
        String studentNumber = scanner.nextLine();

        Student toRemove = null;
        for (Student student : students) {
            if (student.getStudentNumber().equals(studentNumber)) {
                toRemove = student;
                break;
            }
        }

        if (toRemove != null) {
            students.remove(toRemove);
            System.out.println("Student removed");
        } else {
            System.out.println("Student not found");
        }
    }

    /**
     * Prompts the user to modify an existing students details.
     * Allows skipping any field by entering a blank line.
     * Validates email, phone number, and numeric values where appropriate.
     *
     * @param scanner  The Scanner object for user input.
     * @param students The list of students to search for the student to modify.
     */
    public static void ModifyStudent(Scanner scanner, List<Student> students) {
        System.out.print("Student number to modify: ");
        String studentNumber = scanner.nextLine();

        Student toModify = null;
        for (Student student : students) {
            if (student.getStudentNumber().equals(studentNumber)) {
                toModify = student;
                break;
            }
        }

        if (toModify == null) {
            System.out.println("Student not found");
            return;
        }

        try {
            System.out.print("New First Name (Blank to skip): ");
            String input = scanner.nextLine();
            if (!input.isEmpty()) {
                toModify.setFirstName(input);
            }

            System.out.print("New Last Name (Blank to skip): ");
            input = scanner.nextLine();
            if (!input.isBlank()) {
                toModify.setLastName(input);
            }

            System.out.print("New Email (Blank to skip): ");
            input = scanner.nextLine();
            if (!input.isBlank()) {
                if (Student.isValidEmail(input)) {
                    toModify.setEmail(input);
                } else {
                    System.out.println("Invalid Email. Skipping.");
                }
            }

            System.out.print("New Phone Number (Blank to skip): ");
            input = scanner.nextLine();
            if (!input.isBlank()) {
                if (Student.isValidPhoneNumber(input)) {
                    toModify.setPhoneNumber(input);
                } else {
                    System.out.println("Invalid Phone Number. Skipping.");
                }
            }

            System.out.print("New Course Credits (Blank to skip): ");
            input = scanner.nextLine();
            if (!input.isBlank()) {
                try {
                    toModify.setCourseCredits(Integer.parseInt(input));
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number. Skipping course credits.");
                }
            }

            System.out.print("New Balance Owing (Blank to skip): ");
            input = scanner.nextLine();
            if (!input.isBlank()) {
                try {
                    toModify.setBalanceOwing(Integer.parseInt(input));
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number. Skipping balance owing.");
                }
            }

            System.out.println("Student updated.");
        } catch (Exception e) {
            System.out.println("Error updating student: " + e.getMessage());
        }
    }
}
