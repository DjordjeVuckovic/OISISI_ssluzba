package gui.view.dialog.add;

import controller.ProfessorController;
import controller.focuslisteners.ProfessorListener;
import gui.view.MainWindow;
import gui.view.dialog.MyDialog;
import model.Address;
import model.Professor;
import model.Zvanje;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AddProfessor  extends MyDialog {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6176645110187015550L;
	
	private JTextField txtFieldName;
	private JTextField txtFieldSurName;
	private JTextField txtFieldDate;
	private JTextField txtFieldNUm;
	private JTextField txtFieldE;
	private JTextField txtFieldId;
	private JTextField txtFieldYearsTail;

    private JButton btAccept;
    private JButton btDecline;

    private JTextField txtKancelarijaStreet;
    private JTextField txtKancelarijaNum;
    private JTextField txtKancelarijaCity;
    private JTextField txtKancelarijaContry;

    
    private static AddProfessor instance = null;

    public static AddProfessor getInstance() {
        if(instance==null) instance = new AddProfessor();
        return instance;
    }
    public boolean allValid(){
        for(ProfessorListener pl:validations){
            if(!pl.getValidation()){
                return false;
            }
        }
        return true;
    }
    public void EnableButt(){
        btAccept.setEnabled(allValid());
    }
    
	private AddProfessor() {
        super(MainWindow.getInstance(),"Dodavanje Profesora");
        initProfessorDialog();
       
    }
	

    private ArrayList<ProfessorListener> validations=new ArrayList<>();
    private void initProfessorDialog(){
        Dimension cellDim = new Dimension(200, 20);
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
        txtKancelarijaStreet= new JTextField();
        txtKancelarijaStreet.setPreferredSize(cellDim);
        txtKancelarijaStreet.setName("txtStreet");
        lbAdressStreet.setPreferredSize(cellDim);
        
        JLabel lbAdressNum = new JLabel("Broj ulice*");
        txtKancelarijaNum= new JTextField();
        txtKancelarijaNum.setPreferredSize(cellDim);
        txtKancelarijaNum.setName("txtStnum");
        lbAdressNum.setPreferredSize(cellDim);
        
        JLabel lbAdressCity = new JLabel("Grad*");
        txtKancelarijaCity= new JTextField();
        txtKancelarijaCity.setName("txtCity");
        txtKancelarijaCity.setPreferredSize(cellDim);
        lbAdressCity.setPreferredSize(cellDim);
        
        JLabel lbAdressContry = new JLabel("Drzava*");
        txtKancelarijaContry= new JTextField();
        txtKancelarijaContry.setName("txtContry");
        txtKancelarijaContry.setPreferredSize(cellDim);
        lbAdressContry.setPreferredSize(cellDim);


        JPanel panelA1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelA1.add(lbAdressStreet);
        panelA1.add(txtKancelarijaStreet);
       
        JPanel panelA2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelA2.add(lbAdressNum);
        panelA2.add(txtKancelarijaNum);
        
        JPanel panelA3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelA3.add(lbAdressCity);
        panelA3.add(txtKancelarijaCity);
        
        JPanel panelA4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelA4.add(lbAdressContry);
        panelA4.add(txtKancelarijaContry);
        
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
        JPanel panelID = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelID.add(lbId);
        panelID.add(txtFieldId);

        JLabel lbZvanje = new JLabel("Zvanje*");
        lbZvanje.setPreferredSize(cellDim);
        String[] Zvanje = new String[]{"SARADNIK_U_NASTAVI", "ASISTENT", "DOCENT", "VANREDNI_PROFESOR", "REDOVNI_PROFESOR", "ASISTENT_SA_DOKTORATOM"};
        JComboBox<String> txtFJComboBoxZvanje = new JComboBox<>(Zvanje);
        txtFJComboBoxZvanje.setName("txtZvanje");
        txtFJComboBoxZvanje.setPreferredSize(cellDim);
        JPanel panelZ = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelZ.add(lbZvanje);
        panelZ.add(txtFJComboBoxZvanje);
        
        JLabel lbYearsTail = new JLabel("Godine radnog staza*");
        lbYearsTail.setToolTipText("Unesite godine radnog staza");
        lbYearsTail.setPreferredSize(cellDim);
        txtFieldYearsTail = new JTextField();
        txtFieldYearsTail.setToolTipText("Trazeni format:");
        txtFieldYearsTail.setPreferredSize(cellDim);
        txtFieldYearsTail.setName("txtYearsTail");
        JPanel panelY = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelY.add(lbYearsTail);
        panelY.add(txtFieldYearsTail);


        JPanel CentralPanel = new JPanel();
        BoxLayout boxCenter = new BoxLayout(CentralPanel,BoxLayout.Y_AXIS);
        CentralPanel.setLayout(boxCenter);
        CentralPanel.add(Box.createVerticalGlue());
        CentralPanel.add(panelN);
        CentralPanel.add(panelS);
        CentralPanel.add(panelD);
        CentralPanel.add(panelA1);
        CentralPanel.add(panelA2);
        CentralPanel.add(panelA3);
        CentralPanel.add(panelA4);
        CentralPanel.add(panelNum);
        CentralPanel.add(panelE);
        CentralPanel.add(panelID);
        CentralPanel.add(panelZ);
        CentralPanel.add(panelY);
        this.add(CentralPanel,BorderLayout.CENTER);

        
        //validation
        ProfessorListener val= new ProfessorListener(lbName,txtFieldName,this);
        txtFieldName.addFocusListener(val);
        validations.add(val);
        val =new ProfessorListener(lbSurname,txtFieldSurName,this);
        txtFieldSurName.addFocusListener(val);
        validations.add(val);
        validations.add(val);
		/*
		 * val=new ProfessorListener(lbYearsTail,txtFieldYearsTail,this);
		 * txtFieldYearsTail.addFocusListener(val); validations.add(val);
		 */
        val=new ProfessorListener(lbEmail,txtFieldE,this);
        txtFieldE.addFocusListener(val);
        validations.add(val);
        val=new ProfessorListener(lbDate,txtFieldDate,this);
        txtFieldDate.addFocusListener(val);
        validations.add(val);
		/*
		 * val=new ProfessorListener(lbId,txtFieldId,this);
		 * txtFieldId.addFocusListener(val); validations.add(val);
		 */
        val=new ProfessorListener(lbNum,txtFieldNUm,this);
        txtFieldNUm.addFocusListener(val);
        validations.add(val);
        val = new ProfessorListener(lbAdressStreet, txtKancelarijaStreet,this);
        txtKancelarijaStreet.addFocusListener(val);
        validations.add(val);
        val = new ProfessorListener(lbAdressNum, txtKancelarijaNum,this);
        txtKancelarijaNum.addFocusListener(val);
        validations.add(val);
        val = new ProfessorListener(lbAdressCity, txtKancelarijaCity,this);
        txtKancelarijaCity.addFocusListener(val);
        validations.add(val);
        val = new ProfessorListener(lbAdressContry, txtKancelarijaContry,this);
        txtKancelarijaContry.addFocusListener(val);
        validations.add(val);

        //buttons
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
                dispose();
            }
        });

        diaButtonPanel.add(btDecline);
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
                    Professor Professor = new Professor();
                    Professor.setName(txtFieldName.getText());
                    Professor.setSurname(txtFieldSurName.getText());
                    Professor.setBirthday(birthday); 	
                    Professor.setContact(txtFieldNUm.getText());
                    Professor.setMail(txtFieldE.getText());
                    Professor.setIdNumber(txtFieldId.getText());
                    Professor.setYearsTail(Integer.parseInt(txtFieldYearsTail.getText()) );
                    Address adress= new Address();
                    adress.setStreet(txtKancelarijaStreet.getText());
                    adress.setNumber(txtKancelarijaNum.getText());
                    adress.setCity(txtKancelarijaCity.getText());
                    adress.setCountry(txtKancelarijaContry.getText());
                    
                    Professor.setAdresaKancelarije(adress);

      

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

                    ProfessorController.getInstance().addProfessor(Professor);
                    clearFields();
                    btAccept.setEnabled(false);
                    dispose();
                }
            }
        });



        diaButtonPanel.add(btAccept);
        diaButtonPanel.add(Box.createHorizontalStrut(20));
        this.add(diaButtonPanel,BorderLayout.SOUTH);
        
    }
   
    private void clearFields() {
        //txtFieldName.setText("");
       // txtFieldSurName.setText("");
        //txtFieldDate.setText("");
        //txtFieldNUm.setText("");
       // txtFieldE.setText("");
        txtFieldId.setText("");
       // txtFieldAssignYear.setText("");
    }

}
