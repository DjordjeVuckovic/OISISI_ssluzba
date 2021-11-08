package gui.model;

import java.util.Date;


public class Student {
	// POLJA
		private String ime;
		private String prezime;
		private Date datum_rodjenja;
		private String adresa;
		private String kontakt_telefon;
		private String email;
		private String index;
		
		private int godina_upisa;
		private int tren_god_studiranja;
		
		private double pr_ocena;
		
		private Nacin_Finansiranja n_finansiranja;
		// 
	//KONSTRUKTORI
		public Student() {}
		public Student(String ime,String prezime,Date datum_rodjenja,String adresa,String kontakt_telefon,
				String email,String index,int godina_upisa,int tren_god_studiranja,double pr_ocena,Nacin_Finansiranja n_finansiranja) {
			super();
			this.ime=ime;
			this.prezime=prezime;
			this.datum_rodjenja= datum_rodjenja;
			this.adresa= adresa;
			this.kontakt_telefon=kontakt_telefon;
			this.email=email;
			this.index=index;
			this.godina_upisa=godina_upisa;
			this.tren_god_studiranja=tren_god_studiranja;
			this.pr_ocena=pr_ocena;
			this.n_finansiranja=n_finansiranja;
		}
		//GET i SET metode
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
			return datum_rodjenja;
		}
		public void setDatumRodjenja(Date datum_rodjenja) {

			this.datum_rodjenja = datum_rodjenja;
		}
		public String getAdresa() {
			return adresa;
		}
		public void setAdresa(String adresa) {
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
		public String getIndex() {
			return index;
		}
		public void setIndex(String indeks) {
			this.index = indeks;
		}
		public int getGodinaUpisa() {
			return godina_upisa;
		}
		public void setGodinaUpisa(int godina_upisa) {
			this.godina_upisa = godina_upisa;
		}
		public int getTrenGodStudija() {
			return tren_god_studiranja;
		}
		public void setTrenGodStudija(int trenGodStudija) {
			this.tren_god_studiranja = trenGodStudija;
		}
		public double getProsecnaOcena() {
			return pr_ocena;
		}
		public void setProsecnaOcena(double pr_ocena) {
			this.pr_ocena = pr_ocena;
		}
		public Nacin_Finansiranja getNacinFinansiranja() {
			return n_finansiranja;
		}
		public void setFinansiranje(Nacin_Finansiranja n_finansiranja) {
			this.n_finansiranja = n_finansiranja;
		}
		//STRING
		@Override
		public String toString() {
			return "Student [ime=" + ime + ", prezime=" + prezime + ", datum_rodjenja=" + datum_rodjenja + ", adresa="
					+ adresa + ", kontakt_telefon=" + kontakt_telefon + ", email=" + email + ", index=" + index
					+ ", godina_upisa=" + godina_upisa + ", tren_god_studiranja=" + tren_god_studiranja + ", pr_ocena="
					+ pr_ocena + ", n_finansiranja=" + n_finansiranja + "]";
		}
		
		
}
