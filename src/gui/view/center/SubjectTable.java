package gui.view.center;

import gui.view.CentralBox;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class SubjectTable extends JTable {
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
}
