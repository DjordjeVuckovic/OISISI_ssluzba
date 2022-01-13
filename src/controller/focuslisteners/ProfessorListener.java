package controller.focuslisteners;

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
    public ProfessorListener(JLabel lb, JTextField txt){
        label=lb;
        jTextField=txt;
        validation=false;
    }
    public ProfessorListener(JLabel lb,  JTextField txt, AddProfessor addProfessor) {
        label = lb;
        jTextField = txt;
        validation = false;

    }
    public ProfessorListener(JLabel lb,JTextField txt,EditProfessor editProfessor) {
    	label=lb;
        jTextField = txt;
    	validation = true;
    }
    public ProfessorListener(JLabel lb,JTextField txt,EditProfessor editProfessor,String index) {
    	label=lb;
        jTextField = txt;
    	validation = true;
    }
    public void setIndex(String index){ }
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
		// TODO Auto-generated method stub
		
	}

}
