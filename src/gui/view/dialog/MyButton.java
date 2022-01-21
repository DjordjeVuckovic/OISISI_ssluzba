package gui.view.dialog;


import java.awt.Color;

import javax.swing.JButton;

public class MyButton extends JButton{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1822947607830895966L;
	
	private Color zelena = new Color(0, 102, 0);

	public MyButton() {
		setBackground(zelena);
	}
	
	public MyButton(String txt) {
		super(txt);
		setBackground(zelena);
	}
	
	
	
}
