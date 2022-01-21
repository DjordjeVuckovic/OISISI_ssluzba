package model;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;



public class Department implements Serializable {
	@Serial
	private static final long serialVersionUID = 6732445630585765214L;

	private String id;
	private String sifra;
	private String name;
	private Professor director;
	private ArrayList<Professor> professors = new ArrayList<Professor>();
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSifra() {
		return sifra;
	}
	public void setSifra(String sifra) {
		this.sifra = sifra;
	}
	public Professor getDirector() {
		return director;
	}
	public void setDirector(Professor director) {
		this.director = director;
	}
	
	public ArrayList<Professor> getProfessor_list() {
		return professors;
	}
	public void setProfessor_list(ArrayList<Professor> professor_list) {
		this.professors = professor_list;
	}

	public Department(){};
	
	public Department(String id, String sifra, String name, String idD) {
		this.id = id;
		this.sifra = sifra;
		this.name = name;
		
		
	}

	
	

}
