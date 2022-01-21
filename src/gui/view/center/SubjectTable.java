package gui.view.center;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.io.Serial;

public class SubjectTable extends JTable {
    @Serial
    private static final long serialVersionUID = -4175809032429004585L;
    private static SubjectTable instance = null;

    public static SubjectTable getInstance() {
        if(instance==null) instance = new SubjectTable();
        return instance;
    }
    private SubjectTable() {
        this.setRowSelectionAllowed(true);
        setColumnSelectionAllowed(true);
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setModel(new AbstractTableSubject());
    }
    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
        Component c = super.prepareRenderer(renderer, row, column);
        if (isRowSelected(row)) {
            c.setBackground(Color.LIGHT_GRAY);
        } else {
            c.setBackground(Color.WHITE);
        }
        return c;
    }
    public String getSelectedId(){
        String id = (String) this.getValueAt(this.getSelectedRow(),0);
        return id;
    }
    public void refreshTable(){
        AbstractTableSubject model =(AbstractTableSubject) this.getModel();
        model.fireTableDataChanged();
        validate();
    }

}
