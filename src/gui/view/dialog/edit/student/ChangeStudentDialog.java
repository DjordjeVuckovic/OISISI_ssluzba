package gui.view.dialog.edit.student;

import gui.view.MainWindow;
import gui.view.center.StudentsTable;
import gui.view.dialog.MyDialog;
import model.Student;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.io.Serial;

public class ChangeStudentDialog extends MyDialog {


    @Serial
    private static final long serialVersionUID = 8394619157539383781L;
    private JTabbedPane tabbedPane;

    public ChangeStudentDialog(final Student student) {
        super(MainWindow.getInstance(), "Izmena Studenta");
        EditStudent editStudent = new EditStudent(student);
        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Informacije",editStudent);

        PassedSubjects passedSubjects = new PassedSubjects(student);
        tabbedPane.addTab("Polozeni",passedSubjects);


        FailedSubjects failedSubjects = new FailedSubjects(this,student);
        tabbedPane.addTab("Nepolozeni",failedSubjects);
        this.add(tabbedPane);
        tabbedPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if(tabbedPane.getSelectedIndex()==1){
                    passedSubjects.refreshTablePassed();
                    StudentsTable.getInstance().refreshTable();
                }
                if(tabbedPane.getSelectedIndex()==2){
                    failedSubjects.refreshTableFailed();
                    StudentsTable.getInstance().refreshTable();
                }
            }
        });
    }
}
