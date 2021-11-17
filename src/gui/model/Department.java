package gui.model;

import java.util.ArrayList;



public class Department {
	private String id;
	private String name;
	private Professor director;
	private ArrayList<Professor> professor_list = new ArrayList<Professor>();
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
	public Professor getDirector() {
		return director;
	}
	public void setDirector(Professor director) {
		this.director = director;
	}
	public ArrayList<Professor> getProfessor_list() {
		return professor_list;
	}
	public void setProfessor_list(ArrayList<Professor> professor_list) {
		this.professor_list = professor_list;
	}
	
	

}
