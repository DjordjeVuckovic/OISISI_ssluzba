package model;
 //da
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
	
	public Professor(String name, String surname, Zvanje zvanje, String email) {
		this.name = name;
		this.surname = surname;
		this.title = zvanje;
		this.mail = email;
	};
	
	public Professor() {}
	public Professor(String surname, String name, Date birthday, Address adresaStan, Address adresaKanc, String contact, String mail,
					 String idNumber, Zvanje title, int yearsOfTail, ArrayList<Subject> subjects) {
		super();
		this.surname = surname;
		this.name = name;
		this.birthday = birthday;
		this.adresaStan = adresaStan;
		this.adresaKanc = adresaKanc;
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
	public Address getAddressS() {
		return adresaStan;
	}
	public void setAddressS(Address adresaStan) {
		this.adresaStan = adresaStan;
	}
	public void setAddressK(Address adresaKanc) {
		this.adresaKanc = adresaKanc;
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
	public ArrayList<Subject> getSubjects() {
		return subjects;
	}
	public void setSubjects(ArrayList<Subject> subjects) {
		this.subjects = subjects;
	}
	@Override
	public String toString() {
		return "Professor [surname=" + surname + ", name=" + name + ", birthday=" + birthday + ", adresaStana=" + adresaStan
				+ ", adresaKanc=" + adresaKanc + "contact=" + contact + ", mail=" + mail + ", idNumber=" + idNum + ", title=" + title
				+ ", yearsOfTail=" + yearsOfTail + ", subjects=" + subjects + "]";
	}

	public void setAdressS(String street, String number, String city, String country) {
		this.adresaStan =new Address(street,number,city,country);
	}
	
	public void setAdressK(String street, String number, String city, String country) {
		this.adresaKanc =new Address(street,number,city,country);
	}
	
}
