package com.ideais.interview;

public class Student {
	
	private String name;
	private Project project;
	private Boolean friendsWithMrBurns;

	public Student(String name, Project project, Boolean friendsWithMrBurns) {
		this.name = name;
		this.project = project;
		this.friendsWithMrBurns = friendsWithMrBurns;
	}

	public String getName() {
		return name;
	}

	public Project getProject() {
		return project;
	}

	public Boolean getFriendsWithMrBurns() {
		return friendsWithMrBurns;
	}
}
