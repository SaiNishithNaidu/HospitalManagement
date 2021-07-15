package com.example.Project.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

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
@SessionAttributes("id")
public class PatientController {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	PatientService patientService;

	@Autowired
	DoctorAppointmentService doctorAppointmentService;
	
	@Autowired
	FacilityAppointmentService facilityAppointmentService;

	@GetMapping("/ViewHospital_p" )
	public String ViewHospital(ModelMap map) {
		List<String> hospitalNames = new ArrayList<>();
		List<String> hospitalAddress = new ArrayList<>();
		for(registerHospitalAdminModel k:patientService.fetchHospitals()) {
			hospitalNames.add(k.getHospital_Name());
			hospitalAddress.add(k.getAddress_Lane1()+" "+k.getAddress_Lane2()+" "+k.getAddress_Lane3()+" "+k.getCity()+" "+k.getState());
		}
		map.addAttribute("message", hospitalNames);
		map.addAttribute("message1", hospitalAddress);
		return "ViewHospital_p";
	}

	@GetMapping("/BookAppointment_p" )
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

	@GetMapping("/ViewAppointment_p" )
	public String ViewAppointment() {
		return "ViewAppointment_p";
	}
	@GetMapping("/ViewTestResult_p" )
	public String ViewTestResult() {
		return "ViewTestResult_p";
	}
	
	
	@GetMapping("/ViewHospital" )
	public String ViewHospital(@RequestParam String HospitalName,ModelMap map) {
		registerHospitalAdminModel k = patientService.fetchHospitalDetails(HospitalName);
		map.addAttribute("HospitalName", k.getHospital_Name());
		map.addAttribute("HospitalContactNumber", k.getHospital_Contact_Number());
		map.addAttribute("HospitalFaxNumber", k.getHospital_Fax_Number());
		map.addAttribute("HospitalWebsite", k.getHospital_Website());
		return "ViewHospital";
	}
	
	
	@GetMapping("/ViewHospitalFacilities" )
	public String ViewHospitalFacilities(@RequestParam String HospitalName,ModelMap map) {
		List<String> k = patientService.fetchFacilities(HospitalName);
		map.addAttribute("facilities",k );
		map.addAttribute("HospitalName",HospitalName);
		return "ViewHospitalFacilities";
	}
	
	@GetMapping("/ViewHospitalFacilitiesNames" )
	public String ViewHospitalFacilitiesNames(@RequestParam String FacilityName,@RequestParam String HospitalName,ModelMap map) {
		List<String> k = patientService.fetchFacilitiesDetails(FacilityName,HospitalName);
		map.addAttribute("facilitiesDetails",k);
		return "ViewHospitalFacilitiesDetails";
	}

	
	
	@GetMapping("/ViewHospitalDoctor" )
	public String ViewHospitalDoctor(@RequestParam String HospitalName,ModelMap map) {
		List<String> k = patientService.fetchDoctorID(HospitalName);
		 List<registerDoctorModel> docDetails = patientService.fetchDoctorFromTable(k);
		map.addAttribute("doctorID",k );
		map.addAttribute("DoctorDetails", docDetails);
		map.addAttribute("HospitalName",HospitalName);
		return "ViewHospitalDoctor";
	}
	
	@GetMapping("/ViewHospitalDoctorID" )
	public String ViewHospitalDoctorID(@RequestParam String DoctorID,@RequestParam String HospitalName,ModelMap map) {
		List<registerDoctorModel> docDetails = patientService.fetchDoctorFromTable(Arrays.asList(DoctorID));
		map.addAttribute("DoctorDetails", docDetails);
		return "ViewHospitalDoctorDetails";
	}

	
}
