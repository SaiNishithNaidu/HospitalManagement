package com.example.Project.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.Project.Model.registerDoctorModel;
import com.example.Project.Model.registerHospitalAdminModel;
import com.example.Project.Model.registerPatientModel;


@Service
public class PatientService {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<registerHospitalAdminModel> fetchHospitals(){
		
		List<registerHospitalAdminModel> hospitalNamesList = new ArrayList<>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList("select * from register_hospitaladmin");
		for (Map row : rows) {
			registerHospitalAdminModel r = new registerHospitalAdminModel();
			r.setHospital_Name(row.get("Hospital_Name").toString());
			r.setAddress_Lane1(row.get("Address_Lane1").toString());
			r.setAddress_Lane2(row.get("Address_Lane2").toString());
			r.setAddress_Lane3(row.get("Address_Lane3").toString());
			r.setCity(row.get("City").toString());
			r.setState(row.get("State").toString());
			hospitalNamesList.add(r);
		}
		return hospitalNamesList;
	}
	
	
	
	public registerHospitalAdminModel fetchHospitalDetails(String hospitalName) {
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList("select * from register_hospitaladmin where Hospital_Name=\""+hospitalName+"\";");
		registerHospitalAdminModel r = new registerHospitalAdminModel();
		for (Map row : rows) {
			r.setHospital_Name(row.get("Hospital_Name").toString());
			r.setHospital_Contact_Number(row.get("Hospital_Contact_Number").toString());
			r.setHospital_Fax_Number(row.get("Hospital_Fax_Number").toString());
			r.setHospital_Website(row.get("Hospital_Website").toString());
			break;
			
		}
		return r;
	}



	public List<String> fetchFacilities(String hospitalName) {
		
		List<String> rows = jdbcTemplate.queryForList("select Facilities from hospital_"+hospitalName+";",String.class);
		
		return rows;
	}
	
	
	public List<String> fetchDoctorID(String hospitalName) {
		
		List<String> rows = jdbcTemplate.queryForList("select DoctorsIdAvaliable from hospital_"+hospitalName+";",String.class);
		
		return rows;
	}



	public List<String> fetchFacilitiesDetails(String facilityName,String HospitalID) {
		// TODO Auto-generated method stub
		List<String> rows = jdbcTemplate.queryForList("select FacilitiesDetails from hospital_"+HospitalID+" where Facilities=\""+facilityName+"\""+";",String.class);
		
		return rows;
	}



	public List<registerDoctorModel> fetchDoctorFromTable(List<String> k) {
		List<registerDoctorModel> s = new ArrayList<registerDoctorModel>();
		for(String r:k) {
			List<registerDoctorModel> users= jdbcTemplate.query("select * from register_doctor where id=\""+r+"\";", new BeanPropertyRowMapper(registerDoctorModel.class));
			s.addAll(users);
		}
		return s;
	}

}
