package ru.nsu.fit.g18213.tromenshleger;

public class Exam extends Subject<Integer> {

    public Exam(String name, int grade) {
        setName(name);
        if ((grade > 5) || (grade < 2)) {
            throw new IllegalArgumentException("The valid range of grades is from 2 to 5");
        }
        setGrade(grade);
    }
}
