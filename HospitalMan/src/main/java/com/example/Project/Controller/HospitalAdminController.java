package com.example.Project.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HospitalAdminController {

	@GetMapping(path = "/AddFacilities_h")
	public String AddFacilities() {
		return "AddFacilities_h";
	}

	@GetMapping(path =  "/UpdateFacilities_h")
	public String UpdateFacilities() {
		return "UpdateFacilities_h";
	}
	@GetMapping(path =  "/ViewAppointment_h")
	public String ViewAppointment() {
		return "ViewAppointment_h";
	}

	@GetMapping(path =  "/UpdateTestResult_h")
	public String UpdateTestResult() {
		return "UpdateTestResult_h";
	}

	@GetMapping(path =  "/Billing_h")
	public String Billing() {
		return "Billing_h";

	}

}
