package com.example.Project.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.Project.Model.RegisterDoctorModel;

@Service
public class DoctorRegisterService {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public Boolean addDoctorToDatabase(RegisterDoctorModel doctorModel) {
		if(checkAlreadyRegistered(doctorModel)) {
			return false;
		}else{
			String sql = "insert into register_doctor (First_Name,Last_Name,DOB,Gender,Contact_Number,Email,Qualification,Speciality,Experience,Hospital_Name,DAY,Available_From,Available_To)values(" + "\""
					+ doctorModel.getFirst_Name() + "\"" + "," + "\"" + doctorModel.getLast_Name() + "\"" + "," + "\""
					+ doctorModel.getDOB() + "\"" + "," + "\"" + doctorModel.getGender() + "\"" + "," + "\""
					+ Long.parseLong(doctorModel.getContact_Number()) + "\"" + "," + "\"" + doctorModel.getEmail() + "\""
					+ "," + "\"" + doctorModel.getQualification() + "\"" + "," + "\"" + doctorModel.getSpeciality() + "\""
					+ "," + "\"" + doctorModel.getExperience() + "\"" + "," + "\"" + doctorModel.getHospital_Name() + "\""
					+ "," + "\"" + doctorModel.getDAY() + "\"" + "," + "\""
					+ doctorModel.getAvailable_From() + "\"" + "," + "\""
					+ doctorModel.getAvailable_To() + "\"" + ");";
			jdbcTemplate.execute(sql);
			return true;
		}
	}
	
	private boolean checkAlreadyRegistered(RegisterDoctorModel doctorModel) {
		String sql = "select * from register_doctor where First_Name=\""+doctorModel.getFirst_Name()
		+"\" and Last_Name=\""+doctorModel.getLast_Name()
		+"\" and DOB=\""+doctorModel.getDOB()
		+"\" and Gender=\""+doctorModel.getGender()
		+"\" and Contact_Number=\""+doctorModel.getContact_Number()
		+"\" and Email=\""+doctorModel.getEmail()
		+"\" and Qualification=\""+doctorModel.getQualification()
		+"\" and Speciality=\""+doctorModel.getSpeciality()
		+"\" and Experience=\""+doctorModel.getExperience()
		+"\" and DAY=\""+doctorModel.getDAY()
		+"\" and Available_From=\""+doctorModel.getAvailable_From()
		+"\" and Available_To=\""+doctorModel.getAvailable_To()+"\";";
		List<RegisterDoctorModel> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper(RegisterDoctorModel.class));
		if(users.isEmpty()) {
			return false;
		}else {
			return true;	
		}
		
	}

	public String generateId(RegisterDoctorModel doctorModel) {

		String id = "something went wrong";

		List<String> userNameList = new ArrayList<>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList("select id from register_doctor where First_Name=\""
				+ doctorModel.getFirst_Name() + "\"" + " and Last_Name = " + "\"" + doctorModel.getLast_Name() + "\""
				+ " and DOB= " + "\"" + doctorModel.getDOB() + "\"" + " and Gender=" + "\"" + doctorModel.getGender()
				+ "\"" + " and Contact_Number=" + "\"" + doctorModel.getContact_Number() + "\"" + " and Email=" + "\""
				+ doctorModel.getEmail() + "\"" + " and Qualification = " + "\"" + doctorModel.getQualification() + "\""
				+ " and Speciality = " + "\"" + doctorModel.getSpeciality() + "\"" + " and Experience = " + "\""
				+ doctorModel.getExperience() + "\"" + " and Hospital_Name = " + "\"" + doctorModel.getHospital_Name()
				+ "\"" + " and DAY = " + "\"" + doctorModel.getDAY() + "\""
				+ " and Available_From = " + "\"" + doctorModel.getAvailable_From()+ "\""
				+ " and Available_To = " + "\"" + doctorModel.getAvailable_To() + "\"" + ";");

		for (Map row : rows) {
			if (true) {
				id = "DOC" + calculateLength(row.get("id").toString());
				break;
			}
		}
		return id;
	}

	private String calculateLength(String s) {

		String id = "";
		if (s.length() == 1) {
			id = "00000" + s;
		}
		if (s.length() == 2) {
			id = "0000" + s;
		}
		if (s.length() == 3) {
			id = "000" + s;
		}
		if (s.length() == 4) {
			id = "00" + s;
		}
		if (s.length() == 5) {
			id = "0" + s;
		}
		if (s.length() >= 6) {
			id = s;
		}
		return id;

	}

	public void createTable(String id) {
		String sql = "create table doctor_" +id+"Appointments"
				+ " (id int NOT NULL AUTO_INCREMENT,PATID varchar(10),Time Time,Facility varchar(40),Date date,Status varchar(20),Remarks varchar(255),Result1 varchar(100),Result2 varchar(100),PRIMARY KEY (id));";
		jdbcTemplate.execute(sql);
		
	}
}
