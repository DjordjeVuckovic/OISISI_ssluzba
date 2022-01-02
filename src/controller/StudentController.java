package controller;

import gui.view.center.StudentsTable;
import model.BazaStudenata;
import model.Student;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
        student.setName(stN.getName());
        student.setSurname(stN.getSurname());
        student.setCurrentyear(stN.getCurrentyear());
        student.setFinansiranje(stN.getNacinFinansiranja());
        student.setEnrollYear(stN.getEnrollYear());
        student.setIndex(stN.getIndex());
        student.setContactPhone(stN.getContactPhone());
        student.setAvgGrade(stN.getavgGrade());
        student.setAdress(student.getAdress().getStreet(),student.getAdress().getNumber(),student.getAdress().getCity(),student.getAdress().getCountry());
        StudentsTable.getInstance().refreshTable();
    }

}
