package gui.view;



import controller.compare.StudentAvgGradeCmp;
import controller.compare.StudentIdComparator;
import gui.view.center.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.TableRowSorter;
import java.awt.*;



import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.TableRowSorter;

import controller.compare.StudentAvgGradeCmp;
import controller.compare.StudentIdComparator;
import gui.view.center.StudentsTable;
import gui.view.center.SubjectTable;


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


	JPanel panelProfessors= new JPanel(new BorderLayout());
	JScrollPane jScrollPaneProfessors= new JScrollPane(ProfessorsTable.getInstance());
	panelProfessors.add(jScrollPaneProfessors,BorderLayout.CENTER);
	this.addTab("Professors",panelProfessors);

	JPanel pDep= new JPanel(new BorderLayout());
	JScrollPane jDep= new JScrollPane(DepartmentsTable.getInstance());
	pDep.add(jDep,BorderLayout.CENTER);
	this.addTab("Departments",pDep);

	sortStudentRows();
	this.addChangeListener(new ChangeListener() {
		@Override
		public void stateChanged(ChangeEvent e) {
			StudentsTable.getInstance().refreshTable();
			SubjectTable.getInstance().refreshTable();
			ProfessorsTable.getInstance().refreshTable();
			DepartmentsTable.getInstance().refreshTable();
		}
	});
}
	public void  sortStudentRows(){
		TableRowSorter tableRowSorter = new TableRowSorter(StudentsTable.getInstance().getModel());
		tableRowSorter.setComparator(0, new StudentIdComparator());
		tableRowSorter.setComparator(5,new StudentAvgGradeCmp());
		StudentsTable.getInstance().setRowSorter(tableRowSorter);
	}


}
