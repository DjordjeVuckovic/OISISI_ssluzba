package model;

import java.util.ArrayList;
import java.util.Date;

public class BazaProfesora implements AbstractModel {

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
		Professor professor = new Professor("Marko","Markodic",date,address,"0","aa@aa",address,"112",12,Zvanje.ASISTENT);
		Professors.add(professor);
		//Professor pr = new Professor("Milan","Milic",Zvanje.DOCENT,"volim@oisisi");
		//Professors.add(pr);
		//Professors.add(new Professor("Mika", "Mikic", Zvanje.SARADNIK_U_NASTAVI, "mika@gmail.com"));
		//Professors.add(new Professor("Vladimir", "Radic", Zvanje.ASISTENT, "vladimir@gmail.com"));
		//Professors.add(new Professor("Marko", "Markic", Zvanje.DOCENT , "milos@gmail.com"));
		//Professors.add(new Professor("Darko", "Darkic", Zvanje.ASISTENT_SA_DOKTORATOM, "minjule@gmail.com"));
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
	
}
