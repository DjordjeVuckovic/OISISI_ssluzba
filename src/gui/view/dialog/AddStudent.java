package gui.view.dialog;

import gui.view.CentralBox;
import gui.view.MainWindow;
import model.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AddStudent  extends Dialog{

    private JButton btAccept;
    private JButton btDecline;
    Dimension cellDim;

    private static AddStudent instance = null;


    public static AddStudent getInstance() {
        if(instance==null) instance = new AddStudent();
        return instance;
    }


    private AddStudent() {
        super(MainWindow.getInstance(),"Dodavanje studenta");


        setLayout(new BorderLayout());
        cellDim = new Dimension(200, 20);

        JLabel lbName = new JLabel("Ime*");
        lbName.setToolTipText("Unesite svoje ime");
        lbName.setPreferredSize(cellDim);
        JTextField txtFieldName = new JTextField();
        txtFieldName.setToolTipText("Ime je niz karaktera");
        txtFieldName.setPreferredSize(cellDim);
        txtFieldName.setName("txtName");
        JPanel panelN = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelN.add(lbName);
        panelN.add(txtFieldName);

        JLabel lbSurname = new JLabel("Prezime*");
        lbSurname.setToolTipText("Unesite svoje prezime");
        lbSurname.setPreferredSize(cellDim);
        JTextField txtFieldSurName = new JTextField();
        txtFieldSurName.setToolTipText("Prezime je niz karaktera");
        txtFieldSurName.setPreferredSize(cellDim);
        txtFieldSurName.setName("txtSurname");
        JPanel panelS = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelS.add(lbSurname);
        panelS.add(txtFieldSurName);

        JLabel lbDate = new JLabel("Date*");
        lbDate.setToolTipText("Unesite datum rodjenja");
        lbDate.setPreferredSize(cellDim);
        JTextField txtFieldDate = new JTextField();
        txtFieldDate.setToolTipText("Trazeni format:");
        txtFieldDate.setPreferredSize(cellDim);
        txtFieldDate.setName("txtDate");
        JPanel panelD = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelD.add(lbDate);
        panelD.add(txtFieldDate);

        JLabel lbAdress = new JLabel("Adresa stanovanja*");
        lbAdress.setToolTipText("Unesite svoju adresu");
        lbAdress.setPreferredSize(cellDim);
        JTextField txtFieldAdress = new JTextField();
        txtFieldAdress.setToolTipText("Unesite svoju tacnu adresu");
        txtFieldAdress.setPreferredSize(cellDim);
        txtFieldAdress.setName("txtAdress");
        JPanel panelA = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelA.add(lbAdress);
        panelA.add(txtFieldAdress);

        JLabel lbNum = new JLabel("Broj telefona*");
        lbNum.setToolTipText("Unesite svoj broj telefona");
        lbNum.setPreferredSize(cellDim);
        JTextField txtFieldNUm = new JTextField();
        txtFieldNUm.setToolTipText("Broj telefona mora da ima najmanje 3 cifre");
        txtFieldNUm.setPreferredSize(cellDim);
        txtFieldNUm.setName("txtNum");
        JPanel panelNum = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelNum.add(lbNum);
        panelNum.add(txtFieldNUm);

        JLabel lbEmail = new JLabel("E-mail adresa*");
        lbEmail.setToolTipText("Unesite svoj E-mail");
        lbEmail.setPreferredSize(cellDim);
        JTextField txtFieldE = new JTextField();
        txtFieldE.setToolTipText("Trazeni format:");
        txtFieldE.setPreferredSize(cellDim);
        txtFieldE.setName("txtEmail");
        JPanel panelE = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelE.add(lbEmail);
        panelE.add(txtFieldE);

        JLabel lbId = new JLabel("Broj indeksa*");
        lbId.setToolTipText("Unesite svoj indeks");
        lbId.setPreferredSize(cellDim);
        JTextField txtFieldId = new JTextField();
        txtFieldId.setToolTipText("Trazeni format:");
        txtFieldId.setPreferredSize(cellDim);
        txtFieldId.setName("txtId");
        JPanel panelID = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelID.add(lbId);
        panelID.add(txtFieldId);

        JLabel lbAssignYear = new JLabel("Godina Upisa*");
        lbAssignYear.setToolTipText("Unesite godinu svog upisa");
        lbAssignYear.setPreferredSize(cellDim);
        JTextField txtFieldAssignYear = new JTextField();
        txtFieldAssignYear.setToolTipText("Trazeni format:");
        txtFieldAssignYear.setPreferredSize(cellDim);
        txtFieldAssignYear.setName("txtAssignYear");
        JPanel panelY = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelY.add(lbAssignYear);
        panelY.add(txtFieldAssignYear);

        JLabel lbCurrentYear = new JLabel("Trenutna godina studija*");
        lbCurrentYear.setPreferredSize(cellDim);
        String[] CurrentYear = {"I", "II", "III", "IV"};
        JComboBox<String> txtFJComboBoxCurrentYear = new JComboBox<>(CurrentYear);
        txtFJComboBoxCurrentYear.setName("txtCurrentYear");
        txtFJComboBoxCurrentYear.setPreferredSize(cellDim);
        JPanel panelCY = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelCY.add(lbCurrentYear);
        panelCY.add(txtFJComboBoxCurrentYear);

        JLabel lbStatus = new JLabel("Način finansiranja*");
        lbStatus.setPreferredSize(cellDim);
        String[] status = {"Budzet","Samofinansiranje"};
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
        //
        JPanel diaButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        diaButtonPanel.setPreferredSize(new Dimension(60,60));
        btAccept = new JButton("Potvrdi");
        btAccept.setEnabled(false);
        btDecline = new JButton("Odustani");
        diaButtonPanel.add(btAccept);
        diaButtonPanel.add(Box.createHorizontalStrut(20));
        diaButtonPanel.add(btDecline);
        this.add(diaButtonPanel,BorderLayout.SOUTH);

    }







}
