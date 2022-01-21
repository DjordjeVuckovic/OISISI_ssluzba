package gui.view;

import javax.swing.*;
import java.awt.*;
import java.io.Serial;


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
		Toolkit kit= Toolkit.getDefaultToolkit();
		Dimension dim = kit.getScreenSize();
		int width = dim.width;
		int height = dim.height;
		setSize(width*3/4,height*3/4);
		setResizable(true);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		ImageIcon img_student= new ImageIcon("img/student.jpg");
		setIconImage(img_student.getImage());
		getContentPane().setBackground(Color.LIGHT_GRAY);
		MenuBar menu_bar= new MenuBar();
		this.add(menu_bar);
		this.setJMenuBar(menu_bar);
		
		this.add(new Toolbar(),BorderLayout.NORTH);

		this.getContentPane().add(StatusBar.getInstance(),BorderLayout.SOUTH);

		JPanel centralPanel = new JPanel(new BorderLayout());
		centralPanel.add(CentralBox.getInstance());
		this.add(centralPanel, BorderLayout.CENTER);
		closing();

	}
	public void closing() {
		this.addWindowListener(new MyWindowListener());
	}

}
