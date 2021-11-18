package gui.model;

import java.util.ArrayList;
import java.util.Date;

import gui.model.Adress;
import gui.model.Subject;

public class Professor {
	
	// POLJA
	private String surname;
	private String name;
	private Date birthday;
	private Adress adress;
	private String contact;
	private String mail;
	private String id_num;
	private String title;
	private int years_of_tail;
	private ArrayList<Subject> subjects = new ArrayList<Subject>();
	
	
	
	public Professor() {}
	public Professor(String surname, String name, Date birthday, Adress adress, String contact, String mail,
			String idNumber, String title, int yearsOfTail, ArrayList<Subject> subjects) {
		super();
		this.surname = surname;
		this.name = name;
		this.birthday = birthday;
		this.adress = adress;
		this.contact = contact;
		this.mail = mail;
		this.id_num = idNumber;
		this.title = title;
		this.years_of_tail = yearsOfTail;
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
	public Adress getAdress() {
		return adress;
	}
	public void setAdress(Adress adress) {
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
		return id_num;
	}
	public void setIdNumber(String idNumber) {
		this.id_num = idNumber;
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
				+ ", contact=" + contact + ", mail=" + mail + ", idNumber=" + id_num + ", title=" + title
				+ ", yearsOfTail=" + years_of_tail + ", subjects=" + subjects + "]";
	}

			
	
}
