package gui.view;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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
			
			
			JMenuItem mNew = new JMenuItem("New", scaleImg(new ImageIcon("img/21.png")));
			mNew.setMnemonic(KeyEvent.VK_N);
			mNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
			menu_file.add(mNew);
			
			JMenuItem mSave = new JMenuItem("Save", scaleImg(new ImageIcon("img/save.png")));
			mSave.setMnemonic(KeyEvent.VK_S);
			mSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
			menu_file.add(mSave);
			
			JMenuItem mOpen = new JMenuItem("Open",scaleImg(new ImageIcon("img/open.png")));
			mOpen.setMnemonic(KeyEvent.VK_O);
			mOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
			menu_file.add(mOpen);
			
			JMenuItem close_ = new JMenuItem("Close", scaleImg(new ImageIcon("img/close.jpg")));
			close_.setMnemonic(KeyEvent.VK_C);
			close_.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
			menu_file.add(close_);
			
			JMenu menu_edit = new JMenu("Edit");
			menu_edit.setMnemonic(KeyEvent.VK_E);
			
			JMenuItem mEdit = new JMenuItem("Edit",scaleImg(new ImageIcon("img/edit1.png")));
			mEdit.setMnemonic(KeyEvent.VK_E);
			mEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
			menu_edit.add(mEdit);
			
			JMenuItem mDelete = new JMenuItem("Delete",scaleImg(new ImageIcon("img/delete.jpg")));
			mDelete.setMnemonic(KeyEvent.VK_D);
			mDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
			menu_edit.add(mDelete);
			
			JMenu menu_help = new JMenu("Help");
			menu_help.setMnemonic(KeyEvent.VK_H);
			
			JMenuItem mHelp = new JMenuItem("Help",scaleImg(new ImageIcon("img/help.png")));
			mHelp.setMnemonic(KeyEvent.VK_H);
			mHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,ActionEvent.CTRL_MASK));
			menu_help.add(mHelp);
			
			JMenuItem mAbout = new JMenuItem("About", scaleImg(new ImageIcon("img/about.png")));
			mAbout.setMnemonic(KeyEvent.VK_A);
			mAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
			menu_help.add(mAbout);
		
		this.add(menu_file);
		this.add(menu_edit);
		this.add(menu_help);
	}

}
