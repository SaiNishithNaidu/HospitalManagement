package com.example.Project.Model;

public class registerDoctorModel {
	private String First_Name;
	private String Last_Name;
	private String DOB;
	private String Gender;
	private String Contact_Number;
	private String Email;
	private String UserID;
	private String Password;
	private String Qualification;
	private String Speciality;
	private int Experience;
	private String Hospital_Name;
	private String Day_of_Availability;
	private String Time_of_Availability;

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

	public String getUserID() {
		return UserID;
	}

	public void setUserID(String userID) {
		UserID = userID;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
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

	public String getDay_of_Availability() {
		return Day_of_Availability;
	}

	public void setDay_of_Availability(String day_of_Availability) {
		Day_of_Availability = day_of_Availability;
	}

	public String getTime_of_Availability() {
		return Time_of_Availability;
	}

	public void setTime_of_Availability(String time_of_Availability) {
		Time_of_Availability = time_of_Availability;
	}

	@Override
	public String toString() {
		return "registerDoctorModel [First_Name=" + First_Name + ", Last_Name=" + Last_Name + ", DOB=" + DOB
				+ ", Gender=" + Gender + ", Contact_Number=" + Contact_Number + ", Email=" + Email + ", UserID="
				+ UserID + ", Password=" + Password + ", Qualification=" + Qualification + ", Speciality=" + Speciality
				+ ", Experience=" + Experience + ", Hospital_name=" + Hospital_Name + ", Day_of_Availability="
				+ Day_of_Availability + ", Time_of_Availability=" + Time_of_Availability + "]";
	}

}
