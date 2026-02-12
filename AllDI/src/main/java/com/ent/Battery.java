package com.ent;

public class Battery {
	private int backup;
	public Battery() {
		System.out.println("Battery constructor...");
	}

	public int getBackup() {
		return backup;
	}

	public void setBackup(int backup) {
		this.backup = backup;
	}

	public String toString() {
		return ""+this.backup;
	}
}
