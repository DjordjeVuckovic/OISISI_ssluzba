package model;

import serial.Serialization;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class BazaStudenata implements AbstractModel, Serializable {

	@Serial
	private static final long serialVersionUID = -1783935642755010733L;

	private ArrayList<Student> students;
	private ArrayList<String> colums;
	private static BazaStudenata instance=null;
	private boolean searchMode;
	private ArrayList<Student> searchStudents;

	public static BazaStudenata getInstance(){
		if(instance ==null){
			instance = new BazaStudenata();
		}
		return instance;
	}
	
	
	private BazaStudenata() {
		initStudents();
		initFPassed();
		CalculateAvgGrade();
		this.colums= new ArrayList<>();
		this.colums.add("Indeks");
		this.colums.add("Ime");
		this.colums.add("Prezime");
		this.colums.add("Godina studija");
		this.colums.add("Status");
		this.colums.add("Prosek");

		searchStudents = new ArrayList<>();
		searchMode = false;
	}
	private void initStudents(){
		this.students= new ArrayList<>();
		Address address= new Address();
		Student st = new Student("Milan","Milic",new GregorianCalendar(2001, 9, 21).getTime(),address.generateAddress(2),"011/8172-372","milos.milic@mailinator.com","SW/12/2021",2021,YearofStudy.I,Status.SAMOFINANSIRANJE);
		students.add(st);
		students.add(new Student("Marko","Milosevic",new GregorianCalendar(2001, 2, 12).getTime(),address.generateAddress(1),"021/333-555", "marko.milosevic@mailinator.com","RA/2/2020", 2020,YearofStudy.I,Status.BUDZET));
		students.add(new Student("Marija","Milić",new GregorianCalendar(2000, 0, 12).getTime(),address.generateAddress(2),"021/555-2222", "marija.milic@mailinator.com","RA/3/2019", 2019,YearofStudy.II,Status.SAMOFINANSIRANJE));
		students.add(new Student("Nikola","Nikolic",new GregorianCalendar(2001, 7, 30).getTime(),address.generateAddress(3),"021/135-463", "nikola.nikolic@mailinator.com","RA/3/2017", 2017,YearofStudy.I,Status.BUDZET));
		students.add(new Student("Pera","Peric",new GregorianCalendar(1995, 5, 7).getTime(),address.generateAddress(4),"021/903-463", "pera.peric@mailinator.com","RA/134/2015", 2015,YearofStudy.III,Status.BUDZET ));
		students.add(new Student("Sofija","Ilic",new GregorianCalendar(1999, 4, 6).getTime(),address.generateAddress(5),"021/731-067", "sofija.ilic@mailinator.com","RA/5/2019", 2019,YearofStudy.III,Status.BUDZET));
		students.add(new Student("Martina","Lukic",new GregorianCalendar(1999, 4, 16).getTime(),address.generateAddress(6),"011/4333-800", "martina.lukic@mailinator.com","RA/8/2018", 2018,YearofStudy.III,Status.SAMOFINANSIRANJE));
		students.add(new Student("Stojan","Stojakovic",new GregorianCalendar(1999, 4, 16).getTime(),address.generateAddress(7),"011/4333-800", "martina.lukic@mailinator.com","RA 8/2018", 2018,YearofStudy.III,Status.SAMOFINANSIRANJE));
		deserijalizacija();
	}
	private void initFPassed(){
		Address office = new Address("Nikole Pa\u0161i\u0107a","6a","Novi Sad","Srbija");
		Professor p2 = new Professor("Mirkovic", "Nikola",new GregorianCalendar(1978, 0, 1).getTime() ,new Address("Nikole Tesle","56","Novi Sad","Srbija"),office,"021/368-456", "nikola.mirkovic@mailinator.com",  "321321321", Zvanje.REDOVNI_PROFESOR,22);
		Professor p7 = new Professor("Mihajlovic", "Branislav",new GregorianCalendar(1980, 5, 28).getTime() ,new Address("Tolstojeva","31", "Novi Sad","Srbija"),office,"021/778-323", "branislav.mihajlovic@mailinator.com",  "559585632", Zvanje.REDOVNI_PROFESOR,13 );

		Subject s1 = new Subject("p1","osnove programiranja",Semester.WINTER,YearofStudy.I,BazaProfesora.getInstance().getProfessorById("321321321"),7);
		Subject s5=new Subject("p5","matematika",Semester.SUMMER,YearofStudy.I,null,11);
		Subject s3 = new Subject("p3","algoritmi i strukture podataka",Semester.SUMMER,YearofStudy.II,BazaProfesora.getInstance().getProfessorById("321321321"),9);
		Subject s16 = new Subject("p16","konkurentno programiranje",Semester.SUMMER,YearofStudy.II,BazaProfesora.getInstance().getProfessorById("559585632"),9);
		Subject s15 = new Subject("p15","paralelno programiranje",Semester.WINTER,YearofStudy.II,BazaProfesora.getInstance().getProfessorById("559585632"),8);

		ArrayList<Grade> subjectsPassed4 = new ArrayList();
		Grade grade45 = new Grade(this.getStudentById("RA/134/2015"),s5,10,new GregorianCalendar(2017, 11, 12).getTime());
		Grade grade43 = new Grade(this.getStudentById("RA/134/2015"),s3,9,new GregorianCalendar(2019, 9, 10).getTime());
		Grade grade41 = new Grade(this.getStudentById("RA/134/2015"),s1,8,new GregorianCalendar(2020, 10, 11).getTime());
		subjectsPassed4.add(grade45);
		subjectsPassed4.add(grade43);
		subjectsPassed4.add(grade41);
		this.getStudentById("RA/134/2015").setPassedExams(subjectsPassed4);

		ArrayList<Grade> subjectsPassed2 = new ArrayList();
		Grade grade21 = new Grade(this.getStudentById("RA/3/2019"),s1,10,new GregorianCalendar(2020, 10, 20).getTime());
		Grade grade25 = new Grade(this.getStudentById("RA/3/2019"),s5,10,new GregorianCalendar(2021, 9, 30).getTime());
		subjectsPassed2.add(grade21);
		subjectsPassed4.add(grade25);
		this.getStudentById("RA/3/2019").setPassedExams(subjectsPassed2);

		ArrayList<Grade> subjectsPassed15 = new ArrayList();
		Grade grade1515 = new Grade(this.getStudentById("RA/11/2018"),s15,7,new GregorianCalendar(2021, 0, 1).getTime());
		Grade grade1516 = new Grade(this.getStudentById("RA/11/2018"),s16,10,new GregorianCalendar(2021, 0, 1).getTime());
		subjectsPassed15.add(grade1515);
		subjectsPassed15.add(grade1516);
		this.getStudentById("RA/11/2018").setPassedExams(subjectsPassed15);

		ArrayList<Grade> subjectsPassed16 = new ArrayList();
		Grade grade1615 = new Grade(this.getStudentById("RA/12/2018"),s15,10,new GregorianCalendar(2018, 0, 12).getTime());
		Grade grade1616 = new Grade(this.getStudentById("RA/12/2018"),s16,9,new GregorianCalendar(2019, 1, 4).getTime());
		subjectsPassed16.add(grade1615);
		subjectsPassed16.add(grade1616);
		this.getStudentById("RA/12/2018").setPassedExams(subjectsPassed16);

	}
	private void deserijalizacija(){
		BazaPodataka bp = Serialization.readFile();
		if(bp !=null)
		this.students = bp.getStudents();
	}
	public ArrayList<Student> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}

	public int getColumnCount() {
		return this.colums.size();
	}

	public int getRowCount() {
		return this.students.size();
	}

	public String getColumnName(int col) {
		return this.colums.get(col);
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		Student st;
		if(searchMode) {
			st = this.searchStudents.get(rowIndex);
		}
		else{
			st = students.get(rowIndex);
		}
		switch (columnIndex){
			case 0:
				return st.getIndex();
			case 1:
				return st.getName();
			case 2:
				return st.getSurname();
			case 3:
				return st.getCurrentyear().name();
			case 4:
					if(st.getNacinFinansiranja()==Status.BUDZET) {
						return "B";
					}
					else{
						return "S";
					}
			case 5:
				return Double.toString(st.getavgGrade());
			default:
				return null;

		}
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	public Student getStudentById(String id){
		for (Student st: this.students){
			if(st.getIndex().equals(id)){
				return st;
			}
		}
		return null;
	}
	public Student getStudentByRow(int row){
		return students.get(row);
	}
	public void addStudent(Student st){
		students.add(st);
	}

	public void deleteStudentById(String id){
		for(Student st: this.students){
			if(st.getIndex().equals(id)){
				this.students.remove(st);

			}
		}
	}
	public void deleteStudent(Student st){students.remove(st);}
	public boolean UniqueId(String id_){
		boolean ret=true;
		for(Student st:this.students){
			if(st.getIndex().equals(id_)){
				ret=false;
			}
		}
		return ret;
	}
	public void editStudent(Student student,Student stN){
		student.setName(stN.getName());
		student.setSurname(stN.getSurname());
		student.setCurrentyear(stN.getCurrentyear());
		student.setFinansiranje(stN.getNacinFinansiranja());
		student.setEnrollYear(stN.getEnrollYear());
		student.setIndex(stN.getIndex());
		student.setContactPhone(stN.getContactPhone());
		student.setAvgGrade(stN.getavgGrade());
		student.setAdress(student.getAddress().getStreet(),student.getAddress().getNumber(),student.getAddress().getCity(),student.getAddress().getCountry());
	}
	public boolean isSearchMode() {
		return searchMode;
	}

	public void setSearchMode(boolean searchMode) {
		this.searchMode = searchMode;
	}

	public ArrayList<Student> getSearchStudents() {
		return searchStudents;
	}

	public void setSearchStudents(ArrayList<Student> searchStudents) {
		this.searchStudents = searchStudents;
	}
	public void removeSearchSt(Student student){
		if(searchMode){
			searchStudents.remove(student);
		}
	}
	public void CalculateAvgGrade() {
		for (Student st : students) {
			double ret = st.CalculateAvgGrade();
			st.setAvgGrade(ret);
		}
	}
		public void DeleteSubjectForStudent(String id){
			int lenght;
			for(Student st: students){
				lenght = st.getFailedExams().indexOf(BazaPredmeta.getInstance().findSubjectById(id));
				if(lenght>=0){
					st.getFailedExams().remove(lenght);
				}
			}
		}

}
