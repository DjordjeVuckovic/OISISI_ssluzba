package gui.view.dialog.edit.profesor;

import gui.view.MainWindow;
import gui.view.dialog.MyDialog;
import model.Professor;

import javax.swing.*;
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
        this.add(tabbedPane);
		/*
		 * Subjects Subjects = new Subjects(Professor);
		 * tabbedPane.addTab("Predmeti",Subjects ); this.add(tabbedPane);
		 */
    }
}