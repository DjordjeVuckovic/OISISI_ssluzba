package gui.view;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;

public class MenuBar extends JMenuBar {
	private static final long serialVersionUID = 1L;
	
	public ImageIcon scaleImg(ImageIcon ic) {
		
			Image scaleImage = ic.getImage().getScaledInstance(40, 40,Image.SCALE_DEFAULT);
			ImageIcon ic1 = new ImageIcon(scaleImage);
			return ic1;
	}
	
		MenuBar() {
		
			JMenu menu_file = new JMenu("File");
			menu_file.setMnemonic(KeyEvent.VK_F);
			
			
			JMenuItem new_ = new JMenuItem("New", scaleImg(new ImageIcon("img/21.png")));
			new_.setMnemonic(KeyEvent.VK_N);
			new_.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
			menu_file.add(new_);
			menu_file.add(new JSeparator());
			
			JMenuItem save_ = new JMenuItem("Save", scaleImg(new ImageIcon("img/save.png")));
			save_.setMnemonic(KeyEvent.VK_S);
			save_.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
			menu_file.add(save_);
			menu_file.add(new JSeparator());
			//create submenu for open
			JMenu open_ = new JMenu("Open");
			open_.setMnemonic(KeyEvent.VK_O);
			menu_file.add(open_);
		
			JMenuItem st_=new JMenuItem("Studenti",scaleImg(new ImageIcon("img/student.png")));
			st_.setMnemonic(KeyEvent.VK_1);
			st_.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,ActionEvent.CTRL_MASK));
			open_.add(st_);
			open_.add(new JSeparator());
			JMenuItem pr_=new JMenuItem("Predmeti",scaleImg(new ImageIcon("img/subject.png")));
			pr_.setMnemonic(KeyEvent.VK_2);
			pr_.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2,ActionEvent.CTRL_MASK));
			open_.add(pr_);
			open_.add(new JSeparator());
			JMenuItem prof_=new JMenuItem("Profesori",scaleImg(new ImageIcon("img/prof.png")));
			prof_.setMnemonic(KeyEvent.VK_3);
			prof_.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3,ActionEvent.CTRL_MASK));
			open_.add(prof_);
			open_.add(new JSeparator());
			JMenuItem kat_=new JMenuItem("Katedre",scaleImg(new ImageIcon("img/dep.jpg")));
			kat_.setMnemonic(KeyEvent.VK_4);
			kat_.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4,ActionEvent.CTRL_MASK));
			open_.add(kat_);
			
			
			menu_file.add(new JSeparator());
			
			
			
			JMenuItem close_ = new JMenuItem("Close", scaleImg(new ImageIcon("img/close.jpg")));
			close_.setMnemonic(KeyEvent.VK_C);
			close_.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
			menu_file.add(close_);
			
			
			JMenu menu_edit = new JMenu("Edit");
			menu_edit.setMnemonic(KeyEvent.VK_E);
			JMenuItem edit_ = new JMenuItem("Edit",scaleImg(new ImageIcon("img/edit1.png")));
			edit_.setMnemonic(KeyEvent.VK_E);
			edit_.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
			menu_edit.add(edit_);
			menu_edit.add(new JSeparator());
			
			JMenuItem delete_ = new JMenuItem("Delete",scaleImg(new ImageIcon("img/delete.jpg")));
			delete_.setMnemonic(KeyEvent.VK_D);
			delete_.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
			menu_edit.add(delete_);
		
			
			JMenu menu_help = new JMenu("Help");
			menu_help.setMnemonic(KeyEvent.VK_H);
			
			JMenuItem help_ = new JMenuItem("Help",scaleImg(new ImageIcon("img/help.png")));
			help_.setMnemonic(KeyEvent.VK_H);
			help_.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,ActionEvent.CTRL_MASK));
			menu_help.add(help_);
			menu_help.add(new JSeparator());
			
			JMenuItem about_ = new JMenuItem("About", scaleImg(new ImageIcon("img/about.png")));
			about_.setMnemonic(KeyEvent.VK_A);
			about_.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
			menu_help.add(about_);
			
		this.add(menu_file);
		this.add(menu_edit);
		this.add(menu_help);
	}

}
