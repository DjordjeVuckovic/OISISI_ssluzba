package gui.view.center;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;

public class ProfessorsTable extends JTable {
    /**
	 * 
	 */
	
	private static final long serialVersionUID = -8042894672216979364L;
	
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
        HideIdCol();
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
    public String getSelectedIndex(){
        String index = (String) this.getValueAt(this.getSelectedRow(),4);//ovde treba 4 a ne nulla nula je id studenta
        return index;
    }
    //ovako cemo da sakrijemo
    private void HideIdCol(){
        TableColumnModel tableColumnModel = this.getColumnModel();
        tableColumnModel.getColumn(4).setMinWidth(0);
        tableColumnModel.getColumn(4).setMaxWidth(0);
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
