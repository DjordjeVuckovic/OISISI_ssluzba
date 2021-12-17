package gui.view;


import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JSeparator;
import actionsandlisteners.MyAbstractAction;


public class MenuBar extends JMenuBar {
	private static final long serialVersionUID = 1L;
	
	
		MenuBar() {

			JMenu menu_file = new JMenu("File");
			menu_file.setMnemonic(KeyEvent.VK_F);
			MyAbstractAction New= new MyAbstractAction("New");
			menu_file.add(New);
			menu_file.add(new JSeparator());
			MyAbstractAction Save= new MyAbstractAction("Save");
			menu_file.add(Save);
			menu_file.add(new JSeparator());
			//create submenu for open
			JMenu open_ = new JMenu("Open");
			open_.setMnemonic(KeyEvent.VK_O);
			menu_file.add(open_);
			MyAbstractAction Studenti= new MyAbstractAction("Studenti");
			open_.add(Studenti);
			open_.add(new JSeparator());
			MyAbstractAction Predmeti= new MyAbstractAction("Predmeti");
			open_.add(Predmeti);
			open_.add(new JSeparator());
			MyAbstractAction Profesori= new MyAbstractAction("Profesori");
			open_.add(Profesori);
			open_.add(new JSeparator());
			MyAbstractAction Katedre= new MyAbstractAction("Katedre");
			open_.add(Katedre);
			menu_file.add(new JSeparator());
			MyAbstractAction Close= new MyAbstractAction("Close");
			menu_file.add(Close);
			
			
			
			JMenu menu_edit = new JMenu("Edit");
			menu_edit.setMnemonic(KeyEvent.VK_E);
			MyAbstractAction Edit= new MyAbstractAction("Edit");
			menu_edit.add(Edit);
			menu_edit.add(new JSeparator());
			MyAbstractAction Delete= new MyAbstractAction("Delete");
			menu_edit.add(Delete);
			
			JMenu menu_help = new JMenu("Help");
			menu_help.setMnemonic(KeyEvent.VK_H);
			MyAbstractAction Help= new MyAbstractAction("Help");
			menu_help.add(Help);
			menu_help.add(new JSeparator());
			MyAbstractAction About= new MyAbstractAction("About");
			menu_help.add(About);
			
			this.add(menu_file);
			this.add(menu_edit);
			this.add(menu_help);
	}

}
