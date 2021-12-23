package gui.view.center;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class StudentsTable extends JTable {
    private static StudentsTable instance=null;

    public static StudentsTable getInstance(){
        if(instance==null){
            instance = new StudentsTable();
        }
        return instance;
    }


    public StudentsTable() {
        setRowSelectionAllowed(true);
        setColumnSelectionAllowed(true);
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setModel(new AbstractTableStudents());
        setName("Studenti");
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


    public void refreshTable(){
        AbstractTableStudents model =(AbstractTableStudents) this.getModel();
        model.fireTableDataChanged();
        validate();
    }
    public String getRowCnt(){
        int row = this.getSelectedRow();
        if(row==-1) return null;
        return (String) this.getValueAt(row,0);
    }

}
