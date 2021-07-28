package com.example.Project.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
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
import com.example.Project.Model.ViewAppointmentModel;
import com.example.Project.Model.FacilityAppointmentModel;
import com.example.Project.Model.afterRegisterModel;
import com.example.Project.Model.loginModel;
import com.example.Project.Model.RegisterDoctorModel;
import com.example.Project.Model.RegisterHospitalAdminModel;
import com.example.Project.Model.RegisterPatientModel;
import com.example.Project.Service.AfterRegisterService;
import com.example.Project.Service.PatientRegisterService;
import com.example.Project.Service.PatientService;
import com.example.Project.Service.HospitalAdminRegisterService;
import com.example.Project.Service.DoctorRegisterService;

@Controller
@SessionAttributes("id")
@EnableScheduling
public class PatientController {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	PatientService patientService;

	@GetMapping("/logout" )
	public String logout(ModelMap map) {
		return "login";
	}


	@GetMapping("/ViewHospital_p" )
	public String ViewHospital(ModelMap map) {
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
	public String afterDoctorAppointment(@ModelAttribute("DoctorAppointmentModel") DoctorAppointmentModel doctorAppointmentModel, ModelMap map) {
		String hospitalId = patientService.checkHospitalNameAvaliable(doctorAppointmentModel.getHospital_Name());
		System.out.println("came here");
		if(hospitalId.equals("")) {
			map.addAttribute("errorHospitalName","please enter the correct hospital name");
			return "Doctor_Appointment_p";
		}else {
			String doctorId = patientService.checkDoctorAvaliable(doctorAppointmentModel,hospitalId);
			if(doctorId!=null) {
				patientService.BookAppointmentDoctor(doctorAppointmentModel,doctorId, map.get("id").toString(),hospitalId);
				map.addAttribute("Success", "Appointment Booked");
				return "afterAppointment";
			}else {
				System.out.println("doctor not available");
				map.addAttribute("errorDoctorName", "Doctor name is not Availiable");
				return "Doctor_Appointment_p";
			}
		}			
	}  
	@GetMapping("/Facilities_Appointment_p")
	public String FacilitiesAppointment() {
		return "Facilities_Appointment_p";
	}

	@GetMapping("/afterAppointment1")
	public String afterFacilityAppointment(@ModelAttribute("FacilityAppointmentModel") FacilityAppointmentModel facilityAppointmentModel, ModelMap map) {
		String hospitalId = patientService.checkHospitalNameAvaliable(facilityAppointmentModel.getHospital_Name());
		if(hospitalId.equals("")) {
			map.addAttribute("error","please enter the correct hospital name");
			return "Facilities_Appointment_p";
		}else {
			if(patientService.checkFacilityAvaliable(facilityAppointmentModel,hospitalId)) {
				patientService.BookAppointmentFacility(facilityAppointmentModel, hospitalId, map.get("id").toString());
				map.addAttribute("Success", "Appointment Booked");
				return "afterAppointment";
			}else {
				map.addAttribute("error1", "Facility not Availiable");
				return "Facilities_Appointment_p";
			}
		}
	}

	@GetMapping("/ViewAppointment_p" )
	public String ViewAppointment(ModelMap map) {
		List<ViewAppointmentModel> users = patientService.viewAppointments(map.get("id").toString());
		map.addAttribute("appointments", users);
		return "ViewAppointment_p";
	}
	@GetMapping("/ViewTestResult_p" )
	public String ViewTestResult(ModelMap map) {
		List<ViewAppointmentModel> users = patientService.viewAppointments(map.get("id").toString());
		map.addAttribute("appointments", users);
		return "ViewTestResult_p";
	}
	
	
	@GetMapping("/ViewHospital" )
	public String ViewHospital(@RequestParam String HospitalID,ModelMap map) {
	RegisterHospitalAdminModel k = patientService.fetchHospitalDetails(HospitalID);
		map.addAttribute("HospitalName", k.getHospital_Name());
		map.addAttribute("HospitalContactNumber", k.getHospital_Contact_Number());
		map.addAttribute("HospitalFaxNumber", k.getHospital_Fax_Number());
		map.addAttribute("HospitalWebsite", k.getHospital_Website());
		map.addAttribute("HospitalID", HospitalID);
		return "ViewHospital";
	}
	
	
	@GetMapping("/ViewHospitalFacilities" )
	public String ViewHospitalFacilities(@RequestParam String HospitalID,ModelMap map) {
		List<String> k = patientService.fetchFacilities(HospitalID);
		map.addAttribute("facilities",k );
		map.addAttribute("HospitalName",HospitalID);
		return "ViewHospitalFacilities";
	}
	
	@GetMapping("/ViewHospitalFacilitiesNames" )
	public String ViewHospitalFacilitiesNames(@RequestParam String FacilityName,@RequestParam String HospitalName,ModelMap map) {
		List<String> k = patientService.fetchFacilitiesDetails(FacilityName,HospitalName);
		map.addAttribute("facilitiesDetails",k);
		return "ViewHospitalFacilitiesDetails";
	}
	
	@GetMapping("/ViewHospitalDoctor" )
	public String ViewHospitalDoctor(@RequestParam String HospitalID,ModelMap map) {
		List<String> k = patientService.fetchDoctorID(HospitalID);
		 List<RegisterDoctorModel> docDetails = patientService.fetchDoctorFromTable(k);
		map.addAttribute("doctorID",k );
		map.addAttribute("DoctorDetails", docDetails);
		return "ViewHospitalDoctor";
	}
	
	@GetMapping("/ViewHospitalDoctorID" )
	public String ViewHospitalDoctorID(@RequestParam String DoctorID,@RequestParam String HospitalName,ModelMap map) {
		List<RegisterDoctorModel> docDetails = patientService.fetchDoctorFromTable(Arrays.asList(DoctorID));
		map.addAttribute("DoctorDetails", docDetails);
		return "ViewHospitalDoctorDetails";
	}
	
	@GetMapping("/Feedback_p" )
	public String Feedback(ModelMap map) {
		return "Feedback_p";
	}
	
	
	@GetMapping("/Feedback_form" )
	public String Feedbackform(ModelMap map) {
		return "Feedback_form";
	}
	
	
}
