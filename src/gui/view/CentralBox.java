package gui.view;

import gui.view.center.StudentsTable;
import gui.view.center.SubjectTable;
import gui.view.center.ProfessorsTable;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class CentralBox extends JTabbedPane {
private static CentralBox instance = null;

public static CentralBox getInstance() {
	if(instance==null) instance = new CentralBox();
	return instance;
}


private  CentralBox() {
	JPanel panelStudents = new JPanel(new BorderLayout());
	JScrollPane jScrollPaneStudents= new JScrollPane(StudentsTable.getInstance());
	panelStudents.add(jScrollPaneStudents,BorderLayout.CENTER);
	this.addTab("Students",panelStudents);

	JPanel panelSubject = new JPanel(new BorderLayout());
	JScrollPane jScrollPaneSubject= new JScrollPane(SubjectTable.getInstance());
	panelSubject.add(jScrollPaneSubject,BorderLayout.CENTER);
	this.addTab("Subject",panelSubject);
	this.addChangeListener(new ChangeListener() {
		@Override
		public void stateChanged(ChangeEvent e) {
			StudentsTable.getInstance().refreshTable();
			SubjectTable.getInstance().refreshTable();
		}
	});
	
	JPanel panelProfesor = new JPanel(new BorderLayout());
	JScrollPane jScrollPaneProfesor = new JScrollPane(ProfessorsTable.getInstance());
	panelProfesor.add(jScrollPaneProfesor,BorderLayout.CENTER);
	this.addTab("Profesori",panelProfesor);
	this.addChangeListener(new ChangeListener() {
		@Override
		public void stateChanged(ChangeEvent e) {
			ProfessorsTable.getInstance().refreshTable();
			StudentsTable.getInstance().refreshTable();
			SubjectTable.getInstance().refreshTable();
			
		}
	});
}


}
