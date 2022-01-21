package gui.view;


import static java.lang.Thread.sleep;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class StatusBar extends JPanel {
		
	
	private static final long serialVersionUID = 1L;

	private static StatusBar instance = null;
	public static StatusBar getInstance(){
		if(instance==null)instance=new StatusBar();
		return instance;
	}
	
	//private String statusBarLanguage;
	private JLabel date;
	private String switchName = new String();
	JLabel name = new JLabel();
	
	
	
	SimpleDateFormat dateFormat = new SimpleDateFormat( "E  HH:mm:ss  dd.MM.yyyy." );
	private StatusBar() {

		this.setBackground(new Color(51, 153, 255));
		date = new JLabel(dateFormat.format(new GregorianCalendar().getTime()));
		//Timer timer = new Timer(1000, this);
		//timer.start();
		BoxLayout box = new BoxLayout(this, BoxLayout.X_AXIS);//new horizontally component
		this.setLayout(box);
		Thread nit = new Thread(() -> {
			while(true) {
				if(CentralBox.getInstance().getSelectedIndex()==0){
					name.setText(" Studentska Slu\u017eba- Studenti");
				}
				else if(CentralBox.getInstance().getSelectedIndex()==1){
					name.setText(" Studentska Slu\u017eba- Predmeti");
				}
				date.setText(dateFormat.format(new GregorianCalendar().getTime()));
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		nit.start();
		name.setText("Studentska Slu\u017eba-"+switchName);
		this.add(name,BoxLayout.X_AXIS);
		this.add(Box.createHorizontalGlue());
		this.add(Box.createHorizontalStrut(50));
		this.setSize(100, 100);
		this.add(date);
	}
	
	
	
	/*
	 * public void initComponents() {
	 * 
	 * statusBarLanguage.setText(MainWindow.getInstance().getResourceBundle().
	 * getString("lblJezik") + Locale.getDefault().getDisplayLanguage());
	 * 
	 * DateFormat df = DateFormat.getDateInstance(); String datum = df.format(new
	 * date()); statusBarMenuDescription.setText(datum);
	 * 
	 * }
	 * 
	 * public StatusPane getStatusBarLanguage() { return statusBarLanguage; }
	 * 
	 * public void setStatusBarLanguage(StatusPane statusBarLanguage) {
	 * this.statusBarLanguage = statusBarLanguage; }
	 * 
	 * public StatusPane getStatusBarMenuDescription() { return
	 * statusBarMenuDescription; }
	 * 
	 * public void setStatusBarMenuDescription() { this.statusBarMenuDescription =
	 * statusBarMenuDescription; }
	 */
	

}
