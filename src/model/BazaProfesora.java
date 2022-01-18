package model;

import java.util.ArrayList;
import java.util.Date;

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

		Professor pr = new Professor("Milan","Milic",Zvanje.DOCENT,"dsa@asdas");
		Professors.add(pr);
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
		Professor pr=this.Professors.get(rowIndex);
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
}
