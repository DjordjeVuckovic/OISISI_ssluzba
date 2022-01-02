package gui.view;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.GregorianCalendar;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import static java.lang.Thread.sleep;


public class StatusBar extends JPanel {
		

	private static final long serialVersionUID = 1L;
	
	private JLabel date;
	private String switchName = new String();
	
	SimpleDateFormat dateFormat = new SimpleDateFormat( "E  HH:mm:ss  dd.MM.yyyy." );
	StatusBar() {

		this.setBackground(new Color(51, 153, 255));
		JLabel name = new JLabel();
		date = new JLabel(dateFormat.format(new GregorianCalendar().getTime()));
		//Timer timer = new Timer(1000, this);
		//timer.start();
		BoxLayout box = new BoxLayout(this, BoxLayout.X_AXIS);//new horizontally component
		this.setLayout(box);
		Thread nit = new Thread(() -> {
			while(true) {
				//if(CentralBox.getInstance().getSelectedIndex()==0){
					//name.setText(" Studentska Slu\u017eba- Studenti");
				//}
				//else if(CentralBox.getInstance().getSelectedIndex()==1){
					//name.setText(" Studentska Slu\u017eba- Predmeti");
				//}
				/*
				else if(CentralBox.getInstance().getSelectedIndex()==2){
					name.setText(" Studentska Slu\u017eba- Predmeti ");
				}


				 */
				//if(CentralBox.getInstance().getSelectedIndex()==0){
					//switchName = "Studenti";
				//}
				//if(CentralBox.getInstance().getSelectedIndex()==1){
					//switchName = "Predmeti";
				//}
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
	//@Override
	//public void actionPerformed(ActionEvent e) {

		//date.setText(dateFormat.format(new GregorianCalendar().getTime()));
	//}
	
	
	
	
	
	
	
	
	
	
	
//Create panel 	

}
