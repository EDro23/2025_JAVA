package ca.nl.cna.ethan.drover.A2;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * A class that manages Student objects that stores (and retrieves data) in the following format:
 * File structure:
 * Josh Taylor 18298394 josh.taylor@cna.nl.ca 709-555-5555 12 $562.00
 * John Doe 18298395 john.doe@cna.nl.ca 709-555-5555 7 $0.00
 * ....
 * All variables are separated by a space
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

            // Validate student first & last name
            if (!Student.isValidName(firstName, lastName)) {
                logStream.printf("Line %d skipped (invalid phone number): %s%n", lineNum, firstName + " " + lastName);
                continue;

                // Validate student number (must be 9 digits)
                if (!Student.isValidStudentNumber(Integer.parseInt(studentNumber))) {
                    logStream.printf("Line %d skipped (invalid student number): %s%n", lineNum, studentNumber);
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

                // Validate student credits
                if (!Student.isValidCredits(Integer.parseInt(courseCreditsStr))) {
                    logStream.printf("Line %d skipped (invalid phone number): %s%n", lineNum, courseCreditsStr);
                    continue;
                }

                // validate student balance owed
                if (!Student.isValidCredits(Integer.parseInt(balanceStr))) {
                    logStream.printf("Line %d skipped (invalid phone number): %s%n", lineNum, balanceStr);
                    continue;
                }

                try {
                    int courseCredits = Integer.parseInt(courseCreditsStr);
                    int balanceOwing = Integer.parseInt(balanceStr.replace("$", "").replace(".00", ""));

                    Student student = new Student(
                            firstName, lastName, studentNumber, email, phoneNumber, courseCredits, balanceOwing);
                    students.add(student);

                } catch (NumberFormatException nfe) {
                    logStream.printf("Line %d skipped (number format issue): %s%n", lineNum, line);
                }
            }

            br.close();

            return students;
        }

        /**
         * Saves students to a file.
         *
         * @param students  The list of students to save.
         * @param file      The file to write to.
         * @param logStream The PrintStream to log saving status.
         * @throws IOException If there is an error writing the file.
         */
        public static void saveStudents (List < Student > students, File file, PrintStream logStream) throws IOException
        {
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
}
