package gui.view.dialog.edit.student;

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

import controller.StudentController;
import controller.focuslisteners.StudentListener;
import model.Address;
import model.Status;
import model.Student;
import model.YearofStudy;

public class EditStudent extends JPanel{
	/**
	 * 
	 */
	@Serial
    private static final long serialVersionUID = 6674408014723983134L;
	
	private Student student;
	private JTextField txtFieldName;
	private JTextField txtFieldSurName;
	private JTextField txtFieldDate;
	private JTextField txtFieldNUm;
	private JTextField txtFieldE;
	private JTextField txtFieldId;
	private JTextField txtFieldAssignYear;
	private JComboBox<String> CBStatus;
	private JComboBox<String> txtFJComboBoxCurrentYear;
	

    private JButton btAccept;
    private JButton btDecline;
    private  Dimension cellDim;
    
    private JTextField txtAdressStreet;
    private JTextField txtAdressNum;
    private JTextField txtAdressCity;
    private JTextField txtAdressContry;
    
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
    

    private ArrayList<StudentListener> validations=new ArrayList<>();
	public EditStudent(Student student) {
		this.student=student;
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
        txtFieldNUm.setToolTipText("Tra\u017Eeni format(po\u017Eeljno): 0nn/nnn-nnn(niz) ili +MMMnn/nnn-nnn(niz)");
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

        JLabel lbId = new JLabel("Broj indeksa*");
        lbId.setToolTipText("Unesite svoj indeks");
        lbId.setPreferredSize(cellDim);
        txtFieldId = new JTextField();
        txtFieldId.setToolTipText("Trazeni format: smer/upis/godina");
        txtFieldId.setPreferredSize(cellDim);
        txtFieldId.setName("txtId");
        StudentListener valId=new StudentListener(lbId,txtFieldId,this,student.getIndex());
        txtFieldId.addFocusListener(valId);
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
        String[] currentYear = new String[]{"I", "II", "III", "IV"};
        txtFJComboBoxCurrentYear = new JComboBox<>(currentYear);
        txtFJComboBoxCurrentYear.setName("txtCurrentYear");
        txtFJComboBoxCurrentYear.setPreferredSize(cellDim);
        JPanel panelCY = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelCY.add(lbCurrentYear);
        panelCY.add(txtFJComboBoxCurrentYear);

        JLabel lbStatus = new JLabel("Način finansiranja*");
        lbStatus.setPreferredSize(cellDim);
        String[] status = new String[]{"Budzet","Samofinansiranje"};
        CBStatus = new JComboBox<>(status);
        CBStatus.setName("txtstatus");
        CBStatus.setPreferredSize(cellDim);
        JPanel panelSt = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelSt.add(lbStatus);
        panelSt.add(CBStatus);
        
        initFields();

        //validation
        StudentListener val= new StudentListener(lbName,txtFieldName,this);
        txtFieldName.addFocusListener(val);
        validations.add(val);
        
        val =new StudentListener(lbSurname,txtFieldSurName,this);
        txtFieldSurName.addFocusListener(val);
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
        
        validations.add(valId);
        val=new StudentListener(lbNum,txtFieldNUm,this);
        txtFieldNUm.addFocusListener(val);
        validations.add(val);
        val = new StudentListener(lbAdressStreet,txtAdressStreet,this);
        txtAdressStreet.addFocusListener(val);
        validations.add(val);
        val = new StudentListener(lbAdressNum,txtAdressNum,this);
        txtAdressNum.addFocusListener(val);
        validations.add(val);
        val = new StudentListener(lbAdressCity,txtAdressCity,this);
        txtAdressCity.addFocusListener(val);
        validations.add(val);
        val = new StudentListener(lbAdressContry,txtAdressContry,this);
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
        CentralPanel.add(panelCY);
        CentralPanel.add(panelSt);
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
                    Student studentNew = new Student();
                    studentNew.setName(txtFieldName.getText());
                    studentNew.setSurname(txtFieldSurName.getText());
                    studentNew.setBirthday(birthday);
                    studentNew.setContactPhone(txtFieldNUm.getText());
                    studentNew.setEmail(txtFieldE.getText());
                    studentNew.setIndex(txtFieldId.getText());
                    valId.setIndex(studentNew.getIndex());
                    studentNew.setEnrollYear(Integer.parseInt(txtFieldAssignYear.getText()) );
                    Address adress= new Address();
                    adress.setStreet(txtAdressStreet.getText());
                    adress.setNumber(txtAdressNum.getText());
                    adress.setCity(txtAdressCity.getText());
                    adress.setCountry(txtAdressContry.getText());

                    studentNew.setAddress(adress);

                    if(CBStatus.getSelectedIndex() == 0) {
                        studentNew.setFinansiranje(Status.BUDZET);
                    }else {
                        studentNew.setFinansiranje( Status.SAMOFINANSIRANJE );
                    }

                    if(txtFJComboBoxCurrentYear.getSelectedIndex()==0){
                        studentNew.setCurrentyear(YearofStudy.I);
                    } else if(txtFJComboBoxCurrentYear.getSelectedIndex()==1){
                        studentNew.setCurrentyear(YearofStudy.II);
                    }else if(txtFJComboBoxCurrentYear.getSelectedIndex()==2){
                        studentNew.setCurrentyear(YearofStudy.III);
                    }else if(txtFJComboBoxCurrentYear.getSelectedIndex()==3){
                        studentNew.setCurrentyear(YearofStudy.IV);
                    }

                    StudentController.getInstance().editStudent(student,studentNew);
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
		 txtFieldName.setText(student.getName());
		 txtFieldSurName.setText(student.getSurname());
		 DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		 txtFieldDate.setText(dateFormat.format(student.getBirthday()));
		 txtFieldNUm.setText(student.getContactPhone());
		 txtFieldE.setText(student.getEmail());
		 txtFieldId.setText(student.getIndex());
		 txtFieldAssignYear.setText(String.valueOf(student.getEnrollYear()));
		 if(student.getNacinFinansiranja() == Status.BUDZET) {
			 CBStatus.setSelectedIndex(0);
		 }
		 if(student.getNacinFinansiranja() == Status.SAMOFINANSIRANJE) {
			 CBStatus.setSelectedIndex(1);
			 }
		 if(student.getCurrentyear()== YearofStudy.I) {
		 txtFJComboBoxCurrentYear.setSelectedIndex(0);
		 }
		 if(student.getCurrentyear()== YearofStudy.II) {
			 txtFJComboBoxCurrentYear.setSelectedIndex(1);
			 }
		 if(student.getCurrentyear()== YearofStudy.III) {
			 txtFJComboBoxCurrentYear.setSelectedIndex(2);
			 }
		 if(student.getCurrentyear()== YearofStudy.IV) {
			 txtFJComboBoxCurrentYear.setSelectedIndex(3);
			 }
	    
	    txtAdressStreet.setText(student.getAddress().getStreet());
	    txtAdressNum.setText(student.getAddress().getNumber());
	    txtAdressCity.setText(student.getAddress().getCity());
	    txtAdressContry.setText(student.getAddress().getCountry());
	}
}
