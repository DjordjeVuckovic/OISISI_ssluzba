package controller.focuslisteners;

import controller.validation.CheckValidation;
import gui.view.dialog.add.AddSubject;
import gui.view.dialog.edit.EditSubject;

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
    private final int mode;
    private AddSubject addSubject = null;
    private EditSubject editSubject = null;
    private String idSub;
    public SubjectListener(JLabel lb, JTextField txt, AddSubject sub){
        label = lb;
        jTextField = txt;
        validation=false;
        this.addSubject = sub;
        mode =1;
    }
    public SubjectListener(JLabel lb, JTextField txt, EditSubject editSubject){
        label = lb;
        jTextField = txt;
        validation = true;
        this.editSubject = editSubject;
        mode = 2;
    }
    public SubjectListener(JLabel lb, JTextField txt, EditSubject editSubject,String idSub){
        label = lb;
        jTextField = txt;
        this.editSubject = editSubject;
        validation = true;
        this.idSub = idSub;
        mode = 2;
    }
    public String getIdSub(){
        return idSub;
    }
    public void setIdSub(String id){ idSub=id;}
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
            if(mode ==2){
                if(getLine().equals(getIdSub())){
                    validation = true;
                }
                else{
                    validation = CheckValidation.checkSubjectId(getLine());
                }
            }
            else{
                validation = CheckValidation.checkSubjectId(getLine());
            }
        }
        else if(getKey().equals("txtName")){
            validation = CheckValidation.checkSubjectName(getLine());
        }
        else if(getKey().equals("txtESPB")){
            validation = CheckValidation.checkESPB(getLine());
        }
        ValidateCell();
        if(mode ==1){
            addSubject.EnableButt();
        }
        if(mode==2){
           editSubject.EnableButt();
        }

    }
}
