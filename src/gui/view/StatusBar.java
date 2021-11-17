package gui.view;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;






public class StatusBar extends JPanel implements ActionListener {
	//
	
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel date;
	
	SimpleDateFormat dateFormat = new SimpleDateFormat( "E  HH:mm:ss  dd.MM.yyyy." );
	StatusBar() {
			
		JLabel name = new JLabel(" Studentska Slu\u017eba ");
		date = new JLabel(dateFormat.format(new GregorianCalendar().getTime()));
		Timer timer = new Timer(1000, this);
		timer.start();
		BoxLayout box = new BoxLayout(this, BoxLayout.X_AXIS);//horizontally component
		this.setLayout(box);
		this.add(name);
		this.add(Box.createHorizontalGlue());
		this.add(date);
		this.add(Box.createHorizontalStrut(10));
		this.setBackground(new Color(51, 153, 255));
		this.setSize(100, 100);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		date.setText(dateFormat.format(new GregorianCalendar().getTime()));
	}
	
	
	
	
	
	
	
	
	
	
	
//Create panel 	

}
