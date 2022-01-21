package model;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

public class BazaPodataka implements Serializable {
    @Serial
    private static final long serialVersionUID = 3482140730556264549L;
    private ArrayList<Student> students;
    private ArrayList<Professor> professors;
    private ArrayList<Subject> subjects;
    private ArrayList<Department> departments;

    public BazaPodataka() {
        students = new ArrayList<>();
        professors = new ArrayList<>();
        subjects = new ArrayList<>();
        departments = new ArrayList<>();
    }

    public BazaPodataka(ArrayList<Student> students, ArrayList<Professor> professors, ArrayList<Subject> subjects,ArrayList<Department> departments) {
        super();
        this.students = students;
        this.professors = professors;
        this.subjects = subjects;
        this.departments = departments;
    }


    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Professor> getProfessors() {
        return professors;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }
}
