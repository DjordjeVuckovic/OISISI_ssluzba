package model;

import java.util.Date;

public class Osoba {
	private String ime;
	private String prezime;
	private Date datumRodjenja;
	private Adress adresaStanovanja;
	private String telefon;
	private String email;
	
	public Osoba() {}

	public Osoba(String ime, String prezime, Date datumRodjenja, Adress adresaStanovanja, String telefon,
			String email) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodjenja = datumRodjenja;
		this.adresaStanovanja = adresaStanovanja;
		this.telefon = telefon;
		this.email = email;
	}

	public Osoba(Osoba o) {
		this.ime = o.getIme();
		this.prezime = o.getPrezime();
		this.datumRodjenja = o.getDatumRodjenja();
		this.adresaStanovanja = o.getAdresaStanovanja();
		this.telefon = o.getTelefon();
		this.email = o.getEmail();
	}
	
	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public Date getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public Adress getAdresaStanovanja() {
		return adresaStanovanja;
	}

	public void setAdresaStanovanja(Adress adresaStanovanja) {
		this.adresaStanovanja = adresaStanovanja;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
