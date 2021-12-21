package gui.view.central;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class CentralTable extends JPanel{
	protected JTable table;
	
	public CentralTable() {
		super();
		this.setLayout(new GridLayout());
		this.setMaximumSize(this.getSize());
		table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer());
		table.setRowSelectionAllowed(true);
		table.setColumnSelectionAllowed(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	}

}
