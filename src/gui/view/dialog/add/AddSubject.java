package gui.view.dialog.add;

import controller.SubjectController;
import gui.view.MainWindow;
import gui.view.dialog.MyDialog;
import model.Semester;
import model.Subject;
import model.YearofStudy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class AddSubject extends MyDialog {

    private JTextField txtIdS;
    private JTextField txtName;
    private JComboBox<String> txtFJComboBoxCurrentYear;
    private JComboBox<String> txtSemester;
    private JTextField txtPointsESPB;
    private JTextField txtProfessor;
    private JButton btAccept;
    private JButton btDecline;
    private  Dimension cellDim;
    private static AddSubject instance = null;
    public static AddSubject getInstance(){
        if(instance==null){
            instance = new AddSubject();
        }
        return instance;
    }

    private AddSubject() {
        super(MainWindow.getInstance(), "Dodavanje predmeta");
        initFields();

    }
    private void initFields(){
        cellDim = new Dimension(200,20);

        setLayout(new BorderLayout());
        JLabel lbIds = new JLabel("Sifra*");
        lbIds.setToolTipText("Unesite jedinstvenu sifru predmeta");
        lbIds.setPreferredSize(cellDim);
        txtIdS = new JTextField();
        txtIdS.setToolTipText("Unesite jedinstvenu sifru predmeta");
        txtIdS.setPreferredSize(cellDim);
        txtIdS.setName("txtId");
        JPanel panelA = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelA.add(lbIds);
        panelA.add(txtIdS);


        JLabel lbName = new JLabel("Naziv*");
        lbName.setToolTipText("Unesite naziv predmeta");
        lbName.setPreferredSize(cellDim);
        txtName = new JTextField();
        txtName.setToolTipText("Unesite naziv predmeta");
        txtName.setPreferredSize(cellDim);
        txtName.setName("txtName");
        JPanel panelB = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelB.add(lbName);
        panelB.add(txtName);


        JLabel lbESPB = new JLabel("ESPB*");
        lbESPB.setToolTipText("Unesite broj ESPB bodova");
        lbESPB.setPreferredSize(cellDim);
        txtPointsESPB = new JTextField();
        txtPointsESPB.setToolTipText("Unesite broj ESPB bodova");
        txtPointsESPB.setPreferredSize(cellDim);
        txtPointsESPB.setName("txtESPB");
        JPanel panelC = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelC.add(lbESPB);
        panelC.add(txtPointsESPB);

        JLabel lbCurrentYear = new JLabel("Godina izvodjenja predmeta*");
        lbCurrentYear.setPreferredSize(cellDim);
        String []currentYear = new String[]{"I", "II", "III", "IV"};
        txtFJComboBoxCurrentYear = new JComboBox<>(currentYear);
        txtFJComboBoxCurrentYear.setName("txtCurrentYear");
        txtFJComboBoxCurrentYear.setPreferredSize(cellDim);
        JPanel panelD= new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelD.add(lbCurrentYear);
        panelD.add(txtFJComboBoxCurrentYear);

        JLabel lbSem = new JLabel("Semestar*");
        lbSem.setPreferredSize(cellDim);
        String []sem = new String[]{"SUMMER", "WINTER"};
        txtSemester = new JComboBox<>(sem);
        txtSemester.setName("txtCurrentYear");
        txtSemester.setPreferredSize(cellDim);
        JPanel panelE = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelE.add(lbSem);
        panelE.add(txtSemester);

        JPanel CentralPanel = new JPanel();
        BoxLayout boxCenter = new BoxLayout(CentralPanel,BoxLayout.Y_AXIS);
        CentralPanel.setLayout(boxCenter);
        CentralPanel.add(Box.createVerticalGlue());
        CentralPanel.add(panelA);
        CentralPanel.add(panelB);
        CentralPanel.add(panelC);
        CentralPanel.add(panelD);
        CentralPanel.add(panelE);
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
                dispose();
            }
        });

        diaButtonPanel.add(btDecline);
        btAccept.setEnabled(true);
        btAccept.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Subject sub = new Subject();
                sub.setIdS(txtIdS.getText());
                sub.setNameSub(txtName.getText());
                sub.setESPBpoints(Integer.parseInt(txtPointsESPB.getText()));
                if(txtFJComboBoxCurrentYear.getSelectedIndex()==0){
                    sub.setYearOfStudy(YearofStudy.I);
                }
                else if(txtFJComboBoxCurrentYear.getSelectedIndex()==1){
                    sub.setYearOfStudy(YearofStudy.II);
                }
                else if(txtFJComboBoxCurrentYear.getSelectedIndex()==2){
                    sub.setYearOfStudy(YearofStudy.III);
                }
                else if(txtFJComboBoxCurrentYear.getSelectedIndex()==3){
                    sub.setYearOfStudy(YearofStudy.IV);
                }
                if(txtSemester.getSelectedIndex()==0){
                    sub.setSemester(Semester.SUMMER);
                }
                else{
                    sub.setSemester(Semester.WINTER);
                }
                dispose();
                SubjectController.getInstance().addSubject(sub);
            }
        });
        diaButtonPanel.add(btAccept);
        diaButtonPanel.add(Box.createHorizontalStrut(20));
        this.add(diaButtonPanel,BorderLayout.SOUTH);
    }
}
