package model;

import java.util.ArrayList;
import java.util.Date;

public class Professor {
	
	// POLJA
	private String surname;
	private String name;
	private Date birthday;
	private Address adresaStan;
	private Address adresaKanc;
	private String contact;
	private String mail;
	private String idNum;
	private Zvanje title;
	private int yearsOfTail;
	private ArrayList<Subject> subjects = new ArrayList<Subject>();
	
	
	public Professor(String surname, String name, Zvanje title, String mail) {
		this.surname = surname;
		this.name = name;
		this.title = title;
		this.mail = mail;
		subjects = new ArrayList<>();
	}
	
	public Professor(String surname, String name, Date birthday, Zvanje title, String mail) {
		this.surname = surname;
		this.name = name;
		this.birthday = birthday;
		this.title = title;
		this.mail = mail;
	}
	
	public Professor() {subjects = new ArrayList<>();}
	public Professor(String ime, String prezime, Date datum_rodjenja, Address adresaStan, Address adresaKanc, String kontakt_telefon, String email,
					 String brLicne, Zvanje zvanje, int godStaza) {
		super();
		this.name = ime;
		this.surname = prezime;
		this.birthday = datum_rodjenja;
		this.adresaStan = adresaStan;
		this.adresaKanc = adresaKanc;
		this.contact = kontakt_telefon;
		this.mail = email;
		this.idNum = brLicne;
		this.title = zvanje;
		this.yearsOfTail = godStaza;
		subjects = new ArrayList<>();
	}
	
	
	public Address getAdresaKanc() {
		return adresaKanc;
	}
	public void setAdresaKanc(Address adresaKanc) {
		this.adresaKanc = adresaKanc;
	}
	
	public Address getAdresaStan() {
		return adresaStan;
	}
	public void setAdresaStan(Address adresaStan) {
		this.adresaStan = adresaStan;
	}
	
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getIdNumber() {
		return idNum;
	}
	public void setIdNumber(String idNumber) {
		this.idNum = idNumber;
	}
	
	public Zvanje getTitle() {
		return title;
	}
	public void setTitle(Zvanje title) {
		this.title = title;
	}
	
	public int getYearsTail() {
		return yearsOfTail;
	}
	public void setYearsTail(int yearsTail) {
		this.yearsOfTail = yearsTail;
	}
	
	public ArrayList<Subject> getSubjects() {
		return subjects;
	}
	public void setSubjects(ArrayList<Subject> subjects) {
		this.subjects = subjects;
	}
	
	@Override
	public String toString() {
		return "Professor [surname=" + surname + ", name=" + name + ", birthday=" + birthday + ", adresaKanc=" + adresaKanc + ", adresaStan=" + adresaStan +
				 ", contact=" + contact + ", mail=" + mail + ", idNumber=" + idNum + ", title=" + title
				+ ", yearsOfTail=" + yearsOfTail + ", subjects=" + subjects + "]";
	}

	public void setAddressS(String street, String number, String city, String country) {
		this.adresaStan = new Address(street,number,city,country);
	}
	
	public void setAddressK(String street, String number, String city, String country) {
		this.adresaKanc = new Address(street,number,city,country);
	}
	
}
