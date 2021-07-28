package com.example.Project.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.Project.Model.RegisterDoctorModel;
import com.example.Project.Model.RegisterHospitalAdminModel;

@Service
public class HospitalAdminRegisterService {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public Boolean addHospitalAdminToDatabase(RegisterHospitalAdminModel hospitalAdminModel) {
		
		if(checkAlreadyRegistered(hospitalAdminModel)) {
			return false;
		}else {
			String sql = "insert into register_hospitaladmin (Hospital_Name,Address_Lane1,Address_Lane2,Address_Lane3,City,State,Zip,Hospital_Contact_Number,Hospital_Fax_Number,Hospital_Website)values("
					+ "\"" + hospitalAdminModel.getHospital_Name() + "\"" + "," + "\""
					+ hospitalAdminModel.getAddress_Lane1() + "\"" + "," + "\"" + hospitalAdminModel.getAddress_Lane2()
					+ "\"" + "," + "\"" + hospitalAdminModel.getAddress_Lane3() + "\"" + "," + "\""
					+ hospitalAdminModel.getCity() + "\"" + "," + "\"" + hospitalAdminModel.getState() + "\"" + "," + "\""
					+ hospitalAdminModel.getZip() + "\"" + "," + "\"" + hospitalAdminModel.getHospital_Contact_Number()
					+ "\"" + "," + "\"" + hospitalAdminModel.getHospital_Fax_Number() + "\"" + "," + "\""
					+ hospitalAdminModel.getHospital_Website() + "\"" + ");";
			jdbcTemplate.execute(sql);
			return true;
		}
		
		
	}
	private boolean checkAlreadyRegistered(RegisterHospitalAdminModel registerHospitalModel) {
		String sql = "select * from register_hospitaladmin where Hospital_Name=\""+registerHospitalModel.getHospital_Name()
		+"\" and Address_Lane1=\""+registerHospitalModel.getAddress_Lane1()
		+"\" and Address_Lane2=\""+registerHospitalModel.getAddress_Lane2()
		+"\" and Address_Lane3=\""+registerHospitalModel.getAddress_Lane3()
		+"\" and City=\""+registerHospitalModel.getCity()
		+"\" and State=\""+registerHospitalModel.getState()
		+"\" and Zip=\""+registerHospitalModel.getZip()
		+"\" and Hospital_Contact_Number=\""+registerHospitalModel.getHospital_Contact_Number()
		+"\" and Hospital_Fax_Number=\""+registerHospitalModel.getHospital_Fax_Number()
		+"\" and Hospital_Website=\""+registerHospitalModel.getHospital_Website()+"\";";
		List<RegisterHospitalAdminModel> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper(RegisterHospitalAdminModel.class));
		if(users.isEmpty()) {
			return false;
		}else {
			return true;	
		}
		
	}

	public String generateId(RegisterHospitalAdminModel hospitalAdminModel) {

		String id = "something went wrong";

		List<String> userNameList = new ArrayList<>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(
				"select id from register_hospitaladmin where Hospital_Name=\"" + hospitalAdminModel.getHospital_Name()
						+ "\"" + " and Address_Lane1 = " + "\"" + hospitalAdminModel.getAddress_Lane1() + "\""
						+ " and Address_Lane2= " + "\"" + hospitalAdminModel.getAddress_Lane2() + "\""
						+ " and Address_Lane3=" + "\"" + hospitalAdminModel.getAddress_Lane3() + "\"" + " and City="
						+ "\"" + hospitalAdminModel.getCity() + "\"" + " and State=" + "\""
						+ hospitalAdminModel.getState() + "\"" + " and Zip = " + "\"" + hospitalAdminModel.getZip()
						+ "\"" + " and Hospital_Contact_Number = " + "\""
						+ hospitalAdminModel.getHospital_Contact_Number() + "\"" + " and Hospital_Fax_Number = " + "\""
						+ hospitalAdminModel.getHospital_Fax_Number() + "\"" + " and  Hospital_Website= " + "\""
						+ hospitalAdminModel.getHospital_Website() + "\"" + ";");

		for (Map row : rows) {
			if (true) {

				id = "HOS" + calculateLength(row.get("id").toString());
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

	public void createTable(String hospital_id) {
		String sql = "create table hospital_" + hospital_id+"Facilities"
				+ " (Facility varchar(40),Description_of_Facilities varchar(255),Remarks_of_Facilities varchar(255));";
		String sql1 = "create table hospital_" + hospital_id+"Doctors"
				+ " (id int,First_Name varchar(20),Last_Name varchar(20),DOB date,Gender varchar(10),Contact_Number long,Email varchar(30),Qualification varchar(40),Speciality varchar(30),Experience int,Hospital_Name varchar(40),DAY varchar(255),Available_From time,Available_To time,PRIMARY KEY (id))";
		String sql2 = "create table hospital_" + hospital_id+"Appointments"
				+ " (id int NOT NULL AUTO_INCREMENT,PATID varchar(10),Time Time,Facility varchar(40),Date date,Status varchar(20),Remarks varchar(255),Result1 varchar(100),Result2 varchar(100),PRIMARY KEY (id));";
		String sql3 = "create table hospital_" + hospital_id+"InPatient"
				+ " (id int NOT NULL AUTO_INCREMENT,PATID varchar(10),Patient_Name varchar(30),Gender varchar(10),Age varchar(10),Reason varchar(50),Facilities varchar(255),Doctors varchar(255),Date_Of_Joining varchar(15),Date_Of_Discharge varchar(15),Status varchar(10),PRIMARY KEY(id));";

		
		jdbcTemplate.execute(sql);
		jdbcTemplate.execute(sql1);
		jdbcTemplate.execute(sql2);
		jdbcTemplate.execute(sql3);
	}

	public List<String> getHospitalName(String id) {
		String newid = id.substring(3, id.length());
		int newid1 = Integer.parseInt(newid);
		String newid2= String.valueOf(newid1);
		String sql = "select Hospital_Name from register_hospitaladmin where id=\" " + newid2 + "\";";
		List<String> rows = jdbcTemplate.queryForList(sql,String.class);
		return rows;

	}

}
