package gui.view.dialog.edit.student;

import controller.validation.CheckValidation;
import model.Grade;
import model.Student;
import model.Subject;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GradeDialog extends JDialog  {
    private final JLabel lbDate;
    private final JTextField jTextFieldDate;
    private final JButton accButt;
    private boolean validation;
    private Grade grade;

    public GradeDialog(JDialog parent, Student student, Subject subject){
        super(parent,"Upis ocene",true);
        setSize(450,450);
        setLocationRelativeTo(parent);
        setResizable(false);
        setLayout(new BorderLayout());
        Dimension cellDim = new Dimension(200, 20);
        JLabel lbIds = new JLabel("Id*");
        lbIds.setPreferredSize(cellDim);
        JLabel lbName = new JLabel("Naziv*");
        lbName.setPreferredSize(cellDim);
        JLabel lbGrade = new JLabel("Ocena*");
        lbGrade.setPreferredSize(cellDim);
        lbDate = new JLabel("Datum*");
        lbDate.setPreferredSize(cellDim);

        JTextField jTextFieldId = new JTextField();
        jTextFieldId.setText("IdS");
        jTextFieldId.setText(subject.getIdS());
        jTextFieldId.setEditable(false);
        jTextFieldId.setPreferredSize(cellDim);
        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel1.add(lbIds);
        panel1.add(jTextFieldId);

        JTextField jTextFieldName = new JTextField();
        jTextFieldName.setName("NameSub");
        jTextFieldName.setText(subject.getNameSub());
        jTextFieldName.setEditable(false);
        jTextFieldName.setPreferredSize(cellDim);
        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel2.add(lbName);
        panel2.add(jTextFieldName);

        jTextFieldDate = new JTextField();
        jTextFieldDate.setName("Date");
        jTextFieldDate.setPreferredSize(cellDim);
        JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel4.add(lbDate);
        panel4.add(jTextFieldDate);

        jTextFieldDate.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                lbDate.setForeground(Color.BLACK);
                jTextFieldDate.setForeground(Color.BLACK);
                jTextFieldDate.setBorder(new LineBorder(Color.BLACK,1));
            }

            @Override
            public void focusLost(FocusEvent e) {
                validation = CheckValidation.checkDate(jTextFieldDate.getText());
                if(!validation) {
                    lbDate.setForeground(Color.RED);
                    jTextFieldDate.setForeground(Color.RED);
                    jTextFieldDate.setBorder(new LineBorder(Color.RED,1));
                }
                else {
                    jTextFieldDate.setBorder(new LineBorder(Color.GREEN));
                }
                if(validation){
                    enableButt();
                }
            }
        });


        String [] grades = {"6","7","8","9","10"};
        JComboBox<String> stringJComboBox = new JComboBox<>(grades);
        stringJComboBox.setPreferredSize(cellDim);
        JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel3.add(lbGrade);
        panel3.add(stringJComboBox);

        JPanel CentralPanel = new JPanel();
        BoxLayout boxCenter = new BoxLayout(CentralPanel,BoxLayout.Y_AXIS);
        CentralPanel.setLayout(boxCenter);
        CentralPanel.add(Box.createVerticalGlue());
        CentralPanel.add(panel1);
        CentralPanel.add(panel2);
        CentralPanel.add(panel3);
        CentralPanel.add(panel4);
        accButt = new JButton("Potvdi");
        accButt.setEnabled(false);
        accButt.addActionListener(e -> {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            dateFormat.setLenient(false);
            Date date = null;
            try {
                date = dateFormat.parse(jTextFieldDate.getText());
            } catch (ParseException exception) {
                exception.printStackTrace();
            }

            int gr=stringJComboBox.getSelectedIndex()+6;
            grade=new Grade(student,subject,gr,date);

            student.addGrade(grade);
            student.removeFailedExam(subject);
            dispose();
    });
        JButton canButt = new JButton("Odustani");
        canButt.addActionListener(e -> {
            dispose();
        });
        JPanel butPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
        butPane.add(accButt);
        butPane.add(canButt);
        CentralPanel.add(butPane);
        this.add(CentralPanel,BorderLayout.CENTER);

    }
   private void enableButt(){
        accButt.setEnabled(true);
   }
}
