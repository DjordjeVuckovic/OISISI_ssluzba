package gui.view;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.WindowConstants;


public class MainWindow extends JFrame {
	
	private static final long serialVersionUID = 1L;

	
	public MainWindow() {
		super();
		setTitle("Studentska  Slu\u017Eba FTN");
		Toolkit kit= Toolkit.getDefaultToolkit();//klasa nije staticka ali metoda jeste
		Dimension dim = kit.getScreenSize();
		int width = dim.width;
		int height = dim.height;
		setSize(width*3/4,height*3/4);
		setResizable(true);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		ImageIcon img_student= new ImageIcon("img/student.jpg");
		setIconImage(img_student.getImage());
		getContentPane().setBackground(Color.LIGHT_GRAY); 
		
		
		MenuBar menu_bar= new MenuBar();
		menu_bar.setOpaque(true);
		menu_bar.setBackground(new Color(51, 153, 255));
		this.add(menu_bar);
		this.setJMenuBar(menu_bar);
		
		this.add(new Toolbar(),BorderLayout.NORTH);
	}

}
