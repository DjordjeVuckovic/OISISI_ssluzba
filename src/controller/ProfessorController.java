package controller;

import java.util.ArrayList;

import model.Adress;
import model.Osoba;
import model.Subject;
import model.Professor;
import model.BazaProfesora;

public class ProfessorController {
	private static ProfessorController instance = null;
	
	public static ProfessorController getInstance() {
		if(instance == null) {
			instance = new ProfessorController();
		}
		return instance;
	}
	
	private ProfessorController() {}
	
	public void dodajProfessora(Osoba o, Adress AdressKancelarije, int brLicne, String zvanje,
							int godineStaza, ArrayList<Subject> predaje) {
		// izmena modela
		BazaProfesora.getInstance().dodajProfessora(o, AdressKancelarije, brLicne, zvanje, godineStaza, predaje);
		
		// azuriranje prikaza
		Frame.getInstance().azurirajPrikaz("DODAT", -1, "Professori");
	}
	
	public void izbrisiProfessora(int rowSelectedIndex) {
		if(rowSelectedIndex < 0) 
			return;
		
		// izmena modela
		Professor Professor = BazaProfesora.getInstance().getRow(rowSelectedIndex);
		BazaProfesora.getInstance().izbrisiProfessora(Professor.getBrLicne());
		// azuriranje prikaza
		Frame.getInstance().azurirajPrikaz("UKLONJEN", rowSelectedIndex, "Professori");
		
	}
	
	// izmena Professora
	public Professor uzmiProfessora(int rowSelectedIndex) {
		return BazaProfesora.getInstance().getRow(rowSelectedIndex);
	}
	    //uraditi izmenu Professora
	public void izmeniProfessora(Osoba o, Adress AdressKancelarije, int brLicne, String zvanje,
			int godineStaza, ArrayList<Subject> predaje) {

		BazaProfesora.getInstance().izmeniProfessora(o, AdressKancelarije, brLicne, zvanje, godineStaza, predaje);
		
		// azuriranje prikaza
		Frame.getInstance().azurirajPrikaz("AZURIRAN", -1, "Professori");
		}	
	
}
