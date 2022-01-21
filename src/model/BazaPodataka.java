package model;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BazaPodataka implements Serializable {
    @Serial
    private static final long serialVersionUID = 3482140730556264549L;
    private ArrayList<Student> students;
    private ArrayList<Professor> professors;
    private ArrayList<Subject> subjects;

    public BazaPodataka() {
        students = new ArrayList<>();
        professors = new ArrayList<>();
        subjects = new ArrayList<>();
    }

    public BazaPodataka(ArrayList<Student> students, ArrayList<Professor> professors, ArrayList<Subject> subjects) {
        super();
        this.students = students;
        this.professors = professors;
        this.subjects = subjects;
    }


    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Professor> getProfessors() {
        return professors;
    }

    public void setProfessors(ArrayList<Professor> professors) {
        this.professors = professors;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<Subject> subjects) {
        this.subjects = subjects;
    }
}
