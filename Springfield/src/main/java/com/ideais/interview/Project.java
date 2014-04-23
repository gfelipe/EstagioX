package com.ideais.interview;


public class Project {
	
	private Grades grades;
	private int finalGrade;
	
	public Project(Grades grades) {
		this.grades = grades;
	}

	public int getFinalGrade() {
		return finalGrade;
	}

	public void setFinalGrade(int finalGrade) {
		this.finalGrade = finalGrade;
	}

	public Grades getGrades() {
		return grades;
	}
}
