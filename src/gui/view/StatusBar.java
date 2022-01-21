package gui.view;


import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import static java.lang.Thread.sleep;


public class StatusBar extends JPanel {
		

	private static final long serialVersionUID = 1L;

	private static StatusBar instance = null;
	public static StatusBar getInstance(){
		if(instance==null)instance=new StatusBar();
		return instance;
	}
	
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

					name.setText(" Studentska Slu\u017eba - Studenti");
				}
				else if(CentralBox.getInstance().getSelectedIndex()==1){
					name.setText(" Studentska Slu\u017eba- Predmeti");

				}
				else if(CentralBox.getInstance().getSelectedIndex()==2){
					name.setText("Studentska Slu\u017eba- Profesori");
				}
				else if(CentralBox.getInstance().getSelectedIndex()==3){
					name.setText("Studentska Slu\u017eba- Katedre");
				}
				else if(CentralBox.getInstance().getSelectedIndex()==2){
					name.setText(" Studentska Slu\u017eba- Profesori");
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
		this.add(name,BoxLayout.X_AXIS);
		this.add(Box.createHorizontalGlue());
		this.add(Box.createHorizontalStrut(50));
		this.setSize(100, 100);
		this.add(date);
	}


}
