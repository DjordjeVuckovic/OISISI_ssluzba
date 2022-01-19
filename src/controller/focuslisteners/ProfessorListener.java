package controller.focuslisteners;

import controller.validation.CheckValidation;
import gui.view.dialog.add.AddProfessor;
import gui.view.dialog.edit.profesor.EditProfessor;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class ProfessorListener implements FocusListener {
    Border defaultBorer = new LineBorder(Color.BLACK,1);
    Border correctBorder = new LineBorder(Color.GREEN,1);
    Border errorBorder = new LineBorder(Color.RED, 1);
    private JLabel label;
    private JTextField jTextField;
    private boolean validation;
    private AddProfessor addProfessor=null;
    private EditProfessor editProfessor=null;
    private String id=null;
    private int mode;

    public ProfessorListener(JLabel lb, JTextField txt){
        label=lb;
        jTextField=txt;
        validation=false;
        mode=0;
    }
    public ProfessorListener(JLabel lb,  JTextField txt, AddProfessor addProfessor) {
        label = lb;
        jTextField = txt;
        validation = false;
        this.addProfessor = addProfessor;
        mode = 1;

    }
    public ProfessorListener(JLabel lb,JTextField txt,EditProfessor editProfessor) {
    	label=lb;
        jTextField = txt;
    	validation = true;
    	this.editProfessor = editProfessor;
    	mode=2;
    }
    public ProfessorListener(JLabel lb,JTextField txt,EditProfessor editProfessor,String id) {
    	label=lb;
        jTextField = txt;
    	validation = true;
    	this.editProfessor = editProfessor;
    	this.id=id;
    	mode=2;
    }
    public void setIdNumber(String id){this.id= id; }
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
            else {
                jTextField.setBorder(correctBorder);
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
        	validation=CheckValidation.checkIdNumber(getLine());
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
            addProfessor.EnableButt();
        }else if(mode ==2){
            editProfessor.EnableButt();
        }

        }

}
