package com.example.Project.Model;

public class RegisterDoctorModel {
	private String id;
	private String First_Name;
	private String Last_Name;
	private String DOB;
	private String Gender;
	private String Contact_Number;
	private String Email;
	private String Qualification;
	private String Speciality;
	private int Experience;
	private String Hospital_Name;
	private String DAY;
	private String Available_From;
	private String Available_To;
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

	public String getQualification() {
		return Qualification;
	}

	public void setQualification(String qualification) {
		Qualification = qualification;
	}

	public String getSpeciality() {
		return Speciality;
	}

	public void setSpeciality(String speciality) {
		Speciality = speciality;
	}

	public int getExperience() {
		return Experience;
	}

	public void setExperience(int experience) {
		Experience = experience;
	}

	public String getHospital_Name() {
		return Hospital_Name;
	}

	public void setHospital_Name(String hospital_Name) {
		Hospital_Name = hospital_Name;
	}

	public String getDAY() {
		return DAY;
	}

	public void setDAY(String dAY) {
		DAY = dAY;
	}

	public String getAvailable_From() {
		return Available_From;
	}

	public void setAvailable_From(String available_From) {
		Available_From = available_From;
	}

	public String getAvailable_To() {
		return Available_To;
	}

	public void setAvailable_To(String available_To) {
		Available_To = available_To;
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
		return "RegisterDoctorModel [id=" + id + ", First_Name=" + First_Name + ", Last_Name=" + Last_Name + ", DOB="
				+ DOB + ", Gender=" + Gender + ", Contact_Number=" + Contact_Number + ", Email=" + Email
				+ ", Qualification=" + Qualification + ", Speciality=" + Speciality + ", Experience=" + Experience
				+ ", Hospital_Name=" + Hospital_Name + ", DAY=" + DAY + ", Available_From=" + Available_From
				+ ", Available_To=" + Available_To + ", Security_Question=" + Security_Question + ", Answer=" + Answer
				+ "]";
	}

	
	
	


	



}
