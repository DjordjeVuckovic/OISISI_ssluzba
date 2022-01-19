package controller;

import gui.view.center.StudentsTable;
import model.BazaStudenata;
import model.Student;

public class StudentController {
    private static  StudentController instance = null;
    public static StudentController getInstance(){
        if(instance==null){
            instance = new StudentController();
        }
        return instance;
    }
    private StudentController(){}
    public void addStudent(Student st){
        BazaStudenata.getInstance().addStudent(st);
        StudentsTable.getInstance().refreshTable();
    }
    public void deleteStudent(int row){
        if(row <0){
            return;
        }
        Student student = BazaStudenata.getInstance().getStudentByRow(row);
        BazaStudenata.getInstance().deleteStudent(student);
        StudentsTable.getInstance().refreshTable();
    }
    public Student getStudentByIndex(String index){
        Student student = BazaStudenata.getInstance().getStudentById(index);
        return student;
    }
    public void editStudent(Student student,Student stN){
        BazaStudenata.getInstance().editStudent(student,stN);
        StudentsTable.getInstance().refreshTable();
    }

}
