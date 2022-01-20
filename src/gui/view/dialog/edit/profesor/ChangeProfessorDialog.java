package gui.view.dialog.edit.profesor;

import gui.view.MainWindow;
import gui.view.dialog.MyDialog;
import model.Professor;

import javax.swing.*;

public class ChangeProfessorDialog extends MyDialog {
    //private static ChangeProfessorDialog instance=null;
    //public static ChangeProfessorDialog getInstance(){
       // if(instance ==null){
           // instance=new ChangeProfessorDialog();
       // }
        //return instance;
   // }

    private JTabbedPane tabbedPane;

    public ChangeProfessorDialog(final Professor Professor) {
        super(MainWindow.getInstance(), "Izmena Profesora");
        EditProfessor editProfessor = new EditProfessor(Professor);
        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Informacije",editProfessor);
        this.add(tabbedPane);
		/*
		 * Subjects Subjects = new Subjects(Professor);
		 * tabbedPane.addTab("Predmeti",Subjects ); this.add(tabbedPane);
		 */
    }
}