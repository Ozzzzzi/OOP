package ru.nsu.fit.g18213.tromenshleger;

import java.util.ArrayList;

public class Session {

    private ArrayList<Exam> exams;
    private ArrayList<DiffCredit> diffCredits;
    private ArrayList<Credit> credits;
    
/**
 * Constructor which just initializes the fields.
 */
    public Session() {
        this.exams = new ArrayList<>();
        this.diffCredits = new ArrayList<>();
        this.credits = new ArrayList<>();
    }

/**
 * Adds an exam to the exams list.
 *
 * @param   name        the exam title
 * @param   grade       the exam grade from 2 to 5
 */
    public void addExam(String name, int grade) {
        exams.add(new Exam(name, grade));
    }

/**
 * Adds a diff credit to the diff credits list.
 *
 * @param   name        the diff credit title
 * @param   grade       the credit grade from 2 to 5
 */
    public void addDiffCredit(String name, int grade) {
        diffCredits.add(new DiffCredit(name, grade));
    }
    
/**
 * Adds a credit to the credits list.
 *
 * @param   name        the credit title
 * @param   grade       the credit grade "pass" and "notpass"
 */
    public void addCredit(String name, String grade) {
        credits.add(new Credit(name, grade));
    }
    
/**
 * Removes the <code>name</code> subject from the session.
 *
 * @param   name        the credit title
 */
    public void removeSubject(String name) {
        exams.removeIf(subj -> subj.getName().equals(name));
        diffCredits.removeIf(subj -> subj.getName().equals(name));
        credits.removeIf(subj -> subj.getName().equals(name));
    }

/**
 * Calculates the average grade for this session.
 *
 * @return    the average grade
 */
    public double getAverageGrade() {
        int count = getGradesNum();
        if (count == 0) {
            return 0;
        } else {
            return getGradesSum() / count;
        }
        }

/**
 * Checks whether there are any "notpass" credits in this session.
 *
 * @return    true if there is no "notpass" and false otherwise
 */
    public boolean noNotPass() {
        for (Credit cred: credits) {
            if (cred.getGrade().equals("notpass")) {
                return false;
            }
        }
        return true;
    }

/**
 * Gets the sum of all grades for exams and diff credits for further usage.
 *
 * @return    the sum of the grades
 */
    public double getGradesSum() {
        double sum = 0;
        for (Exam ex : exams) {
            sum += ex.getGrade();
        }
        for (DiffCredit difcr : diffCredits) {
            sum += difcr.getGrade();
        }
        return sum;
    }
/**
 * Gets the total number exams and diff credits for further usage.
 *
 * @return    the total number of exams and diff credits
 */
    public int getGradesNum() {
        return exams.size() + diffCredits.size();
    }

}
