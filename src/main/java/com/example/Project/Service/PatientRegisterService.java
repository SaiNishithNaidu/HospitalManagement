package com.example.Project.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.Project.Model.ViewAppointmentModel;
import com.example.Project.Model.RegisterPatientModel;

@Service
public class PatientRegisterService {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public Boolean addPatientToDatabase(RegisterPatientModel patientModel) {
		
		if(checkAlreadyRegistered(patientModel)) {
			return false;
		}else {
			String sql = "insert into register_patient (First_Name,Last_Name,DOB,Gender,Contact_Number,Email)values(" + "\""
					+ patientModel.getFirst_Name() + "\"" + "," + "\"" + patientModel.getLast_Name() + "\"" + "," + "\""
					+ patientModel.getDOB() + "\"" + "," + "\"" + patientModel.getGender() + "\"" + "," + "\""
					+ Long.parseLong(patientModel.getContact_Number()) + "\"" + "," + "\"" 
					+ patientModel.getEmail()+ "\""
					+ ");";
			jdbcTemplate.execute(sql);
			return true;
		}		
	}

	private boolean checkAlreadyRegistered(RegisterPatientModel patientModel) {
		String sql = "select * from register_patient where Email=\""+patientModel.getEmail()
		+"\" and First_Name=\""+patientModel.getFirst_Name()
		+"\" and Last_Name=\""+patientModel.getLast_Name()
		+"\" and DOB=\""+patientModel.getDOB()
		+"\" and Gender=\""+patientModel.getGender()
		+"\" and Contact_Number=\""+patientModel.getContact_Number()+"\";";
		List<RegisterPatientModel> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper(RegisterPatientModel.class));
		if(users.isEmpty()) {
			return false;
		}else {
			return true;	
		}
		
	}

	public String generateId(RegisterPatientModel patientModel) {

		String id = "something went wrong";

		List<String> userNameList = new ArrayList<>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList("select id from register_patient where First_Name=\""
				+ patientModel.getFirst_Name() + "\"" + " and Last_Name = " + "\"" + patientModel.getLast_Name() + "\""
				+ " and DOB= " + "\"" + patientModel.getDOB() + "\"" + " and Gender=" + "\"" + patientModel.getGender()
				+ "\"" + " and Contact_Number=" + "\"" + patientModel.getContact_Number() + "\"" + " and Email=" + "\""
				+ patientModel.getEmail() + "\"" + ";");
		for (Map row : rows) {
			if (true) {

				id = "PAT" + calculateLength(row.get("id").toString());
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

	public void createTable(String patient_id) {
		String sql = "create table patient_" + patient_id+"Appointments"
				+ " (id int NOT NULL AUTO_INCREMENT,PATID varchar(10),Time Time,Facility varchar(40),Date date,Status varchar(20),Remarks varchar(255),Result1 varchar(100),Result2 varchar(100),PRIMARY KEY (id));";
		jdbcTemplate.execute(sql);
		
	}

	public int checkAge(RegisterPatientModel patientModel) {
		LocalDate today = LocalDate.now();  
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate birthday = LocalDate.parse(patientModel.getDOB(), dtf);
		Period p = Period.between(birthday, today);
		return p.getYears();
	}
}
















