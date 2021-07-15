package com.example.Project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.Project.Model.AddFacilitiesModel;
import com.example.Project.Model.DoctorAppointmentModel;
import com.example.Project.Service.AddFacilitiesService;
import com.example.Project.Service.HospitalAdminRegisterService;

@Controller
@SessionAttributes("id")
public class HospitalAdminController {
	
	@Autowired
	HospitalAdminRegisterService hospitalAdminRegisterService;
	@Autowired
	AddFacilitiesService addFacilitiesService;

	@GetMapping(path = "/AddFacilities_h")
	public String AddFacilities(ModelMap map) {
		System.out.println(map.get("id"));
		List<String> hospitalname=hospitalAdminRegisterService.getHospitalName(map.get("id").toString());
		map.addAttribute("hospitalname",hospitalname.get(0));
		map.addAttribute("hospitalid",map.get("id").toString());
		return "AddFacilities_h";
	}
	@GetMapping("/afterAddFacilities")
	public String afterAddFacilities(
			@ModelAttribute("AddFacilitiesModel") AddFacilitiesModel addFacilitiesModel, ModelMap map) {
		addFacilitiesService.addFacilitiesToDatabase(addFacilitiesModel);
		return "afterAddFacilities";
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
