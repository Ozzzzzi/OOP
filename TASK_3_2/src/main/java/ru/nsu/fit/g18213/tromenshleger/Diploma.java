package ru.nsu.fit.g18213.tromenshleger;

import java.util.ArrayList;

public class Diploma {

    private ArrayList<Exam> diplomaGrades;

    public Diploma() {
        diplomaGrades = new ArrayList<>();
    }

    public void addGrade(String name, int grade) {
        diplomaGrades.add(new Exam(name, grade));
    }

    public void removeGrade(String name) {
        diplomaGrades.removeIf(subj -> subj.getName().equals(name));
    }

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

    public boolean noSats() {
        for (Exam ex : diplomaGrades) {
            if (ex.getGrade() < 4) {
                return false;
            }
        }
        return true;
    }
}
