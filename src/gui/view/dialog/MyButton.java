package gui.view.dialog;

<<<<<<< HEAD
import javax.swing.*;
import java.io.Serial;

public class MyButton extends JButton {
    @Serial
    private static final long serialVersionUID = 7827454444333406502L;

    public MyButton(String text){
        super(text);
    }
=======

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
	
	
	
>>>>>>> 3
}
