package model;

import java.util.ArrayList;

public class BazaProfesora implements AbstractModel {

	private ArrayList<Professor> professors;
	private ArrayList<String> colums;
	private static BazaProfesora instance=null;

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
		
	}
	private void initProfessors(){
		this.professors= new ArrayList<>();
		professors.add(new Professor("Nikola", "Nikolic", "Doktor" , "nikola@gmail.com"));
		professors.add(new Professor("Stefan", "Stefanovic", "Docent", "stefan@gmail.com"));
		professors.add(new Professor("Bosko", "Boskic",  "Master", "boskic@gmail.com" ));
	}

	public ArrayList<Professor> getProfessors() {
		return professors;
	}

	public void setprofessors(ArrayList<Professor> professors) {
		this.professors = professors;
	}

	public int getColumnCount() {
		return this.colums.size();
	}

	public int getRowCount() {
		return this.professors.size();
	}

	public String getColumnName(int col) {
		return this.colums.get(col);
	}

	public Object getValueAt(int rowName, int columnName) {
		Professor pr=this.professors.get(rowName);
		switch (columnName){
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
		for (Professor pr: this.professors){
			if(pr.getIdNumber().equals(id)){
				return pr;
			}
		}
		return null;
	}
	public Professor getProfessorByRow(int row){
		return professors.get(row);
	}
	public void addProfessor(Professor pr){
		professors.add(pr);
	}

	public void deleteProfessorById(String id){
		for(Professor pr: this.professors){
			if(pr.getIdNumber().equals(id)){
				this.professors.remove(pr);

			}
		}
	}
	public void deleteProfessor(Professor pr){professors.remove(pr);}
	public boolean UniqueId(String id_){
		boolean ret=true;
		for(Professor pr:this.professors){
			if(pr.getIdNumber().equals(id_)){
				ret=false;
			}
		}
		return ret;
	}
}
