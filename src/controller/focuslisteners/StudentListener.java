package controller.focuslisteners;

import controller.validation.CheckValidation;
import gui.view.dialog.AddStudent;
import gui.view.dialog.edit.EditStudent;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class StudentListener implements FocusListener {
    Border defaultBorer = new LineBorder(Color.BLACK,1);
    Border correctBorder = new LineBorder(Color.GREEN,1);
    Border errorBorder = new LineBorder(Color.RED, 1);
    private JLabel label;
    private JTextField jTextField;
    private boolean validation;
    private AddStudent addStudent=null;
    private EditStudent editStudent=null;
    private String index=null;
    private int mode;

    public StudentListener(JLabel lb, JTextField txt){
        label=lb;
        jTextField=txt;
        validation=false;
        mode=0;
    }
    public StudentListener(JLabel lb,  JTextField txt, AddStudent addStudent) {
        label = lb;
        jTextField = txt;
        validation = false;
        this.addStudent = addStudent;
        mode = 1;

    }
    public StudentListener(JLabel lb,JTextField txt,EditStudent editStudent) {
    	label=lb;
        jTextField = txt;
    	validation = true;
    	this.editStudent = editStudent;
    	mode=2;
    }
    public StudentListener(JLabel lb,JTextField txt,EditStudent editStudent,String index) {
    	label=lb;
        jTextField = txt;
    	validation = true;
    	this.editStudent = editStudent;
    	this.index=index;
    	mode=2;
    }
    public void setIndex(String index){this.index = index; }
    public boolean getValidation(){
        return validation;
    }
    public String getLine(){
        return jTextField.getText();
    }
    public String getKey(){
        return jTextField.getName();
    }
    public String getLabelText(){
        return label.getText();
    }
    public void ValidateCell(){
        if(!validation) {
            label.setForeground(Color.RED);
            jTextField.setForeground(Color.RED);
            jTextField.setBorder(errorBorder);
        }
            else if(validation) {
                jTextField.setBorder(correctBorder);
            }
            else {
            jTextField.setBorder(defaultBorer);
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        label.setForeground(Color.BLACK);
        jTextField.setForeground(Color.BLACK);
        jTextField.setBorder(defaultBorer);
    }

    @Override
    public void focusLost(FocusEvent e) {
        if(getKey().equals("txtName") || getKey().equals("txtSurname")){
            validation= CheckValidation.checkName(getLine());
            }
        else if(getKey().equals("txtDate")){
            validation=CheckValidation.checkDate(getLine());
        }
        /*
        else if(getKey().equals("txtAdress")){
            validation=CheckValidation.checkAdress(getLine());
        }
        */
        else if(getKey().equals("txtNum")){
            validation=CheckValidation.checkPhone(getLine());
        }
        else if(getKey().equals("txtEmail")){
            validation=CheckValidation.checkEmail(getLine());
        }
        else  if(getKey().equals("txtId")){
        	if(mode==2) {
        		if(getKey().equals(index)) {
        			validation=true;
        		}
        		else {
        		validation=CheckValidation.checkIndex(getLine());
        			}
        	}
        	else {
            validation=CheckValidation.checkIndex(getLine());
        	}
        }
        else if(getKey().equals("txtAssignYear")){
            validation=CheckValidation.checkAssignYear(getLine());
        }
        else if(getKey().equals("txtStreet")) {
        	validation=CheckValidation.checkStreet(getLine());
        }
        else if(getKey().equals("txtStnum")) {
        	validation=CheckValidation.checkStreetNum(getLine());
        }
		else if(getKey().equals("txtCity")) {
			validation=CheckValidation.checkName(getLine());  	
		}
		else if(getKey().equals("txtContry")) {
			validation=CheckValidation.checkName(getLine());	
        }
        ValidateCell();
        if(mode==1){
            addStudent.EnableButt();
        }else if(mode ==2){
            editStudent.EnableButt();
        }

        }

}
