package com.example.Project.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.Project.Model.registerHospitalAdminModel;

@Service
public class HospitalAdminRegisterService {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public Boolean addHospitalAdminToDatabase(registerHospitalAdminModel hospitalAdminModel) {
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

	public String generateId(registerHospitalAdminModel hospitalAdminModel) {

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
		String sql = "create table hospital_" + hospital_id
				+ " (Facilities varchar(20),FacilitiesDetails varchar(255),DoctorsIdAvaliable int);";
		jdbcTemplate.execute(sql);
	}

	public List<String> getHospitalName(String id) {
		String newid = id.substring(3, id.length());
		int newid1 = Integer.parseInt(newid);
		String newid2= String.valueOf(newid1);
		String sql = "select Hospital_Name from register_hospitaladmin where id=\" " + newid2 + "\";";
		List<String> rows = jdbcTemplate.queryForList(sql,String.class);
		System.out.println("id"+id);
		System.out.println("newid"+newid);
		System.out.println("newid1"+newid1);
		System.out.println("rows"+rows.toString());
		return rows;

	}

}
