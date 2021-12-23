package gui.view.center;

import model.BazaProfesora;

import javax.swing.table.AbstractTableModel;

public class AbstractTableProfessors extends AbstractTableModel {
    public AbstractTableProfessors(){}
    @Override
    public int getRowCount() {
        return BazaProfesora.getInstance().getRowCount();
    }

    @Override
    public int getColumnCount() {
        return BazaProfesora.getInstance().getColumnCount();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return BazaProfesora.getInstance().getValueAt(rowIndex , columnIndex);
    }
    public String getColumnName(int column){
        return BazaProfesora.getInstance().getColumnName(column);
    }

}
