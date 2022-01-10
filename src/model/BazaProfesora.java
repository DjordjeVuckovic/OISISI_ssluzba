package model;

import java.util.ArrayList;

public class BazaProfesora implements AbstractModel {

	private ArrayList<Professor> Professors;
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
		this.Professors= new ArrayList<>();
		Professors.add(new Professor("Mika", "Mikic", "Docent", "mika@gmail.com"));
		Professors.add(new Professor("Vladimir", "Radic", "Master", "vladimir@gmail.com"));
		Professors.add(new Professor("Marko", "Markic", "VanredniProfesor", "milos@gmail.com"));
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
		Professor st=this.Professors.get(rowIndex);
		switch (columnIndex){
			case 0:
				return st.getName();
			case 1:
				return st.getSurname();
			case 2:
				return st.getTitle();
			case 3:
				return st.getMail();
			default:
				return null;

		}
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	public Professor getProfessorById(String id){ //da li ovde mora jedna od ove 4 metode?
		for (Professor st: this.Professors){
			if(st.getMail().equals(id)){
				return st;
			}
		}
		return null;
	}
	public Professor getProfessorByRow(int row){
		return Professors.get(row);
	}
	public void addProfessor(Professor st){
		Professors.add(st);
	}

	public void deleteProfessorById(String id){
		for(Professor st: this.Professors){
			if(st.getMail().equals(id)){
				this.Professors.remove(st);

			}
		}
	}
	public void deleteProfessor(Professor st){Professors.remove(st);}
	public boolean UniqueId(String id_){
		boolean ret=true;
		for(Professor st:this.Professors){
			if(st.getMail().equals(id_)){
				ret=false;
			}
		}
		return ret;
	}
}
