package com.example.Project.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Project.Model.afterRegisterModel;
import com.example.Project.Model.loginModel;
import com.example.Project.Model.registerDoctorModel;
import com.example.Project.Model.registerHospitalAdminModel;
import com.example.Project.Model.registerPatientModel;
import com.example.Project.Service.AfterRegisterService;
import com.example.Project.Service.PatientRegisterService;
import com.example.Project.Service.HospitalAdminRegisterService;
import com.example.Project.Service.DoctorRegisterService;

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

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main1() {
		return "main";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/loginafterregister", method = RequestMethod.GET)
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

	@RequestMapping(value = "/register_selection", method = RequestMethod.GET)
	public String register_selection1() {
		return "register_selection";
	}

	@RequestMapping(value = "/register_patient", method = RequestMethod.GET)
	public String register_patient() {
		return "register_patient";
	}

	@RequestMapping(value = "/afterRegister", method = RequestMethod.GET)
	public String register_patient1(@ModelAttribute("registerPatientModel") registerPatientModel patientModel,
			ModelMap map) {
		if (patientRegisterService.addPatientToDatabase(patientModel)) {

			id = patientRegisterService.generateId(patientModel);
			map.addAttribute("firstname", id);
		}
		return "afterRegister";
	}

	@RequestMapping(value = "/register_doctor", method = RequestMethod.GET)
	public String register_doctor(ModelMap map) {
		map.addAttribute("message", "successful registered");
		return "register_doctor";
	}

	@RequestMapping(value = "/afterRegister1", method = RequestMethod.GET)
	public String register_patient1(@ModelAttribute("registerDoctorModel") registerDoctorModel doctorModel,
			ModelMap map) {
		if (doctorRegisterService.addDoctorToDatabase(doctorModel)) {

			id = doctorRegisterService.generateId(doctorModel);
			map.addAttribute("firstname", id);
		}
		return "afterRegister";
	}

	@RequestMapping(value = "/register_hospital_admin", method = RequestMethod.GET)
	public String register_hospital_admin() {
		return "register_hospital_admin";
	}

	@RequestMapping(value = "/afterRegister2", method = RequestMethod.GET)
	public String register_patient1(
			@ModelAttribute("registerHospitalAdminModel") registerHospitalAdminModel hospitalAdminModel, ModelMap map) {
		if (hospitalAdminRegisterService.addHospitalAdminToDatabase(hospitalAdminModel)) {

			id = hospitalAdminRegisterService.generateId(hospitalAdminModel);
			map.addAttribute("firstname", id);
		}
		return "afterRegister";
	}

	@RequestMapping(value = "/homepage1", method = RequestMethod.GET)
	public String homepage1() {
		return "homepage1";
	}

	@RequestMapping(value = "/homepage", method = RequestMethod.POST)
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
			return "homepage";
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
