package com.example.Project.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DoctorController {

	@GetMapping(path ="/ViewAppointment_d")
	public String AddFacilities() {
		return "ViewAppointment_d";
	}

	@GetMapping(path ="/ViewTestResult_d")
	public String UpdateFacilities() {
		return "ViewTestResult_d";
	}

	@GetMapping(path ="/UpdateTreatment_d")
	public String ViewAppointment() {
		return "UpdateTreatment_d";
	}
}
