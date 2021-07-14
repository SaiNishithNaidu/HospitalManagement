package com.example.Project.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.Project.Model.registerHospitalAdminModel;


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
}
