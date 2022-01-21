package gui.view.dialog.edit;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import controller.SubjectController;
import controller.focuslisteners.SubjectListener;
import gui.view.MainWindow;
import model.Professor;
import model.Semester;
import model.Subject;
import model.YearofStudy;

public class EditSubject extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -680864083765738860L;
	private boolean ispravno[] = {true, true, true};
	private String id;
	private String naziv;
	private String espbString;
	private Professor profesor;
	private AddProfessorForSubject ddpp;
	
	JButton btnPotvrdi;
	JButton btnOdustani;
	
	public boolean allValid(){
        for(SubjectListener sb:validations){
            if(!sb.getValidation()){
                return false;
            }
        }
        return true;
    }
    public void EnableButt(){
        btnPotvrdi.setEnabled(allValid());
    }

    private ArrayList<SubjectListener> validations=new ArrayList<>();
	
	public EditSubject(int selectedIndex) {
		super();
		setTitle("Izmena predmeta");
		setSize(750, 750);
		setLocationRelativeTo(MainWindow.getInstance());
		this.setModal(true);
		
		JPanel dialogPanel = new JPanel();
		BoxLayout dialogLayout = new BoxLayout(dialogPanel, BoxLayout.Y_AXIS);
		dialogPanel.setLayout(dialogLayout);
		
		Dimension dimension1 = new Dimension(200, 30);
		FlowLayout layout1 = new FlowLayout(FlowLayout.CENTER);
		
		JPanel idPanel = new JPanel(layout1);
		JPanel nazivPanel = new JPanel(layout1);
		JPanel semestarPanel = new JPanel(layout1);
		JPanel godinaPanel = new JPanel(layout1);
		JPanel espbPanel = new JPanel(layout1);
		JPanel profesorPanel = new JPanel(layout1);
		
		Subject predmet = SubjectController.getInstance().getPredmet(selectedIndex);
		naziv = predmet.getNameSub();
		id = predmet.getIdS();
		espbString = Integer.toString(predmet.getESPBpoints());
	
		JLabel idLabel = new JLabel("Sifra predmeta*:");
		idLabel.setPreferredSize(dimension1);
		JLabel nazivLabel = new JLabel("Naziv predmeta*:");
		nazivLabel.setPreferredSize(dimension1);
		JLabel semestarLabel = new JLabel("Semestar*:");
		semestarLabel.setPreferredSize(dimension1);
		JLabel godinaLabel = new JLabel("Godina studija*:");
		godinaLabel.setPreferredSize(dimension1);
		JLabel espbLabel = new JLabel("Broj ESPB bodova*:");
		espbLabel.setPreferredSize(dimension1);
		JLabel profesorLabel = new JLabel("Profesor*:");
		profesorLabel.setPreferredSize(dimension1);
		
		JTextField idTF = new JTextField(id);
		idTF.setPreferredSize(dimension1);
		JTextField nazivTF = new JTextField(naziv);
		nazivTF.setPreferredSize(dimension1);
		JTextField espbTF = new JTextField(espbString);
		espbTF.setPreferredSize(dimension1);
		JTextField profTF = new JTextField();
		if(predmet.getProfessor() != null)
			profTF.setText(predmet.getProfessor().getName() + " " + predmet.getProfessor().getSurname());
		else
			profTF.setText("");
		profTF.setPreferredSize(dimension1);
		profTF.setEditable(false);
		
		String[] semestri = {"Letnji", "Zimski"};
		JComboBox<String> semestarComboBox = new JComboBox<String>(semestri);
		semestarComboBox.setPreferredSize(dimension1);
		
		String[] godine = {"I", "II", "III", "IV"};
		JComboBox<String> godinaComboBox = new JComboBox<String>(godine);
		godinaComboBox.setPreferredSize(dimension1);
		
		semestarComboBox.setSelectedIndex(predmet.getSemester().ordinal());
	    godinaComboBox.setSelectedIndex(predmet.getYearOfStudy().ordinal());
	    
		idPanel.add(idLabel);
		idPanel.add(idTF);
		nazivPanel.add(nazivLabel);
		nazivPanel.add(nazivTF);
		semestarPanel.add(semestarLabel);
		semestarPanel.add(semestarComboBox);
		godinaPanel.add(godinaLabel);
		godinaPanel.add(godinaComboBox);
		espbPanel.add(espbLabel);
		espbPanel.add(espbTF);
		
		
		JButton plus = new JButton("+");
		JButton minus = new JButton("-");
		profesorPanel.add(profesorLabel);
		profesorPanel.add(profTF);
		profesorPanel.add(plus);
		profesorPanel.add(minus);

		dialogPanel.add(idPanel);
		dialogPanel.add(nazivPanel);
		dialogPanel.add(godinaPanel);
		dialogPanel.add(semestarPanel);
		dialogPanel.add(espbPanel);
		dialogPanel.add(profesorPanel);
		dialogPanel.add(Box.createVerticalStrut(25));
		
		add(dialogPanel, BorderLayout.CENTER);
		
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
		
		btnPotvrdi.setEnabled(true);
		
		//profTF.setEnabled(false);
		
		if(profTF.getText().equals("")) {
			minus.setEnabled(false);
			plus.setEnabled(true);
		}
		else {
			plus.setEnabled(false);
			minus.setEnabled(true);
		}
		
		//validacija
		
		 	SubjectListener val1 = new SubjectListener(idLabel,idTF ,this);
		 	idTF.addFocusListener(val1);
	        validations.add(val1);

	        SubjectListener val2 = new SubjectListener(espbLabel,espbTF,this);
	        espbTF.addFocusListener(val2);
	        validations.add(val2);

	        SubjectListener val3 = new SubjectListener(nazivLabel,nazivTF,this);
	        nazivTF.addFocusListener(val3);
	        validations.add(val3);
		
	   btnPotvrdi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Semester semestar = Semester.values()[semestarComboBox.getSelectedIndex()];
				YearofStudy godina = YearofStudy.values()[godinaComboBox.getSelectedIndex()];
				
				for(Subject p: SubjectController.getInstance().getPredmeti()) {
					if(p.getIdS().equals(id) && p != SubjectController.getInstance().getPredmeti().get(selectedIndex)) {
						JOptionPane.showMessageDialog(null,
								"Predmet sa datom sifrom vec postoji u sistemu",
								"Greska pri unosu predmeta", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				if(profTF.getText().equals(""))
					profesor = null;
				else
					profesor = ddpp.getProf();
				
				Subject predmet = new Subject(id, naziv, semestar, godina,Integer.parseInt(espbString), profesor);
				SubjectController.getInstance().editSubject2(selectedIndex, predmet);
				dispose();
			}
			
		});
		
		btnOdustani.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}});
		
		plus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				ddpp = new AddProfessorForSubject(profTF);
				ddpp.setVisible(true);
			
			}
			
		});
		
		minus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				RemoveProfessorFromSubject dup = new RemoveProfessorFromSubject(profTF);
				dup.setVisible(true);
			}
			
		});
	}
	
	public boolean proveraUnosa(String fieldText, String fieldRegex, int index) {
		if (!fieldText.matches(fieldRegex))
			ispravno[index] = false;			
		else 
			ispravno[index] = true;
		boolean sviIspravni = true;
		for(boolean i : ispravno)
			if(i == false)
				sviIspravni = false;
		
		if(sviIspravni == true)
			return true;
		else
			return false;
	}
}
