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

import gui.view.center.AbstractTableNepolozeniIspiti;
import gui.view.center.AbstractTablePolozeniIspiti;
import gui.view.dialog.edit.student.NepolozeniPredmetiJTable;
import gui.view.dialog.edit.student.PolozeniPredmetiJTable;
import model.Grade;
import model.Student;
import model.Subject;

public class ObrisiOcenu extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1599877757650275252L;

	
	private Subject Subject;
	private NepolozeniPredmetiJTable nepolozeni;
	private PolozeniPredmetiJTable polozeni;

	public ObrisiOcenu(PolozeniPredmetiJTable polozeni, NepolozeniPredmetiJTable nepolozeni, Student student) {
		
		super();
		this.nepolozeni = nepolozeni;
		this.polozeni = polozeni;
		
		setSize(400, 150);
		setModal(true);
		setLocationRelativeTo(this.getParent());
		setTitle("Ponistavanje ocene");
		
		JPanel dialogPanel = new JPanel();
		BoxLayout dialogLayout = new BoxLayout(dialogPanel, BoxLayout.Y_AXIS);
		dialogPanel.setLayout(dialogLayout);
		
		dialogPanel.add(Box.createVerticalStrut(25));
		JPanel panelLabel = new JPanel();
		BoxLayout labelLayout = new BoxLayout(panelLabel, BoxLayout.X_AXIS);
		panelLabel.setLayout(labelLayout);
		JLabel poruka = new JLabel("Da li ste sigurni da zelite da ponistite ocenu?");
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
				Grade grade = student.getPassedExams().get(polozeni.getSelectedRow());
				Subject = grade.getSubject();
					student.insertSubject(Subject);
					student.removeGrade(grade);
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
		AbstractTableNepolozeniIspiti nepolozeniModel = (AbstractTableNepolozeniIspiti) nepolozeni.getModel();
		
		nepolozeniModel.fireTableDataChanged();
		validate();
		

		AbstractTablePolozeniIspiti polozeniModel = (AbstractTablePolozeniIspiti) polozeni.getModel();
		
		polozeniModel.fireTableDataChanged();
		validate();
	}
	
}
