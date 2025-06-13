package ca.nl.cna.ethan.drover.A2;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * A class that manages Student objects by storing and retrieving data from a file.
 * File format: FirstName LastName StudentNumber Email PhoneNumber Credits $Balance.00
 */
public class StudentFileManager {

    /**
     * Loads students from a file.
     *
     * @param file      The file to read from.
     * @param logStream The PrintStream to log invalid data lines.
     * @return List of valid Student objects loaded from the file.
     * @throws IOException If there is an error reading the file.
     */
    public static List<Student> loadStudents(File file, PrintStream logStream) throws IOException {
        List<Student> students = new LinkedList<>();

        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        String line;
        int lineNum = 0;

        while ((line = br.readLine()) != null) {
            lineNum++;
            String[] tokens = line.trim().split(" ");

            if (tokens.length < 7) {
                logStream.printf("Line %d skipped (not enough tokens): %s%n", lineNum, line);
                continue;
            }

            String firstName = tokens[0];
            String lastName = tokens[1];
            String studentNumber = tokens[2];
            String email = tokens[3];
            String phoneNumber = tokens[4];
            String courseCreditsStr = tokens[5];
            String balanceStr = tokens[6];

            // Validate name
            if (!Student.isValidName(firstName, lastName)) {
                logStream.printf("Line %d skipped (invalid name): %s %s%n", lineNum, firstName, lastName);
                continue;
            }

            // Validate student number
            try {
                if (!Student.isValidStudentNumber(Integer.parseInt(studentNumber))) {
                    logStream.printf("Line %d skipped (invalid student number): %s%n", lineNum, studentNumber);
                    continue;
                }
            } catch (NumberFormatException e) {
                logStream.printf("Line %d skipped (invalid number format for student number): %s%n", lineNum, studentNumber);
                continue;
            }

            // Validate email
            if (!Student.isValidEmail(email)) {
                logStream.printf("Line %d skipped (invalid email): %s%n", lineNum, email);
                continue;
            }

            // Validate phone number
            if (!Student.isValidPhoneNumber(phoneNumber)) {
                logStream.printf("Line %d skipped (invalid phone number): %s%n", lineNum, phoneNumber);
                continue;
            }

            // Validate course credits
            int courseCredits;
            try {
                courseCredits = Integer.parseInt(courseCreditsStr);
                if (!Student.isValidCredits(courseCredits)) {
                    logStream.printf("Line %d skipped (invalid course credits): %s%n", lineNum, courseCreditsStr);
                    continue;
                }
            } catch (NumberFormatException e) {
                logStream.printf("Line %d skipped (invalid format for course credits): %s%n", lineNum, courseCreditsStr);
                continue;
            }

            // Validate balance owing
            int balanceOwing;
            try {
                balanceOwing = Integer.parseInt(balanceStr.replace("$", "").replace(".00", ""));
                if (!Student.isValidCredits(balanceOwing)) {
                    logStream.printf("Line %d skipped (invalid balance owing): %s%n", lineNum, balanceStr);
                    continue;
                }
            } catch (NumberFormatException e) {
                logStream.printf("Line %d skipped (invalid format for balance owing): %s%n", lineNum, balanceStr);
                continue;
            }

            // If all validations passed, add the student
            students.add(new Student(firstName, lastName, studentNumber, email, phoneNumber, courseCredits, balanceOwing));
        }

        br.close();
        return students;
    }

    /**
     * Saves students to a file in formatted text.
     *
     * @param students  The list of students to save.
     * @param file      The file to write to.
     * @param logStream The PrintStream to log saving status.
     * @throws IOException If there is an error writing the file.
     */
    public static void saveStudents(List<Student> students, File file, PrintStream logStream) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(file));

        for (Student s : students) {
            writer.printf(
                    "%s %s %s %s %s %d $%d.00%n",
                    s.getFirstName(),
                    s.getLastName(),
                    s.getStudentNumber(),
                    s.getEmail(),
                    s.getPhoneNumber(),
                    s.getCourseCredits(),
                    s.getBalanceOwing()
            );
        }

        writer.close();
        logStream.println("Student data successfully saved to: " + file.getAbsolutePath());
    }
}
