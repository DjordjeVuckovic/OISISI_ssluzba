package gui.view.dialog.edit;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class RemoveProfessorFromSubject extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1772892043999432227L;

	RemoveProfessorFromSubject(JTextField profTF) {
		super();
		setTitle("Ukloni profesora");
		setSize(450, 200);
		setLocationRelativeTo(this.getParent());
		setModal(true);

		JPanel messagePanel = new JPanel();
		JLabel messageLabel = new JLabel("Da li ste sigurni?");
		messagePanel.setLayout(new GridBagLayout());
		messagePanel.add(messageLabel);
		messagePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		add(messagePanel, BorderLayout.CENTER);
		
		JPanel buttonPanel = new JPanel();
		BoxLayout buttonLayout = new BoxLayout(buttonPanel, BoxLayout.X_AXIS);
		buttonPanel.setLayout(buttonLayout);
		
		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.setPreferredSize(new Dimension(100, 30));
		JButton btnOdustani = new JButton("Odustani");
		btnOdustani.setPreferredSize(new Dimension(100, 30));
		buttonPanel.add(Box.createHorizontalGlue());
		buttonPanel.add(btnPotvrdi);
		buttonPanel.add(Box.createHorizontalStrut(50));
		buttonPanel.add(btnOdustani);
		buttonPanel.add(Box.createHorizontalGlue());
		
		add(buttonPanel, BorderLayout.SOUTH);
		
		btnPotvrdi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				profTF.setText("");
				dispose();
			}
		});
		
		btnOdustani.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}});
	}
}