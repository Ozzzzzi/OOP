package ru.nsu.fit.g18213.tromenshleger;

import java.util.ArrayList;

public class Diploma {

    private ArrayList<Exam> diplomaGrades;

/**
 * Constructor initializes the diploma supplement.
 *
 */
    public Diploma() {
        diplomaGrades = new ArrayList<>();
    }
    
/**
 * Adds the final grade for some subject in the diploma supplement.
 *
 * @param  name    the title of the subject
 * @param  grade   the final grade for this subject
 */
    public void addGrade(String name, int grade) {
        diplomaGrades.add(new Exam(name, grade));
    }

/**
 * Removes the final grade for the given subject from the diploma supplement.
 *
 * @param  name    the title of the subject
 */
    public void removeGrade(String name) {
        diplomaGrades.removeIf(subj -> subj.getName().equals(name));
    }

/**
 * Gets the average grade for the diploma supplement.
 *
 * @return       the average grade
 */
    public double getDiplomaGrade() {
        double grade = 0;
        for (Exam ex : diplomaGrades) {
            grade += ex.getGrade();
        }
        if (diplomaGrades.size() == 0) {
            return 0;
        } else {
            return grade / diplomaGrades.size();
        }
    }

/**
 * Checks whether there are no final sats in the diploma supplement.
 *
 * @return        true if no sats and false otherwise
 */
    public boolean noSats() {
        for (Exam ex : diplomaGrades) {
            if (ex.getGrade() < 4) {
                return false;
            }
        }
        return true;
    }
}
