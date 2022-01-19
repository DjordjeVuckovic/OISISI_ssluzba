package model;

import gui.view.center.ProfessorsTable;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

		searchProfessors = new ArrayList<>();
		searchMode = false;
	}
	private void initProfessors(){
		this.Professors= new ArrayList<>();		
		Professor pr = new Professor("Milan","Milic",Zvanje.ASISTENT_SA_DOKTORATOM,"dsa@asdas");
		Professors.add(pr);
		Professors.add(new Professor("Sinisa", "Singer", Zvanje.REDOVNI_PROFESOR, "nesto5@gmail.com"));
		Professors.add(new Professor("Dejan", "Vukovic", Zvanje.SARADNIK_U_NASTAVI, "nesto4@gmail.com"));
		Professors.add(new Professor("Zoran", "Bosanac", Zvanje.VANREDNI_PROFESOR, "nesto3@gmail.com"));
		Professors.add(new Professor("Milan", "Milanic", Zvanje.DOCENT, "nesto2@gmail.com"));

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
		else{
			pr = Professors.get(rowIndex);
		}
		switch (columnIndex){
			case 0:
				return pr.getName();
			case 1:
				return pr.getSurname();
			case 2:
				return pr.getTitle();
			case 3:
				return pr.getMail();
			default:
				return null;

		}
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	public Professor getProfessorById(String id){
		for (Professor pr: this.Professors){
			if(pr.getIdNumber().equals(id)){
				return pr;
			}
		}
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
	public boolean UniqueId(String id_){
		boolean ret=true;
		for(Professor pr:this.Professors){
			if(pr.getIdNumber().equals(id_)){
				ret=false;
			}
		}
		return ret;
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
