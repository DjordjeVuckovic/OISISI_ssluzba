package model;

import java.util.ArrayList;
import java.util.Date;


public class Student {
	// POLJA
		private String name;
		private String surname;
		private Date birthday;
		private Address adress;
		private String contactPhone;
		private String Email;
		private String index;
		private int enrollYear;
		private YearofStudy currentYear;
		private double avgGrade;
		private Status status;
		private ArrayList<Grade> passedExams;
		//private Map<String,Subject> failedExams;



	public Student(String name, String surname, String index, YearofStudy currentYear, double avgGrade, Status status) {
		this.name = name;
		this.surname = surname;
		this.index = index;
		this.currentYear = currentYear;
		this.avgGrade = avgGrade;
		this.status = status;
		passedExams = new ArrayList<>();
	}
	
	
	public Student(String name, String surname,Date birthday, String index, YearofStudy currentYear, double avgGrade, Status status) {
		this.name = name;
		this.surname = surname;
		this.birthday=birthday;
		this.index = index;
		this.currentYear = currentYear;
		this.avgGrade = avgGrade;
		this.status = status;
	}
	public Student(){passedExams = new ArrayList<>();}
		public Student(String ime, String prezime, Date datum_rodjenja, Address adresa, String kontakt_telefon,
					   String email, String index, int godina_upisa, YearofStudy tren_god_studiranja, double pr_ocena, Status n_finansiranja) {
			super();
			this.name=ime;
			this.surname =prezime;
			this.birthday= datum_rodjenja;
			this.adress= adresa;
			this.contactPhone =kontakt_telefon;
			this.Email =email;
			this.index=index;
			this.enrollYear =godina_upisa;
			this.currentYear =tren_god_studiranja;
			this.avgGrade =pr_ocena;
			this.status=n_finansiranja;
			passedExams = new ArrayList<>();
		}
		//GET i SET metode
		public String getName() {
			return name;
		}

		public void setName(String ime) {
			this.name = ime;
		}

		public String getSurname() {
			return surname;
		}
		public void setSurname(String surname) {
			this.surname = surname;
		}
		public Date getBirthday() {
			return birthday;
		}
		public void setBirthday(Date birthday) {

			this.birthday = birthday;
		}
		public Address getAddress() {
			return adress;
		}
		public void setAddress(Address adresa) {
			this.adress = adresa;
		}

		public String getContactPhone() {
			return contactPhone;
		}
		public void setContactPhone(String kontakt_telefon) {
			this.contactPhone = kontakt_telefon;
		}
		public String getEmail() {
			return Email;
		}
		public void setEmail(String email) {
			this.Email = email;
		}
		public String getIndex() {
			return index;
		}
		public void setIndex(String indeks) {
			this.index = indeks;
		}
		public int getEnrollYear() {
			return enrollYear;
		}

		public void setEnrollYear(int godina_upisa) {
			this.enrollYear = godina_upisa;
		}
		public YearofStudy getCurrentyear() {
			return currentYear;
		}
		public void setCurrentyear(YearofStudy trenGodStudija) {
			this.currentYear = trenGodStudija;
		}
		public double getavgGrade() {
			return avgGrade;

		}
		public void setAvgGrade(double pr_ocena) {
			this.avgGrade = pr_ocena;
		}
		public Status getNacinFinansiranja() {
			return status;
		}
		public void setFinansiranje(Status n_finansiranja) {
			this.status = n_finansiranja;
		}

		public ArrayList<Grade> getPassedExams() {
			return passedExams;
		}
		
		public double CalculateAvgGrade(){
			double sum = 0;
			for(Grade grade : passedExams){
				sum += grade.getGrade();
			}
			if(passedExams.size()==0){
				avgGrade=0;
			}else{
				avgGrade  = sum/passedExams.size();
			}
			return  avgGrade;
		}
		
		public int SumPoints(){
			int sum = 0;
			for(Grade grade:passedExams){
				if(grade.getSubject() !=null){
					sum +=grade.getSubject().getESPBpoints();
				}
			}
			return sum;
		}
		
	@Override
		public String toString() {
			return "Student [ime=" + name + ", prezime=" + surname + ", datum_rodjenja=" + birthday + ", adresa="
					+ adress + ", kontakt_telefon=" + contactPhone + ", email=" + Email + ", index=" + index
					+ ", godina_upisa=" + enrollYear + ", tren_god_studiranja=" + currentYear + ", pr_ocena="
					+ avgGrade + ", n_finansiranja=" + status + "]";
		}


	public void setAdress(String street, String number, String city, String country) {
		this.adress=new Address(street,number,city,country);
	}
}
