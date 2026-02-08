package com.ent.viaSetter;

import java.util.List;

public class Student {
	String name;
	List<Subject> subjects;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Subject> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
		
	
	
	

}
