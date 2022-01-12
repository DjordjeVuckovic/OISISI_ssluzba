package gui.view.dialog.edit.student;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
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
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import controller.StudentController;
import gui.view.CentralBox;
import gui.view.center.StudentsTable;
import gui.view.dialog.DodajPredmetStudentu;
import gui.view.dialog.ObrisiOcenu;
import gui.view.dialog.ObrisiPredmetStudentu;
import gui.view.dialog.UpisiOcenu;
import model.Address;
import model.Status;
import model.Student;

public class EditStudent extends JDialog {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3483057378640442927L;
	private boolean ispravni[] = {true, true, true, true, true, true, true, true};
	String ime;
	String prezime;
	String brojTelefona;
	String datumRodjenja;
	Address adresa;
	String brIndeksa;
	String email;
	//String prosecnaOcena;
	int godinaUpisa;
	
	public EditStudent(int selectedIndex) {
	super();
	setTitle("Izmeni studenta");
	setSize(750, 750);
	this.setModal(true);
	setLocationRelativeTo(CentralBox.getInstance());
	
	JTabbedPane tabbedPane = new JTabbedPane();
	
	JPanel panelInformacije = new JPanel();
	BoxLayout dialogLayout = new BoxLayout(panelInformacije, BoxLayout.Y_AXIS);
	panelInformacije.setLayout(dialogLayout);
	tabbedPane.addTab("Informacije", panelInformacije );
	
	JPanel panelPolozeni = new JPanel();
	BorderLayout polozeniLayout = new BorderLayout();
	panelPolozeni.setLayout(polozeniLayout);
	tabbedPane.addTab("Polozeni", panelPolozeni);

	JPanel panelNepolozeni = new JPanel();
	BorderLayout nepolozeniLayout = new BorderLayout();
	panelNepolozeni.setLayout(nepolozeniLayout);
	tabbedPane.addTab("Nepolozeni", panelNepolozeni);
	
	add(tabbedPane, BorderLayout.CENTER);
	
	FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
	Dimension dimension = new Dimension(200, 30);
	
	JPanel imePanel = new JPanel(layout);
	JPanel prezimePanel = new JPanel(layout);
	JPanel datumRodjenjaPanel = new JPanel(layout);
	JPanel adresaPanel = new JPanel(layout);
	JPanel kontaktPanel = new JPanel(layout);
	JPanel emailPanel = new JPanel(layout);
	JPanel brIndeksaPanel = new JPanel(layout);
	JPanel godinaUpisaPanel = new JPanel(layout);
	JPanel godinaStudijaPanel = new JPanel(layout);
	JPanel nacinFinansiranjaPanel = new JPanel(layout);
//	JPanel prosecnaOcenaPanel = new JPanel(layout);
		
	JLabel imeLabel = new JLabel("Ime*: ");
	JLabel prezimeLabel = new JLabel("Prezime*: ");
	JLabel datumRodjenjaLabel = new JLabel("Datum rodjenja*: ");
	JLabel adresaLabel = new JLabel("Adresa stanovanja*: ");
	JLabel kontaktLabel = new JLabel("Broj telefona*: ");
	JLabel emailLabel = new JLabel("E-mail adresa*: ");
	JLabel brIndeksaLabel = new JLabel("Broj indeksa*: ");
	JLabel godinaUpisaLabel = new JLabel("Godina upisa*: ");
	JLabel godinaStudijaLabel = new JLabel("Trenutna godina studija*: ");
//	JLabel prosecnaOcenaLabel = new JLabel("Prosecna ocena*: ");
	JLabel nacinFinansiranjaLabel = new JLabel("Nacin finansiranja*:");
	
	imeLabel.setPreferredSize(dimension);
	prezimeLabel.setPreferredSize(dimension);
	datumRodjenjaLabel.setPreferredSize(dimension);
	adresaLabel.setPreferredSize(dimension);
	kontaktLabel.setPreferredSize(dimension);
	emailLabel.setPreferredSize(dimension);
	brIndeksaLabel.setPreferredSize(dimension);
	godinaUpisaLabel.setPreferredSize(dimension);
	godinaStudijaLabel.setPreferredSize(dimension);
	//prosecnaOcenaLabel.setPreferredSize(dimension);
	nacinFinansiranjaLabel.setPreferredSize(dimension);
	
	
	Student student = StudentController.getInstance().getListaSvihStudenata().get(selectedIndex);
	ime = student.getName();
	prezime = student.getSurname();
	DateFormat date = new SimpleDateFormat("dd-MM-yyyy");
	datumRodjenja = date.format(student.getBirthday());
	brojTelefona = student.getContactPhone();
	adresa = student.getAddress();
	brIndeksa = student.getIndex();
	email = student.getEmail();
	//prosecnaOcena = Double.toString(student.getProsecnaOcena());
	godinaUpisa = student.getEnrollYear();
    
	
	
	JTextField imeText = new JTextField(student.getName());
	imeText.setToolTipText("Format: slova i razmaci");
	JTextField prezimeText = new JTextField(student.getSurname());
	prezimeText.setToolTipText("Format: slova i razmaci");
	JTextField datumRodjenjaText = new JTextField(date.format(student.getBirthday()));
	datumRodjenjaText.setToolTipText("Format: dd-MM-yyyy");
	JTextField adresaText = new JTextField();
	adresaText.setToolTipText("Format: slova i razmaci + broj + zapeta + slova i razmaci");
	JTextField kontaktText = new JTextField(student.getContactPhone());
	JTextField emailText = new JTextField(student.getEmail());
	JTextField brIndeksaText = new JTextField(student.getIndex());
	brIndeksaText.setToolTipText("Format: AAxxx-yyyy");
	JTextField godinaUpisaText = new JTextField(student.getEnrollYear());
	godinaUpisaText.setToolTipText("Format: yyyy");
//	JTextField prosecnaOcenaText = new JTextField(Double.toString(student.getProsecnaOcena()));
//	prosecnaOcenaText.setToolTipText("Format: cifra + tacka + dve cifre ili 10.00");
	String[] godineStudija = { "I (prva)", "II (druga)", "III (treca)", "IV (cetvrta)" };
	JComboBox<String> godineStudijaComboBox = new JComboBox<String>(godineStudija);	
	String[] budzet_samofinansiranje = { "Budzet", "Samofinansiranje" };
	JComboBox<String> budzet_samofinansiranjeComboBox = new JComboBox<String>(budzet_samofinansiranje);
	
	godineStudijaComboBox.setSelectedItem(student.getCurrentyear());
    budzet_samofinansiranjeComboBox.setSelectedIndex(student.getNacinFinansiranja().ordinal());	
	
	imeText.setPreferredSize(dimension);
	prezimeText.setPreferredSize(dimension);
	datumRodjenjaText.setPreferredSize(dimension);
	adresaText.setPreferredSize(dimension);
	kontaktText.setPreferredSize(dimension);
	emailText.setPreferredSize(dimension);
	brIndeksaText.setPreferredSize(dimension);
	godinaUpisaText.setPreferredSize(dimension);
//	prosecnaOcenaText.setPreferredSize(dimension);
	godineStudijaComboBox.setPreferredSize(dimension);
	budzet_samofinansiranjeComboBox.setPreferredSize(dimension);
			
	
	imePanel.add(imeLabel);
	imePanel.add(imeText);
	prezimePanel.add(prezimeLabel);
	prezimePanel.add(prezimeText);
	datumRodjenjaPanel.add(datumRodjenjaLabel);
	datumRodjenjaPanel.add(datumRodjenjaText);
	adresaPanel.add(adresaLabel);
	adresaPanel.add(adresaText);
	kontaktPanel.add(kontaktLabel);
	kontaktPanel.add(kontaktText);
	emailPanel.add(emailLabel);
	emailPanel.add(emailText);	
	brIndeksaPanel.add(brIndeksaLabel);
	brIndeksaPanel.add(brIndeksaText);	
	godinaUpisaPanel.add(godinaUpisaLabel);
	godinaUpisaPanel.add(godinaUpisaText);
//	prosecnaOcenaPanel.add(prosecnaOcenaLabel);
//	prosecnaOcenaPanel.add(prosecnaOcenaText);	
	godinaStudijaPanel.add(godinaStudijaLabel);
	godinaStudijaPanel.add(godineStudijaComboBox);
	nacinFinansiranjaPanel.add(nacinFinansiranjaLabel);
	nacinFinansiranjaPanel.add(budzet_samofinansiranjeComboBox);
	
	panelInformacije.add(imePanel);
	panelInformacije.add(prezimePanel);
	panelInformacije.add(datumRodjenjaPanel);
	panelInformacije.add(adresaPanel);
	panelInformacije.add(kontaktPanel);
	panelInformacije.add(emailPanel);
	panelInformacije.add(brIndeksaPanel);
//	panelInformacije.add(prosecnaOcenaPanel);
	panelInformacije.add(godinaUpisaPanel);
	panelInformacije.add(godinaStudijaPanel);
	panelInformacije.add(nacinFinansiranjaPanel);
	panelInformacije.add(Box.createVerticalStrut(25));
	
	add(tabbedPane, BorderLayout.CENTER);
	
	JPanel buttonPanel = new JPanel();
	BoxLayout buttonLayout = new BoxLayout(buttonPanel, BoxLayout.X_AXIS);
	buttonPanel.setLayout(buttonLayout);
	
	JButton potvrda = new JButton("Potvrdi");
	JButton odustanak = new JButton("Odustani");
	potvrda.setPreferredSize(new Dimension(100, 30));
	odustanak.setPreferredSize(new Dimension(100, 30));
	buttonPanel.add(Box.createGlue());
	buttonPanel.add(potvrda);
	buttonPanel.add(Box.createHorizontalStrut(50));
	buttonPanel.add(odustanak);
	buttonPanel.add(Box.createGlue());
	
	panelInformacije.add(buttonPanel);
	setLocationRelativeTo(CentralBox.getInstance());
	
	potvrda.setEnabled(true);
	
	
	imeText.getDocument().addDocumentListener(new DocumentListener() {

		@Override
		public void changedUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			ime = imeText.getText();
			String regex_ime = "[[\\p{L}]\s]+";
			potvrda.setEnabled(proveraUnosa(ime, regex_ime, 0));		
		}

		@Override
		public void insertUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			ime = imeText.getText();
			String regex_ime = "[[\\p{L}]\s]+";
			potvrda.setEnabled(proveraUnosa(ime, regex_ime, 0));	
		}

		@Override
		public void removeUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			ime = imeText.getText();
			String regex_ime = "[[\\p{L}]\s]+";
			potvrda.setEnabled(proveraUnosa(ime, regex_ime, 0));	
		}
			
	});
	
	
	prezimeText.getDocument().addDocumentListener(new DocumentListener() {

		@Override
		public void changedUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			prezime = prezimeText.getText();
			String regex_prezime = "[\\p{L}\s]+";
			potvrda.setEnabled(proveraUnosa(prezime, regex_prezime, 1));		
		}

		@Override
		public void insertUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			prezime = prezimeText.getText();
			String regex_prezime = "[\\p{L}\s]+";
			potvrda.setEnabled(proveraUnosa(prezime, regex_prezime, 1));		
		}

		@Override
		public void removeUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			prezime = prezimeText.getText();
			String regex_prezime = "[\\p{L}\s]+";
			potvrda.setEnabled(proveraUnosa(prezime, regex_prezime, 1));	
		}
			
	});
	
	
	datumRodjenjaText.getDocument().addDocumentListener(new DocumentListener() {

		@Override
		public void changedUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			datumRodjenja = datumRodjenjaText.getText();
			String regex_datumRodjenja = "\\d{1,2}-\\d{1,2}-\\d{4}";
			potvrda.setEnabled(proveraUnosa(datumRodjenja, regex_datumRodjenja, 2));
			
		}

		@Override
		public void insertUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			datumRodjenja = datumRodjenjaText.getText();
			String regex_datumRodjenja = "\\d{1,2}-\\d{1,2}-\\d{4}";
			potvrda.setEnabled(proveraUnosa(datumRodjenja, regex_datumRodjenja, 2));
			
		}

		@Override
		public void removeUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			datumRodjenja = datumRodjenjaText.getText();
			String regex_datumRodjenja = "\\d{1,2}-\\d{1,2}-\\d{4}";
			potvrda.setEnabled(proveraUnosa(datumRodjenja, regex_datumRodjenja, 2));
			
		}
		
	});
	
	
	adresaText.getDocument().addDocumentListener(new DocumentListener() {

		@Override
		public void changedUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			adresa = adresaText.getText();
			Address regex_adresa = "[[\\d\\p{L}]+\s]+\\d*\\,[[\\p{L}]+\s]+";
			potvrda.setEnabled(proveraUnosa(adresa, regex_adresa, 3));
		}

		@Override
		public void insertUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			adresa = adresaText.getText();
			Address regex_adresa = "[[\\d\\p{L}]+\s]+\\d*\\,[[\\p{L}]+\s]+";
			potvrda.setEnabled(proveraUnosa(adresa, regex_adresa, 3));
			
		}

		@Override
		public void removeUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			adresa = adresaText.getText();
			Address regex_adresa = "[[\\d\\p{L}]+\s]+\\d*\\,[[\\p{L}]+\s]+";
			potvrda.setEnabled(proveraUnosa(adresa, regex_adresa, 3));		
		}	
	});
	
	
	brIndeksaText.getDocument().addDocumentListener(new DocumentListener() {

		@Override
		public void changedUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			brIndeksa = brIndeksaText.getText();
			String regex_brIndeksa = "[A-Z]{1,3}[0-9]{1,3}-[2][0-9]{3}";
			potvrda.setEnabled(proveraUnosa(brIndeksa, regex_brIndeksa, 4));	
		}

		@Override
		public void insertUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			brIndeksa = brIndeksaText.getText();
			String regex_brIndeksa = "[A-Z]{1,3}[0-9]{1,3}-[2][0-9]{3}";
			potvrda.setEnabled(proveraUnosa(brIndeksa, regex_brIndeksa, 4));	
		}

		@Override
		public void removeUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			brIndeksa = brIndeksaText.getText();
			String regex_brIndeksa = "[A-Z]{1,3}[0-9]{1,3}-[2][0-9]{3}";
			potvrda.setEnabled(proveraUnosa(brIndeksa, regex_brIndeksa, 4));	
		}
		
	});
	
	
	kontaktText.getDocument().addDocumentListener(new DocumentListener() {

		@Override
		public void changedUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			brojTelefona = kontaktText.getText();
			String regex_brojTelefona = "^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$";
			potvrda.setEnabled(proveraUnosa(brojTelefona, regex_brojTelefona, 5));	
		}

		@Override
		public void insertUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			brojTelefona = kontaktText.getText();
			String regex_brojTelefona = "^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$";
			potvrda.setEnabled(proveraUnosa(brojTelefona, regex_brojTelefona, 5));			
		}

		@Override
		public void removeUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			brojTelefona = kontaktText.getText();
			String regex_brojTelefona = "^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$";
			potvrda.setEnabled(proveraUnosa(brojTelefona, regex_brojTelefona, 5));	
		}
		
	});
	
	
	emailText.getDocument().addDocumentListener(new DocumentListener() {

		@Override
		public void changedUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			email = emailText.getText();
			String regex_email = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[\\p{L}0-9-]+\\.)+[\\p{L}]{2,6}$";
			potvrda.setEnabled(proveraUnosa(email, regex_email, 6));		
		}

		@Override
		public void insertUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			email = emailText.getText();
			String regex_email = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[\\p{L}0-9-]+\\.)+[\\p{L}]{2,6}$";
			potvrda.setEnabled(proveraUnosa(email, regex_email, 6));	
		}

		@Override
		public void removeUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			email = emailText.getText();
			String regex_email = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[\\p{L}0-9-]+\\.)+[\\p{L}]{2,6}$";
			potvrda.setEnabled(proveraUnosa(email, regex_email, 6));		
		}
		
	});
	
/*	prosecnaOcenaText.getDocument().addDocumentListener(new DocumentListener() {

		@Override
		public void changedUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			prosecnaOcena = prosecnaOcenaText.getText();
			String regex_prosecnaOcena = "[6-9][.][0-9]{2}|10\\.00";
			potvrda.setEnabled(proveraUnosa(prosecnaOcena, regex_prosecnaOcena, 7));
			
		}

		@Override
		public void insertUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			prosecnaOcena = prosecnaOcenaText.getText();
			String regex_prosecnaOcena = "[6-9][.][0-9]{2}|10\\.00";
			potvrda.setEnabled(proveraUnosa(prosecnaOcena, regex_prosecnaOcena, 7));
			
		}

		@Override
		public void removeUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			prosecnaOcena = prosecnaOcenaText.getText();
			String regex_prosecnaOcena = "[6-9][.][0-9]{2}|10\\.00";
			potvrda.setEnabled(proveraUnosa(prosecnaOcena, regex_prosecnaOcena, 7));
		
		}
		
	});*/
	
	godinaUpisaText.getDocument().addDocumentListener(new DocumentListener() {

		@Override
		public void changedUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			godinaUpisa = godinaUpisaText.getText();
			int regex_godinaUpisa = "\\d{4}";
			potvrda.setEnabled(proveraUnosa(godinaUpisa, regex_godinaUpisa, 7));
		}

		@Override
		public void insertUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			godinaUpisa = godinaUpisaText.getText();
			int regex_godinaUpisa = "\\d{4}";
			potvrda.setEnabled(proveraUnosa(godinaUpisa, regex_godinaUpisa, 7));
		}

		@Override
		public void removeUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			godinaUpisa = godinaUpisaText.getText();
			int regex_godinaUpisa = "\\d{4}";
			potvrda.setEnabled(proveraUnosa(godinaUpisa, regex_godinaUpisa, 7));
			
		}
		
	});
	
	
	potvrda.addActionListener(new ActionListener() {
	    
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String godinaStudija =  godineStudijaComboBox.getSelectedItem().toString();
	    String nacinFinansiranja = budzet_samofinansiranjeComboBox.getSelectedItem().toString();
	    
		double ocena = student.getavgGrade();
	    
	    Status finansiranje;
	    
		if(nacinFinansiranja=="Budzet")
			finansiranje = Status.BUDZET;
		else
			finansiranje = Status.SAMOFINANSIRANJE;
		

		for (Student s : StudentController.getInstance().getListaSvihStudenata()) {
					if ((s!=StudentController.getInstance().getListaSvihStudenata().get(selectedIndex)) && (s.getIndex().equals(brIndeksa))) {
						JOptionPane.showMessageDialog(null, "Student sa datim broj indeksa vec postoji u sistemu", "Greska pri unosu broja indeksa", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
			
				try {	
			Date datumRodjenjaDate = new SimpleDateFormat("dd-MM-yyyy").parse(datumRodjenja);
		    Student student = new Student(ime, prezime, brojTelefona, datumRodjenja, adresa, email, godinaUpisa);
			StudentController.getInstance().editStudent(student, student);
				}
				catch(java.text.ParseException pe) {
					pe.printStackTrace();
				}
			dispose();
	}
	});
	
	odustanak.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent event) {
			dispose();

		}});
	
	
	
	
	JPanel btnNpPan = new JPanel();
	BoxLayout btnNpLayout = new BoxLayout(btnNpPan, BoxLayout.X_AXIS);
	btnNpPan.setLayout(btnNpLayout);
	
	JButton btnDodaj = new JButton("Dodaj");
	btnDodaj.setPreferredSize(new Dimension(100, 30));
	JButton btnObrisi = new JButton("Obrisi");
	btnObrisi.setPreferredSize(new Dimension(100, 30));
	JButton btnPolaganje = new JButton("Polaganje");
	btnPolaganje.setPreferredSize(new Dimension(100, 30));
	
	btnNpPan.add(Box.createHorizontalStrut(25));
	btnNpPan.add(btnDodaj);
	btnNpPan.add(Box.createHorizontalStrut(25));
	btnNpPan.add(btnObrisi);
	btnNpPan.add(Box.createHorizontalStrut(25));
	btnNpPan.add(btnPolaganje);
	buttonPanel.add(Box.createHorizontalGlue());
	btnNpPan.setPreferredSize(new Dimension(750, 50));
	panelNepolozeni.add(btnNpPan, BorderLayout.NORTH);
	
	NepolozeniPredmetiJTable failedExams = new NepolozeniPredmetiJTable(student);
	JScrollPane nepolozeniScrollPane = new JScrollPane(failedExams);
	nepolozeniScrollPane.setPreferredSize(new Dimension(300, 300));
	panelNepolozeni.add(nepolozeniScrollPane, BorderLayout.CENTER);
	
	JPanel westPanel = new JPanel();
	westPanel.setPreferredSize(new Dimension(25, 750));
	panelNepolozeni.add(westPanel, BorderLayout.WEST);
	
	JPanel eastPanel = new JPanel();
	eastPanel.setPreferredSize(new Dimension(25, 750));
	panelNepolozeni.add(eastPanel, BorderLayout.EAST);
	
	JPanel southPanel = new JPanel();
	southPanel.setPreferredSize(new Dimension(750, 50));
	panelNepolozeni.add(southPanel, BorderLayout.SOUTH);
	
	btnDodaj.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			DodajPredmetStudentu dps = new DodajPredmetStudentu(student, failedExams);
			dps.setVisible(true);
		}
		
	});
	
	btnObrisi.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(failedExams.getSelectedRow() > -1) {
				ObrisiPredmetStudentu ops = new ObrisiPredmetStudentu(failedExams, student);
				ops.setVisible(true);
			}
		}
	});
	
	
	JPanel btnPolozeniPanel = new JPanel();
	BoxLayout btnPolozeniLayout = new BoxLayout(btnPolozeniPanel, BoxLayout.X_AXIS);
	btnPolozeniPanel.setLayout(btnPolozeniLayout);
	
	JButton btnPonistiOcenu = new JButton("Ponisti ocenu");
	btnPonistiOcenu.setPreferredSize(new Dimension(150, 30));
	
	btnPolozeniPanel.add(Box.createHorizontalStrut(25));
	btnPolozeniPanel.add(btnPonistiOcenu);
	btnPolozeniPanel.add(Box.createHorizontalGlue());
	btnPolozeniPanel.setPreferredSize(new Dimension(750, 50));
	panelPolozeni.add(btnPolozeniPanel, BorderLayout.NORTH);
	
	
	PolozeniPredmetiJTable polozeniPredmeti = new PolozeniPredmetiJTable(student);
	JScrollPane polozeniScrollPane = new JScrollPane(polozeniPredmeti);
	polozeniScrollPane.setPreferredSize(new Dimension(300, 300));
	panelPolozeni.add(polozeniScrollPane, BorderLayout.CENTER);
	
	JPanel leviPanel = new JPanel();
	leviPanel.setPreferredSize(new Dimension(25, 750));
	panelPolozeni.add(leviPanel, BorderLayout.WEST);
	
	JPanel desniPanel = new JPanel();
	desniPanel.setPreferredSize(new Dimension(25, 750));
	panelPolozeni.add(desniPanel, BorderLayout.EAST);
	
	JPanel donjiPanel = new JPanel();
	BoxLayout donjiLayout = new BoxLayout(donjiPanel, BoxLayout.Y_AXIS);
	donjiPanel.setLayout(donjiLayout);
	panelPolozeni.add(donjiPanel, BorderLayout.SOUTH);
	
	JPanel panelOcene = new JPanel();
	BoxLayout desniLayout = new BoxLayout(panelOcene, BoxLayout.X_AXIS);
	panelOcene.setLayout(desniLayout);
	
	JPanel panelBodovi = new JPanel();
	BoxLayout desni1Layout = new BoxLayout(panelBodovi, BoxLayout.X_AXIS);
	panelBodovi.setLayout(desni1Layout);
	
	JLabel srednjaOcena = new JLabel("Prosecna ocena:  " + student.CalculateAvgGrade());
	panelOcene.add(Box.createHorizontalGlue());
	panelOcene.add(srednjaOcena);
	panelOcene.add(Box.createHorizontalStrut(10));
	
	JLabel ukupniBodovi = new JLabel("Ukupno ESPB:  " + student.SumPoints());
	panelBodovi.add(Box.createHorizontalGlue());
	panelBodovi.add(ukupniBodovi);
	panelBodovi.add(Box.createHorizontalStrut(10));
	
	donjiPanel.add(Box.createVerticalStrut(10));
	donjiPanel.add(panelOcene);
	donjiPanel.add(Box.createVerticalStrut(10));
	donjiPanel.add(panelBodovi);
	donjiPanel.add(Box.createVerticalStrut(10));

	polozeniPredmeti.getModel().addTableModelListener(new TableModelListener() {

		@Override
		public void tableChanged(TableModelEvent arg0) {
			// TODO Auto-generated method stub
			
			srednjaOcena.setText("Prosecna ocena:  " + student.CalculateAvgGrade());
			ukupniBodovi.setText("Ukupno ESPB:  " + student.SumPoints());
			
			StudentsTable.getInstance().refreshTable();
			
		}
		
	});
	
	
	btnPolaganje.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(failedExams.getSelectedRow() > -1) {
				UpisiOcenu duo = new UpisiOcenu(failedExams, polozeniPredmeti, student);
				duo.setVisible(true);
			}
		}
		
	});
	
	
	btnPonistiOcenu.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(polozeniPredmeti.getSelectedRow() > -1) {
				ObrisiOcenu doo = new ObrisiOcenu(polozeniPredmeti, failedExams, student);
				doo.setVisible(true);
			}
		}
	});
	
	}
	
	
	
	public boolean proveraUnosa(String text, String regex, int index) {
		if(!text.matches(regex))
			ispravni[index] = false;
		else
			ispravni[index] = true;
		
		boolean ispravnoSve = true;
		
		for(boolean i : ispravni)
			if(i == false)
				ispravnoSve = false;
		if(ispravnoSve == true)
			return true;
		else
			return false;
	}
	

}
