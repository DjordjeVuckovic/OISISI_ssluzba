package model;

import java.util.Date;
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
		this.colums.add("Name");
		this.colums.add("Surname");
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

	public Object getValueAt(int rowIndex, int columnIndex) {
		Professor pr=this.professors.get(rowIndex);
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
	public void AddProfessor(Professor pr){
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

	
	public void editProfessor(String Name, String Surname, Date datum, Adress adresa_stanovanja, String kontakt_telefon,String email_adresa, String id, int godine_staza, String titula) {
		for (Professor i : professors) {
			if (i.getIdNumber().equals(id)) {
				i.setName(Name);
				i.setSurname(Surname);
				i.setBirthday(datum);
				i.setAdress(adresa_stanovanja);
				i.setContact(kontakt_telefon);
				i.setMail(email_adresa);
				i.setIdNumber(id) ;
				i.setGodStaza(godine_staza);
				i.setTitle(titula);
			}
		}
		try {
			for (Professor i : professors) {
				if (i.getIdNumber().equals(id)) {
					i.setName(Name);
					i.setSurname(Surname);
					i.setBirthday(datum);
					i.setAdress(adresa_stanovanja);
					i.setContact(kontakt_telefon);
					i.setMail(email_adresa);
					i.setIdNumber(id);
					i.setGodStaza(godine_staza);
					i.setTitle(titula);
					
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
}
