package gui.view.center;

import model.BazaKatedri;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.io.Serial;

public class DepartmentsTable extends JTable {
    @Serial
    private static final long serialVersionUID = 8054281760067602497L;
    public static DepartmentsTable instance;

    public static DepartmentsTable getInstance(){
        if(instance==null){
            instance = new DepartmentsTable();
        }
        return instance;
    }
    DepartmentsTable (){
        setRowSelectionAllowed(true);
        setColumnSelectionAllowed(true);
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setModel(new AbstractDepartment());
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
    public String getSelectedIndex(){
        String index = (String) this.getValueAt(this.getSelectedRow(),0);
        return index;
    }

    private class AbstractDepartment extends AbstractTableModel
    {
        @Override
        public int getRowCount() {
            return BazaKatedri.getInstance().getRowCount();
        }

        @Override
        public int getColumnCount() {
            return BazaKatedri.getInstance().getColumnCount();
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return BazaKatedri.getInstance().getValueAt(rowIndex,columnIndex);
        }
        public String getColumnName(int column){
            return BazaKatedri.getInstance().getColumnName(column);
        }

    }
    public void refreshTable(){
        AbstractDepartment model = (AbstractDepartment) this.getModel();
        model.fireTableDataChanged();
        validate();
    }

}
