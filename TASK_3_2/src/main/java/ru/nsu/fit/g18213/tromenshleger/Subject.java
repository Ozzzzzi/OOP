package ru.nsu.fit.g18213.tromenshleger;

public abstract class Subject<T> {

    private String name;
    private T grade;

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(T grade) {
        this.grade = grade;
    };

    public String getName() {
        return name;
    }

    public T getGrade() {
        return grade;
    }
}
