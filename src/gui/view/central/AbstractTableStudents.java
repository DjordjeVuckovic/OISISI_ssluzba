package gui.view.central;

import model.BazaStudenata;

import javax.swing.table.AbstractTableModel;

public class AbstractTableStudents extends AbstractTableModel {
    public AbstractTableStudents(){}
    @Override
    public int getRowCount() {
        return BazaStudenata.getInstance().getRowCount();
    }

    @Override
    public int getColumnCount() {
        return BazaStudenata.getInstance().getColumnCount();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return BazaStudenata.getInstance().getValueAt(rowIndex,columnIndex);
    }
    public String getColumnName(int column){
        return BazaStudenata.getInstance().getColumnName(column);
    }

}
