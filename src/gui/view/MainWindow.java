package gui.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.print.attribute.standard.PrinterMoreInfoManufacturer;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class MainWindow extends JFrame {
	private static MainWindow unique_instance = null;
	public MainWindow() {
		super();
		setTitle("Studentska Sluzba FTN");
		Toolkit kit= Toolkit.getDefaultToolkit();//klasa nije staticka ali metoda jeste
		Dimension dim = kit.getScreenSize();
		int width = dim.width;
		int height = dim.height;
		setSize(width*3/4,height*3/4);
		setResizable(true);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		ImageIcon img_student= new ImageIcon("img/st.jpg");
		setIconImage(img_student.getImage());
		//this.setJMenuBar(MenuBar.getIn);
		getContentPane().setBackground(new Color(51, 153, 255)); 
	
	}

}
