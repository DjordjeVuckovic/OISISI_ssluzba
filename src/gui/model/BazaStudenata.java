package gui.model;

import java.util.ArrayList;


public class BazaStudenata {
	private static BazaStudenata unique_instance = null;
	private ArrayList<Student> studenti;
	private ArrayList<String> kolone;
	
	public static BazaStudenata getInstance(){
			if(unique_instance == null) {
				unique_instance = new BazaStudenata();
	}
			return unique_instance;
		}
	
	public BazaStudenata() {
		this.studenti = new ArrayList<Student>();
		this.studenti.add(new Student());
		this.kolone= new ArrayList<String>();
		this.kolone.add("Ime");
		this.kolone.add("Prezime");
		this.kolone.add("Broj indeksa");
		this.kolone.add("Datum rodjenja");
		this.kolone.add("Godina upisa");
		this.kolone.add("Trenutna godina");
		this.kolone.add("Status");
		this.kolone.add("Prosecna ocena");
		
		
	}

	public ArrayList<Student> getStudenti() {
		return studenti;
	}

	public void setStudenti(ArrayList<Student> studenti) {
		this.studenti = studenti;
	}
	public int getColumnCnt() {
		return kolone.size();
	}
	public String getColumnName(int index) {
		return kolone.get(index);
	}

	public ArrayList<String> getKolone() {
		return kolone;
	}

	public void setKolone(ArrayList<String> kolone) {
		this.kolone = kolone;
	}
	public Student getRow(int row) {
		return this.studenti.get(row);
	}
	public String getStrValue(int r, int c) {
		Student s= this.studenti.get(r);
		switch(c) {
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
