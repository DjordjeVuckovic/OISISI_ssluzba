package gui.view.dialog.add;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

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

import controller.ProfessorController;
import gui.view.MainWindow;
import model.Address;
import model.Professor;
import model.Zvanje;


public class AddProfessor extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3690682637438183192L;
	
	private boolean ispravno[] = {false, false, false, false, false, false, false, false, false};
	private String ime;
	private String prezime;
	private String datumRodjenjaString;
	private Address adresaStanovanja;
	private String kontaktTelefon;
	private String emailAdresa;
	private Address adresaKancelarije;
	private String brojLicneKarte;
	private int godStaza;
	//predmeti
	
	public AddProfessor() {
		super();
		setTitle("Dodavanje profesora");
		setSize(750, 750);
		setLocationRelativeTo(MainWindow.getInstance());
		this.setModal(true);
		
		JPanel dialogPanel = new JPanel();
		BoxLayout dialogLayout = new BoxLayout(dialogPanel, BoxLayout.Y_AXIS);
		dialogPanel.setLayout(dialogLayout);
		
		Dimension dimension1 = new Dimension(200, 30);
		FlowLayout layout1 = new FlowLayout(FlowLayout.CENTER);
		
		JPanel imePanel = new JPanel(layout1);
		JPanel prezimePanel = new JPanel(layout1);
		JPanel datumPanel = new JPanel(layout1);
		JPanel adresaStanPanel = new JPanel(layout1);
		JPanel telefonPanel = new JPanel(layout1);
		JPanel emailPanel = new JPanel(layout1);
		JPanel adresaKancPanel = new JPanel(layout1);
		JPanel brLicneKartePanel = new JPanel(layout1);
		JPanel godStazaPanel = new JPanel(layout1);
		JPanel zvanjePanel = new JPanel(layout1);
		
		JLabel imeLabel = new JLabel("Ime*:");
		imeLabel.setPreferredSize(dimension1);
		JLabel prezimeLabel = new JLabel("Prezime*:");
		prezimeLabel.setPreferredSize(dimension1);
		JLabel datumLabel = new JLabel("Datum rodjenja*:");
		datumLabel.setPreferredSize(dimension1);
		JLabel adresaStanLabel = new JLabel("Adresa stanovanja*:");
		adresaStanLabel.setPreferredSize(dimension1);
		JLabel telefonLabel = new JLabel("Broj telefona*:");
		telefonLabel.setPreferredSize(dimension1);
		JLabel emailLabel = new JLabel("E-mail adresa*:");
		emailLabel.setPreferredSize(dimension1);
		JLabel adresaKancLabel = new JLabel("Adresa kancelarije*:");
		adresaKancLabel.setPreferredSize(dimension1);
		JLabel brLicneKarteLabel = new JLabel("Broj licne karte*:");
		brLicneKarteLabel.setPreferredSize(dimension1);
		JLabel godStazaLabel = new JLabel("Godine staza*:");
		godStazaLabel.setPreferredSize(dimension1);
		JLabel zvanjeLabel = new JLabel("Zvanje*:");
		zvanjeLabel.setPreferredSize(dimension1);
		
		JTextField imeTF = new JTextField();
		imeTF.setPreferredSize(dimension1);
		JTextField prezimeTF = new JTextField();
		prezimeTF.setPreferredSize(dimension1);
		JTextField datumTF = new JTextField();
		datumTF.setPreferredSize(dimension1);
		datumTF.setToolTipText("Format: dd-mm-yyyy");
		JTextField adresaStanTF = new JTextField();
		adresaStanTF.setPreferredSize(dimension1);
		adresaStanTF.setToolTipText("Format: ulica broj, grad");
		JTextField telefonTF = new JTextField();
		telefonTF.setPreferredSize(dimension1);
		telefonTF.setToolTipText("Format: 06x-xxxxxxxxx");
		JTextField emailTF = new JTextField();
		emailTF.setPreferredSize(dimension1);
		emailTF.setToolTipText("Format: xxxx@xxxx.xx");
		JTextField adresaKancTF = new JTextField();
		adresaKancTF.setPreferredSize(dimension1);
		adresaKancTF.setToolTipText("Format: ulica broj, grad, kancelarija");
		JTextField brLicneKarteTF = new JTextField();
		brLicneKarteTF.setPreferredSize(dimension1);
		JTextField godStazaTF = new JTextField();
		godStazaTF.setPreferredSize(dimension1);

		String[] zvanja = { "saradnik u nastavi", "asistent", "asistent sa doktoratom", "docent", "vanredni profesor", "redovni profesor", "profesor emeritus" };
		JComboBox<String> zvanjeComboBox = new JComboBox<String>(zvanja);
		zvanjeComboBox.setPreferredSize(dimension1);
		
		
		imePanel.add(imeLabel);
		imePanel.add(imeTF);
		prezimePanel.add(prezimeLabel);
		prezimePanel.add(prezimeTF);
		datumPanel.add(datumLabel);
		datumPanel.add(datumTF);
		adresaStanPanel.add(adresaStanLabel);
		adresaStanPanel.add(adresaStanTF);
		telefonPanel.add(telefonLabel);
		telefonPanel.add(telefonTF);
		emailPanel.add(emailLabel);
		emailPanel.add(emailTF);
		adresaKancPanel.add(adresaKancLabel);
		adresaKancPanel.add(adresaKancTF);
		brLicneKartePanel.add(brLicneKarteLabel);
		brLicneKartePanel.add(brLicneKarteTF);
		godStazaPanel.add(godStazaLabel);
		godStazaPanel.add(godStazaTF);
		zvanjePanel.add(zvanjeLabel);
		zvanjePanel.add(zvanjeComboBox);
		
		dialogPanel.add(imePanel);
		dialogPanel.add(prezimePanel);
		dialogPanel.add(datumPanel);
		dialogPanel.add(adresaStanPanel);
		dialogPanel.add(telefonPanel);
		dialogPanel.add(emailPanel);
		dialogPanel.add(adresaKancPanel);
		dialogPanel.add(brLicneKartePanel);
		dialogPanel.add(godStazaPanel);
		dialogPanel.add(zvanjePanel);
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
		
		btnPotvrdi.setEnabled(false);
		
		imeTF.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				ime = imeTF.getText();
				String imeRegex = "[\\p{L}\s]+";
				btnPotvrdi.setEnabled(proveraUnosa(ime, imeRegex, 0));
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				ime = imeTF.getText();
				String imeRegex = "[\\p{L}\s]+";
				btnPotvrdi.setEnabled(proveraUnosa(ime, imeRegex, 0));
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				ime = imeTF.getText();
				String imeRegex = "[\\p{L}\s]+";
				btnPotvrdi.setEnabled(proveraUnosa(ime, imeRegex, 0));
			}
		});
		
		prezimeTF.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				prezime = prezimeTF.getText();
				String prezimeRegex = "[\\p{L}\s]+";
				btnPotvrdi.setEnabled(proveraUnosa(prezime, prezimeRegex, 1));
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				prezime = prezimeTF.getText();
				String prezimeRegex = "[\\p{L}\s]+";
				btnPotvrdi.setEnabled(proveraUnosa(prezime, prezimeRegex, 1));
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				prezime = prezimeTF.getText();
				String prezimeRegex = "[\\p{L}\s]+";
				btnPotvrdi.setEnabled(proveraUnosa(prezime, prezimeRegex, 1));
			}
		});
		
		datumTF.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				datumRodjenjaString = datumTF.getText();
				String datumRodjenjaRegex = "\\d{1,2}-\\d{1,2}-\\d{4}";
				btnPotvrdi.setEnabled(proveraUnosa(datumRodjenjaString, datumRodjenjaRegex, 2));
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				datumRodjenjaString = datumTF.getText();
				String datumRodjenjaRegex = "\\d{1,2}-\\d{1,2}-\\d{4}";
				btnPotvrdi.setEnabled(proveraUnosa(datumRodjenjaString, datumRodjenjaRegex, 2));
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				datumRodjenjaString = datumTF.getText();
				String datumRodjenjaRegex = "\\d{1,2}-\\d{1,2}-\\d{4}";
				btnPotvrdi.setEnabled(proveraUnosa(datumRodjenjaString, datumRodjenjaRegex, 2));
			}
		});
		
		
		
		telefonTF.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				kontaktTelefon = telefonTF.getText();
				String telefonRegex = "^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$";
				btnPotvrdi.setEnabled(proveraUnosa(kontaktTelefon, telefonRegex, 4));
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				kontaktTelefon = telefonTF.getText();
				String telefonRegex = "^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$";
				btnPotvrdi.setEnabled(proveraUnosa(kontaktTelefon, telefonRegex, 4));
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				kontaktTelefon = telefonTF.getText();
				String telefonRegex = "^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$";
				btnPotvrdi.setEnabled(proveraUnosa(kontaktTelefon, telefonRegex, 4));
			}
		});
		
		emailTF.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				emailAdresa = emailTF.getText();
				String emailRegex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
				btnPotvrdi.setEnabled(proveraUnosa(emailAdresa, emailRegex, 5));
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				emailAdresa = emailTF.getText();
				String emailRegex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
				btnPotvrdi.setEnabled(proveraUnosa(emailAdresa, emailRegex, 5));
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				emailAdresa = emailTF.getText();
				String emailRegex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
				btnPotvrdi.setEnabled(proveraUnosa(emailAdresa, emailRegex, 5));
			}
		});
			
		brLicneKarteTF.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				brojLicneKarte = brLicneKarteTF.getText();
				String brLicneKarteRegex = "\\d{9}";
				btnPotvrdi.setEnabled(proveraUnosa(brojLicneKarte, brLicneKarteRegex, 7));
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				brojLicneKarte = brLicneKarteTF.getText();
				String brLicneKarteRegex = "\\d{9}";
				btnPotvrdi.setEnabled(proveraUnosa(brojLicneKarte, brLicneKarteRegex, 7));
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				brojLicneKarte = brLicneKarteTF.getText();
				String brLicneKarteRegex = "\\d{9}";
				btnPotvrdi.setEnabled(proveraUnosa(brojLicneKarte, brLicneKarteRegex, 7));
			}
		});
		
		btnPotvrdi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				Zvanje zvanje = Zvanje.values()[zvanjeComboBox.getSelectedIndex()];
				
				for(Professor p: ProfessorController.getInstance().getProfessors()) {
					if(p.getIdNumber().equals(brojLicneKarte)) {
						JOptionPane.showMessageDialog(null,
								"Profesor sa datim brojem licne karte vec postoji u sistemu",
								"Greska pri unosu profesora", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				
				try {
					Date datumRodjenja = new SimpleDateFormat("dd-MM-yyyy").parse(datumRodjenjaString);
					Professor professor = new Professor(ime, prezime, datumRodjenja, adresaStanovanja, kontaktTelefon, emailAdresa, adresaKancelarije, brojLicneKarte, godStaza, zvanje);
					ProfessorController.getInstance().addProfessor(professor);
					}
					catch(java.text.ParseException pe) {
						pe.printStackTrace();
					}
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
