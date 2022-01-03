package gui.view.dialog.edit.student;

import gui.view.MainWindow;
import gui.view.dialog.MyDialog;
import model.Student;

import javax.swing.*;

public class ChangeStudentDialog extends MyDialog {
    //private static ChangeStudentDialog instance=null;
    //public static ChangeStudentDialog getInstance(){
       // if(instance ==null){
           // instance=new ChangeStudentDialog();
       // }
        //return instance;
   // }

    private JTabbedPane tabbedPane;

    public ChangeStudentDialog(final Student student) {
        super(MainWindow.getInstance(), "Izmena Studenta");
        EditStudent editStudent = new EditStudent(student);
        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Informacije",editStudent);
        this.add(tabbedPane);
    }
}
