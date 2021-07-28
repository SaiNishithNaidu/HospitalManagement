package com.example.Project.Model;

public class afterRegisterModel {
	private String userid;
	private String password;
	private String confirmpassword;
	private String Security_Question;
	private String Answer;
	private String Contact_Number;

	

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
	
	
	
	public String getSecurity_Question() {
		return Security_Question;
	}

	public void setSecurity_Question(String security_Question) {
		Security_Question = security_Question;
	}

	public String getAnswer() {
		return Answer;
	}

	public void setAnswer(String answer) {
		Answer = answer;
	}

	public String getContact_Number() {
		return Contact_Number;
	}

	public void setContact_Number(String contact_Number) {
		Contact_Number = contact_Number;
	}

	@Override
	public String toString() {
		return "afterRegisterModel [userid=" + userid + ", password=" + password + ", confirmpassword="
				+ confirmpassword + ", Security_Question=" + Security_Question + ", Answer=" + Answer
				+ ", Contact_Number=" + Contact_Number + "]";
	}

	

}
