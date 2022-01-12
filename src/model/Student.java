package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


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
		private ArrayList<Subject> failedExams;
		private List<Subject> nePohadja;
		private List<String> koloneNepolozeni;
		private List<String> kolonePolozeni;



	public Student(String name, String surname, String index, YearofStudy currentYear, double avgGrade, Status status) {
		this.name = name;
		this.surname = surname;
		this.index = index;
		this.currentYear = currentYear;
		this.avgGrade = avgGrade;
		this.status = status;
		passedExams = new ArrayList<>();
		failedExams = new ArrayList<>();
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
					   String email, String index, int godina_upisa, YearofStudy tren_god_studiranja, double pr_Grade, Status n_finansiranja) {
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
			this.avgGrade =pr_Grade;
			this.status=n_finansiranja;
			passedExams = new ArrayList<>();
			failedExams = new ArrayList<>();
			
			initFailedExams();
			this.koloneNepolozeni = new ArrayList<String>();
			//---------------------------------------------
			this.koloneNepolozeni.add("Sifra Subjecta");
			this.koloneNepolozeni.add("Naziv Subjecta");
			this.koloneNepolozeni.add("ESPB");
			this.koloneNepolozeni.add("Godina studija");
			this.koloneNepolozeni.add("Semestar");
			
			initPassedExams();
			this.kolonePolozeni = new ArrayList<String>();
			this.kolonePolozeni.add("Sifra Subjecta");
			this.kolonePolozeni.add("Naziv Subjecta");
			this.kolonePolozeni.add("ESPB");
			this.kolonePolozeni.add("Grade");
			this.kolonePolozeni.add("Datum");
			
		}
		//GET i SET metode
		
		public Student(String ime, String prezime, String brojTelefona, String datumRodjenja, Address adresa,
				String email2, int godinaUpisa) {
			// TODO Auto-generated constructor stub
		}


		public void initFailedExams() {
			failedExams = new ArrayList<Subject>();
		}
		
		public void initPassedExams() {
			passedExams= new ArrayList<Grade>();
		}
		
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
		public void setAvgGrade(double pr_Grade) {
			this.avgGrade = pr_Grade;
		}
		
		public int getColumnCountNepolozeni() {
			return 5;
		}
		
		public String getColumnNameNepolozeni(int index) {
			return this.koloneNepolozeni.get(index);
		}
		
		public Subject getRowNepolozeni(int rowIndex) {
			return this.failedExams.get(rowIndex);
		}
		
		public String getValueAtNepolozeni(int row, int column) {
			Subject subject = this.failedExams.get(row);
			switch(column) {
			case 0:
				return subject.getIdS();
			case 1:
				return subject.getNameSub();
			case 2:
				return subject.getESPBpoints() + "";
			case 3:
				String[] godine = {"I (prva)", "II (druga)", "III (treca)", "IV (cetvrta)"};
				int idxGodine = subject.getYearOfStudy().ordinal();
				return godine[idxGodine];
			case 4:
				String[] semestri = {"Letnji", "Zimski"};
				int idxSemestra = subject.getSemester().ordinal();
				return semestri[idxSemestra];
			default:
				return null;
			}
		}
		
		public void initNePohadja() {
			nePohadja = new ArrayList<Subject>();
			for(Subject sub : BazaPredmeta.getInstance().getSubjects()) {
				
				boolean ima = false;
				
				int godinaP=0;
				
				if(sub.getYearOfStudy().equals(YearofStudy.I)) {
					godinaP=1;
				}
				else if(sub.getYearOfStudy().equals(YearofStudy.II)) {
					godinaP=2;
				}
				else if(sub.getYearOfStudy().equals(YearofStudy.III)) {
					godinaP=3;
				}
				else {
					godinaP=4;
				}
			
				YearofStudy godina = this.getCurrentyear();
				int godStud = 0;
				
				if(godina.equals("IV")) {
					godStud = 4;
				}
				else if(godina.equals("III")) {
					godStud = 3;
				}
				else if(godina.equals("II")) {
					godStud = 2;
				}
				else {
					godStud = 1;
				}
				
				if(godStud < godinaP) {
					ima = true;
				}
				
				for(Grade g : passedExams) {
					if(sub.getIdS().equals(g.getSubject().getIdS())) {
						ima = true;
					}
				}
				
				for(Subject sub1 : failedExams) {
					if(sub.getIdS().equals(sub1.getIdS())) {
						ima = true;
					}
				}
				
				if(!ima) {
					nePohadja.add(sub);
				}
			}
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
		
		public ArrayList<Subject> getFailedExams() {
			return failedExams;
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
		
		public void insertGrade(Grade Grade) {
			passedExams.add(Grade);
		}
		
		public void removeGrade(Grade Grade) {
			passedExams.remove(Grade);
		}
		
		public void insertSubject(Subject subject) {
			failedExams.add(subject);
		}
		
		public void removeSubject(Subject subject) {
			failedExams.remove(subject);
		}
	//polozeni
		
		public int getColumnCountPolozeni() {
			return 5;
		}
		
		
		public String getColumnNamePolozeni(int index) {
			return this.kolonePolozeni.get(index);
		}
		
		public String getValueAtPolozeni(int row, int column) {
			Grade grade = this.passedExams.get(row);
			switch(column) {
			case 0:
				return grade.getSubject().getIdS();
			case 1:
				return grade.getSubject().getNameSub();
			case 2:
				return "" + grade.getSubject().getESPBpoints();
			case 3:
				return "" + grade.getGrade();
			case 4:
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				Date d = grade.getExamDate();
				String newDateString = sdf.format(d);
				return "" + newDateString;
			default:
				return null;
			}
		}
		
		public Object getValueAtNePohadja(int index) {
			// TODO Auto-generated method stub
			Subject subject= this.nePohadja.get(index);
			return subject.getIdS() + " - " + subject.getNameSub();
		}

		public int getSizeNePohadja() {
			// TODO Auto-generated method stub
			return nePohadja.size();
		}

		public void dodajPredmet(int index) {
			
			Subject subject= nePohadja.get(index);
			nePohadja.remove(index);
			failedExams.add(subject);
		}
			
		
		public void dodajNepohadjani(Subject subject) {
			nePohadja.add(subject);
		}
		
	@Override
		public String toString() {
			return "Student [ime=" + name + ", prezime=" + surname + ", datum_rodjenja=" + birthday + ", adresa="
					+ adress + ", kontakt_telefon=" + contactPhone + ", email=" + Email + ", index=" + index
					+ ", godina_upisa=" + enrollYear + ", tren_god_studiranja=" + currentYear + ", pr_Grade="
					+ avgGrade + ", n_finansiranja=" + status + "]";
		}


	public void setAdress(String street, String number, String city, String country) {
		this.adress=new Address(street,number,city,country);
	}
}
