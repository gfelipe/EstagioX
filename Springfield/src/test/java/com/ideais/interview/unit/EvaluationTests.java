package com.ideais.interview.unit;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.ideais.interview.Grades;
import com.ideais.interview.Evaluation;
import com.ideais.interview.Project;
import com.ideais.interview.Student;

@RunWith(JUnit4.class)
public class EvaluationTests {
	
	private Evaluation evaluation;
	private List<Student> students;
	
	@Before
	public void setUp() {
		evaluation = new Evaluation();
		students = new ArrayList<Student>();
		
		Student bart = new Student("bart", new Project(new Grades(1,1,1)), false);
		Student milhouse = new Student("milhouse", new Project(new Grades(1,1,2)), false);
		
		students.add(bart);
		students.add(milhouse);
	}
	
	@Test
	public void evaluate_criterion_1_test() {
		Assert.assertEquals(1 , evaluation.evaluateCriterion1(1));
	}
	
	@Test
	public void evaluate_criterion_2_test() {
		Assert.assertEquals(2, evaluation.evaluateCriterion2(1));
	}
	
	@Test
	public void evaluate_criterion_3_test() {
		Assert.assertEquals(3, evaluation.evaluateCriterion3(1));
	}
	
	@Test
	public void get_final_grade_test() {
		Assert.assertEquals(6, evaluation.evaluateFinalGrade(new Grades(1,1,1)));
	}
	
	@Test
	public void get_winner_test() {
		Student winner = null;
		
		try { 
			winner = evaluation.getWinner(students);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		
		Assert.assertEquals("milhouse", winner.getName());
	}
	
	@Test
	public void null_students_list_test() {
		students = null;
		
		try { 
			evaluation.getWinner(students);
			Assert.fail("Deveria ter lançado exceção");
		} catch (Exception e) {
			Assert.assertEquals("Lista de estudantes está nula.", e.getMessage());
		}
	}
	
	@Test
	public void empty_students_list_test() {
		students = new ArrayList<Student>();
		
		try { 
			evaluation.getWinner(students);
			Assert.fail("Deveria ter lançado exceção");
		} catch (Exception e) {
			Assert.assertEquals("Lista de estudantes está vazia.", e.getMessage());
		}
	}
	
	@Test
	public void check_winner_one_friend_of_mr_burn_test() {
		Student lisa = new Student ("lisa", new Project(new Grades(0,0,0)), true);
		students.add(lisa);
		
		Student winner = null;
		
		try {
			winner = evaluation.getWinner(students);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		
		Assert.assertEquals("lisa", winner.getName());
	}
	
	@Test
	public void check_winner_two_friends_of_mr_burn_test() {
		Student lisa = new Student ("lisa", new Project(new Grades(0,0,0)), true);
		students.add(lisa);
		Student margie = new Student ("margie", new Project(new Grades(0,0,1)), true);
		students.add(margie);
		
		Student winner = null;
		
		try {
			winner = evaluation.getWinner(students);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		
		Assert.assertEquals("margie", winner.getName());
		
	}
}
