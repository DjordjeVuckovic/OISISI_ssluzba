package gui.view.dialog.edit.professor;

import gui.view.MainWindow;
import gui.view.dialog.MyDialog;
import model.Professor;

import javax.swing.*;

public class ChangeProfessorDialog extends MyDialog {
    //private static ChangeStudentDialog instance=null;
    //public static ChangeStudentDialog getInstance(){
       // if(instance ==null){
           // instance=new ChangeStudentDialog();
       // }
        //return instance;
   // }

    private JTabbedPane tabbedPane;

    public ChangeProfessorDialog(final Professor profesor) {
        super(MainWindow.getInstance(), "Izmena Profesora");
        EditProfessor editProfessor = new EditProfessor(profesor);
        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Informacije",editProfessor);
        this.add(tabbedPane);
    }
}
