package gui.view.dialog.edit.student;

import javax.swing.table.AbstractTableModel;

import model.Student;

public class AbstractTableModelNepolozeniIspiti extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5820853360617025345L;

	Student student;
	
	AbstractTableModelNepolozeniIspiti(Student student) {
		this.student = student;
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return student.getFailedExams().size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return student.getColumnCountNepolozeni();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return student.getValueAtNepolozeni(rowIndex, columnIndex);
	}

	@Override
	public String getColumnName(int column) {
		return student.getColumnNameNepolozeni(column);
	}
	
}
