package ru.nsu.fit.g18213.tromenshleger;

/**
 * Implements an abstract class from which classes Exam, 
 * DiffCredit, Credit and QualifyingWork are inherited.
 */
public abstract class Subject<T> {
    
/**
 * Pack of setters and getters
 *
 */
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
