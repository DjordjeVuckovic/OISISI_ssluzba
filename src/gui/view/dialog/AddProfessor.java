package gui.view.dialog;

import controller.ProfessorController;
import controller.focuslisteners.ProfessorListener;
import gui.view.MainWindow;
import model.Adress;
import model.Professor;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AddProfessor  extends MyDialog {

    private JTextField txtFieldSurName;
    private JTextField txtFieldName;
    private JTextField txtFieldDate;
    //private JTextField txtFieldAdress;
    private JTextField txtFieldNUm;
    private JTextField txtFieldEmail;
    private JTextField txtFieldId;
    private JTextField txtFieldTitle; 
    private JTextField txtAdressStreet;
    private JTextField txtAdressNum;
    private JTextField txtAdressCity;
    private JTextField txtAdressCountry;
  
    private JButton btAccept;
    private JButton btDecline;
    private  Dimension cellDim;

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
        if(allValid()){
            btAccept.setEnabled(true);
        }
        else{
            btAccept.setEnabled(false);
        }
    }

    private AddProfessor() {
        super(MainWindow.getInstance(),"Dodavanje Profesora");
        initProfessorDialog();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                instance.setVisible(false);
                instance=null;
                clearFields();
            }
        });
    }

    private ArrayList<ProfessorListener> validations=new ArrayList<>();
    private void initProfessorDialog(){
        cellDim = new Dimension(200, 20);
        setLayout(new BorderLayout());
        
        JLabel lbSurname = new JLabel("Prezime*");
        lbSurname.setToolTipText("Unesite svoje prezime");
        lbSurname.setPreferredSize(cellDim);
        txtFieldSurName = new JTextField();
        txtFieldSurName.setToolTipText("Prezime je niz karaktera");
        txtFieldSurName.setPreferredSize(cellDim);
        txtFieldSurName.setName("txtSurName");
        JPanel panelS = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelS.add(lbSurname);
        panelS.add(txtFieldSurName);

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

        JLabel lbDate = new JLabel("Date*");
        lbDate.setToolTipText("Unesite datum rodjenja");
        lbDate.setPreferredSize(cellDim);
        txtFieldDate = new JTextField();
        txtFieldDate.setToolTipText("Trazeni format: gg.mm.yyyy");
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
        
        JLabel lbAdressCountry = new JLabel("Drzava*");
        txtAdressCountry= new JTextField();
        txtAdressCity.setName("txtCity");
        txtAdressCountry.setPreferredSize(cellDim);
        lbAdressCountry.setPreferredSize(cellDim);
        txtAdressCountry.setName("txtCountry");
        
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
        panelA4.add(lbAdressCountry);
        panelA4.add(txtAdressCountry);


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
        txtFieldEmail = new JTextField();
        txtFieldEmail.setToolTipText("Trazeni format:nesto@nesto");
        txtFieldEmail.setPreferredSize(cellDim);
        txtFieldEmail.setName("txtEmail");
        JPanel panelE = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelE.add(lbEmail);
        panelE.add(txtFieldEmail);

        
        JLabel lbTitle = new JLabel("Zvanje*");
        lbTitle.setToolTipText("Unesite svoje zvanje");
        lbTitle.setPreferredSize(cellDim);
        txtFieldTitle = new JTextField();
        txtFieldTitle.setToolTipText("Zvanje je niz karaktera");
        txtFieldTitle.setPreferredSize(cellDim);
        txtFieldTitle.setName("txtTitle");
        JPanel panelT = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelT.add(lbTitle);
        panelT.add(txtFieldTitle);
        

        JPanel CentralPanel = new JPanel();
        BoxLayout boxCenter = new BoxLayout(CentralPanel,BoxLayout.Y_AXIS);
        CentralPanel.setLayout(boxCenter);
        CentralPanel.add(Box.createVerticalGlue());
        CentralPanel.add(panelS);
        CentralPanel.add(panelN);
        CentralPanel.add(panelD);
        CentralPanel.add(panelA1);
        CentralPanel.add(panelA2);
        CentralPanel.add(panelA3);
        CentralPanel.add(panelA4);
        CentralPanel.add(panelNum);
        CentralPanel.add(panelE);
        CentralPanel.add(panelT);
        
        this.add(CentralPanel,BorderLayout.CENTER);

        //validation
        ProfessorListener val = new ProfessorListener(lbSurname,txtFieldSurName,this);
        txtFieldSurName.addFocusListener(val);
        validations.add(val);
        
        val = new ProfessorListener(lbName,txtFieldName,this);
        txtFieldName.addFocusListener(val);
        validations.add(val);
        
        val = new ProfessorListener(lbAdressStreet,txtAdressStreet,this);
        txtAdressStreet.addFocusListener(val);
        validations.add(val);
        
        val = new ProfessorListener(lbAdressNum,txtAdressNum ,this);
        txtAdressNum.addFocusListener(val);
        validations.add(val);
        
        val = new ProfessorListener(lbAdressCity,txtAdressCity,this);
        txtAdressCity.addFocusListener(val);
        validations.add(val);
        
        val = new ProfessorListener(lbAdressCountry,txtAdressCountry,this);
        txtAdressCountry.addFocusListener(val);
        validations.add(val);
        
        val = new ProfessorListener(lbEmail,txtFieldEmail,this);
        txtFieldEmail.addFocusListener(val);
        validations.add(val);
        
        val = new ProfessorListener(lbDate,txtFieldDate,this);
        txtFieldDate.addFocusListener(val);
        validations.add(val);
        
        val= new ProfessorListener(lbNum,txtFieldNUm);
        txtFieldNUm.addFocusListener(val);
        validations.add(val);
        
        val = new ProfessorListener(lbTitle,txtFieldTitle,this);
        txtFieldTitle.addFocusListener(val);
        validations.add(val);

        
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
                clearFields();
                instance=null;
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
                    
                    Adress adress= new Adress();
                    adress.setStreet(txtAdressStreet.getText());
                    adress.setNumber(txtAdressNum.getText());
                    adress.setCity(txtAdressCity.getText());
                    adress.setCountry(txtAdressCountry.getText());
                    
                    Professor.setName(txtFieldName.getText());
                    Professor.setSurname(txtFieldSurName.getText());               
                    Professor.setBirthday(birthday); 	                    
                    Professor.setContact(txtFieldNUm.getText());
                    Professor.setMail(txtFieldEmail.getText());
                    Professor.setTitle(txtFieldTitle.getText());
            
                    ProfessorController.getInstance().AddProfessor(Professor);
                    clearFields();
                    dispose();
                }
            }
        });


        diaButtonPanel.add(btAccept);
        diaButtonPanel.add(Box.createHorizontalStrut(20));
        this.add(diaButtonPanel,BorderLayout.SOUTH);

    }
    protected void validateOneByOne(){

    }
    private void clearFields() {
        txtFieldId.setText("");
    }

}
