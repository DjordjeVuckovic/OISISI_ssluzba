package gui.view;

import gui.view.center.StudentsTable;
import gui.view.center.SubjectTable;

import javax.swing.*;
import java.awt.*;

public class CentralBox extends JTabbedPane {
private static CentralBox instance = null;
private JTable studentsTable;
private JTable SubjectTable;

public static CentralBox getInstance() {
	if(instance==null) instance = new CentralBox();
	return instance;
}
private CentralBox() {
	JPanel panelStudents = new JPanel(new BorderLayout());
	studentsTable = new StudentsTable();
	JScrollPane jScrollPaneStudents= new JScrollPane(studentsTable);
	panelStudents.add(jScrollPaneStudents,BorderLayout.CENTER);
	this.addTab("Students",panelStudents);

	JPanel panelSubject = new JPanel(new BorderLayout());
	SubjectTable = new SubjectTable();
	JScrollPane jScrollPaneSubject= new JScrollPane(SubjectTable);
	panelSubject.add(jScrollPaneSubject,BorderLayout.CENTER);
	this.addTab("Subject",panelSubject);


}

}
