package model;

import java.util.ArrayList;

public class BazaStudenata implements AbstractTableModel {

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
		this.colums= new ArrayList<String>();
		this.colums.add("Indeks");
		this.colums.add("Ime");
		this.colums.add("Prezime");
		this.colums.add("Godina studija");
		this.colums.add("Status");
		this.colums.add("Prosek");
		
		
	}
	private void initStudents(){
		this.students= new ArrayList<>();
		students.add(new Student("Mika", "Mikic", "RA8/2020", YearStudy.I,9.8, NacinFinansiranja.SAMOFINANSIRANJE ));
		students.add(new Student("Igor", "Bodiroga", "RA5/2017", YearStudy.II,7.8, NacinFinansiranja.SAMOFINANSIRANJE ));
		students.add(new Student("Marko", "Markovic", "RA88/2016", YearStudy.I,10.0, NacinFinansiranja.BUDZET ));
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
				return st.getIme();
			case 2:
				return st.getSurname();
			case 3:
				return st.getCurrentyear().name();
			case 4:
				return st.getNacinFinansiranja().name();
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
		for (Student st: students){
			if(st.getIndex().equals(id)){
				return st;
			}
		}
		return null;
	}
}
