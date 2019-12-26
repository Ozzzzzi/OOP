package ru.nsu.fit.g18213.tromenshleger;

import java.util.ArrayList;

public class Session {

    private ArrayList<Exam> exams;
    private ArrayList<DiffCredit> diffCredits;
    private ArrayList<Credit> credits;

    public Session() {
        this.exams = new ArrayList<>();
        this.diffCredits = new ArrayList<>();
        this.credits = new ArrayList<>();
    }

    public void addExam(String name, int grade) {
        exams.add(new Exam(name, grade));
    }

    public void addDiffCredit(String name, int grade) {
        diffCredits.add(new DiffCredit(name, grade));
    }

    public void addCredit(String name, String grade) {
        credits.add(new Credit(name, grade));
    }

    public void removeSubject(String name) {
        exams.removeIf(subj -> subj.getName().equals(name));
        diffCredits.removeIf(subj -> subj.getName().equals(name));
        credits.removeIf(subj -> subj.getName().equals(name));
    }

    public double getAverageGrade() {
        int count = getGradesNum();
        if (count == 0) {
            return 0;
        } else {
            return getGradesSum() / count;
        }
        }

    public boolean noNotPass() {
        for (Credit cred: credits) {
            if (cred.getGrade().equals("notpass")) {
                return false;
            }
        }
        return true;
    }

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

    public int getGradesNum() {
        return exams.size() + diffCredits.size();
    }

}
