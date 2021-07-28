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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.Project.Model.afterRegisterModel;
import com.example.Project.Model.loginModel;
import com.example.Project.Model.ForgetPasswordModel;
import com.example.Project.Model.RegisterDoctorModel;
import com.example.Project.Model.RegisterHospitalAdminModel;
import com.example.Project.Model.RegisterPatientModel;
import com.example.Project.Model.TieUpModel;
import com.example.Project.Model.ViewAppointmentModel;
import com.example.Project.Service.AdminService;
import com.example.Project.Service.AfterRegisterService;
import com.example.Project.Service.PatientRegisterService;
import com.example.Project.Service.PatientService;
import com.example.Project.Service.HospitalAdminRegisterService;
import com.example.Project.Service.DoctorRegisterService;
import com.example.Project.Service.DoctorService;

@Controller
@SessionAttributes("id")
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
	
	@Autowired
	DoctorService doctorService;
	
	@Autowired
	PatientService patientService;
	
	@Autowired
	AdminService adminService;
	

	String id = "something went wrong";

	@GetMapping("/main")
	public String main1() {
		return "main";
	}

	@GetMapping("/login" )
	public String login() {
		return "login";
	}

	@GetMapping("/loginafterregister" )
	public String loginafterregister(@ModelAttribute("afterRegisterModel") afterRegisterModel after, ModelMap map) {
		if (afterRegisterService.comparePassword(after.getPassword(), after.getConfirmpassword())) {
			afterRegisterService.giveAccess(after, id);
			return "login";
		} else {
			map.addAttribute("firstname", id);
			map.addAttribute("Security_Question", after.getSecurity_Question());
			map.addAttribute("Answer", after.getAnswer());
			map.addAttribute("Contact_Number", after.getContact_Number());
			map.addAttribute("message", "password and confirm password should be same");
			return "afterRegister";
		}

	}

	@GetMapping("/register_selection" )
	public String register_selection1() {
		return "register_selection";
	}

	@GetMapping("/register_patient" )
	public String register_patient() {
		return "register_patient";
	}

	@GetMapping("/afterRegisterPatient" )
	public String register_patient1(@ModelAttribute("registerPatientModel") RegisterPatientModel patientModel,
			ModelMap map) {
		if(patientRegisterService.checkAge(patientModel)>18){
			if (patientRegisterService.addPatientToDatabase(patientModel)) {
				id = patientRegisterService.generateId(patientModel);
				patientRegisterService.createTable(id);
				map.addAttribute("firstname", id);
				map.addAttribute("Security_Question", patientModel.getSecurity_Question());
				map.addAttribute("Answer", patientModel.getAnswer());
				map.addAttribute("Contact_Number", patientModel.getContact_Number());
				return "afterRegister";
			}else {
				map.addAttribute("error", "user already Exists");
				return "register_patient";
			}
		}else {
			map.addAttribute("age", "age should be above 18");
			return "register_patient";
		}
		

	}

	@GetMapping("/register_doctor" )
	public String register_doctor(ModelMap map) {
		map.addAttribute("message", "successful registered");
		return "register_doctor";
	}

	@GetMapping("/afterRegisterDoctor")
	public String register_doctor1(@ModelAttribute("registerDoctorModel") RegisterDoctorModel doctorModel,
			ModelMap map) {
		if (doctorRegisterService.addDoctorToDatabase(doctorModel)) {
			id = doctorRegisterService.generateId(doctorModel);
			doctorRegisterService.createTable(id);
			map.addAttribute("firstname", id);
			map.addAttribute("Security_Question", doctorModel.getSecurity_Question());
			map.addAttribute("Answer", doctorModel.getAnswer());
			map.addAttribute("Contact_Number", doctorModel.getContact_Number());
			return "afterRegister";
		} else {
			map.addAttribute("error", "user already Exists");
			return "register_doctor";
		}
	}

	@GetMapping("/register_hospital_admin")
	public String register_hospital_admin() {
		return "register_hospital_admin";
	}

	@GetMapping("/afterRegisterHospitalAdmin")
	public String register_hospitaladmin1(
			@ModelAttribute("registerHospitalAdminModel") RegisterHospitalAdminModel hospitalAdminModel, ModelMap map) {
		if (hospitalAdminRegisterService.addHospitalAdminToDatabase(hospitalAdminModel)) {
			id = hospitalAdminRegisterService.generateId(hospitalAdminModel);
			hospitalAdminRegisterService.createTable(id);
			map.addAttribute("firstname", id);
			map.addAttribute("Security_Question", hospitalAdminModel.getSecurity_Question());
			map.addAttribute("Answer", hospitalAdminModel.getAnswer());
			map.addAttribute("Contact_Number", hospitalAdminModel.getHospital_Contact_Number());
			return "afterRegister";
		}
		else {
			map.addAttribute("error", "user already Exists");
			return "register_hospital_admin";
		}
	
	}
	
	@PostMapping("/homepage")
	public String homepage(@ModelAttribute("loginModel") loginModel login, BindingResult result, ModelMap map) {
		int selector = 0;
		List<String> userNameList = new ArrayList<>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList("select userid,password from login;");
		for (Map row : rows) {
			if (row.get("userid").equals(login.getUserid()) && row.get("password").equals(login.getPassword())) {
				selector = 1;
			}
		}
		if (selector == 1) {
				if(login.getUserid().substring(0, 3).equalsIgnoreCase("HOS")) {
					map.addAttribute("id",login.getUserid());
					List<String> hospitalname=hospitalAdminRegisterService.getHospitalName(map.get("id").toString());
					map.addAttribute("hospitalid",map.get("id").toString());
					map.addAttribute("hospitalname",hospitalname.get(0));
					return "AddFacilities_h";
				}else if(login.getUserid().substring(0, 3).equalsIgnoreCase("PAT")) {
					map.addAttribute("id",login.getUserid());
					List<String> hospitalNames = new ArrayList<>();
					List<String> hospitalid = new ArrayList<>();
					List<String> hospitalAddress = new ArrayList<>();
					for(RegisterHospitalAdminModel k:patientService.fetchHospitals()) {
						hospitalNames.add(k.getHospital_Name());
						hospitalAddress.add(k.getAddress_Lane1()+" "+k.getAddress_Lane2()+" "+k.getAddress_Lane3()+" "+k.getCity()+" "+k.getState());
						hospitalid.add(k.getHospital_Id());
					}
					map.addAttribute("hospitalname", hospitalNames);
					map.addAttribute("hospitaladdress", hospitalAddress);
					map.addAttribute("hospitalid", hospitalid);
					return "ViewHospital_p";
				}else if(login.getUserid().substring(0, 3).equalsIgnoreCase("DOC")) {
					map.addAttribute("id",login.getUserid());
					List<ViewAppointmentModel> appointments = doctorService.viewAppointments(map.get("id").toString());
					System.out.println(appointments.toString());
					map.addAttribute("appointments", appointments);
					return "ViewAppointment_d";
				}else {
					List<TieUpModel> k =  adminService.getTieUpHospitals();
					map.addAttribute("TieUp", k);
					map.addAttribute("id",login.getUserid());
					return "TieUpHospital_a";
				}
			
		} else {
			map.addAttribute("message", "Invalid User ID (or) Incorrect Password");
			return "login";
		}
	}	
	

	@GetMapping("/ForgetPassword" )
	public String ForgetPassword(ModelMap map) {
		return "ForgetPassword";
	}
	
	@GetMapping("/ResetPassword" )
	public String ForgetPassword1(@ModelAttribute("ForgetPassword") ForgetPasswordModel forgetPasswordModel,ModelMap map) {
		if(afterRegisterService.checkIdPresent(forgetPasswordModel.getUser_Id())) {
			if(afterRegisterService.checkResetDetails(forgetPasswordModel)) {
				map.addAttribute("userid", forgetPasswordModel.getUser_Id());
				return "ResetPassword";
			}else {
				map.addAttribute("error","Details are in correct");
				return "ForgetPassword";
			}
		}else {
			map.addAttribute("UserId", "User ID not availiable");
			return "ForgetPassword";
		}
		
	}
	
	@GetMapping("/UpdatePassword" )
	public String ForgetUserID(@ModelAttribute("afterResgisterModel") afterRegisterModel afterRegisterModel1,ModelMap map) {
		if(afterRegisterModel1.getPassword().equals(afterRegisterModel1.getConfirmpassword())) {
			afterRegisterService.changePassword(afterRegisterModel1.getUserid(),afterRegisterModel1.getPassword());
			return "login";	
		}else {
			map.addAttribute("error", "Password and Confirm Password should be same");
			map.addAttribute("userid", afterRegisterModel1.getUserid());
			return "ResetPassword";
		}
	}
	
	
	
	@GetMapping("/ForgetUserID" )
	public String ForgetUserID(ModelMap map) {
		return "ForgetUserID";
	}
	
	
	@GetMapping("/DisplayUserID" )
	public String DisplayUserID1(@ModelAttribute("ForgetPassword") ForgetPasswordModel forgetPasswordModel,ModelMap map) {
		List<afterRegisterModel> k = afterRegisterService.checkDetailsPresent(forgetPasswordModel);
		if(k.isEmpty()) {
			map.addAttribute("error", "Details are Incorrect");
			return "ForgetUserID";
		}else {
			map.addAttribute("userid", k.get(0).getUserid());
			return "ShowUserId";
		}
	
	}
	

	
	

}
