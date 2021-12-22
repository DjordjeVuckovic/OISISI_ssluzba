package gui.view;

import gui.view.center.StudentsTable;
import gui.view.center.SubjectTable;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class CentralBox extends JTabbedPane {
//private static CentralBox instance = null;
private JTable studentsTable;
private JTable SubjectTable;
/*
public static CentralBox getInstance() {
	if(instance==null) instance = new CentralBox();
	return instance;
}
*/

public CentralBox(JTable tabStudents,JTable tabSubject) {
	JPanel panelStudents = new JPanel(new BorderLayout());
	//studentsTable = new StudentsTable();
	JScrollPane jScrollPaneStudents= new JScrollPane(tabStudents);
	panelStudents.add(jScrollPaneStudents,BorderLayout.CENTER);
	this.addTab("Students",panelStudents);

	JPanel panelSubject = new JPanel(new BorderLayout());
	//SubjectTable = new SubjectTable();
	JScrollPane jScrollPaneSubject= new JScrollPane(tabSubject);
	panelSubject.add(jScrollPaneSubject,BorderLayout.CENTER);
	this.addTab("Subject",panelSubject);
	this.addChangeListener(new ChangeListener() {
		@Override
		public void stateChanged(ChangeEvent e) {
			StudentsTable.getInstance().refreshTable();
		}
	});
}

}
