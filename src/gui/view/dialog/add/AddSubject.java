package gui.view.dialog.add;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ProfessorController;
import controller.SubjectController;
import controller.focuslisteners.SubjectListener;
import gui.view.MainWindow;
import gui.view.dialog.MyDialog;
import gui.view.dialog.edit.AddProfessorForSubject;
import model.Professor;
import model.Semester;
import model.Subject;
import model.YearofStudy;

public class AddSubject extends MyDialog {
    
    private static final long serialVersionUID = 3582140730556264549L;

    private JTextField txtIdS;
    private JTextField txtName;
    private JComboBox<String> txtFJComboBoxCurrentYear;
    private JComboBox<String> txtSemester;
    private JTextField txtPointsESPB;
    private JTextField txtProfesor;
    private JButton btAccept;
    
    private JButton btnDodajProf;
    private JButton btnUkloniProf;
    /*
    private static AddSubject instance = null;
    public static AddSubject getInstance(){
        if(instance==null){
            instance = new AddSubject();
        }
        return instance;
    }
    /*
     */
    private Professor profesor;
    
    public AddSubject() {
        super(MainWindow.getInstance(), "Dodavanje predmeta");
        initFields();

    }
    
    public void setEnableButtProf(boolean yes) {
		if(yes) {
			btnDodajProf.setEnabled(true);
			btnUkloniProf.setEnabled(false);
		}else {
			btnDodajProf.setEnabled(false);
			btnUkloniProf.setEnabled(true);
		}
	}
    
    public boolean allValid(){
        for(SubjectListener sb:validations){
            if(!sb.getValidation()){
                return false;
            }
        }
        return true;
    }
    public void EnableButt(){
        btAccept.setEnabled(allValid());
    }

    private ArrayList<SubjectListener> validations=new ArrayList<>();
    private void initFields(){
        Dimension cellDim = new Dimension(200, 20);

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

        
        JLabel lbProf = new JLabel("Profesor*");
        lbProf.setToolTipText("Samo jedan profesor");
        lbProf.setPreferredSize(new Dimension(135,20));
        txtProfesor = new JTextField();
        txtProfesor.setToolTipText("Samo jedan profesor");
        txtProfesor.setPreferredSize(cellDim);
        txtProfesor.setName("txtProfesor");
        txtProfesor.setEditable(false);  
        JPanel panelP = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelP.add(lbProf);
        panelP.add(txtProfesor);
     
		btnDodajProf = new JButton();
		btnDodajProf.setIcon(new ImageIcon("img/add-icon.png"));
		btnDodajProf.setPreferredSize(new Dimension(20,20));
		btnUkloniProf = new JButton();
		btnUkloniProf.setIcon(new ImageIcon("img/iconDelete.png"));
		btnUkloniProf.setPreferredSize(new Dimension(20,20));
		btnUkloniProf.setEnabled(false);
        
		btnDodajProf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				AddProfessorForSubject dodajProfPredmetu = new AddProfessorForSubject(parent);
				profesor = dodajProfPredmetu.getSelectedProf();
				if(profesor != null) {
					txtProfesor.setText(profesor.getName() + " " + profesor.getSurname());
					setEnableButtProf(false);
					allValid();
				}
			}
		});
		
		btnUkloniProf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String poruka = "Da li želite da uklonite predmetnog profesora?";
				Object[] opcije = {"Odustani","Potvrdi"};
				int option = JOptionPane.showOptionDialog(parent, poruka, "Ukloni Profesora", JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE, null, opcije, null);
				if(option == JOptionPane.NO_OPTION) {
					profesor = null; 
					setEnableButtProf(true);
					txtProfesor.setText("");
					allValid();
				}
			}
		});
        
		
        JPanel CentralPanel = new JPanel();
        BoxLayout boxCenter = new BoxLayout(CentralPanel,BoxLayout.Y_AXIS);
        CentralPanel.setLayout(boxCenter);
        CentralPanel.add(Box.createVerticalGlue());
        CentralPanel.add(panelA);
        CentralPanel.add(panelB);
        CentralPanel.add(panelC);
        CentralPanel.add(panelD);
        CentralPanel.add(panelE);
        CentralPanel.add(panelP);
        
        panelP.add(btnDodajProf);
        panelP.add(Box.createHorizontalStrut(6));
        panelP.add(btnUkloniProf);
        
        this.add(CentralPanel,BorderLayout.CENTER);
        //validation
        SubjectListener val1 = new SubjectListener(lbIds,txtIdS,this);
        txtIdS.addFocusListener(val1);
        validations.add(val1);

        SubjectListener val2 = new SubjectListener(lbESPB,txtPointsESPB,this);
        txtPointsESPB.addFocusListener(val2);
        validations.add(val2);

        SubjectListener val3 = new SubjectListener(lbName,txtName,this);
        txtName.addFocusListener(val3);
        validations.add(val3);
        //button
        JPanel diaButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        diaButtonPanel.setPreferredSize(new Dimension(60,60));
        btAccept = new JButton("Potvrdi");
        btAccept.setEnabled(false);
        btAccept.setMnemonic(KeyEvent.VK_S);
        btAccept.setForeground(Color.GREEN);
        JButton btDecline = new JButton("Odustani");
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
                if(profesor != null) {
                	sub.setProfessor(profesor);
                }
                SubjectController.getInstance().addSubject(sub);
                
				if(profesor != null) {
					ProfessorController.getInstance().AddSubjectForProfessor(profesor, sub);
				}
				
				dispose();
                
            }
        });
        diaButtonPanel.add(btAccept);
        diaButtonPanel.add(Box.createHorizontalStrut(20));
        this.add(diaButtonPanel,BorderLayout.SOUTH);
    }
}