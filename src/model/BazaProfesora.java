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
		Professors.add(new Professor("Mika", "Mikic", Zvanje.SARADNIK_U_NASTAVI, "mika@gmail.com"));
		Professors.add(new Professor("Vladimir", "Radic", Zvanje.ASISTENT, "vladimir@gmail.com"));
		Professors.add(new Professor("Marko", "Markic", Zvanje.DOCENT , "milos@gmail.com"));
		Professors.add(new Professor("Darko", "Darkic", Zvanje.ASISTENT_SA_DOKTORATOM, "minjule@gmail.com"));
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
	public void addProfessor(Professor st){
		Professors.add(st);
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
}
