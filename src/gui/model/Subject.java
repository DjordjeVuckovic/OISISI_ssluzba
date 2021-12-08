package gui.model;

import java.util.ArrayList;


enum Semester {SUMMER, WINTER}
enum YearOfStudy{I, II, III, IV}

public class Subject {
	// POLJA
	
				private String id;
				private String nameSub;
				private Semester semester;
				private YearOfStudy yearOfStudy;
				private String profesor;
				private int points;
				private ArrayList<Student> passed = new ArrayList<Student>();
				private ArrayList<Student> failed = new ArrayList<Student>();
				public String getId() {
					return id;
				}
				public void setId(String id) {
					this.id = id;
				}
				public String getName_of_sub() {
					return nameSub;
				}
				public void setName_of_sub(String name_of_sub) {
					this.nameSub = name_of_sub;
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
					return "Subject [id=" + id + ", name_of_sub=" + nameSub + ", semester=" + semester
							+ ", yearOfStudy=" + yearOfStudy + ", profesor=" + profesor + ", points=" + points
							+ ", passed=" + passed + ", failed=" + failed + "]";
				}
				
				
				
	
}
