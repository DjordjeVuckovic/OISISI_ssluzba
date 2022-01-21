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
		CalculateAvgGrade();
		deserijalizacija();
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
