package gui.view.center;

import javax.swing.table.AbstractTableModel;

import model.BazaProfesora;
import model.BazaStudenata;

public class AbstractTableProfessors extends AbstractTableModel {
    public AbstractTableProfessors(){}
    @Override
    public int getRowCount() {
        if(BazaProfesora.getInstance().isSearchMode()){
            return BazaProfesora.getInstance().getSearchProfessors().size();
        }
        else {
            return BazaProfesora.getInstance().getProfessors().size();
        }
    }

    @Override
    public int getColumnCount() {
        return BazaProfesora.getInstance().getColumnCount();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return BazaProfesora.getInstance().getValueAt(rowIndex,columnIndex);
    }
    public String getColumnName(int column){
        return BazaProfesora.getInstance().getColumnName(column);
    }

}
