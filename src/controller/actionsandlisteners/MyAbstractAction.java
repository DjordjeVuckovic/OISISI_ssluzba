package controller.actionsandlisteners;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import gui.view.CentralBox;
import gui.view.MainWindow;
import gui.view.ScaleImage;
import gui.view.dialog.AddStudent;

public class MyAbstractAction extends AbstractAction implements ScaleImage {
	
	
	private static final long serialVersionUID = 2525487053356975101L;
	private String name;
	
	
	public ImageIcon scaleImg(ImageIcon ic) {
		
		Image scaleImage = ic.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
		ImageIcon ic1 = new ImageIcon(scaleImage);
		return ic1;
}
	public  MyAbstractAction(String s) {
		name=s;
		switch (s) {
		case "New":
			putValue(Action.NAME, "New");
			putValue(MNEMONIC_KEY, KeyEvent.VK_N);
			putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
			putValue(SMALL_ICON, scaleImg(new ImageIcon("img/21.png")));
			break;
		case "Save":
			putValue(Action.NAME, "Save");
			putValue(MNEMONIC_KEY, KeyEvent.VK_S);
			putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
			putValue(SMALL_ICON, scaleImg(new ImageIcon("img/save.png")));
			break;
		case "Studenti":
			putValue(Action.NAME, "Studenti");
			putValue(MNEMONIC_KEY, KeyEvent.VK_1);
			putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_1,ActionEvent.CTRL_MASK));
			putValue(SMALL_ICON, scaleImg(new ImageIcon("img/student.png")));
			break;
		case "Predmeti":
			putValue(Action.NAME, "Predmeti");
			putValue(MNEMONIC_KEY, KeyEvent.VK_2);
			putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_2,ActionEvent.CTRL_MASK));
			putValue(SMALL_ICON, scaleImg(new ImageIcon("img/subject.png")));
			break;
		case "Profesori":
			putValue(Action.NAME, "Profesori");
			putValue(MNEMONIC_KEY, KeyEvent.VK_3);
			putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_3,ActionEvent.CTRL_MASK));
			putValue(SMALL_ICON, scaleImg(new ImageIcon("img/prof.png")));
			break;
		case "Katedre":
			putValue(Action.NAME, "Katedre");
			putValue(MNEMONIC_KEY, KeyEvent.VK_3);
			putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_3,ActionEvent.CTRL_MASK));
			putValue(SMALL_ICON, scaleImg(new ImageIcon("img/dep.jpg")));
			break;
		case "Close":
			putValue(Action.NAME, "Close");
			putValue(MNEMONIC_KEY, KeyEvent.VK_C);
			putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
			putValue(SMALL_ICON, scaleImg(new ImageIcon("img/close.jpg")));
			break;
		case "Edit":
			putValue(Action.NAME, "Edit");
			putValue(MNEMONIC_KEY, KeyEvent.VK_E);
			putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
			putValue(SMALL_ICON, scaleImg(new ImageIcon("img/edit1.png")));
			break;
		case "Delete":
			putValue(Action.NAME, "Delete");
			putValue(MNEMONIC_KEY, KeyEvent.VK_D);
			putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
			putValue(SMALL_ICON, scaleImg(new ImageIcon("img/delete.jpg")));
			break;
		case "Help":
			putValue(Action.NAME, "Help");
			putValue(MNEMONIC_KEY, KeyEvent.VK_H);
			putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_H,ActionEvent.CTRL_MASK));
			putValue(SMALL_ICON, scaleImg(new ImageIcon("img/help.png")));
			break;
		case "About":
			putValue(Action.NAME, "About");
			putValue(MNEMONIC_KEY, KeyEvent.VK_A);
			putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
			putValue(SMALL_ICON, scaleImg(new ImageIcon("img/about.png")));
			break;
		
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if(name.equals("New")){
			switch (CentralBox.getInstance().getSelectedIndex()){
				case 0:
					AddStudent.getInstance().setVisible(true);
					break;
				case 1:
					//AddProffesor
				case 2:
					//AddPredmet
			}
		}
		else if(name.equals("Save")){
			//
		}
		else if(name.equals("Delete")){
			//
		}


		else if(name.equals("close")) {
			//MainWindow.exit();
		}
		
	}

}
