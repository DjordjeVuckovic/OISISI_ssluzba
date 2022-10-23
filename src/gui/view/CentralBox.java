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

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.TableRowSorter;

import gui.view.center.StudentsTable;



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


	sortStudentRows();
	this.addChangeListener(new ChangeListener() {
		@Override
		public void stateChanged(ChangeEvent e) {
			StudentsTable.getInstance().refreshTable();
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
