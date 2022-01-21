package model;

import gui.view.center.StudentsTable;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class BazaStudenata implements AbstractModel {

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
		Address address = new Address("N","N","N","N");
		Date date = new Date();
		students.add(new Student("Milan","Milic",date,address,"069584871","jej@hotmail","RA/1/2011",2011,YearofStudy.I,9.1,Status.SAMOFINANSIRANJE));
		students.add(new Student("Mika", "Mikic",date,address,"06125412","ne@hotmail","RA/5/2015",2011,YearofStudy.II,9.1,Status.BUDZET));
		students.add(new Student("Milan","Milic",date,address,"06125412","da@hotmail","RA/155/2016",2011,YearofStudy.II,8.7,Status.BUDZET));
		students.add(new Student("Milan","Milic",date,address,"06125412","nesto@hotmail","RA/16/2019",2011,YearofStudy.IV,8.0,Status.SAMOFINANSIRANJE));
		students.add(new Student("Milan","Milic",date,address,"06125412","nesto2@hotmail","RA/88/2014",2011,YearofStudy.III,6.5,Status.BUDZET));
		//students.add(new Student("Igor", "Igic",date, "RA/8/2017", YearofStudy.II,7.8, Status.BUDZET));
		//students.add(new Student("Marko", "Kraljevic",date, "RA/888/2016", YearofStudy.III,10.0, Status.BUDZET));
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
}
