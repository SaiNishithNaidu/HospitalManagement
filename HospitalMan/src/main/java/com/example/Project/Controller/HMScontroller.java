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

import com.example.Project.Model.afterRegisterModel;
import com.example.Project.Model.loginModel;
import com.example.Project.Model.registerDoctorModel;
import com.example.Project.Model.registerHospitalAdminModel;
import com.example.Project.Model.registerPatientModel;
import com.example.Project.Service.AfterRegisterService;
import com.example.Project.Service.DoctorRegisterService;
import com.example.Project.Service.HospitalAdminRegisterService;
import com.example.Project.Service.PatientRegisterService;

@Controller
public class HMScontroller {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	PatientRegisterService patientRegisterService;

	@Autowired
	DoctorRegisterService doctorRegisterService;

	@Autowired
	HospitalAdminRegisterService hospitalAdminRegisterService;

	@Autowired
	AfterRegisterService afterRegisterService;

	String id = "something went wrong";

	@GetMapping("/main")
	public String main1() {
		return "main";
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping(path = "/loginafterregister")
	public String loginafterregister(@ModelAttribute("afterRegisterModel") afterRegisterModel after, ModelMap map) {
		if (afterRegisterService.comaprePassword(after.getPassword(), after.getConfirmpassword())) {
			if (afterRegisterService.giveAccess(after, id)) {
				return "login";
			} else {
				map.addAttribute("firstname", id);
				map.addAttribute("message", "something went wrong");
				return "afterRegisterModel";
			}

		} else {
			map.addAttribute("firstname", id);
			map.addAttribute("message", "password and confirm password should be same");
			return "afterRegisterModel";
		}

	}

	@GetMapping(path = "/register_selection")
	public String register_selection1() {
		return "register_selection";
	}

	@GetMapping(path = "/register_patient")
	public String register_patient() {
		return "register_patient";
	}

	@GetMapping(path = "/afterRegister")
	public String register_patient1(@ModelAttribute("registerPatientModel") registerPatientModel patientModel,
			ModelMap map) {
		if (patientRegisterService.addPatientToDatabase(patientModel)) {

			id = patientRegisterService.generateId(patientModel);
			map.addAttribute("firstname", id);
		}
		return "afterRegister";
	}

	@GetMapping(path = "/register_doctor")
	public String register_doctor(ModelMap map) {
		map.addAttribute("message", "successful registered");
		return "register_doctor";
	}

	@GetMapping(path = "/afterRegister1")
	public String register_patient1(@ModelAttribute("registerDoctorModel") registerDoctorModel doctorModel,
			ModelMap map) {
		if (doctorRegisterService.addDoctorToDatabase(doctorModel)) {

			id = doctorRegisterService.generateId(doctorModel);
			map.addAttribute("firstname", id);
		}
		return "afterRegister";
	}

	@GetMapping(path = "/register_hospital_admin")
	public String register_hospital_admin() {
		return "register_hospital_admin";
	}

	@GetMapping(path = "/afterRegister2")
	public String register_patient1(
			@ModelAttribute("registerHospitalAdminModel") registerHospitalAdminModel hospitalAdminModel, ModelMap map) {
		if (hospitalAdminRegisterService.addHospitalAdminToDatabase(hospitalAdminModel)) {

			id = hospitalAdminRegisterService.generateId(hospitalAdminModel);
			map.addAttribute("firstname", id);
		}
		return "afterRegister";
	}
	
	@PostMapping(path = "/homepage")
	public String homepage(@ModelAttribute("loginModel") loginModel login, BindingResult result, ModelMap map) {
		int selector = 0;
		List<String> userNameList = new ArrayList<>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList("select username,password from login;");
		for (Map row : rows) {
			if (row.get("username").equals(login.getUsername()) && row.get("password").equals(login.getPassword())) {
				selector = 1;
			}
		}
		if (selector == 1) {
			if(login.getUsername().substring(0, 3).equalsIgnoreCase("HOS")) {
				return "homepageHospitalAdmin";
			}else if(login.getUsername().substring(0, 3).equalsIgnoreCase("PAT")) {
				return "homepagePatientAdmin";
			}else{
				return "homepageDoctorAdmin";
			}
			
		} else {
			map.addAttribute("message", "Invalid User ID (or) Incorrect Password");
			return "login";
		}

//		 if(login.getUsername().equals("kalyan") && login.getPassword().equals("kalyan")) {
//			 return "homepage1"; 
//		 }else {
//			 
//		 }
////		 map.addAttribute("username",login.getUsername());
//		 map.addAttribute("password", login.getPassword());

	}

}
