package com.example.Project.Model;

public class DoctorAppointmentModel {

	private String Hospital_Name;
	private String Doctor_Name;
	private String Date_of_Appointment;
	private String Time_of_Appointment;
	private String Remarks_of_Doctor_Appointment;
	/**
	 * @return the hospital_Name
	 */
	public String getHospital_Name() {
		return Hospital_Name;
	}
	/**
	 * @param hospital_Name the hospital_Name to set
	 */
	public void setHospital_Name(String hospital_Name) {
		Hospital_Name = hospital_Name;
	}
	/**
	 * @return the date_of_Appointment
	 */
	public String getDoctor_Name() {
		return Doctor_Name;
	}
	public void setDoctor_Name(String doctor_Name) {
		Doctor_Name = doctor_Name;
	}
	public String getDate_of_Appointment() {
		return Date_of_Appointment;
	}
	/**
	 * @param date_of_Appointment the date_of_Appointment to set
	 */
	public void setDate_of_Appointment(String date_of_Appointment) {
		Date_of_Appointment = date_of_Appointment;
	}
	/**
	 * @return the time_of_Appointment
	 */
	public String getTime_of_Appointment() {
		return Time_of_Appointment;
	}
	/**
	 * @param time_of_Appointment the time_of_Appointment to set
	 */
	public void setTime_of_Appointment(String time_of_Appointment) {
		Time_of_Appointment = time_of_Appointment;
	}
	/**
	 * @return the remarks_of_Doctor_Appointment
	 */
	public String getRemarks_of_Doctor_Appointment() {
		return Remarks_of_Doctor_Appointment;
	}
	/**
	 * @param remarks_of_Doctor_Appointment the remarks_of_Doctor_Appointment to set
	 */
	public void setRemarks_of_Doctor_Appointment(String remarks_of_Doctor_Appointment) {
		Remarks_of_Doctor_Appointment = remarks_of_Doctor_Appointment;
	}
	@Override
	public String toString() {
		return "DoctorAppointmentModel [Hospital_Name=" + Hospital_Name + ", Doctor_Name=" + Doctor_Name
				+ ", Date_of_Appointment=" + Date_of_Appointment + ", Time_of_Appointment=" + Time_of_Appointment
				+ ", Remarks_of_Doctor_Appointment=" + Remarks_of_Doctor_Appointment + "]";
	}



}
