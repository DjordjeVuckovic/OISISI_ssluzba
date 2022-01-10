package model;
import java.util.ArrayList;

public class Katedra {

	private String sifra;
	private String naziv;
	private Professor sef;
	private ArrayList<Professor> profesori = new ArrayList<Professor>();
	
	public Katedra() {}

	public Katedra(String sifra, String naziv, Professor sef, ArrayList<Professor> profesori) {
		super();
		this.sifra = sifra;
		this.naziv = naziv;
		this.sef = sef;
		this.profesori = profesori;
	}

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Professor getSef() {
		return sef;
	}

	public void setSef(Professor sef) {
		this.sef = sef;
	}

	public ArrayList<Professor> getProfesori() {
		return profesori;
	}

	public void setProfesori(ArrayList<Professor> profesori) {
		this.profesori = profesori;
	}
	
	
}
