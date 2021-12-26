package controller;

import gui.view.center.ProfessorsTable;
import model.Adress;
import model.BazaProfesora;

import model.Professor;
import java.util.Date;

public class ProfessorController {
    private static  ProfessorController instance = null;
    public static ProfessorController getInstance(){
        if(instance==null){
            instance = new ProfessorController();
        }
        return instance;
    }
    private ProfessorController(){}
    public void AddProfessor(Professor pr){
        BazaProfesora.getInstance().AddProfessor(pr);
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
    public void editProfessor(String ime, String prezime, Date datum, Adress adresa_stanovanja, String kontakt_telefon,String email_adresa, String id, int godine_staza, String titula) {
		BazaProfesora.getInstance().editProfessor(ime, prezime, datum, adresa_stanovanja, kontakt_telefon, email_adresa, id, godine_staza , titula);
		ProfessorsTable.getInstance().refreshTable();
	}

}
