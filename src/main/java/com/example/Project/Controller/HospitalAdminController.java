package com.example.Project.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.Project.Model.AddFacilitiesModel;
import com.example.Project.Model.BillSubmitModel;
import com.example.Project.Model.DoctorAppointmentModel;
import com.example.Project.Model.InPateintModel;
import com.example.Project.Model.PatientRecordModel;
import com.example.Project.Model.ViewAppointmentModel;
import com.example.Project.Model.RegisterDoctorModel;
import com.example.Project.Model.RegisterHospitalAdminModel;
import com.example.Project.Model.TestResultModel;
import com.example.Project.Model.TieUpModel;
import com.example.Project.Service.HospitalAdminRegisterService;
import com.example.Project.Service.HospitalAdminService;
import com.example.Project.Service.PatientRegisterService;
import com.example.Project.Service.PatientService;

@Controller
@SessionAttributes("id")
public class HospitalAdminController {
	
	@Autowired
	HospitalAdminRegisterService hospitalAdminRegisterService;
	@Autowired
	PatientService patientService;
	@Autowired
	HospitalAdminService hospitalAdminService;

	@GetMapping(path = "/AddFacilities_h")
	public String AddFacilities(ModelMap map) {
		List<String> hospitalname=hospitalAdminRegisterService.getHospitalName(map.get("id").toString());
		map.addAttribute("hospitalid",map.get("id").toString());
		map.addAttribute("hospitalname",hospitalname.get(0));
		return "AddFacilities_h";
	}
	
	@GetMapping("/afterAddFacilities")
	public String afterAddFacilities(@ModelAttribute("AddFacilitiesModel") AddFacilitiesModel addFacilitiesModel, ModelMap map) {
		if(hospitalAdminService.addFacilitiesToDatabase(addFacilitiesModel,map.get("id").toString())){
			List<String> hospitalname=hospitalAdminRegisterService.getHospitalName(map.get("id").toString());
			map.addAttribute("hospitalid",map.get("id").toString());
			map.addAttribute("hospitalname",hospitalname.get(0));
			map.addAttribute("error", "Successfully Added");
			return "AddFacilities_h";
		}else {
			List<String> hospitalname=hospitalAdminRegisterService.getHospitalName(map.get("id").toString());
			map.addAttribute("hospitalid",map.get("id").toString());
			map.addAttribute("hospitalname",hospitalname.get(0));
			map.addAttribute("error", "Facility Already Added");
			return "AddFacilities_h";
		}
		
	}
	@GetMapping("/updateFacilities")
	public String updateFacilities(@ModelAttribute("AddFacilitiesModel") AddFacilitiesModel addFacilitiesModel, ModelMap map) {
		if(hospitalAdminService.updateFacilitiesToDatabase(addFacilitiesModel,map.get("id").toString())) {
			List<AddFacilitiesModel> k = hospitalAdminService.ViewAvaliableFacilities(map.get("id").toString());
			map.addAttribute("facilities", k);
			map.addAttribute("error", "Successfully Updated");
			return "UpdateFacilities_h";
		}else{
			List<AddFacilitiesModel> k = hospitalAdminService.ViewAvaliableFacilities(map.get("id").toString());
			map.addAttribute("facilities", k);
			map.addAttribute("error", "Facility Not Availiable");
			return "UpdateFacilities_h";
		}
		
	}

	@GetMapping("/updateFacilitiesDelete")
	public String UpdateFacilitiesDelete(@RequestParam String facility, ModelMap map) {
		hospitalAdminService.DeleteFacility(facility,map.get("id").toString());
		List<AddFacilitiesModel> k = hospitalAdminService.ViewAvaliableFacilities(map.get("id").toString());
		map.addAttribute("facilities", k);
		return "UpdateFacilities_h";
	}
	
	
	
	
	
	
	@GetMapping("/UpdateFacilities_h")
	public String UpdateFacilities(ModelMap map) {
		List<AddFacilitiesModel> k = hospitalAdminService.ViewAvaliableFacilities(map.get("id").toString());
		map.addAttribute("facilities", k);
		return "UpdateFacilities_h";
	}
	
	
	@GetMapping("/Doctors_h")
	public String Doctors(ModelMap map) {
		map.addAttribute("registeredDoctors", hospitalAdminService.AllDoctors());
		map.addAttribute("DoctorsInHospital",hospitalAdminService.DoctorsInOurHospital(map.get("id").toString()));	 
		return "Doctors_h";
	}
	
	@GetMapping("/Doctors1_h")
	public String Doctors1(@RequestParam String select, ModelMap map) {
		List<RegisterDoctorModel> doctors = hospitalAdminService.getDoctorDetails(select);
		if(!hospitalAdminService.checkIfPresent(doctors.get(0),map.get("id").toString())) {
			hospitalAdminService.addToHospitalDatabase(doctors.get(0),map.get("id").toString());
		}
		map.addAttribute("registeredDoctors", hospitalAdminService.AllDoctors());
		map.addAttribute("DoctorsInHospital",hospitalAdminService.DoctorsInOurHospital(map.get("id").toString()));	 
		return "Doctors_h";
	}
	
	@GetMapping("/Doctors2_h")
	public String Doctors2(@RequestParam String deselect, ModelMap map) {
		hospitalAdminService.removeFromHospitalDatabase(deselect,map.get("id").toString());
		map.addAttribute("registeredDoctors", hospitalAdminService.AllDoctors());
		map.addAttribute("DoctorsInHospital",hospitalAdminService.DoctorsInOurHospital(map.get("id").toString()));	 
		return "Doctors_h";
	}
	
	
	@GetMapping("/ViewAppointment_h")
	public String ViewAppointment(ModelMap map) {
		List<ViewAppointmentModel> appointments = hospitalAdminService.viewAppointments(map.get("id").toString());
		map.addAttribute("appointments", appointments);
		return "ViewAppointment_h";
	}
	@GetMapping("/ViewAppointmentAccept_h")
	public String ViewAppointmentaccept(@RequestParam String accept, ModelMap map) {
		List<ViewAppointmentModel> appointments = hospitalAdminService.viewAppointments(map.get("id").toString());
		hospitalAdminService.changeStatus(map.get("id").toString(),accept,"Approve");
		List<ViewAppointmentModel> appointments1 = hospitalAdminService.viewAppointments(map.get("id").toString());
		map.addAttribute("appointments", appointments1);
		return "ViewAppointment_h";
	}
	@GetMapping("/ViewAppointmentReject_h")
	public String ViewAppointmentreject(@RequestParam String reject, ModelMap map) {
		List<ViewAppointmentModel> appointments = hospitalAdminService.viewAppointments(map.get("id").toString());
		hospitalAdminService.changeStatus(map.get("id").toString(),reject,"Reject");
		List<ViewAppointmentModel> appointments1 = hospitalAdminService.viewAppointments(map.get("id").toString());
		map.addAttribute("appointments", appointments1);
		return "ViewAppointment_h";
	}

	@GetMapping("/UpdateTestResult_h")
	public String UpdateTestResult(ModelMap map) {
		List<ViewAppointmentModel> appointments = hospitalAdminService.viewAppointments(map.get("id").toString());
		map.addAttribute("appointments", appointments);
		return "UpdateTestResult_h";
	}

	
	@GetMapping("/UpdateTestResultPatientValues_h")
	public String UpdateTestResultPatient(@ModelAttribute("TestResult") TestResultModel TR, ModelMap map) {
		hospitalAdminService.updateResult(TR,map.get("id").toString());
		map.addAttribute("Success", "Results Updated");
		return "UpdateTestResultPatient_h";
	}
	@GetMapping("/UpdateTestResultPatient_h")
	public String UpdateTestResultPatient(@RequestParam String uniqueID, ModelMap map) {
		map.addAttribute("uniqueId",uniqueID);
		return "UpdateTestResultPatient_h";
	}
	

	@GetMapping("/InPatient_h")
	public String InPatient() {
		return "InPatient_h";

	}
	
	
	@RequestMapping(value = "/InPatientSubmit", method = RequestMethod.GET)
	public String InPatientSubmit(@ModelAttribute("InPateintModel") InPateintModel inPateintModel,ModelMap map) { 
		System.out.println(inPateintModel.toString());
		if (hospitalAdminService.checkPatientExists(inPateintModel.getPATID())) {
			if(hospitalAdminService.checkStatusOfInPatient(inPateintModel,map.get("id").toString())) {
				map.addAttribute("PatientNotAvailiable", "Patinet is in treatment");
				return "InPatient_h";
			}else {
				hospitalAdminService.AddToInPatientTable(inPateintModel,map.get("id").toString());
				map.addAttribute("Sucess", "Create In Pateint Sucessful");
				return "InPatient_h";
			}
			
		} else {
			
			map.addAttribute("PatientNotAvailiable", "Patient id is not registered");
			return "InPatient_h";
		}

	}

	@GetMapping("/Billing_h")
	public String Billing() {
		return "Billing_h";

	}
	
	@GetMapping("/BillingValue_h")
	public String BillingValue(@ModelAttribute("InPatientModel") InPateintModel inPatientModel,ModelMap map) {
		if(hospitalAdminService.checkPatientExists(inPatientModel.getPATID())){
			List<InPateintModel> user = hospitalAdminService.getInPatientDetails(inPatientModel.getPATID(),map.get("id").toString());
			map.addAttribute("user", user);				
			return "BillingFinal_h";
		}else {
			map.addAttribute("PatientNotAvailiable", "Patient does not exists");
			return "Billing_h";
			
		}
	}
	@GetMapping("/BillSubmit")
	public String Billingsubmit(@ModelAttribute("BillSubmitModel") BillSubmitModel billSubmitModel,ModelMap map) {
		map.addAttribute("billing",billSubmitModel);
		return "TotalAmountBilling";

	}
	
	
	@GetMapping("/RemovePatient")
	public String Billingsubmit(@RequestParam String PATID ,String Date_Of_Discharge,ModelMap map) {
		
		System.out.println(PATID+ "                 "+Date_Of_Discharge);
		
		hospitalAdminService.ChangeStatusOfInPatient(PATID,Date_Of_Discharge,map.get("id").toString());
		return "InPatient_h";
	}
	
	
	
	@GetMapping("/TieUp_h")
	public String TieUp(ModelMap map) {
		List<RegisterHospitalAdminModel> hospitals =  hospitalAdminService.getAllHospitalDetails(map.get("id").toString());
		map.addAttribute("hospitals", hospitals);
		return "TieUp_h";

	}
	@GetMapping("/TieUpHospital")
	public String TieUp(@RequestParam String Hos,String HosName, ModelMap map) {
		hospitalAdminService.makeTieUpRequest(Hos,map.get("id").toString(),HosName.toString());
		List<RegisterHospitalAdminModel> hospitals =  hospitalAdminService.getAllHospitalDetails(map.get("id").toString());
		map.addAttribute("hospitals", hospitals);
		map.addAttribute("status", "Request Made");
		return "TieUp_h";

	}
	
	
	
	
	@GetMapping("/TiedUp_h")
	public String TiedUp(ModelMap map) {
		List<TieUpModel> s1 = hospitalAdminService.getTiedUpDetails();
		map.addAttribute("hospitals", s1);
		map.addAttribute("hospitalid", map.get("id").toString());
		return "TiedUp_h";

	}
	
	@GetMapping("/PatientRecord_h")
	public String PatientRecord(ModelMap map) {
		return "PatientRecord_h";
	}
	
	@GetMapping("/PatientRecordSearch_h")
	public String PatientRecordSearch(@ModelAttribute("PatientRecordModel") PatientRecordModel model, ModelMap map) {
		boolean k = hospitalAdminService.checkTieUpHospital(model.getHospital_Id(),map.get("id").toString());
		if(k) {
			List<ViewAppointmentModel> c = hospitalAdminService.checkPatientRecord(model);
			if(c.isEmpty()) {
				map.addAttribute("error2", "Patient ID not availiable");
				return "PatientRecord_h";
			}else {
				map.addAttribute("model", c);
				return "PatientRecordSearch_h";
			}
		}else {
			map.addAttribute("error1", "Hospital Not TiedUp");
			return "PatientRecord_h";
		}
		
		
	}
	

	
	
}
