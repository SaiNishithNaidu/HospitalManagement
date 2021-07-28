package com.example.Project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.Project.Model.TestResultModel;
import com.example.Project.Model.ViewAppointmentModel;
import com.example.Project.Service.DoctorService;
import com.example.Project.Service.PatientRegisterService;

@Controller
@SessionAttributes("id")
public class DoctorController {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DoctorService doctorService;

	@GetMapping(path ="/ViewAppointment_d")
	public String AddFacilities(ModelMap map) {
		List<ViewAppointmentModel> appointments = doctorService.viewAppointments(map.get("id").toString());
		System.out.println(appointments.toString());
		map.addAttribute("appointments", appointments);
		return "ViewAppointment_d";
	}
	@GetMapping("/ViewAppointmentAccept_d")
	public String ViewAppointmentaccept(@RequestParam String accept, ModelMap map) {
		List<ViewAppointmentModel> appointments = doctorService.viewAppointments(map.get("id").toString());
		doctorService.changeStatus(map.get("id").toString(),accept,"Approve");
		List<ViewAppointmentModel> appointments1 = doctorService.viewAppointments(map.get("id").toString());
		map.addAttribute("appointments", appointments1);
		return "ViewAppointment_d";
	}
	@GetMapping("/ViewAppointmentReject_d")
	public String ViewAppointmentreject(@RequestParam String reject, ModelMap map) {
		List<ViewAppointmentModel> appointments = doctorService.viewAppointments(map.get("id").toString());
		doctorService.changeStatus(map.get("id").toString(),reject,"Reject");
		List<ViewAppointmentModel> appointments1 = doctorService.viewAppointments(map.get("id").toString());
		map.addAttribute("appointments", appointments1);
		return "ViewAppointment_d";
	}
	@GetMapping(path ="/ViewTestResult_d")
	public String UpdateFacilities(ModelMap map) {
		List<ViewAppointmentModel> users = doctorService.viewAppointments(map.get("id").toString());
		map.addAttribute("appointments", users);
		return "ViewTestResult_d";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/UpdateTreatment_d")
	public String UpdateTestResult(ModelMap map) {
		List<ViewAppointmentModel> appointments = doctorService.viewAppointments(map.get("id").toString());
		
		System.out.println(appointments.toString());
		
		map.addAttribute("appointments", appointments);
		return "UpdateTreatment_d";
	}

	
	@GetMapping("/UpdateTestResultPatient_d")
	public String UpdateTestResultPatient(@RequestParam String uniqueID, ModelMap map) {
		System.out.println(uniqueID.toString());
		map.addAttribute("uniqueId",uniqueID);
		return "UpdateTestResultPatient_d";
	}
	
	
	@GetMapping("/UpdateTestResultPatientValues_d")
	public String UpdateTestResultPatient(@ModelAttribute("TestResult") TestResultModel TR, ModelMap map) {
		doctorService.updateResult(TR,map.get("id").toString());
		map.addAttribute("Success", "Results Updated");
		return "UpdateTestResultPatient_d";
	}

	
	
	
	
	
	
	
	
	
	
	
}
