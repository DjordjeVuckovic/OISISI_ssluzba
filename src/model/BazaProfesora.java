package model;

import java.util.ArrayList;
import java.util.List;

import model.Adress;
import model.Osoba;
import model.Subject;
import model.Professor;

public class BazaProfesora {
	private static BazaProfesora instance = null;
	
	public static BazaProfesora getInstance() {
		if(instance == null) {
			instance = new BazaProfesora();
		}
		return instance;
	}
	
	
	
	public static List<Professor> Professori = new ArrayList<Professor>();
	private List<String> kolone = new ArrayList<String>();
	
	private BazaProfesora() {
		
		this.kolone = new ArrayList<String>();
		this.kolone.add("Ime");
		this.kolone.add("Prezime");
		this.kolone.add("Zvanje");
		this.kolone.add("E-mail Adress");
		
	}

	public List<Professor> getProfessori() {
		return Professori;
	}

	public void setProfessori(List<Professor> Professori) {
		BazaProfesora.Professori = Professori;
	}

	public List<String> getKolone() {
		return kolone;
	}

	public void setKolone(List<String> kolone) {
		this.kolone = kolone;
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Professor getRow(int rowIndex) {
		return BazaProfesora.Professori.get(rowIndex);
	}
	
	public int getColumnCount() {
		return 4;
	}
	
	public String getValueAt(int row, int column) {
		Professor Professor = BazaProfesora.Professori.get(row);
		switch (column) {
		case 0:
			return Professor.getIme();
		case 1:
			return Professor.getPrezime();
		case 2:
			return Professor.getZvanje();
		case 3:
			return Professor.getEmail();
		default:
			return null;
		}
	}
	
	public void dodajProfessora(Osoba o, Adress AdressKancelarije, int brLicne, String zvanje,
							int godineStaza, ArrayList<Subject> predaje) {
		BazaProfesora.Professori.add(new Professor(o, AdressKancelarije, brLicne, zvanje, godineStaza, predaje));
	}
	
	public void izbrisiProfessora(int brLicne) {
		for (Professor p: Professori) {
			if(p.getBrLicne() == brLicne) {
				Professori.remove(p);
				break;
			}
		}
	}
	
	public void izmeniProfessora(Osoba o, Adress AdressKancelarije, int brLicne, String zvanje,
			int godineStaza, ArrayList<Subject> predaje) {
		for (Professor p: Professori) {
			if(p.getBrLicne() == brLicne) {
				p.setAdressKancelarije(AdressKancelarije);
				p.setAdresaStanovanja(o.getAdresaStanovanja());
				p.setDatumRodjenja(o.getDatumRodjenja());
				p.setGodineStaza(godineStaza);
				p.setIme(o.getIme());
				p.setPredaje(predaje);
				p.setPrezime(o.getPrezime());
				p.setTelefon(o.getTelefon());
				p.setZvanje(zvanje);
			}
		}
	}
		

}
