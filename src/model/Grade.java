package gui.model;

import java.util.Date;

import gui.model.Student;
import gui.model.Subject;

public class Grade {
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

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

	public int getGrade() {
		return grade;
	}

}
