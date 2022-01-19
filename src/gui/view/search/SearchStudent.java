package gui.view.search;

import gui.view.center.StudentsTable;
import model.BazaStudenata;
import model.Student;

import java.util.ArrayList;

public class SearchStudent {
    public SearchStudent(){}
    public void searchStudents(String string){
        if(string.isBlank() || string.isEmpty()){
            BazaStudenata.getInstance().setSearchMode(false);
            StudentsTable.getInstance().refreshTable();
        }
        else{
            BazaStudenata.getInstance().setSearchMode(true);
        }
        ArrayList<Student> search = new ArrayList<>();
        string.trim().toLowerCase();
        String[] arraySt =string.split(",");
        // sw-1-2019, Marko, Marković
        if(arraySt.length ==3){
            for(Student student :BazaStudenata.getInstance().getStudents()){
                if(student.getIndex().toLowerCase().contains(arraySt[0].trim()) && student.getName().toLowerCase().contains(arraySt[1].trim()) && student.getSurname().contains(arraySt[2].trim())){
                    search.add(student);
                }
            }
        }
        //surname,name
        else if(arraySt.length ==2){
            for(Student student :BazaStudenata.getInstance().getStudents()){
                if(student.getSurname().toLowerCase().contains(arraySt[0].trim()) && student.getName().toLowerCase().contains(arraySt[1].trim())){
                    search.add(student);
                }
            }
        }
        //surname
        else if(arraySt.length ==1){
            for(Student student:BazaStudenata.getInstance().getStudents()){
                if(student.getSurname().toLowerCase().contains(arraySt[0].trim())){
                    search.add(student);
                }
            }
        }
        else{
            BazaStudenata.getInstance().setSearchMode(false);
        }
        BazaStudenata.getInstance().setSearchStudents(search);
        StudentsTable.getInstance().refreshTable();
    }
}
