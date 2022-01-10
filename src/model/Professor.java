package model;
import java.util.ArrayList;

public class Professor extends Osoba{

	private Adress AdressKancelarije;
	private int brLicne;
	private String zvanje;
	private int godineStaza;
	private ArrayList<Subject> predaje = new ArrayList<Subject>();
	
	public Professor(){ super();}

	public Professor(Osoba o, Adress AdressKancelarije, int brLicne, String zvanje, int godineStaza,
			ArrayList<Subject> predaje) {
		super(o);
		this.AdressKancelarije = AdressKancelarije;
		this.brLicne = brLicne;
		this.zvanje = zvanje;
		this.godineStaza = godineStaza;
		this.predaje = predaje;
	}

	public Adress getAdressKancelarije() {
		return AdressKancelarije;
	}

	public void setAdressKancelarije(Adress AdressKancelarije) {
		this.AdressKancelarije = AdressKancelarije;
	}

	public int getBrLicne() {
		return brLicne;
	}

	public void setBrLicne(int brLicne) {
		this.brLicne = brLicne;
	}

	public String getZvanje() {
		return zvanje;
	}

	public void setZvanje(String zvanje) {
		this.zvanje = zvanje;
	}

	public int getGodineStaza() {
		return godineStaza;
	}

	public void setGodineStaza(int godineStaza) {
		this.godineStaza = godineStaza;
	}

	public ArrayList<Subject> getPredaje() {
		return predaje;
	}

	public void setPredaje(ArrayList<Subject> predaje) {
		this.predaje = predaje;
	}
	
}
