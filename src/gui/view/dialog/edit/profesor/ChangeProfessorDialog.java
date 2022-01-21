package gui.view.dialog.edit.profesor;

import gui.view.MainWindow;
import gui.view.center.ProfessorsTable;
import gui.view.dialog.MyDialog;
import model.Professor;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.io.Serial;


public class ChangeProfessorDialog extends MyDialog {


    @Serial
    private static final long serialVersionUID = -4880791851891937466L;
    private JTabbedPane tabbedPane;

    public ChangeProfessorDialog(final Professor Professor) {
        super(MainWindow.getInstance(), "Izmena Profesora");
        EditProfessor editProfessor = new EditProfessor(Professor);
        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Informacije",editProfessor);


        Subjects Subjects = new Subjects(this,Professor);
        tabbedPane.addTab("Predmeti",Subjects);
        this.add(tabbedPane);
        tabbedPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if(tabbedPane.getSelectedIndex()==1){
                    Subjects.refreshTableIspiti();
                    ProfessorsTable.getInstance().refreshTable();
                }
            }
        });
    }
}
