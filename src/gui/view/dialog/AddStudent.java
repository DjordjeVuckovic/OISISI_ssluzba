package gui.view.dialog;

import controller.keyfocuslisteners.StudentListener;
import gui.view.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddStudent  extends Dialog{

    private JTextField txtFieldName;
    private JTextField txtFieldSurName;
    private JTextField txtFieldDate;
    private JTextField txtFieldAdress;
    private JTextField txtFieldNUm;
    private JTextField txtFieldE;
    private JTextField txtFieldId;
    private JTextField txtFieldAssignYear;
    private String[] currentYear;
    private String[] status;
    private JButton btAccept;
    private JButton btDecline;
    private  Dimension cellDim;

    private static AddStudent instance = null;

    public static AddStudent getInstance() {
        if(instance==null) instance = new AddStudent();
        return instance;
    }
    public boolean allValid(){
        for(StudentListener sl:validations){
            if(!sl.getValidation()){
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

    private AddStudent() {
        super(MainWindow.getInstance(),"Dodavanje studenta");
        setLayout(new BorderLayout());
        initStudentDialog();
    }

    private ArrayList<StudentListener> validations=new ArrayList<>();
    private void initStudentDialog(){
        cellDim = new Dimension(200, 20);

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
        txtFieldDate.setToolTipText("Trazeni format:");
        txtFieldDate.setPreferredSize(cellDim);
        txtFieldDate.setName("txtDate");
        JPanel panelD = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelD.add(lbDate);
        panelD.add(txtFieldDate);

        JLabel lbAdress = new JLabel("Adresa stanovanja*");
        lbAdress.setToolTipText("Unesite svoju adresu");
        lbAdress.setPreferredSize(cellDim);
        txtFieldAdress = new JTextField();
        txtFieldAdress.setToolTipText("Unesite svoju tacnu adresu");
        txtFieldAdress.setPreferredSize(cellDim);
        txtFieldAdress.setName("txtAdress");
        JPanel panelA = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelA.add(lbAdress);
        panelA.add(txtFieldAdress);

        JLabel lbNum = new JLabel("Broj telefona*");
        lbNum.setToolTipText("Unesite svoj broj telefona");
        lbNum.setPreferredSize(cellDim);
        txtFieldNUm = new JTextField();
        txtFieldNUm.setToolTipText("Broj telefona mora da ima najmanje 3 cifre");
        txtFieldNUm.setPreferredSize(cellDim);
        txtFieldNUm.setName("txtNum");
        JPanel panelNum = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelNum.add(lbNum);
        panelNum.add(txtFieldNUm);

        JLabel lbEmail = new JLabel("E-mail adresa*");
        lbEmail.setToolTipText("Unesite svoj E-mail");
        lbEmail.setPreferredSize(cellDim);
        txtFieldE = new JTextField();
        txtFieldE.setToolTipText("Trazeni format:");
        txtFieldE.setPreferredSize(cellDim);
        txtFieldE.setName("txtEmail");
        JPanel panelE = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelE.add(lbEmail);
        panelE.add(txtFieldE);

        JLabel lbId = new JLabel("Broj indeksa*");
        lbId.setToolTipText("Unesite svoj indeks");
        lbId.setPreferredSize(cellDim);
        txtFieldId = new JTextField();
        txtFieldId.setToolTipText("Trazeni format:");
        txtFieldId.setPreferredSize(cellDim);
        txtFieldId.setName("txtId");
        JPanel panelID = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelID.add(lbId);
        panelID.add(txtFieldId);

        JLabel lbAssignYear = new JLabel("Godina Upisa*");
        lbAssignYear.setToolTipText("Unesite godinu svog upisa");
        lbAssignYear.setPreferredSize(cellDim);
        txtFieldAssignYear = new JTextField();
        txtFieldAssignYear.setToolTipText("Trazeni format:");
        txtFieldAssignYear.setPreferredSize(cellDim);
        txtFieldAssignYear.setName("txtAssignYear");
        JPanel panelY = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelY.add(lbAssignYear);
        panelY.add(txtFieldAssignYear);

        JLabel lbCurrentYear = new JLabel("Trenutna godina studija*");
        lbCurrentYear.setPreferredSize(cellDim);
        currentYear = new String[]{"I", "II", "III", "IV"};
        JComboBox<String> txtFJComboBoxCurrentYear = new JComboBox<>(currentYear);
        txtFJComboBoxCurrentYear.setName("txtCurrentYear");
        txtFJComboBoxCurrentYear.setPreferredSize(cellDim);
        JPanel panelCY = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelCY.add(lbCurrentYear);
        panelCY.add(txtFJComboBoxCurrentYear);

        JLabel lbStatus = new JLabel("Način finansiranja*");
        lbStatus.setPreferredSize(cellDim);
        status = new String[]{"Budzet","Samofinansiranje"};
        JComboBox<String> CBStatus = new JComboBox<>(status);
        CBStatus.setName("txttatus");
        CBStatus.setPreferredSize(cellDim);
        JPanel panelSt = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelSt.add(lbStatus);
        panelSt.add(CBStatus);


        JPanel CentralPanel = new JPanel();
        BoxLayout boxCenter = new BoxLayout(CentralPanel,BoxLayout.Y_AXIS);
        CentralPanel.setLayout(boxCenter);
        CentralPanel.add(Box.createVerticalGlue());
        CentralPanel.add(panelN);
        CentralPanel.add(panelS);
        CentralPanel.add(panelD);
        CentralPanel.add(panelA);
        CentralPanel.add(panelNum);
        CentralPanel.add(panelE);
        CentralPanel.add(panelID);
        CentralPanel.add(panelY);
        CentralPanel.add(panelCY);
        CentralPanel.add(panelSt);
        this.add(CentralPanel,BorderLayout.CENTER);
        //validation
        StudentListener val= new StudentListener(lbName,txtFieldName,this);
        txtFieldName.addFocusListener(val);
        validations.add(val);
        val =new StudentListener(lbSurname,txtFieldSurName,this);
        txtFieldSurName.addFocusListener(val);
        validations.add(val);
        val= new StudentListener(lbAdress,txtFieldAdress,this);
        txtFieldAdress.addFocusListener(val);
        validations.add(val);
        val=new StudentListener(lbAssignYear,txtFieldAssignYear,this);
        txtFieldAssignYear.addFocusListener(val);
        validations.add(val);
        val=new StudentListener(lbEmail,txtFieldE,this);
        txtFieldE.addFocusListener(val);
        validations.add(val);
        val=new StudentListener(lbDate,txtFieldDate,this);
        txtFieldDate.addFocusListener(val);
        validations.add(val);
        val=new StudentListener(lbId,txtFieldId,this);
        txtFieldId.addFocusListener(val);
        validations.add(val);
        val=new StudentListener(lbNum,txtFieldNUm);
        txtFieldNUm.addFocusListener(val);
        validations.add(val);



        JPanel diaButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        diaButtonPanel.setPreferredSize(new Dimension(60,60));
        btAccept = new JButton("Potvrdi");
        btAccept.setEnabled(false);
        btDecline = new JButton("Odustani");
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
                    System.out.println("Sva validna");
                }
            }
        });




        diaButtonPanel.add(btAccept);
        diaButtonPanel.add(Box.createHorizontalStrut(20));
        this.add(diaButtonPanel,BorderLayout.SOUTH);

    }








}
