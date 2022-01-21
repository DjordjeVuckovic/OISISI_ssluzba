package model;

import serial.Serialization;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class BazaProfesora implements AbstractModel, Serializable {

	@Serial
	private static final long serialVersionUID = 2875967262004282589L;

	private ArrayList<Professor> Professors;
	private ArrayList<String> colums;
	private static BazaProfesora instance=null;
	private boolean searchMode;
	private ArrayList<Professor> searchProfessors;


	public static BazaProfesora getInstance(){
		if(instance ==null){
			instance = new BazaProfesora();
		}
		return instance;
	}
	
	
	private BazaProfesora() {
		initProfessors();
		this.colums= new ArrayList<>();
		this.colums.add("Ime");
		this.colums.add("Prezime");
		this.colums.add("Zvanje");
		this.colums.add("Email");
		this.colums.add("Licna karta");

		searchProfessors = new ArrayList<>();
		searchMode = false;
		
	}
	private void initProfessors(){
		this.Professors= new ArrayList<>();
		Date date = new Date();
		Address address = new Address("N","N","N","N");
		Professor professor = new Professor("Marko","Markodic",date,address,"0","aa@aa",address,"112",12,Zvanje.REDOVNI_PROFESOR);
		Professors.add(professor);
		Address office = new Address("\u0160afarikova","2","Novi Sad","Srbija");
		Professors.add(new Professor("Nikolic", "Milos",new GregorianCalendar(1965, 11, 12).getTime() ,new Address("\u0160afarikova","2","Novi Sad","Srbija"),office,"021/356-785", "milos.nikolic@mailinator.com",  "123123123", Zvanje.REDOVNI_PROFESOR,30 ));
		Professors.add(new Professor("Mirkovic", "Nikola",new GregorianCalendar(1978, 0, 1).getTime() ,new Address("Nikole Tesle","56","Novi Sad","Srbija"),office,"021/368-456", "nikola.mirkovic@mailinator.com",  "321321321", Zvanje.REDOVNI_PROFESOR,22 ));
		Professors.add(new Professor("Petkovic", "Ilija",new GregorianCalendar(1988, 8, 3).getTime() ,new Address("Bulevar Patrijaha Pavla","3","Beograd","Srbija"),office,"021/215-314", "ilija.petkovic@mailinator.com",  "456456456", Zvanje.VANREDNI_PROFESOR,22 ));
		Professors.add(new Professor("Petrovic", "Mitar",new GregorianCalendar(1976, 6, 25).getTime() ,new Address("Stra\u017Eilovska","6a","Novi Sad","Srbija"),office,"021/884-640", "mitar.petrovic@mailinator.com",  "789789789", Zvanje.VANREDNI_PROFESOR,27 ));
		Professors.add(new Professor("Micic", "Vasa",new GregorianCalendar(1970, 1, 14).getTime() ,new Address("Nikole Pa\u0161i\u0107a","2d","Kikinda","Srbija"),office,"021/212-114", "vasa.micic@mailinator.com",  "100100144", Zvanje.DOCENT,24 ));
		Professors.add(new Professor("Miletic", "Srdjan",new GregorianCalendar(1966, 3, 20).getTime() ,new Address("Bulevar Kralja Petra","22", "Ni\u0161","Srbija"),office,"021/978-225", "srdjan.miletic@mailinator.com",  "200020244", Zvanje.DOCENT,31 ));
		Professors.add(new Professor("Mihajlovic", "Branislav",new GregorianCalendar(1980, 5, 28).getTime() ,new Address("Tolstojeva","31", "Novi Sad","Srbija"),office,"021/778-323", "branislav.mihajlovic@mailinator.com",  "559585632", Zvanje.REDOVNI_PROFESOR,13 ));
		Professors.add(new Professor("Markovi\u0107", "Marko",new GregorianCalendar(1985, 0, 31).getTime() ,new Address("Mari\u0107eva","11", "Kragujevac","Srbija"),office,"021/899-659", "marko.markovic@mailinator.com",  "334968855", Zvanje.REDOVNI_PROFESOR,17 ));
		Professors.add(new Professor("Milakovi\u0107", "Milo\u0161",new GregorianCalendar(1975, 8, 21).getTime() ,new Address("Stražilovska","3", "Beograd","Srbija"),office,"021/122-326", "milos.milakovic@mailinator.com",  "730703654", Zvanje.VANREDNI_PROFESOR,12 ));
		Professors.add(new Professor("Brati\u0107", "Lazar",new GregorianCalendar(1973, 10, 13).getTime() ,office,office,"021/156-326", "lazar.bratic@mailinator.com",  "600378644", Zvanje.VANREDNI_PROFESOR,3 ));
		Professors.add(new Professor("Dra\u017Ei\u0107", "Ljeposava",new GregorianCalendar(1964, 7, 11).getTime() ,new Address("Bulevar Kralja Petra","2d", "Ni\u0161","Srbija"),office,"021/888-156", "ljeposava.drazic@mailinator.com",  "158496152", Zvanje.DOCENT,31 ));
		Professors.add(new Professor("Dragi\u0107", "Miroljub",new GregorianCalendar(1959, 2, 2).getTime() ,new Address("Knez Mihajlova","22", "Beograd","Srbija"),office,"021/456-125", "miroljub.dragic@mailinator.com",  "777348595", Zvanje.DOCENT,42 ));
		Professors.add(new Professor("Rekavi\u0107", "Bogdan",new GregorianCalendar(1977, 5, 23).getTime() ,new Address("Bulevar Kralja Petra","22", "Ni\u0161","Srbija"),office,"021/886-455", "bogdan.rekavic@mailinator.com",  "721254363", Zvanje.VANREDNI_PROFESOR,18 ));
		Professors.add(new Professor("Mili\u0107", "Stanka",new GregorianCalendar(1991, 2, 3).getTime() ,new Address("Bulevar Patrijaha Pavla","3","Beograd","Srbija"),office,"021/945-155", "stanka.milic@mailinator.com",  "225533448", Zvanje.DOCENT,7 ));
		Professors.add(new Professor("Vukovi\u0107", "Milica",new GregorianCalendar(1967, 9, 18).getTime() ,new Address("Mari\u0107eva","11", "Kragujevac","Srbija"),office,"021/746-659", "milica.vukovic@mailinator.com",  "111555888", Zvanje.VANREDNI_PROFESOR,14 ));
		Professors.add(new Professor("Mi\u0161i\u0107", "Mi\u0161a",new GregorianCalendar(1969, 9, 20).getTime() ,new Address("\u0160afarikova","2","Novi Sad","Srbija"),office,"021/489-326", "misa.misic@mailinator.com",  "300300344", Zvanje.DOCENT,19 ));
		Professors.add(new Professor("Marici\u0107", "Branko",new GregorianCalendar(1973, 0, 18).getTime() ,new Address("Nikole Tesle","56","Novi Sad","Srbija"),office,"021/487-265", "branko.maricic@mailinator.com",  "400400444", Zvanje.DOCENT,22 ));
		Professors.add(new Professor("Lukovic", "Branislav",new GregorianCalendar(1982, 3, 8).getTime() ,new Address("Bulevar Patrijaha Pavla","3","Beograd","Srbija"),office,"021/159-478", "branislav.lukovic@mailinator.com",  "500500544", Zvanje.REDOVNI_PROFESOR,9));
		Professors.add(new Professor("Obradovi\u0107", "Branimir",new GregorianCalendar(1979, 0, 17).getTime() ,new Address("\u0160afarikova","2","Novi Sad","Srbija"),office,"021/922-333", "branimir.obradovic@mailinator.com",  "600600644", Zvanje.DOCENT,17 ));
		deserijalizacija();
	}

	private void deserijalizacija(){
		BazaPodataka bp = Serialization.readFile();
		if(bp !=null)
			this.Professors = bp.getProfessors();
	}

	public ArrayList<Professor> getProfessors() {
		return Professors;
	}

	public void setProfessors(ArrayList<Professor> Professors) {
		this.Professors = Professors;
	}

	public int getColumnCount() {
		return this.colums.size();
	}

	public int getRowCount() {
		return this.Professors.size();
	}

	public String getColumnName(int col) {
		return this.colums.get(col);
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		Professor pr;
		if(searchMode) {
			pr = this.searchProfessors.get(rowIndex);
		}
		else {
			pr = Professors.get(rowIndex);
		}
		switch (columnIndex){
			case 0:
				return pr.getName();
			case 1:
				return pr.getSurname();
			case 2:
				if(pr.getTitle()==Zvanje.SARADNIK_U_NASTAVI) {
					return "SARADNIK U NASTAVI";
				}else if(pr.getTitle()==Zvanje.ASISTENT){
					return "ASISTENT";
				}else if(pr.getTitle()==Zvanje.DOCENT){
					return "DOCENT";
				}else if(pr.getTitle()==Zvanje.VANREDNI_PROFESOR){
					return "VANREDNI PROFESOR";
				}
				else if(pr.getTitle()==Zvanje.REDOVNI_PROFESOR){
					return "REDOVNI PROFESOR";
				}
				else if(pr.getTitle()==Zvanje.ASISTENT_SA_DOKTORATOM){
					return "ASISTENT SA DOKTORATOM";
				}
			case 3:
				return pr.getMail();
			case 4:
				return pr.getIdNumber();
			default:
				return null;
		}
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	public Professor getProfessorById(String id){ //da li ovde mora jedna od ove 4 metode?--ovde nesto ne valja ne vrati profesora
		for (Professor pr: this.Professors){
			if(pr.getIdNumber().equals(id)){
				return pr;
			}
		}
		//return null;
		//Professor  pr= Professors.get(0);
		return null;
	}
	
	public Professor getProfessorByRow(int row){
		return Professors.get(row);
	}
	public void addProfessor(Professor pr){
		Professors.add(pr);
	}

	public void deleteProfessorById(String id){
		for(Professor pr: this.Professors){
			if(pr.getIdNumber().equals(id)){
				this.Professors.remove(pr);

			}
		}
	}
	public void deleteProfessor(Professor pr){Professors.remove(pr);}
	
	public void addSubjectForProf(Professor pro,Subject pre) {

		if(pro == null || pre == null) return;
		

		for (Subject predmet : pro.getSubjects()) {
			if(predmet.equals(pre)) {
				return; 		
			}
		}
		pro.addSubjects(pre);
		return;
	}
	
	
	public boolean UniqueId(String id_){
		boolean ret=true;
		for(Professor pr:this.Professors){
			if(pr.getIdNumber().equals(id_)){
				ret=false;
			}
		}
		return ret;
	}
	
	public void editProfessor(Professor profesor, Professor noviProf) {
		profesor.setName(noviProf.getName());
		profesor.setSurname(noviProf.getName());
		profesor.setName(noviProf.getName());
		profesor.setContact(noviProf.getContact());
		profesor.setMail(noviProf.getMail());
		profesor.setBirthday(noviProf.getBirthday());
		profesor.setIdNumber(noviProf.getIdNumber());
		profesor.setAddressS(noviProf.getAddressS().getStreet(), noviProf.getAddressS().getNumber(),noviProf.getAddressS().getCity(),noviProf.getAddressS().getCountry());
		//profesor.setAddressK(noviProf.getAddressK().getStreet(), noviProf.getAddressK().getNumber(),noviProf.getAddressK().getCity(),noviProf.getAddressK().getCountry());
		profesor.setTitle(noviProf.getTitle());
		profesor.setYearsTail(noviProf.getYearsTail());
	}
	
	public boolean isSearchMode() {
		return searchMode;
	}

	public void setSearchMode(boolean searchMode) {
		this.searchMode = searchMode;
	}

	public ArrayList<Professor> getSearchProfessors() {
		return searchProfessors;
	}

	public void setSearchProfessors(ArrayList<Professor> searchProfessors) {
		this.searchProfessors = searchProfessors;
	}
	public void removeSearchSt(Professor Professor){
		if(searchMode){
			searchProfessors.remove(Professor);
		}
	}

	public ArrayList<Professor> checkForBosses(){
		ArrayList<Professor> profs = new ArrayList<>();
		for(Professor professor:Professors) {
			if (professor.getTitle().equals(Zvanje.REDOVNI_PROFESOR) || professor.getTitle().equals(Zvanje.VANREDNI_PROFESOR)) {
				if (professor.getYearsTail() >=5){
					profs.add(professor);
				}
			}
		}
		return profs;
	}


}
