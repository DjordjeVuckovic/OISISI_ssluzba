package gui.view;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.Serial;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.*;


public class MainWindow extends JFrame {
	
	@Serial
	private static final long serialVersionUID = 1L;
	private static MainWindow instance = null;
	public JTabbedPane centralWindow;
	
	private MenuBar menu;
	private StatusBar statusBar;
	public static MainWindow getInstance() {
		if(MainWindow.instance==null) MainWindow.instance = new MainWindow();
		return MainWindow.instance;
	}

	private ResourceBundle resourceBundle;
	
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
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
		
		//Lokalizacija
		System.out.println("Ukupan broj lokala: " + Locale.getAvailableLocales().length);
		for(Locale locale : Locale.getAvailableLocales()) {
			System.out.println("Local: " + locale + ", za jezik:" + locale.getDisplayLanguage() + ", za državu: "
					+ locale.getDisplayCountry() + " i naziva: " + locale.getDisplayName());
		}
		System.out.println("Default lokal: " + Locale.getDefault());
		Locale.setDefault(new Locale("sr", "RS"));
		System.out.println("Novi Default lokal:" + Locale.getDefault());
		
		resourceBundle = ResourceBundle.getBundle("gui.messageresources.MessageResources", Locale.getDefault());
		
		UIManager.put("OptionPane.yesButtonText", resourceBundle.getObject("yesOption"));
		UIManager.put("OptionPane.noButtonText", resourceBundle.getObject("noOption"));
		UIManager.put("OptionPane.okButtonText", resourceBundle.getObject("okOption"));
		UIManager.put("OptionPane.cancelButtonText", resourceBundle.getObject("cancelOption"));
	}

	public void changeLanguage() {
		
		resourceBundle = ResourceBundle.getBundle("gui.messageresources.MessageResources", Locale.getDefault());
		setTitle(resourceBundle.getString("naslovAplikacije"));
		
		menu.initComponents();
		//statusBar.initComponents();
		
		UIManager.put("OptionPane.yesButtonText", resourceBundle.getObject("yesOption"));
		UIManager.put("OptionPane.noButtonText", resourceBundle.getObject("noOption"));
		UIManager.put("OptionPane.okButtonText", resourceBundle.getObject("okOption"));
		UIManager.put("OptionPane.cancelButtonText", resourceBundle.getObject("cancelOption"));
		
		
	}
	
	public ResourceBundle getResourceBundle() {
		return resourceBundle;
	}
	
	public MenuBar getMenu() {
		return menu;
	}
	
	public StatusBar getStatusBar() {
		return statusBar;
	}
	
}
