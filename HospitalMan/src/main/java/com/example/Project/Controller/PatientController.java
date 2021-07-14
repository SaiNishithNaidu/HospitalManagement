package com.example.Project.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Project.Model.DoctorAppointmentModel;
import com.example.Project.Model.FacilityAppointmentModel;
import com.example.Project.Model.afterRegisterModel;
import com.example.Project.Model.loginModel;
import com.example.Project.Model.registerDoctorModel;
import com.example.Project.Model.registerHospitalAdminModel;
import com.example.Project.Model.registerPatientModel;
import com.example.Project.Service.AfterRegisterService;
import com.example.Project.Service.DoctorAppointmentService;
import com.example.Project.Service.PatientRegisterService;
import com.example.Project.Service.PatientService;
import com.example.Project.Service.HospitalAdminRegisterService;
import com.example.Project.Service.DoctorRegisterService;
import com.example.Project.Service.FacilityAppointmentService;

@Controller
public class PatientController {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	PatientService patientService;
	
	@Autowired
	DoctorAppointmentService doctorAppointmentService;
	
	@Autowired
	FacilityAppointmentService facilityAppointmentService;

	@GetMapping(path = "/ViewHospital_p")
	public String ViewHospital(ModelMap map) {
		List<String> hospitalNames = new ArrayList<>();
		List<String> hospitalAddress = new ArrayList<>();
		for (registerHospitalAdminModel k : patientService.fetchHospitals()) {
			hospitalNames.add(k.getHospital_Name());
			hospitalAddress.add(k.getAddress_Lane1() + " " + k.getAddress_Lane2() + " " + k.getAddress_Lane3() + " "
					+ k.getCity() + " " + k.getState());
		}
		map.addAttribute("message", hospitalNames);
		map.addAttribute("message1", hospitalAddress);
		return "ViewHospital_p";
	}

	@GetMapping(path = "/BookAppointment_p")
	public String BookAppointment() {
		return "BookAppointment_p";
	}

	@GetMapping("/Doctor_Appointment_p")
	public String DoctorAppointment() {
		return "Doctor_Appointment_p";
	}

	@GetMapping("/afterAppointment")
	public String afterDoctorAppointment(
			@ModelAttribute("DoctorAppointmentModel") DoctorAppointmentModel doctorAppointmentModel, ModelMap map) {
		doctorAppointmentService.addPatientToDatabase(doctorAppointmentModel);
		return "afterAppointment";
	}

	@GetMapping("/Facilities_Appointment_p")
	public String FacilitiesAppointment() {
		return "Facilities_Appointment_p";
	}

	@GetMapping("/afterAppointment1")
	public String afterFacilityAppointment(
			@ModelAttribute("FacilityAppointmentModel") FacilityAppointmentModel facilityAppointmentModel, ModelMap map) {
		System.out.println(facilityAppointmentModel.toString());
		facilityAppointmentService.addPatientToDatabase(facilityAppointmentModel);
		return "afterAppointment";
	}

	@GetMapping(path = "/ViewAppointment_p")
	public String ViewAppointment() {
		return "ViewAppointment_p";
	}

	@GetMapping(path = "/ViewTestResult_p")
	public String ViewTestResult() {
		return "ViewTestResult_p";
	}

	@GetMapping(path = "/ViewHospital")
	@ResponseBody
	public String ViewTestResult1(@RequestParam String HospitalName) {
		return "ViewTestResult1234" + HospitalName;
	}

}
