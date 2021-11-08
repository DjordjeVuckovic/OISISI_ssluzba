package gui.view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class MenuBar extends JMenuBar {
	private static final long serialVersionUID = 1L;
	public MenuBar() {
		JMenu menu_file = new JMenu("File");
		JMenu menu_edit = new JMenu("Edit");
		JMenu menu_help = new JMenu("Help");
		
		this.add(menu_file);
		this.add(menu_edit);
		this.add(menu_help);
	}

}
