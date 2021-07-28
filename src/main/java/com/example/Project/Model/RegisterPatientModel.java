package com.example.Project.Model;

import java.sql.Date;

public class RegisterPatientModel {
	private String id;
	private String First_Name;
	private String Last_Name;
	private String DOB;
	private String Gender;
	private String Contact_Number;
	private String Email;
	private String Security_Question;
	private String Answer;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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
	public String getSecurity_Question() {
		return Security_Question;
	}

	public void setSecurity_Question(String security_Question) {
		Security_Question = security_Question;
	}

	public String getAnswer() {
		return Answer;
	}

	public void setAnswer(String answer) {
		Answer = answer;
	}

	@Override
	public String toString() {
		return "RegisterPatientModel [id=" + id + ", First_Name=" + First_Name + ", Last_Name=" + Last_Name + ", DOB="
				+ DOB + ", Gender=" + Gender + ", Contact_Number=" + Contact_Number + ", Email=" + Email
				+ ", Security_Question=" + Security_Question + ", Answer=" + Answer + "]";
	}

	
	
}
