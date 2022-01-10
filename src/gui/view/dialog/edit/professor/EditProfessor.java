package gui.view.dialog.edit.professor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.Serial;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ProfessorController;
import controller.focuslisteners.ProfessorListener;
import model.Address;
import model.Zvanje;
import model.Professor;

public class EditProfessor extends JPanel{
	/**
	 * 
	 */
	@Serial
    private static final long serialVersionUID = 6674408014723983134L;
	
	private Professor Professor;
	private JTextField txtFieldName;
	private JTextField txtFieldSurName;
	private JTextField txtFieldDate;
	private JTextField txtFieldNUm;
	private JTextField txtFieldE;
	private JTextField txtFieldId;
	private JTextField txtFieldGodStaza;
	private JComboBox<String> txtFJComboBoxZvanje;
	

    private JButton btAccept;
    private JButton btDecline;
    private  Dimension cellDim;
    
    private JTextField txtAdressStreet;
    private JTextField txtAdressNum;
    private JTextField txtAdressCity;
    private JTextField txtAdressContry;
    
    public boolean allValid(){
        for(ProfessorListener pl:validations){
            if(!pl.getValidation()){
                return false;
            }
        }
        return true;
    }
    public void EnableButt(){
        if(allValid()){
            btAccept.setEnabled(true);
        }
        else{
            btAccept.setEnabled(false);
        }
    }
    

    private ArrayList<ProfessorListener> validations=new ArrayList<>();
	public EditProfessor(Professor Professor) {
		this.Professor=Professor;
		cellDim = new Dimension(200, 20);
        setLayout(new BorderLayout());
        
        JLabel lbName = new JLabel("Ime*");
        lbName.setToolTipText("Unesite svoje ime");
        lbName.setPreferredSize(cellDim);
        txtFieldName = new JTextField();
        txtFieldName.setToolTipText("Ime je niz karaktera");
        txtFieldName.setPreferredSize(cellDim);
        txtFieldName.setName("txtName");
        JPanel panelN = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelN.add(lbName);
        panelN.add(txtFieldName);

        JLabel lbSurname = new JLabel("Prezime*");
        lbSurname.setToolTipText("Unesite svoje prezime");
        lbSurname.setPreferredSize(cellDim);
        txtFieldSurName = new JTextField();
        txtFieldSurName.setToolTipText("Prezime je niz karaktera");
        txtFieldSurName.setPreferredSize(cellDim);
        txtFieldSurName.setName("txtSurname");
        JPanel panelS = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelS.add(lbSurname);
        panelS.add(txtFieldSurName);

        JLabel lbDate = new JLabel("Date*");
        lbDate.setToolTipText("Unesite datum rodjenja");
        lbDate.setPreferredSize(cellDim);
        txtFieldDate = new JTextField();
        txtFieldDate.setToolTipText("Trazeni format: dd.mm.yyyy");
        txtFieldDate.setPreferredSize(cellDim);
        txtFieldDate.setName("txtDate");
        JPanel panelD = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelD.add(lbDate);
        panelD.add(txtFieldDate);

        JLabel lbAdressStreet = new JLabel("Ulica*");
        txtAdressStreet= new JTextField();
        lbAdressStreet.setPreferredSize(cellDim);
        txtAdressStreet.setPreferredSize(cellDim);
        txtAdressStreet.setName("txtStreet");
        
        JLabel lbAdressNum = new JLabel("Broj ulice*");
        txtAdressNum= new JTextField();
        lbAdressNum.setPreferredSize(cellDim);
        txtAdressNum.setPreferredSize(cellDim);
        txtAdressNum.setName("txtStnum");
        
        JLabel lbAdressCity = new JLabel("Grad*");
        txtAdressCity= new JTextField();
        txtAdressCity.setName("txtCity");
        txtAdressCity.setPreferredSize(cellDim);
        lbAdressCity.setPreferredSize(cellDim);
        
        JLabel lbAdressContry = new JLabel("Drzava*");
        txtAdressContry= new JTextField();
        txtAdressCity.setName("txtCity");
        txtAdressContry.setPreferredSize(cellDim);
        lbAdressContry.setPreferredSize(cellDim);
        txtAdressContry.setName("txtContry");
        
        JPanel panelA1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelA1.add(lbAdressStreet);
        panelA1.add(txtAdressStreet);
       
        JPanel panelA2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelA2.add(lbAdressNum);
        panelA2.add(txtAdressNum);
        
        JPanel panelA3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelA3.add(lbAdressCity);
        panelA3.add(txtAdressCity);
        
        JPanel panelA4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelA4.add(lbAdressContry);
        panelA4.add(txtAdressContry);
        
        JLabel lbNum = new JLabel("Broj telefona*");
        lbNum.setToolTipText("Unesite svoj broj telefona");
        lbNum.setPreferredSize(cellDim);
        txtFieldNUm = new JTextField();
        txtFieldNUm.setToolTipText("Broj telefona mora da ima najmanje 3 cifre,a najvise 12");
        txtFieldNUm.setPreferredSize(cellDim);
        txtFieldNUm.setName("txtNum");
        JPanel panelNum = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelNum.add(lbNum);
        panelNum.add(txtFieldNUm);

        JLabel lbEmail = new JLabel("E-mail adresa*");
        lbEmail.setToolTipText("Unesite svoj E-mail");
        lbEmail.setPreferredSize(cellDim);
        txtFieldE = new JTextField();
        txtFieldE.setToolTipText("Trazeni format:nesto@nesto");
        txtFieldE.setPreferredSize(cellDim);
        txtFieldE.setName("txtEmail");
        JPanel panelE = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelE.add(lbEmail);
        panelE.add(txtFieldE);

        JLabel lbId = new JLabel("Broj licne karte*");
        lbId.setToolTipText("Unesite broj licne karte");
        lbId.setPreferredSize(cellDim);
        txtFieldId = new JTextField();
        txtFieldId.setToolTipText("Trazeni format: xxxxxxxx");
        txtFieldId.setPreferredSize(cellDim);
        txtFieldId.setName("txtId");
        ProfessorListener valId=new ProfessorListener(lbId,txtFieldId,this,Professor.getIdNumber());
        txtFieldId.addFocusListener(valId);
        JPanel panelID = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelID.add(lbId);
        panelID.add(txtFieldId);

        JLabel lbGodStaza = new JLabel("Godine Staza*");
        lbGodStaza.setToolTipText("Unesite godine staza");
        lbGodStaza.setPreferredSize(cellDim);
        txtFieldGodStaza = new JTextField();
        txtFieldGodStaza.setToolTipText("Trazeni format: 0-9");
        txtFieldGodStaza.setPreferredSize(cellDim);
        txtFieldGodStaza.setName("txtGodStaza");
        JPanel panelY = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelY.add(lbGodStaza);
        panelY.add(txtFieldGodStaza);
        
        JLabel lbZvanje = new JLabel("Zvanje profesora*");
        lbZvanje.setPreferredSize(cellDim);
        String[] Zvanje = new String[]{"SARADNIK_U_NASTAVI", "ASISTENT", "DOCENT", "VANREDNI_PROFESOR", "REDOVNI_PROFESOR", "ASISTENT_SA_DOKTORATOM"};
        txtFJComboBoxZvanje = new JComboBox<>(Zvanje);
        txtFJComboBoxZvanje.setName("txtZvanje");
        txtFJComboBoxZvanje.setPreferredSize(cellDim);
        JPanel panelZ = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelZ.add(lbZvanje);
        panelZ.add(txtFJComboBoxZvanje);

        
        initFields();

        //validation
        ProfessorListener val= new ProfessorListener(lbName,txtFieldName,this);
        txtFieldName.addFocusListener(val);
        validations.add(val);
        val =new ProfessorListener(lbSurname,txtFieldSurName,this);
        txtFieldSurName.addFocusListener(val);
        validations.add(val);
        val=new ProfessorListener(lbGodStaza,txtFieldGodStaza,this);
        txtFieldGodStaza.addFocusListener(val);
        validations.add(val);
        val=new ProfessorListener(lbEmail,txtFieldE,this);
        txtFieldE.addFocusListener(val);
        validations.add(val);
        val=new ProfessorListener(lbDate,txtFieldDate,this);
        txtFieldDate.addFocusListener(val);
        validations.add(val);
        validations.add(valId);
        val=new ProfessorListener(lbNum,txtFieldNUm,this);
        txtFieldNUm.addFocusListener(val);
        validations.add(val);
        val = new ProfessorListener(lbAdressStreet,txtAdressStreet,this);
        txtAdressStreet.addFocusListener(val);
        validations.add(val);
        val = new ProfessorListener(lbAdressNum,txtAdressNum,this);
        txtAdressNum.addFocusListener(val);
        validations.add(val);
        val = new ProfessorListener(lbAdressCity,txtAdressCity,this);
        txtAdressCity.addFocusListener(val);
        validations.add(val);
        val = new ProfessorListener(lbAdressContry,txtAdressContry,this);
        txtAdressContry.addFocusListener(val);
        validations.add(val);
        //addition of components
        JPanel CentralPanel = new JPanel();
        BoxLayout boxCenter = new BoxLayout(CentralPanel,BoxLayout.Y_AXIS);
        CentralPanel.setLayout(boxCenter);
        CentralPanel.add(Box.createVerticalGlue());
        CentralPanel.add(panelN);
        CentralPanel.add(panelS);
        CentralPanel.add(panelD);
        CentralPanel.add(panelNum);
        CentralPanel.add(panelE);
        CentralPanel.add(panelID);
        CentralPanel.add(panelY);
        CentralPanel.add(panelA1);
        CentralPanel.add(panelA2);
        CentralPanel.add(panelA3);
        CentralPanel.add(panelA4);
        CentralPanel.add(panelZ);
        
        this.add(CentralPanel,BorderLayout.CENTER);
        
        //button
        JPanel diaButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        diaButtonPanel.setPreferredSize(new Dimension(60,60));
        btAccept = new JButton("Potvrdi");
        btAccept.setEnabled(false);
        btAccept.setMnemonic(KeyEvent.VK_S);
        btAccept.setForeground(Color.GREEN);
        btDecline = new JButton("Odustani");
        btDecline.setForeground(Color.BLACK);
        btDecline.setMnemonic(KeyEvent.VK_Q);
        btDecline.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //
            }
        });
        btAccept.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(allValid()){
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
                    dateFormat.setLenient(false);
                    Date birthday = null;
                    try {
                        birthday = dateFormat.parse(txtFieldDate.getText());
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }
                    Professor ProfessorNew = new Professor();
                    ProfessorNew.setName(txtFieldName.getText());
                    ProfessorNew.setSurname(txtFieldSurName.getText());
                    ProfessorNew.setBirthday(birthday);
                    ProfessorNew.setContact(txtFieldNUm.getText());
                    ProfessorNew.setMail(txtFieldE.getText());
                    ProfessorNew.setIdNumber(txtFieldId.getText());
                    //valId.setIdNumber(ProfessorNew.getIdNumber());
                    ProfessorNew.setYearsTail(Integer.parseInt(txtFieldGodStaza.getText()) );
                    Address adress= new Address();
                    adress.setStreet(txtAdressStreet.getText());
                    adress.setNumber(txtAdressNum.getText());
                    adress.setCity(txtAdressCity.getText());
                    adress.setCountry(txtAdressContry.getText());

                    ProfessorNew.setAdresaKancelarije(adress);


                    if(txtFJComboBoxZvanje.getSelectedIndex()==0){
                        Professor.setTitle(model.Zvanje.SARADNIK_U_NASTAVI);
                    } else if(txtFJComboBoxZvanje.getSelectedIndex()==1){
                        Professor.setTitle(model.Zvanje.ASISTENT);
                    }else if(txtFJComboBoxZvanje.getSelectedIndex()==2){
                        Professor.setTitle(model.Zvanje.DOCENT);
                    }else if(txtFJComboBoxZvanje.getSelectedIndex()==3){
                        Professor.setTitle(model.Zvanje.VANREDNI_PROFESOR);
                    }else if(txtFJComboBoxZvanje.getSelectedIndex()==4){
                        Professor.setTitle(model.Zvanje.REDOVNI_PROFESOR);
                    }else if(txtFJComboBoxZvanje.getSelectedIndex()==5){
                        Professor.setTitle(model.Zvanje.ASISTENT_SA_DOKTORATOM);
                    }


                    ProfessorController.getInstance().editProfessor(Professor,ProfessorNew);
                    btAccept.setEnabled(false);
                }
            }
        });

        diaButtonPanel.add(btDecline);
        diaButtonPanel.add(btAccept);
        diaButtonPanel.add(Box.createHorizontalStrut(20));
        this.add(diaButtonPanel,BorderLayout.SOUTH);
        
	}
	private void initFields(){
		 txtFieldName.setText(Professor.getName());
		 txtFieldSurName.setText(Professor.getSurname());
		 DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		 txtFieldDate.setText(dateFormat.format(Professor.getBirthday()));
		 txtFieldNUm.setText(Professor.getContact());
		 txtFieldE.setText(Professor.getMail());
		 txtFieldId.setText(Professor.getIdNumber());
		 txtFieldGodStaza.setText(String.valueOf(Professor.getYearsTail()));
		 
		 if(Professor.getTitle()== Zvanje.SARADNIK_U_NASTAVI) {
		 txtFJComboBoxZvanje.setSelectedIndex(0);
		 }
		 if(Professor.getTitle()== Zvanje.ASISTENT) {
			 txtFJComboBoxZvanje.setSelectedIndex(1);
			 }
		 if(Professor.getTitle()== Zvanje.DOCENT) {
			 txtFJComboBoxZvanje.setSelectedIndex(2);
			 }
		 if(Professor.getTitle()== Zvanje.VANREDNI_PROFESOR) {
			 txtFJComboBoxZvanje.setSelectedIndex(3);
			 }
		 if(Professor.getTitle()== Zvanje.REDOVNI_PROFESOR) {
			 txtFJComboBoxZvanje.setSelectedIndex(4);
			 }
		 if(Professor.getTitle()== Zvanje.ASISTENT_SA_DOKTORATOM) {
			 txtFJComboBoxZvanje.setSelectedIndex(5);
			 }
	    
	    txtAdressStreet.setText(Professor.getAdresaKancelarije().getStreet());
	    txtAdressNum.setText(Professor.getAdresaKancelarije().getNumber());
	    txtAdressCity.setText(Professor.getAdresaKancelarije().getCity());
	    txtAdressContry.setText(Professor.getAdresaKancelarije().getCountry());
	}
}
