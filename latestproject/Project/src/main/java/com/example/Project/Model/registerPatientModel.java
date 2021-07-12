package com.example.Project.Model;

import java.sql.Date;

public class registerPatientModel {
	private String First_Name;
	private String Last_Name;
	private String DOB;
	private String Gender;
	private String Contact_Number;
	private String Email;

	public String getFirst_Name() {
		return First_Name;
	}

	public void setFirst_Name(String first_Name) {
		First_Name = first_Name;
	}

	public String getLast_Name() {
		return Last_Name;
	}

	public void setLast_Name(String last_Name) {
		Last_Name = last_Name;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getContact_Number() {
		return Contact_Number;
	}

	public void setContact_Number(String contact_Number) {
		Contact_Number = contact_Number;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	@Override
	public String toString() {
		return "registerPatientModel [First_Name=" + First_Name + ", Last_Name=" + Last_Name + ", DOB=" + DOB
				+ ", Gender=" + Gender + ", Contact_Number=" + Contact_Number + ", Email=" + Email + "]";
	}

}
