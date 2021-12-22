package gui.view;



import gui.view.center.StudentsTable;
import gui.view.center.SubjectTable;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.Serial;
import javax.swing.*;


public class MainWindow extends JFrame {
	
	@Serial
	private static final long serialVersionUID = 1L;
	private static MainWindow instance = null;
	public JTabbedPane centralWindow;
	public static MainWindow getInstance() {
		if(MainWindow.instance==null) MainWindow.instance = new MainWindow();
		return MainWindow.instance;
	}

	
	private MainWindow() {
		super();
		setTitle("Studentska  Slu\u017Eba ");
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
		menu_bar.setBackground(new Color(51, 153, 255));
		this.add(menu_bar);
		this.setJMenuBar(menu_bar);
		
		this.add(new Toolbar(),BorderLayout.NORTH);

		this.getContentPane().add(new StatusBar(),BorderLayout.SOUTH);

		JPanel centralniPanel = new JPanel(new BorderLayout());
		centralniPanel.add(CentralBox.getInstance());
		add(centralniPanel, BorderLayout.CENTER);

	}

}
