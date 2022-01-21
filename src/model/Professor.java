package model;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Professor implements Serializable {


	@Serial
	private static final long serialVersionUID = 2906642554793891381L;
	// POLJA
	private String name;
	private String surname;
	private Date birthday;
	private Address adresaStan;
	private Address adresaKanc;
	private String contact;
	private String mail;
	private String idNum;
	private Zvanje title;
	private int yearsOfTail;
	private ArrayList<Subject> subjects;

	public Professor(String surname,String name,Date birthday,Address adresaStan, Address adresaKanc,String contact,String mail,String idNum, Zvanje title,int yearsOfTail){
		this.surname = surname;
		this.name = name;
		this.birthday = birthday;
		this.adresaStan = adresaStan;
		this.adresaKanc = adresaKanc;
		this.contact = contact;
		this.mail = mail;
		this.idNum = idNum;
		this.title = title;
		this.yearsOfTail = yearsOfTail;
	}
	public Professor(String name, String surname, Zvanje title, String mail) {
		this.name = name;
		this.surname = surname;
		this.title = title;
		this.mail = mail;
		subjects = new ArrayList<>();
	}
	
	public Professor(String name, String surname, Zvanje title, String mail, String idNum) {
		this.name = name;
		this.surname = surname;
		this.title = title;
		this.mail = mail;
		this.idNum = idNum;
		subjects = new ArrayList<>();
	}
	
	public Professor() {subjects = new ArrayList<>();}
	public Professor(String ime, String prezime, Date datum_rodjenja, Address adresaStan, String kontaktTelefon, String emailAdresa, Address adresaKanc,
					 String idNum, int godStaza, Zvanje zvanje) {
		super();
		this.name = ime;
		this.surname = prezime;
		this.birthday = datum_rodjenja;
		this.adresaStan = adresaStan;
		this.contact = kontaktTelefon;
		this.mail = emailAdresa;
		this.adresaKanc = adresaKanc;
		this.idNum = idNum;
		this.yearsOfTail = godStaza;
		this.title = zvanje;
		subjects = new ArrayList<>();
	}
	
	
	public Address getAddressK() {
		return adresaKanc;
	}
	public void setAddressK(Address adresaKanc) {
		this.adresaKanc = adresaKanc;
	}
	
	public Address getAddressS() {
		return adresaStan;
	}
	public void setAddressS(Address adresaStan) {
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
	public void setIdNumber(String brLicne) {
		this.idNum = brLicne;
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
		return "Professor [ime=" + name + ", prezime=" + surname + ", rodjendan=" + birthday + ", adresaKanc=" + adresaKanc + ", adresaStan=" + adresaStan +
				 ", kontakt_telefon=" + contact + ", mail=" + mail + ", brLicne=" + idNum + ", zvanje=" + title
				+ ", godineStaza=" + yearsOfTail + ", predmeti=" + subjects + "]";
	}

	public void setAddressS(String street, String number, String city, String country) {
		this.adresaStan = new Address(street,number,city,country);
	}
	
	public void setAddressK(String street, String number, String city, String country) {
		this.adresaKanc = new Address(street,number,city,country);
	}
	
}
