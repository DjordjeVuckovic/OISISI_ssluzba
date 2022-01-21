package gui.view.center;

import model.BazaPredmeta;

import javax.swing.table.AbstractTableModel;
import java.io.Serial;

public class AbstractTableSubject extends AbstractTableModel {
    @Serial
    private static final long serialVersionUID = 7104895964774040596L;

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
