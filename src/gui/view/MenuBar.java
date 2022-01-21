package gui.view;


import java.awt.Color;
import java.awt.event.KeyEvent;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

import gui.view.actionsandlisteners.MyAbstractAction;



public class MenuBar extends JMenuBar {
	private static final long serialVersionUID = 1L;
	
		JMenu menu_file;
		JMenu mnuOpen;
		JMenu mnuEdit;
		JMenu mnuHelp;
		JMenu mnuLanguage;
		
		JMenuItem mniNew;
		JMenuItem mniSave;
		JMenuItem mniClose;
		JMenuItem mniEdit;
		JMenuItem mniDelete;
		JMenuItem mniHelp;
		JMenuItem mniAbout;
		JMenuItem mniStudenti;
		JMenuItem mniPredmeti;
		JMenuItem mniProfesori;
		JMenuItem mniKatedre;
		
		JMenuItem mniSrpski; //ili JCheckBoxMenuItem?
		JMenuItem mniEnglish;
	
		MenuBar() {
			this.setBackground(new Color(51, 153, 255));
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
			
			//MainFrame.getInstance().getResourceBundle().getString("menu_file"));
			
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
			
			JMenu menu_lang = new JMenu("Language");
			menu_lang.setMnemonic(KeyEvent.VK_L);
			MyAbstractAction Srpski= new MyAbstractAction("Srpski");
			menu_lang.add(Srpski);
			menu_lang.add(new JSeparator());
			MyAbstractAction English= new MyAbstractAction("English");
			menu_lang.add(English);
			
			this.add(menu_file);
			this.add(menu_edit);
			this.add(menu_help);
			this.add(menu_lang);
			
			
			
	}

		public void initComponents() {
			//Language.setText(MainWindow.getInstance().getResourceBundle().getString("mnuFile"));
				mniNew.setText(MainWindow.getInstance().getResourceBundle().getString("mniNew"));
				mniSave.setText(MainWindow.getInstance().getResourceBundle().getString("mniSave"));
				mnuOpen.setText(MainWindow.getInstance().getResourceBundle().getString("mnuOpen"));
					mniStudenti.setText(MainWindow.getInstance().getResourceBundle().getString("mniStudenti"));
					mniPredmeti.setText(MainWindow.getInstance().getResourceBundle().getString("mniPredmeti"));
					mniProfesori.setText(MainWindow.getInstance().getResourceBundle().getString("mniProfesori"));
					mniKatedre.setText(MainWindow.getInstance().getResourceBundle().getString("mniKatedre"));
				mniClose.setText(MainWindow.getInstance().getResourceBundle().getString("mniClose"));
				
			mnuEdit.setText(MainWindow.getInstance().getResourceBundle().getString("mnuEdit"));
				mniEdit.setText(MainWindow.getInstance().getResourceBundle().getString("mniEdit"));
				mniDelete.setText(MainWindow.getInstance().getResourceBundle().getString("mniDelete"));
				
			mnuHelp.setText(MainWindow.getInstance().getResourceBundle().getString("mnuHelp"));
				mniHelp.setText(MainWindow.getInstance().getResourceBundle().getString("mniHelp"));
				mniAbout.setText(MainWindow.getInstance().getResourceBundle().getString("mniAbout"));
				
			mnuLanguage.setText(MainWindow.getInstance().getResourceBundle().getString("mnuLanguage"));
				mniSrpski.setText(MainWindow.getInstance().getResourceBundle().getString("mniSrpski"));
				mniEnglish.setText(MainWindow.getInstance().getResourceBundle().getString("mniEnglish"));
			
		}

}
