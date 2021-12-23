package gui.view.center;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class ProfessorsTable extends JTable {
    private static ProfessorsTable instance=null;

    public static ProfessorsTable getInstance(){
        if(instance==null){
            instance = new ProfessorsTable();
        }
        return instance;
    }


    public ProfessorsTable() {
        setRowSelectionAllowed(true);
        setColumnSelectionAllowed(true);
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setModel(new AbstractTableProfessors());
        setName("Profesori");
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
        AbstractTableProfessors model =(AbstractTableProfessors) this.getModel();
        model.fireTableDataChanged();
        validate();
    }
    public String getRowCnt(){
        int row = this.getSelectedRow();
        if(row==-1) return null;
        return (String) this.getValueAt(row,0);
    }

}
