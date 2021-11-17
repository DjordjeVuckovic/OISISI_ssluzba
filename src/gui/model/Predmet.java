package gui.model;

enum Semestar {LETNJI, ZIMSKI}

public class Predmet {
	// POLJA
	
				private String sifra;
				private String naziv_predmeta;
				private Semestar semestar;
				private int godina_studija;
				private String profesor;
				private int broj_bodova;
				private String polozeni;
				private String nepolozeni;
				
				
	//KONSTRUKTORI
				
				public Predmet() {}
				public Predmet(String sifra, String naziv_predmeta, Semestar semestar, int godina_studija, String profesor, int broj_bodova, String polozeni, String nepolozeni) {
				super();
				this.sifra = sifra;
				this.naziv_predmeta = naziv_predmeta;
				this.semestar = semestar;
				this.godina_studija = godina_studija;
				this.profesor = profesor;
				this.broj_bodova = broj_bodova;
				this.polozeni = polozeni;
				this.nepolozeni = nepolozeni;
				}
				
				
	//Geteri seteri
				
				public String getSifra() {
					return sifra;
				}
				public void setSifra(String sifra) {
					this.sifra = sifra;
				}
				
				public String getNaziv () {
					return naziv_predmeta;
				}
				public void setNaziv (String naziv_predmeta) {
					this.naziv_predmeta = naziv_predmeta;
				}
				
				public Semestar getSemestar() {
					return semestar;
				}
				public void setSemestar (Semestar semestar) {
					this.semestar = semestar;
				}
				
				public int getGodina () {
					return godina_studija;
				}
				public void setGodina (int godina_studija) { 
					this.godina_studija = godina_studija;
				}
				
				public String getProfesor () {
					return profesor;
				}
				public void setProfesor (String profesor) { 
					this.profesor = profesor;
				}
				
				public int getBodovi () {
					return broj_bodova;
				}
				public void setBodovi (int broj_bodova) { 
					this.broj_bodova = broj_bodova;
				}
				
				public String getPolozeni() {
					return polozeni;
				}
				public void setPolozeni (String polozeni) { 
					this.polozeni = polozeni;
				}
				
				public String getNepolozeni() {
					return nepolozeni;
				}
				public void setNepolozeni (String nepolozeni) {
					this.nepolozeni = nepolozeni;
				}
				
				
	//STRING
				@Override
				public String toString() {
					return "Predmet [sifra=" + sifra + ", naziv=" + naziv_predmeta + ", semestar=" + semestar + ", godina_studija="
							+ godina_studija + ", profesor=" + profesor + ", broj_bodova=" + broj_bodova + ", polozeni=" + polozeni
							+ ", nepolozeni=" + nepolozeni + "]";
				}
}
