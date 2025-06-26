package ca.nl.cna.ethan.drover.A4;

import java.util.*;
import java.util.stream.Collectors;

/**
 * The StudentManager class provides methods for managing
 * a list of Student objects. It includes methods for sorting and
 * filtering based on specific attributes using Java lambda expressions.
 *
 */
public class StudentManager {

    /**
     * Sorts the given list of students in ascending order based on
     * the number of course credits each student has.
     *
     * @param students the list of students to sort by course credits
     */
    public void sortByCredits(List<Student> students) {
        students.sort((student1, student2) -> Integer.compare(student1.getCourseCredits(), student2.getCourseCredits()));
    }

    /**
     * Sorts the given list of students alphabetically by last name,
     * ignoring case sensitivity.
     *
     * @param students the list of students to sort by last name
     */
    public void sortByLastName(List<Student> students) {
        students.sort((student1, student2) -> student1.getLastName().compareToIgnoreCase(student2.getLastName()));
    }

    /**
     * Filters the given list of students to include only those who
     * have a balance owing greater than 0.
     *
     * @param students the list of students to filter
     * @return a new list containing only students with a balance owing
     */
    public List<Student> filterWithBalance(List<Student> students) {
        return students.stream()
                .filter(student -> student.getBalanceOwing() > 0)
                .collect(Collectors.toList());
    }
}
