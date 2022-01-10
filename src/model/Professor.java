package model;

import java.util.ArrayList;
import java.util.Date;

public class Professor {
	
	// POLJA
	private String surname;
	private String name;
	private Date birthday;
	private Address adresaKancelarije;
	private String contact;
	private String mail;
	private String idNum;
	private Zvanje title;
	private int yearsOfTail;
	private ArrayList<Subject> subjects = new ArrayList<Subject>();
	
	
	
	public Professor() {}
	public Professor(String surname, String name, Date birthday, Address adress, String contact, String mail,
					 String idNumber, Zvanje title, int yearsOfTail, ArrayList<Subject> subjects) {
		super();
		this.surname = surname;
		this.name = name;
		this.birthday = birthday;
		this.adresaKancelarije = adress;
		this.contact = contact;
		this.mail = mail;
		this.idNum = idNumber;
		this.title = title;
		this.yearsOfTail = yearsOfTail;
		this.subjects = subjects;
	}
	public Professor(String ime, String prezime, Zvanje title, String email) {
	}
	
	public Address getAdresaKancelarije() {
		return adresaKancelarije;
	}
	public void setAdresaKancelarije(Address adresa) {
		this.adresaKancelarije = adresa;
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
		return "Professor [surname=" + surname + ", name=" + name + ", birthday=" + birthday + ", adress=" + adresaKancelarije
				+ ", contact=" + contact + ", mail=" + mail + ", idNumber=" + idNum + ", title=" + title
				+ ", yearsOfTail=" + yearsOfTail + ", subjects=" + subjects + "]";
	}

	public void setAdress(String street, String number, String city, String country) {
		this.adresaKancelarije = new Address(street,number,city,country);
	}
}
