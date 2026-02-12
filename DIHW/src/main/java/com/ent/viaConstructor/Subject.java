package com.ent.viaConstructor;

public class Subject {
	private int id;
	private String subname;
	
	public Subject(int id, String subname) {
		this.id = id;
		this.subname = subname;
	}
	
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public String getSubname() {
//		return subname;
//	}
//	public void setSubname(String subname) {
//		this.subname = subname;
//	}
	
	@Override
	public String toString() {
		return "Subject [id=" + id + ", subname=" + subname + "]";
	}
}
