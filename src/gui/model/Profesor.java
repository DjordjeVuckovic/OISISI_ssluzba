package gui.model;

import java.util.Date;

public class Profesor {
	
	// POLJA
	
			private String prezime;
			private String ime;
			private Date datum_rodjenja;
			private Adress adresa;
			private String kontakt_telefon;
			private String email;
			private String licna;
			private String zvanje;
			private String predmeti;
			private int godine_staza;

			
	//KONSTRUKTORI
			
			public Profesor() {}
			public Profesor(String prezime, String ime, Date datum_rodjenja, Adress adresa, String kontakt_telefon,
					String email, String index, String licna, String zvanje, String predmeti, int godine_staza) {
			super();
			this.prezime = prezime;
			this.ime = ime;
			this.datum_rodjenja = datum_rodjenja;
			this.adresa = adresa;
			this.kontakt_telefon = kontakt_telefon;
			this.email = email;
			this.licna = licna;
			this.zvanje = zvanje;
			this.predmeti = predmeti;
			this.godine_staza = godine_staza;
			}		
			
			
	//GET i SET metode
			
			public String getPrezime() {
				return prezime;
			}
			public void setPrezime(String prezime) {
				this.prezime = prezime;
			}

			public String getIme() {
				return ime;
			}
			public void setIme(String ime) {
				this.ime = ime;
			}
			
			public Date getDatumRodjenja() {
				return datum_rodjenja;
			}
			public void setDatumRodjenja(Date datum_rodjenja) {
				this.datum_rodjenja = datum_rodjenja;
			}
			
			public Adress getAdresa() {
				return adresa;
			}
			public void setAdresa(Adress adresa) {
				this.adresa = adresa;
				
			}
			public String getKontaktTelefon() {
				return kontakt_telefon;
			}
			public void setKontaktTelefon(String kontakt_telefon) {
				this.kontakt_telefon = kontakt_telefon;
			}
			
			public String getEmail() {
				return email;
			}
			public void setEmail(String email) {
				this.email = email;
			}
			
			public String getLicna() {
				return licna;
			}
			public void setLicna(String licna) {
				this.licna = licna;
			}
			
			public String getZvanje() {
				return zvanje;
			}
			public void setZvanje(String zvanje) {
				this.zvanje = zvanje;
			}
			
			public String getPredmeti() {
				return predmeti;
			}
			public void setPredmeti(String predmeti) {
				this.predmeti = predmeti;
			}
			
			public int getGodineStaza( ) {
				return godine_staza;
			}
			public void setGodineStaza(int godine_staza) {
				this.godine_staza = godine_staza;
			}
			
			//STRING
			@Override
			public String toString() {
				return "Profesor [ prezime=" + prezime + ", ime=" + ime + ", datum_rodjenja=" + datum_rodjenja + ", adresa="
						+ adresa + ", kontakt_telefon=" + kontakt_telefon + ", email=" + email + ", licna=" + licna
						+ ", zvanje=" + zvanje + ", godine_staza=" + godine_staza + ", predmeti="
						+ predmeti + "]";
			}
}
