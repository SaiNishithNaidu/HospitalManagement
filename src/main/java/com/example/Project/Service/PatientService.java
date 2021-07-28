package com.example.Project.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.Project.Model.ViewAppointmentModel;
import com.example.Project.Model.DoctorAppointmentModel;
import com.example.Project.Model.FacilityAppointmentModel;
import com.example.Project.Model.RegisterDoctorModel;
import com.example.Project.Model.RegisterHospitalAdminModel;
import com.example.Project.Model.RegisterPatientModel;


@Service
public class PatientService {

	@Autowired
	JdbcTemplate jdbcTemplate;

	
	public List<RegisterHospitalAdminModel> fetchHospitals(){
		
		List<RegisterHospitalAdminModel> hospitalNamesList = new ArrayList<>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList("select * from register_hospitaladmin");
		for (Map row : rows) {
			RegisterHospitalAdminModel r = new RegisterHospitalAdminModel();
			r.setHospital_Id(row.get("id").toString());
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
	
	
	
	public RegisterHospitalAdminModel fetchHospitalDetails(String hospitalid) {
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList("select * from register_hospitaladmin where id=\""+hospitalid+"\";");
		RegisterHospitalAdminModel r = new RegisterHospitalAdminModel();
		for (Map row : rows) {
			r.setHospital_Name(row.get("Hospital_Name").toString());
			r.setHospital_Contact_Number(row.get("Hospital_Contact_Number").toString());
			r.setHospital_Fax_Number(row.get("Hospital_Fax_Number").toString());
			r.setHospital_Website(row.get("Hospital_Website").toString());
			break;
			
		}
		return r;
	}



	public List<String> fetchFacilities(String hospitalId) {
		long k = 1000000+Integer.parseInt(hospitalId);
		String lastid = String.valueOf(k);
		String hospitalId1 = "HOS"+lastid.substring(1, lastid.length());
		List<String> rows = jdbcTemplate.queryForList("select Facility from hospital_"+hospitalId1+"Facilities"+";",String.class);
		return rows;
	}
	
	
	public List<String> fetchDoctorID(String hospitalid) {
		long k = 1000000+Integer.parseInt(hospitalid);
		String lastid = String.valueOf(k);
		String hospitalId1 = "HOS"+lastid.substring(1, lastid.length());
		List<String> rows = jdbcTemplate.queryForList("select id from hospital_"+hospitalId1+"Doctors"+";",String.class);
		return rows;
	}



	public List<String> fetchFacilitiesDetails(String facilityName,String HospitalID) {
		long k = 1000000+Integer.parseInt(HospitalID);
		String lastid = String.valueOf(k);
		String hospitalId1 = "HOS"+lastid.substring(1, lastid.length());
		List<String> rows = jdbcTemplate.queryForList("select Description_of_Facilities from hospital_"+hospitalId1+"Facilities"+" where Facility=\""+facilityName+"\""+";",String.class);
		
		return rows;
	}



	public List<RegisterDoctorModel> fetchDoctorFromTable(List<String> k) {
		List<RegisterDoctorModel> s = new ArrayList<RegisterDoctorModel>();
		for(String r:k) {
			List<RegisterDoctorModel> users= jdbcTemplate.query("select * from register_doctor where id=\""+r+"\";", new BeanPropertyRowMapper(RegisterDoctorModel.class));
			s.addAll(users);
		}
		return s;
	}









	public String checkHospitalNameAvaliable(String hospital_Name) {
		List<String> users= jdbcTemplate.queryForList("select id from register_hospitaladmin where Hospital_Name =\""+hospital_Name+"\";",String.class);
		if(users.isEmpty()) {
			return "";
		}else {
			return users.get(0).toString();
		}
	}



	public void BookAppointmentFacility(FacilityAppointmentModel facilityAppointmentModel, String hospitalId,String patientId) {

		String id = calculateLength(hospitalId);
		String sql = "insert into hospital_HOS"+id+"Appointments"+" (PATID,Time,Facility,Date,Status,Remarks)values("
				+ "\"" + patientId + "\"" + "," + "\""
				+ facilityAppointmentModel.getTime_of_Appointment() + "\"" + "," + "\""
				+ facilityAppointmentModel.getFacility() + "\"" + "," + "\""
				+ facilityAppointmentModel.getDate_of_Appointment()+ "\"" + "," + "\""
				+ "pending" + "\"" + "," + "\""
				+ facilityAppointmentModel.getRemarks_of_Facility_Appointment()+ "\"" + ");";
		String sql1 = "insert into patient_"+patientId+"Appointments"+" (PATID,Time,Facility,Date,Status,Remarks)values("
				+ "\"" + patientId + "\"" + "," + "\""
				+ facilityAppointmentModel.getTime_of_Appointment() + "\"" + "," + "\""
				+ facilityAppointmentModel.getFacility() + "\"" + "," + "\""
				+ facilityAppointmentModel.getDate_of_Appointment()+ "\"" + "," + "\""
				+ "pending" + "\"" + "," + "\""
				+ facilityAppointmentModel.getRemarks_of_Facility_Appointment()+ "\"" + ");";
		String facilities = facilityAppointmentModel.getFacility()+",";
		String sql2 ="update hospital_HOS"+id+"InPatient set Facilities = concat(Facilities,\""+facilities+"\") where PATID=\""+patientId+"\" and Status = \"Active\";";
		jdbcTemplate.execute(sql);
		jdbcTemplate.execute(sql1);
		jdbcTemplate.execute(sql2);
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



	public List<ViewAppointmentModel> viewAppointments(String patientId) {
		String sql = "select * from patient_"+patientId+"appointments";
		List<ViewAppointmentModel> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper(ViewAppointmentModel.class));
		return users;
	}



	public List<String> RetriveDoctorsIdsFromHospital(String hospital_Id) {
		String hospitalId = calculateLength(hospital_Id);
		List<String> users= jdbcTemplate.queryForList("select id from  hospital_HOS"+hospitalId+"Doctors;",String.class);
		if(users.isEmpty()) {
			return null;
		}else {
			return users;
		}
	}



	public List<RegisterDoctorModel> RetiveDoctorsNameFromHospital(List<String> doctorIds, String hospitalId) {
		List<RegisterDoctorModel> doctors = new ArrayList<RegisterDoctorModel>();
		for(String id:doctorIds) {
			String sql = "select * from register_doctor where id = "+id+";";
			List<RegisterDoctorModel> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper(RegisterDoctorModel.class));
			doctors.addAll(users);
		}
		return doctors;
	}



	public void BookAppointmentDoctor(DoctorAppointmentModel doctorAppointmentModel, String doctorId, String patientId,String hospitalId) {
		
		String id = calculateLength(doctorId);
		String sql = "insert into doctor_DOC"+id+"Appointments"+" (PATID,Time,Facility,Date,Status,Remarks)values("
				+ "\"" + patientId + "\"" + "," + "\""
				+ doctorAppointmentModel.getTime_of_Appointment() + "\"" + "," + "\""
				+ doctorAppointmentModel.getDoctor_Name() + "\"" + "," + "\""
				+ doctorAppointmentModel.getDate_of_Appointment()+ "\"" + "," + "\""
				+ "pending" + "\"" + "," + "\""
				+ doctorAppointmentModel.getRemarks_of_Doctor_Appointment()+ "\"" + ");";
		String sql1 = "insert into patient_"+patientId+"Appointments"+" (PATID,Time,Facility,Date,Status,Remarks)values("
				+ "\"" + patientId + "\"" + "," + "\""
				+ doctorAppointmentModel.getTime_of_Appointment() + "\"" + "," + "\""
				+ doctorAppointmentModel.getDoctor_Name()+ "\"" + "," + "\""
				+ doctorAppointmentModel.getDate_of_Appointment()+ "\"" + "," + "\""
				+ "pending" + "\"" + "," + "\""
				+ doctorAppointmentModel.getRemarks_of_Doctor_Appointment()+ "\"" + ");";
		String doctor_ID = "DOC"+calculateLength(doctorId)+",";
		String sql2 ="update hospital_HOS"+calculateLength(hospitalId)+"InPatient set doctors = concat(doctors,\""+doctor_ID+"\") where PATID=\""+patientId+"\" and Status = \"Active\";";
		jdbcTemplate.execute(sql);
		jdbcTemplate.execute(sql1);
		jdbcTemplate.execute(sql2);
		
	}



	public boolean checkFacilityAvaliable(FacilityAppointmentModel facilityAppointmentModel, String hospitalId) {
		String hospital_Id = calculateLength(hospitalId);
		List<String> users= jdbcTemplate.queryForList("select Facility from  hospital_HOS"+hospital_Id+"facilities where Facility=\""+facilityAppointmentModel.getFacility()+"\";",String.class);
		if(users.isEmpty()) {
			return false;
		}else {
			return true;
		}
	}



	public String checkDoctorAvaliable(DoctorAppointmentModel doctorAppointmentModel, String hospitalId) {
		String hospital_Id = calculateLength(hospitalId);
		List<String> users= jdbcTemplate.queryForList("select id from  hospital_HOS"+hospital_Id+"doctors where First_Name=\""+doctorAppointmentModel.getDoctor_Name()+"\";",String.class);
		if(users.isEmpty()) {
			return null;
		}else {
			return users.get(0);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
