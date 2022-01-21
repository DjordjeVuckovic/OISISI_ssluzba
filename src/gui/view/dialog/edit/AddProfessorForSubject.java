package gui.view.dialog.edit;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import gui.view.center.AbstractListProfessors;
import model.BazaProfesora;
import model.Professor;

public class AddProfessorForSubject extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5968193652354772695L;
	private JList<Object> profesoriList;
	Professor prof;
	
	public AddProfessorForSubject(JTextField profTF) {
		
		super();
	
		
		setSize(500, 500);
		setModal(true);
		setLocationRelativeTo(this.getParent());
		setTitle("Odaberite profesora");
		
		JPanel dialogPanel = new JPanel();
		BorderLayout dialogLayout = new BorderLayout();
		dialogPanel.setLayout(dialogLayout);
		
		JPanel panLabel = new JPanel();
		BoxLayout labelLayout = new BoxLayout(panLabel, BoxLayout.X_AXIS);
		panLabel.setLayout(labelLayout);
		panLabel.setPreferredSize(new Dimension(500, 50));
		JLabel predmetiLabel = new JLabel("Profesori:");
		
		Dimension dimension = new Dimension(100, 30);
		predmetiLabel.setPreferredSize(dimension);
		
		panLabel.add(Box.createHorizontalStrut(25));
		panLabel.add(predmetiLabel);
		panLabel.add(Box.createHorizontalGlue());
		
		dialogPanel.add(panLabel, BorderLayout.NORTH);
		
		profesoriList = new JList<Object>(new AbstractListProfessors());
		profesoriList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane profesoriScrollPane = new JScrollPane(profesoriList);
		profesoriScrollPane.setPreferredSize(new Dimension(200, 200));
		dialogPanel.add(profesoriScrollPane, BorderLayout.CENTER);
		
		JPanel btnPanel = new JPanel();
		BoxLayout btnLayout = new BoxLayout(btnPanel, BoxLayout.X_AXIS);
		btnPanel.setLayout(btnLayout);
		btnPanel.setPreferredSize(new Dimension(500, 50));
		
		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.setPreferredSize(new Dimension(100, 30));
		JButton btnOdustani = new JButton("Odustani");
		btnOdustani.setPreferredSize(new Dimension(100, 30));
		
		btnPanel.add(Box.createHorizontalGlue());
		btnPanel.add(btnPotvrdi);
		btnPanel.add(Box.createHorizontalStrut(25));
		btnPanel.add(btnOdustani);
		btnPanel.add(Box.createHorizontalGlue());
		dialogPanel.add(btnPanel, BorderLayout.SOUTH);
		
		JPanel westPanel = new JPanel();
		westPanel.setPreferredSize(new Dimension(25, 500));
		dialogPanel.add(westPanel, BorderLayout.WEST);
		
		JPanel eastPanel = new JPanel();
		eastPanel.setPreferredSize(new Dimension(25, 500));
		dialogPanel.add(eastPanel, BorderLayout.EAST);
		
		add(dialogPanel, BorderLayout.CENTER);
		
		btnPotvrdi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(profesoriList.getSelectedIndex() > -1) {
					prof = BazaProfesora.getInstance().getProfessors().get(profesoriList.getSelectedIndex());
					profTF.setText(prof.getName() + " " + prof.getSurname());
					
					dispose();
				}
			}});
		
		btnOdustani.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}});
	}

	public Professor getProf() {
		return prof;
	}

	public void setProf(Professor prof) {
		this.prof = prof;
	}
	
}
