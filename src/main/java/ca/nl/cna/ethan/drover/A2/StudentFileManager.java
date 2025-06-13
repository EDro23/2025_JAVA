package ca.nl.cna.ethan.drover.A2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintStream;
import java.util.ArrayList;

public class StudentFileManager {

    private String filename;

    public StudentFileManager(String filename) {
        this.filename = filename;
    }

    /**
     * Loads student data from a file.
     * @param logStream Stream to log invalid data lines.
     * @return ArrayList of valid Student objects.
     */
    public ArrayList<Student> loadStudents(PrintStream logStream) {
        ArrayList<Student> students = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int lineNum = 0;
            while ((line = reader.readLine()) != null) {
                lineNum++;
                // Assume CSV: firstName,lastName,studentNumber,email,phone,credits,balance
                String[] parts = line.split(" ");
                if (parts.length != 7) {
                    logStream.printf("Line %d skipped (incorrect number of fields): %s%n", lineNum, line);
                    continue;
                }
                String firstName = parts[0].trim();
                String lastName = parts[1].trim();
                String studentNumber = parts[2].trim();
                String email = parts[3].trim();
                String phone = parts[4].trim();
                String creditsStr = parts[5].trim();
                String balanceStr = parts[6].trim();

                // Validate each field using Student's validation methods
                // If it is invalid skip to the next line.
                if (!Student.isValidName(firstName, lastName)) {
                    logStream.printf("Line %d skipped (invalid name): %s %s%n", lineNum, firstName, lastName);
                    continue;
                }

                if (!Student.isValidStudentNumber(Integer.parseInt(studentNumber))) {
                    logStream.printf("Line %d skipped (invalid student number): %s%n", lineNum, studentNumber);
                    continue;
                }

                if (!Student.isValidEmail(email)) {
                    logStream.printf("Line %d skipped (invalid email): %s%n", lineNum, email);
                    continue;
                }

                if (!Student.isValidPhoneNumber(phone)) {
                    logStream.printf("Line %d skipped (invalid phone number): %s%n", lineNum, phone);
                    continue;
                }

                int credits;
                try {
                    credits = Integer.parseInt(creditsStr);
                } catch (NumberFormatException e) {
                    logStream.printf("Line %d skipped (invalid credits): %s%n", lineNum, creditsStr);
                    continue;
                }
                if (!Student.isValidCredits(credits)) {
                    logStream.printf("Line %d skipped (invalid credits): %s%n", lineNum, creditsStr);
                    continue;
                }

                double balance;
                // balanceStr might contain $ sign, so remove it before parsing
                String cleanedBalanceStr = balanceStr.replace("$", "").trim();
                try {
                    balance = Double.parseDouble(cleanedBalanceStr);
                } catch (NumberFormatException e) {
                    logStream.printf("Line %d skipped (invalid balance owing): %s%n", lineNum, balanceStr);
                    continue;
                }
                if (!Student.isValidBalanceOwing(balance)) {
                    logStream.printf("Line %d skipped (invalid balance owing): %s%n", lineNum, balanceStr);
                    continue;
                }

                // All validations passed - create Student object
                Student student = new Student(firstName, lastName, studentNumber, email, phone, credits, balance);
                students.add(student);
            }
        } catch (Exception e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return students;
    }

    /**
     * Saves the list of students to a file.
     * @param students List of students to save.
     * @return True if save was successful, false otherwise.
     */
    public boolean saveStudents(ArrayList<Student> students) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Student s : students) {
                String line = String.format("%s %s %s %s %s %d %.2f",
                        s.getFirstName(),
                        s.getLastName(),
                        s.getStudentNumber(),
                        s.getEmail(),
                        s.getPhoneNumber(),
                        s.getCourseCredits(),
                        s.getBalanceOwing());
                writer.write(line);
                writer.newLine();
            }
            return true;
        } catch (Exception e) {
            System.err.println("Error writing file: " + e.getMessage());
            return false;
        }
    }
}
