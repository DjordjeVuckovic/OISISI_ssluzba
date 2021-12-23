package controller;

import gui.view.center.ProfessorsTable;
import model.BazaProfesora;
import model.Professor;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ProfessorController {
    private static  ProfessorController instance = null;
    public static ProfessorController getInstance(){
        if(instance==null){
            instance = new ProfessorController();
        }
        return instance;
    }
    private ProfessorController(){}
    public void addProfessor(Professor pr){
        BazaProfesora.getInstance().addProfessor(pr);
        ProfessorsTable.getInstance().refreshTable();
    }
    public void deleteProfessor(int row){
        if(row <0){
            return;
        }
        Professor Professor = BazaProfesora.getInstance().getProfessorByRow(row);
        BazaProfesora.getInstance().deleteProfessor(Professor);
        ProfessorsTable.getInstance().refreshTable();
    }

}
