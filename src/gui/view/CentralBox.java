package gui.view;

import controller.compare.StudentAvgGradeCmp;
import controller.compare.StudentIdComparator;
import gui.view.center.StudentsTable;
import gui.view.center.SubjectTable;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.TableRowSorter;
import java.awt.*;

public class CentralBox extends JTabbedPane {
private static CentralBox instance = null;

public static CentralBox getInstance() {
	if(instance==null)
	{
		synchronized (CentralBox.class){
			if(instance == null){
				instance = new CentralBox();
			}
		}
	}
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

	sortIdRow();
	sortAvg();
	this.addChangeListener(new ChangeListener() {
		@Override
		public void stateChanged(ChangeEvent e) {
			StudentsTable.getInstance().refreshTable();
			SubjectTable.getInstance().refreshTable();
		}
	});
}
	public void  sortIdRow(){
		TableRowSorter tableRowSorter = new TableRowSorter(StudentsTable.getInstance().getModel());
		tableRowSorter.setComparator(0, new StudentIdComparator());
		StudentsTable.getInstance().setRowSorter(tableRowSorter);
	}
	public void sortAvg(){
		TableRowSorter tableRowSorter = new TableRowSorter(StudentsTable.getInstance().getModel());
		tableRowSorter.setComparator(5, new StudentAvgGradeCmp());
		StudentsTable.getInstance().setRowSorter(tableRowSorter);
	}

}
