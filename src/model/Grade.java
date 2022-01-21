package model;

import java.io.Serial;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Grade implements Serializable {
	@Serial
	private static final long serialVersionUID = 8630380230244350235L;
	private Student studentPassed;
	private Subject subject;
	private int grade;
	private Date examDate;
	
	public void setGrade(int gr) {
		if(gr>=6 && gr<=10) {
			grade = gr;
		}else {
		 throw new IllegalArgumentException("Unexpected value: " + gr);
		}
		
	}

	public Grade(Student studentPassed, Subject subject, int grade, Date examDate) {
		this.studentPassed = studentPassed;
		this.subject = subject;
		this.grade = grade;
		this.examDate = examDate;
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
