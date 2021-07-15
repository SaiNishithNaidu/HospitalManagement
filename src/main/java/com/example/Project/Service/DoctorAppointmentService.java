package com.example.Project.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.Project.Model.DoctorAppointmentModel;

@Service
public class DoctorAppointmentService {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public Boolean addPatientToDatabase(DoctorAppointmentModel doctorAppointmentModel) {
		String sql = "insert into doctor_appointment (Hospital_Name,Date_of_Appointment,Time_of_Appointment,Remarks_of_Doctor_Appointment)values("
				+ "\"" + doctorAppointmentModel.getHospital_Name() + "\"" + "," + "\""
				+ doctorAppointmentModel.getDate_of_Appointment() + "\"" + "," + "\""
				+ doctorAppointmentModel.getTime_of_Appointment() + "\"" + "," + "\""
				+ doctorAppointmentModel.getRemarks_of_Doctor_Appointment() + "\"" + ");";
		jdbcTemplate.execute(sql);
		return true;
	}
}
