package action_and_listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.ObjectInputValidation;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

public  class MyAction extends AbstractAction {
	public MyAction(String s) {
		s.toLowerCase();
		switch(s) {
		case "new":
		{
			putValue(NAME,"New");
			putValue(MNEMONIC_KEY,KeyEvent.VK_N);
			putValue(SMALL_ICON, new ImageIcon("img/new.png"));
			putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
			break;
		}
		case "close":
		{
			putValue(NAME,"Close");
			putValue(MNEMONIC_KEY,KeyEvent.VK_C);
			putValue(SMALL_ICON, new ImageIcon("img/new.png"));
			putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
			break;
		}
		case "edit":
		{
			putValue(NAME,"Edit");
			putValue(MNEMONIC_KEY,KeyEvent.VK_E);
			putValue(SMALL_ICON, new ImageIcon("img/new.png"));
			putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
			break;
		}
		case "delete":
		{
			putValue(NAME,"Delete");
			putValue(MNEMONIC_KEY,KeyEvent.VK_D);
			putValue(SMALL_ICON, new ImageIcon("img/new.png"));
			putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));
			break;
		}
		case "help":
		{
			putValue(NAME,"Help");
			putValue(MNEMONIC_KEY,KeyEvent.VK_H);
			putValue(SMALL_ICON, new ImageIcon("img/new.png"));
			putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_DOWN_MASK));
			break;
		}
		case "about":
		{
			putValue(NAME,"About");
			putValue(MNEMONIC_KEY,KeyEvent.VK_A);
			putValue(SMALL_ICON, new ImageIcon("img/new.png"));
			putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
			break;
		}
		
		
		
		
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
}
