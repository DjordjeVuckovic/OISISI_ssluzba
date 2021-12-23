package model;

import java.util.ArrayList;
import java.util.Date;

public class Professor {
	
	// POLJA          //nema assignyear, currentyear, status
	private String surname;
	private String name;
	private Date birthday;
	private Address adress;
	private String contact;
	private String mail;
	private String idNum;
	private String title;
	private int yearsOfTail;
	private ArrayList<Subject> subjects = new ArrayList<Subject>();
	
	public Professor(String name, String surname, String title, String mail) {
		this.name = name;
		this.surname = surname;
		this.title = title;
		this.mail = mail;
		
	}
	
	
	public Professor() {}
	public Professor(String surname, String name, Date birthday, Address adress, String contact, String mail,
					 String idNumber, String title, int yearsOfTail, ArrayList<Subject> subjects) {
		super();
		this.surname = surname;
		this.name = name;
		this.birthday = birthday;
		this.adress = adress;
		this.contact = contact;
		this.mail = mail;
		this.idNum = idNumber;
		this.title = title;
		this.yearsOfTail = yearsOfTail;
		this.subjects = subjects;
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
	public Address getAdress() {
		return adress;
	}
	public void setAdress(Address adress) {
		this.adress = adress;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public ArrayList<Subject> getSubjects() {
		return subjects;
	}
	public void setSubjects(ArrayList<Subject> subjects) {
		this.subjects = subjects;
	}
	@Override
	public String toString() {
		return "Professor [surname=" + surname + ", name=" + name + ", birthday=" + birthday + ", adress=" + adress
				+ ", contact=" + contact + ", mail=" + mail + ", idNumber=" + idNum + ", title=" + title
				+ ", yearsOfTail=" + yearsOfTail + ", subjects=" + subjects + "]";
	}

			
	
}
