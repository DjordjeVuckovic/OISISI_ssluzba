package gui.view.dialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.view.dialog.edit.student.AbstractTableModelNepolozeniIspiti;
import gui.view.dialog.edit.student.NepolozeniPredmetiJTable;
import model.Student;
import model.Subject;

public class ObrisiPredmetStudentu extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5179037093258079538L;

	private NepolozeniPredmetiJTable nepolozeni;
	
	public ObrisiPredmetStudentu(NepolozeniPredmetiJTable nepolozeni, Student student) {
		
		super();
		this.nepolozeni = nepolozeni;
		
		setSize(400, 150);
		setModal(true);
		setLocationRelativeTo(this.getParent());
		setTitle("Uklanjanje Subjecta");
		
		JPanel dialogPanel = new JPanel();
		BoxLayout dialogLayout = new BoxLayout(dialogPanel, BoxLayout.Y_AXIS);
		dialogPanel.setLayout(dialogLayout);
		
		dialogPanel.add(Box.createVerticalStrut(25));
		JPanel panelLabel = new JPanel();
		BoxLayout labelLayout = new BoxLayout(panelLabel, BoxLayout.X_AXIS);
		panelLabel.setLayout(labelLayout);
		JLabel poruka = new JLabel("Da li ste sigurni da zelite da uklonite Subject?");
		panelLabel.add(Box.createHorizontalGlue());
		panelLabel.add(poruka);
		panelLabel.add(Box.createHorizontalGlue());
		dialogPanel.add(panelLabel);
		dialogPanel.add(Box.createVerticalStrut(25));
		
		add(dialogPanel, BorderLayout.CENTER);
		
		JPanel buttonPanel = new JPanel();
		BoxLayout buttonLayout = new BoxLayout(buttonPanel, BoxLayout.X_AXIS);
		buttonPanel.setLayout(buttonLayout);
		
		JButton btnDa = new JButton("Da");
		btnDa.setPreferredSize(new Dimension(50, 30));
		JButton btnNe = new JButton("Ne");
		btnNe.setPreferredSize(new Dimension(50, 30));
		buttonPanel.add(Box.createHorizontalGlue());
		buttonPanel.add(btnDa);
		buttonPanel.add(Box.createHorizontalStrut(50));
		buttonPanel.add(btnNe);
		buttonPanel.add(Box.createHorizontalGlue());
		
		add(buttonPanel, BorderLayout.SOUTH);
		
		btnDa.setEnabled(true);
			
		btnDa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub	
				Subject Subject = student.getFailedExams().get(nepolozeni.getSelectedRow());
					student.removeSubject(Subject);
					student.dodajNepohadjani(Subject);
					azurirajPrikaz();
				
				dispose();
			}
			
		});
		
		btnNe.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}});
	}
	
	public void azurirajPrikaz() {
		AbstractTableModelNepolozeniIspiti nepolozeniModel = (AbstractTableModelNepolozeniIspiti) nepolozeni.getModel();
		
		nepolozeniModel.fireTableDataChanged();
		validate();

	}
}
