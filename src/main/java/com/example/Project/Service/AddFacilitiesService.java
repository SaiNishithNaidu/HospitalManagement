package com.example.Project.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.Project.Model.AddFacilitiesModel;
import com.example.Project.Model.DoctorAppointmentModel;

@Service
public class AddFacilitiesService {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public Boolean addFacilitiesToDatabase(AddFacilitiesModel addFacilitiesModel) {
		String sql = "insert into add_facilities (Facility,Description_of_Facilities,Remarks_of_Facilities)values("
				+ "\"" + addFacilitiesModel.getFacility() + "\"" + "," + "\""
				+ addFacilitiesModel.getDescription_of_Facilities() + "\"" + "," + "\""
				+ addFacilitiesModel.getRemarks_of_Facilities() + "\"" + ");";
		jdbcTemplate.execute(sql);
		return true;
	}
}
