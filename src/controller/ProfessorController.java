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
    public void addProfessor(Professor st){
        BazaProfesora.getInstance().addProfessor(st);
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
    public Professor getProfessorByIndex(String index){
        Professor Professor = BazaProfesora.getInstance().getProfessorById(index);
        return Professor;
    }
    public void editProfessor(Professor Professor,Professor prof){
        Professor.setName(prof.getName());
        Professor.setSurname(prof.getSurname());
        Professor.setContact(prof.getContact());
        Professor.setMail(prof.getMail());
        Professor.setIdNumber(prof.getIdNumber());
        Professor.setAddressK(prof.getAdresaKanc().getStreet(),prof.getAdresaKanc().getNumber(),prof.getAdresaKanc().getCity(),prof.getAdresaKanc().getCountry());
        Professor.setAddressS(prof.getAdresaStan().getStreet(),prof.getAdresaStan().getNumber(),prof.getAdresaStan().getCity(),prof.getAdresaStan().getCountry());
        ProfessorsTable.getInstance().refreshTable();
    }

}
