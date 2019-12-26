package ru.nsu.fit.g18213.tromenshleger;

public class QualifyingWork extends Subject<Integer> {

    public QualifyingWork() {
        setName("NoWorkYet");
        setGrade(0);
    }

    public void addWork(String workName, int grade) {
        setName(workName);
        if ((grade > 5) || (grade < 2)) {
            throw new IllegalArgumentException("The valid range of grades is from 2 to 5");
        }
        setGrade(grade);
    }

    public void removeWork() {
        setName("NoWorkYet");
        setGrade(0);
    }
}
