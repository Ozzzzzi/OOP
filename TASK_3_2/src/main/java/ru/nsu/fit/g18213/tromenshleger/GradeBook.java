package ru.nsu.fit.g18213.tromenshleger;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;


public class GradeBook {

     private int bookNum;
     private String name;
     private String speciality;
     private String department;

     private Diploma diploma;
     private QualifyingWork qualifyingWork;
     private Map<Integer, Session> sessions;

/**
 * Constructor which initializes all the fields in the book.
 */
     public GradeBook(int bookNum, String name, String speciality, String department) {
         this.bookNum = bookNum;
         this.name = name;
         this.speciality = speciality;
         this.department = department;
         this.diploma = new Diploma();
         this.qualifyingWork = new QualifyingWork();
         this.sessions = new HashMap<>();
    }

/**
 * Adds a new subject of the given type to the given session.  
 * Available subject types are "Exam", "Credit" and "DiffCredit".
 * Sessions are numerated from 1 to 10. Grades for credit are "pass"
 * and "notpass". Grades for exam and diff credit are in the range 
 * from 2 to 5.
 *
 * @param  sessionNum                 the number of session
 * @param  type                       the subject type
 * @param  name                       the subject title
 * @param  grade                      the grade for exam, diff credit or credit
 * @throws IllegalArgumentException   if any parameter is out of available values
 */
    public void addSubjectToSession(int sessionNum, String type, String name, String grade) {
         if (sessionNum > 10 || sessionNum < 1) {
             throw new IllegalArgumentException("Available range for session num is from 1 to 10");
         }

         Session curr;
         if (!(sessions.containsKey(sessionNum))) {
             curr = new Session();
             sessions.put(sessionNum, curr);
         } else {
             curr = sessions.get(sessionNum);
         }
         if (type.equals("Credit")) {
            curr.addCredit(name, grade);
            return;
         }

         int convertedGrade;
         try {
            convertedGrade = Integer.parseInt(grade);
         } catch(Exception NumberFormatException) {
            convertedGrade = 0;
         }
         if (type.equals("Exam")) {
            curr.addExam(name, convertedGrade);
         } else if (type.equals("DiffCredit")) {
            curr.addDiffCredit(name, convertedGrade);
         } else {
            throw new IllegalArgumentException("Available types are \"Exam\", \"DiffCredit\" and \"Credit\"");
         }

    }
     
/**
 * Removes subject from the given session by the subject name.
 *
 * @param  sessionNum                 the number of session
 * @param  name                       the subject title
 * @throws IllegalArgumentException   if any <code>sessionNum</code> is out of available values
 * @throws NoSuchElementException     if no session with the <code>sessionNum</code> was found
 */
    public void removeSubjectFromSession(int sessionNum, String name) {
        if (sessionNum > 10 || sessionNum < 1) {
            throw new IllegalArgumentException("Available range for session num is from 1 to 10");
        }
        if (sessions.containsKey(sessionNum)) {
            sessions.get(sessionNum).removeSubject(name);
        } else {
            throw new NoSuchElementException("No session was found");
        }
    }
/**
 * Adds a qualifying work to the grade book.
 *
 * @param  nameOfWork                 the name of qualifying work
 * @param  grade                      the grade from 1 to 5
 */
    public void addQualifyingWork(String nameOfWork, int grade) {
         qualifyingWork.addWork(nameOfWork, grade);
    }
     
/**
 * Removes the qualifying work from the grade book
 * and resets all fields.
 *
 */
    public void removeQualifying() {
         qualifyingWork.removeWork();
    }
     
/**
 * Adds final grade for some subject to the diploma supplement.
 *
 * @param  name                 the subject title
 * @param  grade                the grade from 1 to 5
 */
    public void addDiplomaGrade(String name, int grade) {
         diploma.addGrade(name, grade);
    }

/**
 * Removes the given subject from the diploma supplement.
 *
 * @param  name                 the subject title
 */   
    public void removeDiplomaGrade(String name) {
        diploma.removeGrade(name);
    }

/**
 * Finds the average grade for all sessions presented in the book.
 *
 * @return       the average grade
 */
    public double getAverageForAll() {
         double grade = 0;
         int count = 0;
         for (Session curr : sessions.values()) {
            grade += curr.getGradesSum();
            count += curr.getGradesNum();
         }
        if (count == 0) {
            return 0;
        } else {
            return grade / count;
        }
    }

     
/**
 * Checks whether it is possible to get red diploma on the current 
 * study stage.
 *
 * @return       true if possible and false otherwise
 */
    public boolean canGetRedDiploma() {
         for (Session curr : sessions.values()) {
             if (!(curr.noNotPass()))
                 return false;
         }
         return (diploma.noSats()) && (diploma.getDiplomaGrade() >= 4.75) && (qualifyingWork.getGrade() == 5);
    }

/**
 * Checks whether it is possible to get increased scholarship 
 * in the <code>sessionNum</code> session.
 *
 * @param   sessionNum   the number of session
 * @return               true if possible and false otherwise
 */
    public boolean canGetScholarship(int sessionNum) {
        if (sessions.containsKey(sessionNum)) {
            Session curr = sessions.get(sessionNum);
            return (curr.noNotPass()) && (curr.getAverageGrade() == 5);
        } else {
            throw new NoSuchElementException("No session was found");
        }
    }
     
/**
 * Pack of setters and getters for the grade book.
 *
 */
    public String getQualifyingName() {
        return qualifyingWork.getName();
    }

    public int getQualifyingGrade() {
        return qualifyingWork.getGrade();
    }

    public void setName(String newName) {
         name = newName;
    }

    public void setSpec(String newSpec) {
        speciality = newSpec;
    }

    public void setDep(String newDep) {
        department = newDep;
    }

    public int getNum() {
        return bookNum;
    }

    public String getName() {
        return name;
    }

    public String getSpec() {
        return speciality;
    }

    public String getDep() {
        return department;
    }

}
