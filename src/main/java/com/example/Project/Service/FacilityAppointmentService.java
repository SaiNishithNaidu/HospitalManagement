package com.example.Project.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.Project.Model.FacilityAppointmentModel;

@Service
public class FacilityAppointmentService {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public Boolean addPatientToDatabase(FacilityAppointmentModel facilityAppointmentModel) {
		String sql = "insert into facility_appointment (Facility,Hospital_Name,Date_of_Appointment,Time_of_Appointment,Remarks_of_Doctor_Appointment)values("
				+ "\"" + facilityAppointmentModel.getFacility() + "\"" + "," + "\""+ facilityAppointmentModel.getHospital_Name() + "\"" + "," + "\""
				+ facilityAppointmentModel.getDate_of_Appointment() + "\"" + "," + "\""
				+ facilityAppointmentModel.getTime_of_Appointment() + "\"" + "," + "\""
				+ facilityAppointmentModel.getRemarks_of_Doctor_Appointment() + "\"" + ");";
		jdbcTemplate.execute(sql);
		return true;
	}
}
