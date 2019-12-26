package ru.nsu.fit.g18213.tromenshleger;

import org.junit.Assert;
import org.junit.Test;


public class Tests {
    @Test
    public void myBook() {
        GradeBook myBook = new GradeBook(180745, "Yana Tromenshleger", "Computer Science", "FIT");

        String[] names = {"Discr", "MathAn", "Platf", "History", "PhysCult", "Declar"};
        String[] types = {"Exam", "Exam", "Credit", "DiffCredit", "Credit", "DiffCredit"};
        String[] grades = {"5", "5", "pass", "5", "pass", "5"};
        for (int i = 0; i < names.length; i++) {
            myBook.addSubjectToSession(1, types[i], names[i], grades[i]);
        }

        String[] names1 = {"Discr", "MathAn", "Phys", "Platf", "Decl"};
        String[] types1 = {"Exam", "Exam", "Credit", "DiffCredit", "DiffCredit"};
        String[] grades1 = {"4", "3", "notpass", "4", "4"};
        for (int i = 0; i < names1.length; i++) {
            myBook.addSubjectToSession(2, types1[i], names1[i], grades1[i]);
        }

        System.out.println(myBook.getAverageForAll());
        Assert.assertTrue(myBook.canGetScholarship(1));
        Assert.assertFalse(myBook.canGetScholarship(2));
        Assert.assertFalse(myBook.canGetRedDiploma());

        String[] names2 = {"Discr", "MathAn", "Platf", "Decl"};
        Integer[] grades2 = {4, 3, 4, 4};
        for (int i = 0; i < names2.length; i++) {
            myBook.addDiplomaGrade(names2[i], grades2[i]);
        }
        System.out.println(myBook.getAverageForAll());
        Assert.assertFalse(myBook.canGetRedDiploma());

        for (int i = 0; i < names1.length; i++) {
            myBook.removeSubjectFromSession(2, names1[i]);
        }
        System.out.println(myBook.getAverageForAll());
        for (int i = 0; i < names2.length; i++) {
            myBook.removeDiplomaGrade(names2[i]);
            myBook.addDiplomaGrade(names2[i], 5);
        }
        myBook.addQualifyingWork("SomeWork", 5);
        Assert.assertTrue(myBook.canGetRedDiploma());

        myBook.removeQualifying();
        Assert.assertFalse(myBook.canGetRedDiploma());
    }
}
