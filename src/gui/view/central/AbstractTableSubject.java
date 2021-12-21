package gui.view.central;

import model.BazaPredmeta;

import javax.swing.table.AbstractTableModel;

public class AbstractTableSubject extends AbstractTableModel {
    @Override
    public int getRowCount() {
        return BazaPredmeta.getInstance().getRowCount();
    }

    @Override
    public int getColumnCount() {
        return BazaPredmeta.getInstance().getColumnCount();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return BazaPredmeta.getInstance().getValueAt(rowIndex,columnIndex);
    }

    @Override
    public String getColumnName(int column) {
        return BazaPredmeta.getInstance().getColumnName(column);
    }
}
