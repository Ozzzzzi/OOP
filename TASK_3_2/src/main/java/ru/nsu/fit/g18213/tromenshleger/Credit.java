package ru.nsu.fit.g18213.tromenshleger;

public class Credit extends Subject<String> {

    public Credit(String name, String grade) {
        setName(name);
        if ((grade.equals("pass")) || (grade.equals("notpass"))) {
            setGrade(grade);
        } else {
            throw new IllegalArgumentException("The valid range of grades is from 2 to 5");
        }
    }
}
