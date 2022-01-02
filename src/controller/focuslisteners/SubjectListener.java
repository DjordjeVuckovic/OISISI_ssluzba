package controller.focuslisteners;

import controller.validation.CheckValidation;
import gui.view.dialog.add.AddSubject;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class SubjectListener implements FocusListener {
    Border defaultBorer = new LineBorder(Color.BLACK,1);
    Border correctBorder = new LineBorder(Color.GREEN,1);
    Border errorBorder = new LineBorder(Color.RED, 1);
    private JLabel label;
    private JTextField jTextField;
    private boolean validation;
    private int mode;
    private AddSubject subject = null;
    public SubjectListener(JLabel lb, JTextField txt, AddSubject sub){
        label = lb;
        jTextField = txt;
        subject = sub;
        mode =1;
    }
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
        if(getKey().equals("txtId")){
            validation = CheckValidation.checkSubjectId(getLine());
        }
        else if(getKey().equals("txtName")){
            validation = CheckValidation.checkSubjectName(getLine());
        }
        else if(getKey().equals("txtESPB")){
            validation = CheckValidation.checkESPB(getLine());
        }
        ValidateCell();
        if(mode ==1){
        AddSubject.getInstance().EnableButt();
        }

    }
}
