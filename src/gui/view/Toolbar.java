package gui.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Toolbar extends JToolBar{

	private static final long serialVersionUID = 1209699209668701828L;
	
	public ImageIcon scaleImg(ImageIcon ic) {
		
		Image scaleImage = ic.getImage().getScaledInstance(32, 32,Image.SCALE_DEFAULT);
		ImageIcon ic1 = new ImageIcon(scaleImage);
		return ic1;
	}

	public Toolbar() {
		
		
		super(SwingConstants.HORIZONTAL);
		
		
		JButton btnNew = new JButton();
		btnNew.setToolTipText("Kreiraj entitet");
		btnNew.setIcon(scaleImg(new ImageIcon("img/add1.png")));
		btnNew.setBackground(Color.WHITE);
		btnNew.setBorderPainted(false);
		btnNew.setFocusPainted(false);		
		addSeparator();
		add(btnNew);
		addSeparator();
		
		
		JButton btnNew1 = new JButton();
		btnNew1.setToolTipText("Izmeni entitet");
		btnNew1.setIcon(scaleImg(new ImageIcon("img/ch.png")));
		btnNew1.setBackground(Color.WHITE);
		btnNew1.setBorderPainted(false);
		btnNew1.setFocusPainted(false);
		add(btnNew1);
		addSeparator();
		
		JButton btnNew2 = new JButton();
		btnNew2.setToolTipText("Obrisi entitet");
		btnNew2.setIcon(scaleImg(new ImageIcon("img/trash1.png")));
		btnNew2.setBackground(Color.WHITE);
		btnNew2.setBorderPainted(false);
		btnNew2.setFocusPainted(false);		
		add(btnNew2);
		addSeparator();
		
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		add(Box.createHorizontalStrut(screenSize.width/2));
		
		
		JTextField searchable = new JTextField("");
		searchable.setMaximumSize(new Dimension(screenSize.width,27));
		LineBorder lineBorder1 = new LineBorder(Color.BLACK);
	    searchable.setBorder(lineBorder1);
        JButton searchB = new JButton(scaleImg(new ImageIcon("img/sr.png")));
        searchB.setBackground(Color.WHITE);
		searchB.setBorderPainted(false);
		searchB.setFocusPainted(false);
		add(searchable);
		add(searchB);
	}
	
}
