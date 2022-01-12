package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Grade {
	private Student studentPassed;
	private Subject subject;
	private int grade;
	private Date examDate;
	
	public Grade(Student student, Subject subject, int vrednost, Date datumPolaganja) {
		// TODO Auto-generated constructor stub
	}

	public void setGrade(int gr) {
		if(gr>=6 && gr<=10) {
			grade = gr;
		}else {
		 throw new IllegalArgumentException("Unexpected value: " + gr);
		}
		
	}

	public Student getStudentPassed() {
		return studentPassed;
	}

	public void setStudentPassed(Student studentPassed) {
		this.studentPassed = studentPassed;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Date getExamDate() {
		return examDate;
	}

	public String getExamDateString(){
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		return dateFormat.format(examDate);
	}

	public int getGrade() {
		return grade;
	}

}
