package com.ideais.interview;

import java.util.ArrayList;
import java.util.List;

public class Evaluation {

	private static final int CRITERION_1_WEIGHT = 1;
	private static final int CRITERION_2_WEIGHT = 2;
	private static final int CRITERION_3_WEIGHT = 3;

	public int evaluateCriterion1(int grade) {
		return grade * CRITERION_1_WEIGHT;
	}

	public int evaluateCriterion2(int grade) {
		return grade * CRITERION_2_WEIGHT;
	}

	public int evaluateCriterion3(int grade) {
		return grade * CRITERION_3_WEIGHT;
	}

	public int evaluateFinalGrade(Grades grades) {
		int finalGrade1 = evaluateCriterion1(grades.getGrade1());
		int finalGrade2 = evaluateCriterion2(grades.getGrade2());
		int finalGrade3 = evaluateCriterion3(grades.getGrade3());
		
		return finalGrade1 + finalGrade2 + finalGrade3;
	}

	public Student getWinner(List<Student> students) throws Exception {

		if (students == null) {
			throw new NullPointerException("Lista de estudantes está nula.");
		} else if (students.size() < 1) {
			throw new Exception("Lista de estudantes está vazia.");
		}
		
		List <Student> friendsWithMrBurns = new ArrayList<Student>();
		
		for (Student student : students) {
			if(student.getFriendsWithMrBurns()) {
				friendsWithMrBurns.add(student);
			}
		}
		
		Student winningStudent;
		
		if (friendsWithMrBurns.size() > 1) {
			winningStudent = checkWinner(friendsWithMrBurns);
		} else if (friendsWithMrBurns.size() == 1) {
			winningStudent = friendsWithMrBurns.get(0); 
		} else {
			winningStudent = checkWinner(students);
		}
		
		return winningStudent;
	}

	private Student checkWinner(List<Student> students) {
		Student winningStudent = students.get(0);
		winningStudent.getProject().setFinalGrade(evaluateFinalGrade(winningStudent.getProject().getGrades()));
		
		for (Student student : students) {
			student.getProject().setFinalGrade(evaluateFinalGrade(student.getProject().getGrades()));
			if (student.getProject().getFinalGrade() > winningStudent.getProject().getFinalGrade()) {
				winningStudent = student;
			}
		}
		return winningStudent;
	}
}
