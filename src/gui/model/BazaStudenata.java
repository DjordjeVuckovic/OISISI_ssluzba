package gui.model;

import java.util.ArrayList;


public class BazaStudenata {

	private ArrayList<Student> students;
	private ArrayList<String> colums;
	
	
	public BazaStudenata() {
		this.students = new ArrayList<Student>();
		this.students.add(new Student());
		this.colums= new ArrayList<String>();
		this.colums.add("Ime");
		this.colums.add("Prezime");
		this.colums.add("Broj indeksa");
		this.colums.add("Datum rodjenja");
		this.colums.add("Godina upisa");
		this.colums.add("Trenutna godina");
		this.colums.add("Status");
		this.colums.add("Prosecna ocena");
		
		
	}

	public ArrayList<Student> getStudenti() {
		return students;
	}

	public void setStudenti(ArrayList<Student> studenti) {
		this.students = studenti;
	}
	public int getColumnCnt() {
		return colums.size();
	}
	public String getColumnName(int index) {
		return colums.get(index);
	}

	public ArrayList<String> getKolone() {
		return colums;
	}

	public void setKolone(ArrayList<String> kolone) {
		this.colums = kolone;
	}
	public Student getRow(int row) {
		return this.students.get(row);
	}
	public String getStrValue(int row, int col) {
		Student s= this.students.get(row);
		switch(col) {
		case 0:
			return s.getIme();
		case 1:
			return s.getPrezime();
		case 2:
			return s.getIndex();
		case 3:
			return s.getDatumRodjenja().toString();
		case 4:
			return Integer.toString(s.getGodinaUpisa());
		case 5:
			return Integer.toString(s.getTrenGodStudija());
		case 6:
			if(s.getNacinFinansiranja()==Nacin_Finansiranja.BUDZET) {
				return "B";
			}
			else {
				return "S";
			}
		case 7:
			return Double.toString(s.getProsecnaOcena());
		default:
			return null;
				
		}
	}
}
