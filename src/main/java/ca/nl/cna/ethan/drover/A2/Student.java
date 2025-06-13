package ca.nl.cna.ethan.drover.A2;

/**
 * Student class for a student object:
 * •	First Name
 * •	Last Name
 * •	Student Number
 * •	Email
 * •	Phone Number
 * •	Course Credits Achieved
 * •	Balance Owing ($)
 */
public class Student {

    public static final String NAME_REGEX = "^[a-zA-Z]+$";
    public static final String STUDENTNUM_REGEX = "\\d{9}";
    public static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z0-9.-]+$";
    public static final String PHONE_REGEX = "^(\\(\\d{3}\\)|\\d{3})[-.]?\\d{3}[-.]?\\d{4}$";
    public static final String CREDITS_REGEX = "^[0-9]+$";

    private String firstName;
    private String lastName;
    private String studentNumber;
    private String email;
    private String phoneNumber;
    private int courseCredits;
    private double balanceOwing; // Changed to double

    /**
     * Student object with the following params
     * @param firstName First name of the student
     * @param lastName Last name of the student
     * @param studentNumber The student number
     * @param email Email of the student
     * @param phoneNumber Phone number of the student
     * @param courseCredits Course credits belonging to the student
     * @param balanceOwing The balance the student owes
     */
    public Student(String firstName, String lastName, String studentNumber, String email, String phoneNumber, int courseCredits, double balanceOwing) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentNumber = studentNumber;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.courseCredits = courseCredits;
        this.balanceOwing = balanceOwing;
    }

    /**
     * Get the first name of the student
     * @return The students first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the first name of the student
     * @param firstName The students first name you are setting
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get the students last name
     * @return The students last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the last name of the student
     * @param lastName The students last name you are setting
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get the student number
     * @return The student number of the student object
     */
    public String getStudentNumber() {
        return studentNumber;
    }

    /**
     * Set the student number
     * @param studentNumber The student number being set to the student
     */
    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    /**
     * Get the email of the student
     * @return The students email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the email of the student
     * @param email The email being set to the student
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the phone number of the student
     * @return The phone number of the student
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Set the phone number of the student
     * @param phoneNumber The phone number to be set to the student
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Get the course credits that the student has
     * @return The course credits from the student
     */
    public int getCourseCredits() {
        return courseCredits;
    }

    /**
     * Set the course credits for a student
     * @param courseCredits The credits being set for the student
     */
    public void setCourseCredits(int courseCredits) {
        this.courseCredits = courseCredits;
    }

    /**
     * Get the balance owed by the student
     * @return The balance owed in dollar amount
     */
    public double getBalanceOwing() {
        return balanceOwing;
    }

    /**
     * Set the balance owed by a student
     * @param balanceOwing The balance owed to be set to the student
     */
    public void setBalanceOwing(double balanceOwing) {
        this.balanceOwing = balanceOwing;
    }

    /**
     * Validation for the student number that checks if it is 9 digits in length
     * @param studentNumber The student number being passed in
     * @return True or false if the number is less than 9 (Matching the REGEX)
     */
    public static boolean isValidStudentNumber(int studentNumber) {
        return String.valueOf(studentNumber).matches(STUDENTNUM_REGEX);
    }

    /**
     * Validation for the email, must match REGEX for email
     * @param email The email being passed in
     * @return True or false if matching the REGEX
     */
    public static boolean isValidEmail(String email) {
        return email.matches(EMAIL_REGEX);
    }

    /**
     * Validation for the phone number:
     * Must have 10 digits and can have “(,),-,.” in the
     * number e.g. (709) 555-555 or 709.555-5555
     * @param phoneNumber The phone number being passed in
     * @return If the phone number matches the REGEX
     */
    public static boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.matches(PHONE_REGEX);
    }

    /**
     * Validation for the first name and last name
     * Must be of letter format without integers
     * name e.g. John Doe, Jane Doe
     * @param firstName The first name being passed in
     * @param lastName The last name being passed in
     * @return If the first name and last name matches the REGEX
     */
    public static boolean isValidName(String firstName, String lastName) {
        return firstName.matches(NAME_REGEX) && lastName.matches(NAME_REGEX);
    }

    /**
     * Validation for the credits
     * Must be numbers from 0-9
     * @param credits The credits being passed in
     * @return If the credits match the REGEX
     */
    public static boolean isValidCredits(int credits) {
        return String.valueOf(credits).matches(CREDITS_REGEX);
    }

    /**
     * Validation for the balance owing
     * Must be a non-negative decimal number
     * @param balanceOwing The balance owed by the student being passed in
     * @return If the balance owing is valid (>= 0)
     */
    public static boolean isValidBalanceOwing(double balanceOwing) {
        return balanceOwing >= 0;
    }
}
