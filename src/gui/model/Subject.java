package gui.model;

import java.util.ArrayList;


enum Semester {SUMMER, WINTER}
enum YearOfStudy{I, II, III, IV}

public class Subject {
	// POLJA
	
				private String id;
				private String name_of_sub;
				private Semester semester;
				private YearOfStudy yearOfStudy;
				private String profesor;
				private int points;
				private String polozeni;
				private String nepolozeni;
				private ArrayList<Student> passed = new ArrayList<Student>();
				private ArrayList<Student> failed = new ArrayList<Student>();
				public String getId() {
					return id;
				}
				public void setId(String id) {
					this.id = id;
				}
				public String getName_of_sub() {
					return name_of_sub;
				}
				public void setName_of_sub(String name_of_sub) {
					this.name_of_sub = name_of_sub;
				}
				public Semester getSemester() {
					return semester;
				}
				public void setSemester(Semester semester) {
					this.semester = semester;
				}
				public String getProfesor() {
					return profesor;
				}
				public void setProfesor(String profesor) {
					this.profesor = profesor;
				}
				public int getPoints() {
					return points;
				}
				public void setPoints(int points) {
					this.points = points;
				}
				
				public ArrayList<Student> getPassed() {
					return passed;
				}
				public void setPassed(ArrayList<Student> passed) {
					this.passed = passed;
				}
				public ArrayList<Student> getFailed() {
					return failed;
				}
				public void setFailed(ArrayList<Student> failed) {
					this.failed = failed;
				}
				@Override
				public String toString() {
					return "Subject [id=" + id + ", name_of_sub=" + name_of_sub + ", semester=" + semester
							+ ", yearOfStudy=" + yearOfStudy + ", profesor=" + profesor + ", points=" + points
							+ ", polozeni=" + polozeni + ", nepolozeni=" + nepolozeni + ", passed=" + passed
							+ ", failed=" + failed + "]";
				}
				
				
	
}
