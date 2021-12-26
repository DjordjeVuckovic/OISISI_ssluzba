package gui.view.dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.focuslisteners.ProfessorListener;
import gui.view.center.ProfessorsTable;
import controller.FocusProfessor;
import controller.ProfessorController;
import model.BazaProfesora;
import model.Professor;

public class EditProfessor extends JDialog{
	/**
	 * 
	 */
	public static JTextField prezimeTF;
	public static JTextField imeTF;
	public static JTextField datumTF;
	public static JTextField telefonTF;
	public static JTextField adresaTF; //treba da se ubaci adresaStreetTf itd.
	public static JTextField emailTF;
	public static JTextField idTF;
	public static String titula;
	public static JTextField godineStazaTF;
	public static JTextField predmetiTF; //arraylist

	private static final long serialVersionUID = 8592866674972968760L;

	public EditProfessor() {
		try {

		setModal(true);
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();
		int screenHeight=screenSize.height;
		int screenWidth=screenSize.width;
		
		if(3*screenHeight/7 < 400 || 2*screenWidth/10 < 350){
			setSize(350, 400);
		}else {
			setSize(2*screenWidth/10,3*screenHeight/7);
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Izmena Profesora");
				
		JPanel donjiPanel = new JPanel(new FlowLayout());
		donjiPanel.setBackground(Color.DARK_GRAY);
		donjiPanel.setPreferredSize(new Dimension(100,23));
		
		FocusProfessor fokus=new FocusProfessor();
		
		
		JPanel imeP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel imeL=new JLabel("Ime: *");
		imeTF=new JTextField();
		imeTF.setName("txt");
		imeTF.setPreferredSize(new Dimension(200,25));
		imeTF.addFocusListener(fokus);
		imeTF.setToolTipText("npr. Nebojša");
		imeP.add(imeL);
		imeP.add(imeTF);
		
		
		JPanel prezimeP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel prezimeL=new JLabel("Prezime: *");
		prezimeTF=new JTextField();
		prezimeTF.setName("txt");
		prezimeTF.setPreferredSize(new Dimension(200,25));
		prezimeTF.addFocusListener(fokus);
		prezimeTF.setToolTipText("npr. Ralević");
		prezimeP.add(prezimeL);
		prezimeP.add(prezimeTF);
		
		JPanel datumP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel datumL=new JLabel("Datum rodjenja: *");
		datumTF=new JTextField();
		datumTF.setName("txt");
		datumTF.setPreferredSize(new Dimension(200,25));
		datumTF.addFocusListener(fokus);
		datumTF.setToolTipText("npr. 14.12.1983 tj. u formatu dd.MM.yyyy ");
		datumP.add(datumL);
		datumP.add(datumTF);
		
		JPanel telefonP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel telefonL=new JLabel("Kontakt telefon: *");
		telefonTF=new JTextField();
		telefonTF.setName("txt");
		telefonTF.setPreferredSize(new Dimension(200,25));
		telefonTF.addFocusListener(fokus);
		telefonTF.setToolTipText("npr. 021/1234-123");
		telefonP.add(telefonL);
		telefonP.add(telefonTF);
		
		JPanel emailP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel emailL=new JLabel("Email: *");
		emailTF=new JTextField();
		emailTF.setName("txt");
		emailTF.setPreferredSize(new Dimension(200,25));
		emailTF.addFocusListener(fokus);
		emailTF.setToolTipText("npr. nebojsa.ralevic@hotmail.com");
		emailP.add(emailL);
		emailP.add(emailTF);
		
		
		JPanel adresaP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel adresaL= new JLabel("Adresa stanovanja* ");
		adresaTF = new JTextField();
		adresaTF.setName("txt");
		adresaTF.setPreferredSize(new Dimension(200,25));
		adresaTF.addFocusListener(fokus);
		adresaTF.setToolTipText("npr. Jovana Subotića 33, Novi Sad");
		adresaP.add(adresaL);
		adresaP.add(adresaTF);

	
		JPanel idP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel idL=new JLabel("ID profesora: *");
		idTF=new JTextField();
		idTF.setName("txt");
		idTF.setPreferredSize(new Dimension(200,25));
		idTF.addFocusListener(fokus);
		idTF.setToolTipText("npr. 007");
		idP.add(idL);
		idP.add(idTF);
		
		
		JPanel titulaP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel titulaL=new JLabel("Titula: *");
		String[] titule= {"BSc","MSc","PhD"};
		JComboBox<Object> tituleCB=new JComboBox<Object>(titule);
		titulaP.add(titulaL);
		titulaP.add(tituleCB);
		
		JPanel godineStazaP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel godineStazaL=new JLabel("godineStaza: *");
		godineStazaTF=new JTextField();
		godineStazaTF.setName("txt");
		godineStazaTF.setPreferredSize(new Dimension(200,25));
		godineStazaTF.addFocusListener(fokus);
		godineStazaTF.setToolTipText("npr. 1");
		godineStazaP.add(godineStazaL);
		godineStazaP.add(godineStazaTF);
		
		//predmeti
		
		
		JPanel odustanakPotvrda = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton odustanak = new JButton("Odustanak");
		JButton potvrda = new JButton("Potvrda");
		odustanak.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();

			}
		});
		//implementiram serijalizaciju
		potvrda.addActionListener(new ActionListener() {
			
			
			String imeReg="[A-Ž][a-ž]+";
			String adresaReg="[a-žA-Ž0-9 ]*[,][ a-žA-Ž]+";
			String telReg="[0-9]+/[0-9]+[-][0-9]+";
			String emailReg="[a-zA-Z0-9.]+@[a-zA-Z]+[.][a-zA-Z]+";
			String idReg="[a-žA-Ž0-9, ]+";
			String godineStazaReg="[0-9]+";
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(imeTF.getText().equals("") || prezimeTF.getText().equals("") || datumTF.getText().equals("") || adresaTF.getText().equals("") || 
						telefonTF.getText().equals("") || emailTF.getText().equals("") || idTF.getText().equals("")  || godineStazaTF.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Niste popunili sva obavezna polja!!!","",JOptionPane.ERROR_MESSAGE);
				
				}else if(!imeTF.getText().trim().matches(imeReg)){
					JOptionPane.showMessageDialog(null, "Ime nije uneseno kako treba!","",JOptionPane.ERROR_MESSAGE);
				}else if(!prezimeTF.getText().trim().matches(imeReg)){
					JOptionPane.showMessageDialog(null, "Prezime nije uneseno kako treba!","",JOptionPane.ERROR_MESSAGE);
				}else if(!proveriDatum(datumTF.getText())){
					JOptionPane.showMessageDialog(null, "Datum nije unesen kako treba! (dd.MM.yyyy)","",JOptionPane.ERROR_MESSAGE);
				}else if(!adresaTF.getText().trim().matches(adresaReg)) {
					JOptionPane.showMessageDialog(null, "Adresa nije uneta kako treba!","",JOptionPane.ERROR_MESSAGE);
				}else if(!telefonTF.getText().matches(telReg)) {
					JOptionPane.showMessageDialog(null, "Telefon nije unet kako treba!","",JOptionPane.ERROR_MESSAGE);
				}else if(!emailTF.getText().matches(emailReg)) {
					JOptionPane.showMessageDialog(null, "Email nije unet kako treba!","",JOptionPane.ERROR_MESSAGE);
				}else if(!idTF.getText().matches(idReg)) {
					JOptionPane.showMessageDialog(null, "id nije uneta kako treba!","",JOptionPane.ERROR_MESSAGE);
				}else if(!godineStazaTF.getText().matches(godineStazaReg)){
					JOptionPane.showMessageDialog(null, "Godine nije uneta kako treba!","",JOptionPane.ERROR_MESSAGE);
				}else {
					
					titula=(String)tituleCB.getSelectedItem();
					
					String [] datum = datumTF.getText().split("\\.");
					LocalDate lc = LocalDate.of(Integer.parseInt(datum[2]), Integer.parseInt(datum[1]), Integer.parseInt(datum[0]));
					ProfessorController.getInstance().editProfessor(imeTF.getText(), prezimeTF.getText(), lc, adresaTF.getText(), telefonTF.getText(), emailTF.getText(), idTF.getText(), godineStazaTF.getText(), titula);
					
					setVisible(false);
					dispose();
				}
				
			}
			private boolean proveriDatum(String text) {
				// TODO Auto-generated method stub
				if(!text.isEmpty()) {
					
					String regexdatum="^\\d{2,2}\\.\\d{2,2}\\.\\d{4}$";
					
					if(!text.matches(regexdatum)) {
						return false;
					}else {
						String[] datumi=text.split("\\.");
						int dan=Integer.parseInt(datumi[0]);
						int mesec=Integer.parseInt(datumi[1]);

						if(dan<1) {
							return false;
						}else if(mesec>12) {
							return false;
						}else if(mesec<1) {
							return false;
						}else if(mesec==2) {
							if(dan>29 ) {
								return false;
							}
						}else if(mesec==1 || mesec==3 || mesec==5 || mesec==7 ||mesec==8 || mesec==10 || mesec==12) {
							if(dan>31) {
								return false;
							}
						}else if(mesec==4 || mesec==6 || mesec==9 || mesec==11) {
							if(dan>30) {
								return false;
							}
						}
						return true;
						}
					}
				return false;
				}
		});
		Professor prof=new Professor(BazaProfesora.getInstance().getRow(ProfessorsTable.getInstance().getRowCnt())); //treba se napraviti funkcija getSelectedRow
		imeTF.setText(prof.getName());
		prezimeTF.setText(prof.getSurname());
		//datumTF.setText(prof.getBirthday().SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
       
		//.setAdress(prof.getAdress());
		telefonTF.setText(prof.getContact());
		emailTF.setText(prof.getMail());
		idTF.setText(prof.getIdNumber());
		//godineStazaTF=prof.getGodStaza());
		titula=prof.getTitle();
		

		odustanakPotvrda.add(odustanak);
		odustanakPotvrda.add(potvrda);

		Box obrazac = Box.createVerticalBox();
		obrazac.add(Box.createVerticalStrut(10));
		obrazac.add(imeP);
		obrazac.add(prezimeP);
		obrazac.add(datumP);
		obrazac.add(adresaP);
		obrazac.add(telefonP);
		obrazac.add(emailP);
		obrazac.add(idP);
		obrazac.add(godineStazaP);
		obrazac.add(titulaP);
		obrazac.add(odustanakPotvrda);
		obrazac.add(Box.createGlue());
		
		
		this.add(obrazac,BorderLayout.CENTER);
		
		this.add(donjiPanel,BorderLayout.SOUTH);

		setSize(400, 400);
		setVisible(true);
		}catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Nije selektovan Professor!","",JOptionPane.ERROR_MESSAGE);

			System.out.println(e.getMessage());
		}
	}
}
