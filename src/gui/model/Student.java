package gui.model;

import java.util.Date;


public class Student {
	// POLJA
		private String name;
		private String prezime;
		private Date birthday;
		private Adress adress;
		private String contact_ph;
		private String e_mail;
		private String index;
		
		private int enroll_year;
		private int current_year;
		
		private double avg;
		
		private Nacin_Finansiranja status;
		// 
	//KONSTRUKTORI
		public Student() {}
		public Student(String ime,String prezime,Date datum_rodjenja,Adress adresa,String kontakt_telefon,
				String email,String index,int godina_upisa,int tren_god_studiranja,double pr_ocena,Nacin_Finansiranja n_finansiranja) {
			super();
			this.name=ime;
			this.prezime=prezime;
			this.birthday= datum_rodjenja;
			this.adress= adresa;
			this.contact_ph=kontakt_telefon;
			this.e_mail=email;
			this.index=index;
			this.enroll_year=godina_upisa;
			this.current_year=tren_god_studiranja;
			this.avg=pr_ocena;
			this.status=n_finansiranja;
		}
		//GET i SET metode
		public String getIme() {
			return name;
		}

		public void setIme(String ime) {
			this.name = ime;
		}

		public String getPrezime() {
			return prezime;
		}
		public void setPrezime(String prezime) {
			this.prezime = prezime;
		}
		public Date getDatumRodjenja() {
			return birthday;
		}
		public void setDatumRodjenja(Date datum_rodjenja) {

			this.birthday = datum_rodjenja;
		}
		public Adress getAdresa() {
			return adress;
		}
		public void setAdresa(Adress adresa) {
			this.adress = adresa;
		}
		public String getKontaktTelefon() {
			return contact_ph;
		}
		public void setKontaktTelefon(String kontakt_telefon) {
			this.contact_ph = kontakt_telefon;
		}
		public String getEmail() {
			return e_mail;
		}
		public void setEmail(String email) {
			this.e_mail = email;
		}
		public String getIndex() {
			return index;
		}
		public void setIndex(String indeks) {
			this.index = indeks;
		}
		public int getGodinaUpisa() {
			return enroll_year;
		}
		public void setGodinaUpisa(int godina_upisa) {
			this.enroll_year = godina_upisa;
		}
		public int getTrenGodStudija() {
			return current_year;
		}
		public void setTrenGodStudija(int trenGodStudija) {
			this.current_year = trenGodStudija;
		}
		public double getProsecnaOcena() {
			return avg;
		}
		public void setProsecnaOcena(double pr_ocena) {
			this.avg = pr_ocena;
		}
		public Nacin_Finansiranja getNacinFinansiranja() {
			return status;
		}
		public void setFinansiranje(Nacin_Finansiranja n_finansiranja) {
			this.status = n_finansiranja;
		}
		//STRING
		@Override
		public String toString() {
			return "Student [ime=" + name + ", prezime=" + prezime + ", datum_rodjenja=" + birthday + ", adresa="
					+ adress + ", kontakt_telefon=" + contact_ph + ", email=" + e_mail + ", index=" + index
					+ ", godina_upisa=" + enroll_year + ", tren_god_studiranja=" + current_year + ", pr_ocena="
					+ avg + ", n_finansiranja=" + status + "]";
		}
		
		
}
