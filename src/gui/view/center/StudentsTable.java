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
    private StudentsTable() {
        setName("Studenti");
        setRowSelectionAllowed(true);
        setColumnSelectionAllowed(true);
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setModel(new AbstractTableStudents());
        setAutoCreateRowSorter(true);
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
    public String getSelectedIndex(){
        String index = (String) this.getValueAt(this.getSelectedRow(),0);
        return index;
    }
    public int getSelectedIndexinTable(){
        return this.getSelectedRow();
    }

    public String getRowCnt(){
        int row = this.getSelectedRow();
        if(row==-1) return null;
        return (String) this.getValueAt(row,0);
    }


}
