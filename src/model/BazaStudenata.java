package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class BazaStudenata implements AbstractModel {

	private ArrayList<Student> students;
	private ArrayList<String> colums;
	private static BazaStudenata instance=null;

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
		
	}
	private void initStudents(){
		this.students= new ArrayList<>();
		Address address = new Address("N","N","N","N");
		Date date = new Date();
		Student st = new Student("Milan","Milic",date,address,"06125412","dsa@asdas","RA/1/2011",2011,YearofStudy.I,9.1,Status.SAMOFINANSIRANJE);
		students.add(st);
		students.add(new Student("Mika", "Mikic", "RA/8/2020", YearofStudy.I,9.8, Status.SAMOFINANSIRANJE));
		students.add(new Student("Igor", "Bodiroga", "RA/5/2017", YearofStudy.II,7.8, Status.SAMOFINANSIRANJE));
		students.add(new Student("Marko", "Markovic", "RA/88/2016", YearofStudy.I,10.0, Status.BUDZET ));
		students.add(new Student("Mirko", "Mikic",date, "RA/1/2020", YearofStudy.IV,9.8, Status.SAMOFINANSIRANJE));
		students.add(new Student("Igor", "Igic",date, "RA/8/2017", YearofStudy.II,7.8, Status.BUDZET));
		students.add(new Student("Marko", "Kraljevic",date, "RA/888/2016", YearofStudy.III,10.0, Status.BUDZET));
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
		Student st=this.students.get(rowIndex);
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
}
