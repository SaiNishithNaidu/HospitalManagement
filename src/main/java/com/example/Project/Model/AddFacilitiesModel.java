package com.example.Project.Model;

public class AddFacilitiesModel {
	
	private String Facility;
	private String Description_of_Facilities;
	private String Remarks_of_Facilities;
	
	/**
	 * @return the facility
	 */
	public String getFacility() {
		return Facility;
	}
	/**
	 * @param facility the facility to set
	 */
	public void setFacility(String facility) {
		Facility = facility;
	}
	/**
	 * @return the description_of_Facilities
	 */
	public String getDescription_of_Facilities() {
		return Description_of_Facilities;
	}
	/**
	 * @param description_of_Facilities the description_of_Facilities to set
	 */
	public void setDescription_of_Facilities(String description_of_Facilities) {
		Description_of_Facilities = description_of_Facilities;
	}
	/**
	 * @return the remarks_of_Facilities
	 */
	public String getRemarks_of_Facilities() {
		return Remarks_of_Facilities;
	}
	/**
	 * @param remarks_of_Facilities the remarks_of_Facilities to set
	 */
	public void setRemarks_of_Facilities(String remarks_of_Facilities) {
		Remarks_of_Facilities = remarks_of_Facilities;
	}
	@Override
	public String toString() {
		return "AddFacilitiesModel [Facility=" + Facility + ", Description_of_Facilities=" + Description_of_Facilities
				+ ", Remarks_of_Facilities=" + Remarks_of_Facilities + "]";
	}
	
	
}
